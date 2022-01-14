function dientich() {
    let inputWidth;
    let inputHeight;
    inputWidth = prompt("Enter the width");
    inputHeight = prompt("Enter the height");
    let width=parseInt(inputWidth);
    let height=parseInt(inputHeight);
    result=width*height;
    document.getElementById('height').innerHTML=inputHeight;
    document.getElementById('width').innerHTML=inputWidth;
    document.getElementById('result').innerHTML=result;
}