function laygiatricu() {
    return document.getElementById('xuat_ket_qua').innerText;
}
function xuatketqua(so) {
    document.getElementById('xuat_ket_qua').innerText = so;
}

var he_thong=document.getElementsByClassName('he_thong');/*[+,-,*,/,=]*/
for (var i=0;i<he_thong.length;i++) {
    he_thong[i].addEventListener("click",function (){
        if (this.id=="xoa_tat_ca") {
            xuatketqua("")
        }
        else {
            if (this.id=="=") {
                xuatketqua(laygiatricu().replace(/%/igm,"/100"))
                ket_qua=eval(laygiatricu())
                xuatketqua(ket_qua)
            }
            else {
                ket_qua=laygiatricu()+this.id;
                xuatketqua(ket_qua)
            }
        }

    })
}
var con_so=document.getElementsByClassName('con_so');
for (var i=0;i<con_so.length;i++) {
    con_so[i].addEventListener('click',function (){
        ket_qua=laygiatricu()+Number(this.id);
        xuatketqua(ket_qua)
    })
}