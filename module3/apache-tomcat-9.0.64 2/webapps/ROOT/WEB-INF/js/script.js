let query = 'https://api.nasa.gov/planetary/apod?api_key=8NOkSAhg2Nkwpq6uCfQP0TfmcTtNrFHMnDnX1Zxu';
let request = new XMLHttpRequest();
request.open('GET', query);
request.onload = function () {
    if (request.status === 200) {
        let response = JSON.parse(request.responseText);
        document.getElementById('img-of-the-day').setAttribute('src', response.url);
    }
};
request.send();
