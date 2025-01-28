let stream;
let mediaRecorder;
let recordedChunks = [];

document.addEventListener('DOMContentLoaded', () => {
    const video = document.getElementById('liveVideo');
    const stopButton = document.getElementById('stopButton');

    // Access the camera and microphone stream
    navigator.mediaDevices.getUserMedia({ video: true, audio: true })
        .then(cameraStream => {
            console.log('Camera stream accessed successfully');
            stream = cameraStream;
            video.srcObject = stream;

            // Start recording automatically
            mediaRecorder = new MediaRecorder(stream);
            mediaRecorder.ondataavailable = event => {
                recordedChunks.push(event.data);
                sendChunk(event.data);
            };
            mediaRecorder.start(100); // Collect data every 100ms
        })
        .catch(error => {
            console.error('Error accessing the camera and microphone:', error);
            alert('Could not access the camera. Please check your camera settings and permissions.');
        });

    stopButton.addEventListener('click', () => {
        if (stream) {
            stream.getTracks().forEach(track => track.stop());
        }
        if (mediaRecorder) {
            mediaRecorder.stop();
        }
    });
});

// Function to send video chunk to the server
function sendChunk(chunk) {
    const reader = new FileReader();
    reader.onloadend = () => {
        const data = new Uint8Array(reader.result);
        fetch('http://localhost:8080/api/stream', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/octet-stream',
            },
            body: data,
        })
        .then(() => {
            console.log(`Chunk of size: ${data.length} sent`);
        })
        .catch(error => {
            console.error('Error sending video chunk:', error);
        });
    };
    reader.readAsArrayBuffer(chunk);
}

