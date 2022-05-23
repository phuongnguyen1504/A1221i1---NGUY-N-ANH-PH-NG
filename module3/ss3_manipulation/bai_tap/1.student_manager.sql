CREATE DATABASE IF NOT EXISTS student_manager;
use student_manager;
CREATE TABLE IF NOT EXISTS  `class` (
`class_id` int PRIMARY KEY AUTO_INCREMENT,
`class_name` VARCHAR(50) NOT NULL,
`start_date` DATETIME NOT NULL,
`status` BIT
);
CREATE TABLE IF NOT EXISTS `student` (
`student_id` int PRIMARY KEY AUTO_INCREMENT,
`student_name` VARCHAR(30) NOT NULL,
`adress` VARCHAR(50) NOT NULL,
`phone` VARCHAR(20),
`status` BIT,
class_id int NOT NULL,
FOREIGN KEY (class_id) REFERENCES class(class_id)
);
CREATE TABLE IF NOT EXISTS `subject` (
`sub_id` int PRIMARY KEY AUTO_INCREMENT,
`sub_name` VARCHAR(30) NOT NULL,
`credit` TINYINT NOT NULL DEFAULT 1,
`status` bit DEFAULT 1,
CHECK (credit>=1)
);
CREATE TABLE IF NOT EXISTS `mark` (
`mark_id` int PRIMARY KEY AUTO_INCREMENT,
`sub_id` int NOT NULL,
`student_id` int NOT NULL,
`mark` FLOAT NOT NULL,
`exam_times` TINYINT DEFAULT 1,
UNIQUE(sub_id,student_id),
CHECK (MARK BETWEEN 0 AND 100),
FOREIGN KEY (sub_id) REFERENCES subject(sub_id),
FOREIGN KEY (student_id) REFERENCES `student` (student_id)
);
-- ----Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’----
SELECT *
FROM student
WHERE student_name like "h%";
-- ----Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.----
SELECT *
FROM class
WHERE MONTH(start_date)=12;
-- ----Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5. ----
SELECT *
FROM subject
WHERE credit BETWEEN 3 AND 5;
-- ---- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2. ----
UPDATE student set class_id=2 WHERE student_name="Hung";
-- ---- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần. ----
SELECT student_name,sub_name,mark from student
JOIN mark on student.student_id=mark.student_id
JOIN subject on mark.sub_id=subject.sub_id
ORDER BY mark desc,student_name;



