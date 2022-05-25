use student_manager;
SELECT adress, COUNT(student_id) AS 'Số lượng học viên'
FROM student
GROUP BY adress;
-- Tính điểm trung bình các môn học của mỗi học viên bằng cách sử dụng hàm AVG
SELECT s.student_id,s.student_name, AVG(mark)
FROM student s join mark m on s.student_id = m.student_id
GROUP BY s.student_id, s.student_name
-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
select s.student_name,s.adress,avg(mark) as `mark` from student s
join mark m on s.student_id=m.student_id
group by s.student_id, s.student_name
having avg(mark)>15
-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
select s.student_name,s.adress,avg(mark) as `mark` from student s
join mark m on s.student_id=m.student_id
group by s.student_id
having avg(mark)>= all(select avg(mark) from mark group by mark.student_id)

