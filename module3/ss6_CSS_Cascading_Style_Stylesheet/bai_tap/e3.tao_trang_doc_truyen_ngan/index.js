const manga=document.getElementById("manga");
const lightnovel=document.getElementById('lightnovel');
const manhua=document.getElementById('manhua');
const nav=document.querySelector('body > main > div #nav > nav >ul >li>a');
function hideAll(){
    manga.style.display="none";
    lightnovel.style.display="none";
    manhua.style.display="none";
}
nav.addEventListener('click',e => {
    hideAll();
    const ele =e.target;
    switch (ele.textContent){
        case "Manga":
            return manga.style.display="block";
        case "Light Novel":
            return lightnovel.style.display="block";
        case "Manhua":
            return manhua.style.display="block";
    }
});