/*
hàm lay_gia_tri_cu và lay_ket_qua dùng để xử lý tính toán
còn hàm in_gia_tri_cu và in_ket_qua thì chỉ in ra màn hình hiển thị giá trị
*/

function lay_gia_tri_cu(){
    return document.getElementById('gia_tri_cu').innerText;
}
function in_gia_tri_cu(so) {
    document.getElementById('gia_tri_cu').innerText=so;
}
function lay_ket_qua() {
    return document.getElementById('gia_tri_xuat').innerText;
}
function in_ket_qua(so) {
    if (so=="") {
        document.getElementById('gia_tri_xuat').innerText=so;
    } else {
        document.getElementById('gia_tri_xuat').innerText=dinhdangchuoi(so);
    }
}
function dinhdangchuoi(so) {
    if(so == "-") {
        return "";
    }
    var n=Number(so);
    var gia_tri=n.toLocaleString("en");
    return gia_tri;
}
/*/pattern/modifiers
pattern là chuỗi Regular Expression
modifiers là thông số cấu hình cho chuỗi pattern, và nó có các giá trị sau:
    i : so khớp không quan tâm đến chữ hoa chữ thường
g : so khợp toàn bộ chuỗi cần tìm
m : so khớp luôn cả các dữ liệu xuống dòng (multiline)*/
function xoa_dinhdangchuoi(so) {
    return Number(so.replace(/,/g,""));
}

/*Tạo biến con sô lấy toàn bộ phần tử của class
    cho biến i chạy từ 0 đến đồ dại mảng phần tử
khi chạy có phần tử nào click thì function chạy
    tạo biến kết qua = xoa_dinhdangchuoi(lay_ket_qua()) để nhập dữ liệu kết quả
    if ket_qua là số= thì ket_qua=ket_qua trc + kết qua theo id mới thêm này rồi in_ket_qua theo kết quả vừa tạo*/
var con_so=document.getElementsByClassName('con_so');
for(var i=0;i<con_so.length;i++) {
        con_so[i].addEventListener("click",function (){
            var ket_qua=xoa_dinhdangchuoi(lay_ket_qua())
            if (ket_qua!=NaN) {
                ket_qua=ket_qua+this.id;
                in_ket_qua(ket_qua)
            }
    })
}
/*Tạo biến hệ thống lấy toàn bộ phần tử trong class
cho biến i chạy từ 0 đến độ dài của biến hệ thống theo index
khi chạy từ 0 đến độ dài thì nếu nút nào thể hiện click vào thì sẽ chạy hàm đó
+Nếu click vào ô có id là xoa_tat_ca thì in_ket_qua và in_gia_tri_cu sẽ trả kết quả rỗng
+Nếu nếu click ô "xoa_tun_phan" thì tạo biến ket_qua= hàm chuyển từ chuỗi sang số(của hàm lay_ket_qua ép ra dạng chuoi)
    *nếu hàm kết quả có chứa giá trị thì sẽ giảm chuỗi bằng cash chuyển biến ket_qua giảm 1 chuỗi, dùng hàm substr(từ, đến độ dài của hàm ket_qua -1)
    sau đó chạy lại hàm in_ket_qua để hiển thị trên html
    *còn không thì tạo biến ket_qua=layketqua và ket_qua_cu=lay_gia_tri_cu
        Nếu kết quả k phải rỗng thì ket_qua=xoa_dinhdanchuoi(ket_qua); ket_qua_cu=ket_qua_cu+ket_qua(Ket qua cũ tiếp theo = ket qua cử lần đầu+ kết quả của hiện tại để chạy tiếp)
    */
var he_thong=document.getElementsByClassName('he_thong');
for(var i=0;i<he_thong.length;i++) {
    he_thong[i].addEventListener('click',function (){
        if (this.id=="xoa_tat_ca") {
            in_ket_qua("");
            in_gia_tri_cu("");
        }
        else if (this.id=="xoa_tung_phan") {
            let ket_qua= xoa_dinhdangchuoi(lay_ket_qua()).toString();
            if (ket_qua) {
                ket_qua=ket_qua.substr(0,ket_qua.length-1)
                in_ket_qua(ket_qua)
            }
        }
        else {
            var ket_qua=lay_ket_qua();
            var ket_qua_cu=lay_gia_tri_cu();
            if (ket_qua!="") {
                ket_qua=xoa_dinhdangchuoi(ket_qua);
                ket_qua_cu =ket_qua_cu+ket_qua;
                if (this.id=="=") {
                    var ket_qua_cuoi=eval(ket_qua_cu);
                    in_ket_qua(ket_qua_cuoi)
                    in_gia_tri_cu("")
                }
                else {
                    ket_qua_cu= ket_qua_cu+this.id;
                    in_gia_tri_cu(ket_qua_cu)
                    in_ket_qua("")
                }
            }
        }
    })
}
