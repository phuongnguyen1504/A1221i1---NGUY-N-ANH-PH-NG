class Hero {
    constructor(image, top, left, size) {
        this.image = image;
        this.top = top;
        this.left = left;
        this.size = size;
        this.speed = 20;
    }

    getHeroElement() {
        return '<img width="' + this.size + '"' +
            'height="' + this.size + '"' +
            ' src="' + this.image + '"' +
            ' style="top: ' + this.top + 'px; left:' + this.left + 'px;position:absolute;"/>';
    }
}

let hero = new Hero('doremon.png', 50, 50, 200);
function start() {
    docReady();
    document.getElementById('game').innerHTML = hero.getHeroElement();
}
function docReady(){
    window.addEventListener('keydown',moveSelection)
}
function moveSelection(evt){
    if (evt.keyCode==17){
        hero.speed+=20;
    }
    switch (evt.keyCode){
        case 37:
            hero.left-=20;
            console.log("chay trai")
            break;
        case 38:
            hero.top-=20;
            console.log("chay len")
            break;
        case 39:
            hero.left += 20;
            console.log("chay phai")
            break;
        case 40:
            hero.top+=20;
            console.log("chay xuong")
            break;
        case 17:
            hero.speed+=20;
            console.log("tang toc")
            break;
    }

    document.getElementById('game').innerHTML = hero.getHeroElement();
}
start()