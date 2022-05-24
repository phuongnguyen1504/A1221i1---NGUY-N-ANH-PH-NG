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
 -- Hiển thị danh sách tất cả các học viên
 select * from student;
 -- Hiển thị danh sách các học viên đang theo học.
 select * from student
 where status <>0;
 -- Hiển thị danh sách các môn học có thời gian học nhỏ hơn 10 giờ.
 select * from subject
 where credit<10;
 -- Hiển thị danh sách học viên lớp A1
 select s.student_id,s.student_name,c.class_name from student s
 join class c on s.class_id=c.class_id
 where c.class_name="A1";
 -- Hiển thị điểm môn CF của các học viên.
 select s.student_name,sub.sub_name,m.mark from student s
 join mark m on s.student_id=m.student_id
 join subject sub on m.sub_id=sub.sub_id
 where sub.sub_name="CF";
 