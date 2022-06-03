-- 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là
-- một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
use furama;
select * from nhan_vien where substring_index(ho_ten,' ',-1) regexp '^[HTK]' and length(ho_ten)<25;

-- 3. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và
-- có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khach_hang where timestampdiff(year,ngay_sinh,now()) between 18 and 50 and dia_chi 
regexp '(Đà Nẵng|Quảng Trị)' 
order by ngay_sinh;

-- 4 Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu
-- lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của
-- khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select c.ho_ten,t.ten_loai_khach,count(c.ma_khach_hang) as so_lan_dat from khach_hang c
join loai_khach t on c.ma_loai_khach= t.ma_loai_khach
join hop_dong cons on c.ma_khach_hang=cons.ma_khach_hang
where t.ten_loai_khach="Diamond"
group by c.ma_khach_hang
order by count(c.ma_khach_hang);

-- 5.Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong,
-- ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien (Với
-- tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng *
-- Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem,
-- hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. (những
-- khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.ma_khach_hang,kh.ho_ten,lk.ten_loai_khach,hd.ma_hop_dong,
dv.ten_dich_vu,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,
sum((hdct.so_luong*dvdk.gia)+dv.chi_phi_thue) as tong_tien from khach_hang kh
left join loai_khach lk on kh.ma_loai_khach=lk.ma_loai_khach
left join hop_dong hd on kh.ma_khach_hang=hd.ma_khach_hang
left join dich_vu dv on hd.ma_dich_vu=dv.ma_dich_vu
left join loai_dich_vu ldv on dv.ma_loai_dich_vu=ldv.ma_loai_dich_vu
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong=hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem
group by kh.ma_khach_hang,hd.ma_hop_dong
order by kh.ma_khach_hang;

-- 6.Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue,
-- ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng
-- thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
select dv.ma_dich_vu,dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,ldv.ten_loai_dich_vu from dich_vu dv
join hop_dong hd on dv.ma_dich_vu=hd.ma_dich_vu
join loai_dich_vu ldv on dv.ma_loai_dich_vu=ldv.ma_loai_dich_vu
where dv.ma_dich_vu not in (select ma_dich_vu from hop_dong where ngay_lam_hop_dong between '2021-01-01' and '2021-03-31');
-- 7.Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại
-- dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
select distinct * from dich_vu dv
join hop_dong hd on dv.ma_dich_vu=hd.ma_dich_vu
join loai_dich_vu ldv on dv.ma_loai_dich_vu=ldv.ma_loai_dich_vu
where Year(hd.ngay_lam_hop_dong)='2020' and dv.ma_dich_vu not in (select ma_dich_vu from hop_dong where year(ngay_lam_hop_dong)="2021");

-- 8.Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

select * from khach_hang
group by ho_ten
having count(ho_ten)=1;
set global sql_mode='';

-- 9 Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi
-- tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select year(ngay_lam_hop_dong) as nam,month(ngay_lam_hop_dong) as thang, count(ma_hop_dong) as so_luong from hop_dong hd
group by year(ngay_lam_hop_dong),month(ngay_lam_hop_dong)
order by year(ngay_lam_hop_dong),month(ngay_lam_hop_dong);

-- Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc,
-- so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
select hd.ma_hop_dong,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,hd.tien_dat_coc,count(hdct.ma_dich_vu_di_kem) as so_luong_dvdk from hop_dong hd
join hop_dong_chi_tiet hdct on hd.ma_hop_dong=hdct.ma_hop_dong
join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem
group by hdct.ma_hop_dong;
-- 11.Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách
-- hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
select dvdk.ten_dich_vu_di_kem as ten_dich_vu_da_su_dung from khach_hang kh
join loai_khach lk on kh.ma_loai_khach=lk.ma_loai_khach
join hop_dong hd on hd.ma_khach_hang=hd.ma_khach_hang
join hop_dong_chi_tiet hdct on hd.ma_hop_dong=hdct.ma_hop_dong
join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem
where lk.ten_loai_khach="Diamond" and kh.dia_chi regexp "(Vinh|Quảng Ngãi)$"
group by dvdk.ten_dich_vu_di_kem;
-- 12. Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), 
-- so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem 
-- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả 
-- các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được
-- khách hàng đặt vào 6 tháng đầu năm 2021.
SELECT hd.ma_hop_dong, nv.ho_ten, kh.ho_ten, kh.so_dien_thoai, dv.ten_dich_vu AS so_luong_dich_vu_di_kem,sum(hd.tien_dat_coc) as tong_tien_coc
FROM hop_dong hd 
	JOIN khach_hang kh ON hd.ma_khach_hang = kh.ma_khach_hang
    JOIN nhan_vien nv ON  hd.ma_nhan_vien = nv.ma_nhan_vien
    JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
    JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong 
WHERE ngay_lam_hop_dong BETWEEN '2020-10-01' AND '2020-12-31' AND dv.ma_dich_vu
	NOT IN
		(SELECT ma_dich_vu
		 FROM dich_vu
		 WHERE ngay_lam_hop_dong BETWEEN '2021-01-01' AND '2021-06-01')
GROUP BY hd.ma_hop_dong;    

-- 13.Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã 
-- đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
create or replace view sum_dvdk as
select ma_dich_vu_di_kem,count(ma_dich_vu_di_kem)as so_lan_su_dung from hop_dong_chi_tiet
group by ma_dich_vu_di_kem; 
select * from dich_vu_di_kem
having  ma_dich_vu_di_kem in (select ma_dich_vu_di_kem from sum_dvdk where so_lan_su_dung=(select max(so_lan_su_dung)  from sum_dvdk));
/* 14.Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một
lần duy nhất. Thông tin hiển thị bao gồm ma_hop_dong,
ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính
dựa trên việc count các ma_dich_vu_di_kem).*/
SELECT hdct.ma_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, COUNT(dvdk.ma_dich_vu_di_kem) as so_lan_su_dung
FROM  dich_vu_di_kem dvdk
	JOIN hop_dong_chi_tiet hdct ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
	JOIN hop_dong hd ON hdct.ma_hop_dong = hd.ma_hop_dong
    JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
    JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
GROUP BY dvdk.ten_dich_vu_di_kem
HAVING COUNT(dvdk.ma_dich_vu_di_kem)=3
ORDER BY COUNT(dvdk.ma_dich_vu_di_kem);
/* 15.Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten,
ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được
tối đa 3 hợp đồng từ năm 2020 đến 2021.*/
select nv.ma_nhan_vien,nv.ho_ten,td.ten_trinh_do,bp.ten_bo_phan,nv.so_dien_thoai,nv.dia_chi,
count(nv.ma_nhan_vien) as so_hop_dong from nhan_vien nv
join vi_tri vt on nv.ma_vi_tri=vt.ma_vi_tri
join trinh_do td on nv.ma_trinh_do=td.ma_trinh_do
join bo_phan bp on nv.ma_bo_phan=bp.ma_bo_phan
join hop_dong hd on nv.ma_nhan_vien=hd.ma_nhan_vien
where year(hd.ngay_lam_hop_dong) between '2020' and '2021'
group by nv.ma_nhan_vien
having count(nv.ma_nhan_vien)<=3;
/* 16.Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019
đến năm 2021.*/
delete from nhan_vien
where not exists (select ma_nhan_vien from hop_dong hd where hd.ngay_lam_hop_dong between '2019-01-01' and '2021-12-31' and hd.ma_nhan_vien=nhan_vien.ma_nhan_vien);
/* 17.Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum
lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với
Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.*/
create or replace view update_loai_kh as
select kh.ma_khach_hang,sum(hdct.so_luong*dvdk.gia) as thanh_tien,lk from hop_dong hd
join khach_hang kh on hd.ma_khach_hang=kh.ma_khach_hang
join loai_khach lk on kh.ma_loai_khach=lk.ma_loai_khach
join hop_dong_chi_tiet hdct on hd.ma_hop_dong=hdct.ma_hop_dong
join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem
where year(hd.ngay_lam_hop_dong)='2021'
group by kh.ma_khach_hang;
update khach_hang
set ma_loai_khach=1
where  ma_khach_hang in (select ma_khach_hang from update_loai_kh) and ma_loai_khach=2;
/*18. Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).*/

delete khach_hang,hop_dong,hop_dong_chi_tiet from khach_hang inner join hop_dong on khach_hang.ma_khach_hang=hop_dong.ma_khach_hang
inner join hop_dong_chi_tiet on hop_dong.ma_hop_dong=hop_dong_chi_tiet.ma_hop_dong
where not exists (select hop_dong.ma_hop_dong where year(hop_dong.ngay_lam_hop_dong)>'2021' and khach_hang.ma_khach_hang=hop_dong.ma_khach_hang);
/* 19.Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong
năm 2020 lên gấp đôi. */
create or replace view update_price as
select dvdk.ma_dich_vu_di_kem,count(dvdk.ma_dich_vu_di_kem) as so_lan from hop_dong_chi_tiet hdct
join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem
group by dvdk.ma_dich_vu_di_kem
having count(dvdk.ma_dich_vu_di_kem)>5;
update dich_vu_di_kem
set gia=gia*2
where ma_dich_vu_di_kem in (select ma_dich_vu_di_kem from update_price);

/* 20.Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ
thống, thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang),
ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.*/
select ma_nhan_vien as id,ho_ten,email,so_dien_thoai,ngay_sinh,dia_chi from nhan_vien
union All
select ma_khach_hang,ho_ten,email,so_dien_thoai,ngay_sinh,dia_chi from khach_hang;

/*21.Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả
các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho một
hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.*/
create or replace view v_nhan_vien as
select nv.ma_nhan_vien,nv.ho_ten,nv.ngay_sinh,nv.so_cmnd,nv.luong,nv.so_dien_thoai,nv.email,nv.dia_chi from nhan_vien nv
join hop_dong hd on nv.ma_nhan_vien=hd.ma_nhan_vien
join khach_hang kh on hd.ma_khach_hang=kh.ma_khach_hang
where (nv.dia_chi like '%Hải Châu%') and (hd.ngay_lam_hop_dong='2019-12-12')
group by nv.ma_nhan_vien
having count(hd.ma_hop_dong)>=1;

/*22.Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn
này.*/
-- P1.
update nhan_vien
set dia_chi="Lien Chieu"
where ma_nhan_vien in (select ma_nhan_vien from v_nhan_vien);
-- P2.
update v_nhan_vien set dia_chi="Lien Chieu";

/*23.Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó với ma_khach_hang được truyền vào như là 1
tham số của sp_xoa_khach_hang.*/
DELIMITER //
DROP PROCEDURE IF EXISTS sp_xoa_khach_hang //
CREATE PROCEDURE sp_xoa_khach_hang(id int)
BEGIN
	delete from hop_dong_chi_tiet where ma_hop_dong in (select distinct hd.ma_hop_dong from hop_dong hd
    join hop_dong_chi_tiet hdct on hd.ma_hop_dong=hdct.ma_hop_dong
    where hd.ma_khach_hang=id);
    delete from hop_dong where ma_khach_hang=id;
	delete from khach_hang where ma_khach_hang=id;
END //
DELIMITER 
call sp_xoa_khach_hang(10);

/*24. Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào
bảng hop_dong với yêu cầu sp_them_moi_hop_dong phải thực hiện
kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được
trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên
quan.*/
DELIMITER //
DROP PROCEDURE IF EXISTS sp_them_moi_hop_dong //
CREATE PROCEDURE sp_them_moi_hop_dong(IN 
BEGIN
IN in_ngay_lam_hop_dong datetime, 
IN in_ngay_ket_thuc datetime, 
IN in_tien_dat_coc double, 
IN in_ma_nhan_vien int, 
IN in_ma_khach_hang int, 
IN in_ma_dich_vu int)
BEGIN
  INSERT INTO hop_dong(ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu)
values	(in_ngay_lam_hop_dong,in_ngay_ket_thuc,in_tien_dat_coc,in_ma_nhan_vien,in_ma_khach_hang,in_ma_dich_vu);
END //
DELIMITER ;
CALL sp_them_moi_hop_dong('2021-12-01','2022-03-01',0,3,1,3);
