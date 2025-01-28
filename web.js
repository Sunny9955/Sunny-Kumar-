async function reels(event) {
    event.preventDefault();
    window.location.href = "reels.html";
}

async function uploadvideo(event) {
    event.preventDefault();

    const videodetails = document.getElementById('uploadvideoContainer');
    const vid = videodetails.querySelector('#video'); 
    
    if (vid.files.length > 0) {
        const file = vid.files[0];
        console.log(file);

        const formData = new FormData();
        formData.append('video', file);
        alert('It Take Some Time Please Wait');
        try {
            const response = await fetch('http://localhost:8080/video/upload', {
                method: "POST",
                body: formData,
            });
            

            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            
            alert('Video Upload successfully');
            // const result = await response.json();
           
        } catch (error) {
            console.error('There has been a problem with your upload operation:', error);
        }

    } else {
        console.log('No video file selected');
    }
}

document.addEventListener('DOMContentLoaded', function() {
    const btn = document.getElementById('uploadButton');
    if (btn) btn.addEventListener('click', uploadvideo);
});
async function live(event) {
    event.preventDefault();
    window.location.href = "live.html";
}