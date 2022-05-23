CREATE DATABASE student_manager;
use student_manager;
CREATE TABLE  `class` (
`class_id` int PRIMARY KEY AUTO_INCREMENT,
`class_name` VARCHAR(50) NOT NULL,
`start_date` DATETIME NOT NULL,
`status` BIT
);
CREATE TABLE `student` (
`student_id` int PRIMARY KEY AUTO_INCREMENT,
`student_name` VARCHAR(30) NOT NULL,
`adress` VARCHAR(50) NOT NULL,
`phone` VARCHAR(20),
`status` BIT,
class_id int NOT NULL,
FOREIGN KEY (class_id) REFERENCES class(class_id)
);
CREATE TABLE `subject` (
`sub_id` int PRIMARY KEY AUTO_INCREMENT,
`sub_name` VARCHAR(30) NOT NULL,
`credit` TINYINT NOT NULL DEFAULT 1,
`status` bit DEFAULT 1,
CHECK (credit>=1)
);
CREATE TABLE `mark` (
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
-- ----ADD VALUE----
INSERT INTO class(class_name,start_date,status)
VALUES ('A1', '2008-12-20', 1);
INSERT INTO class(class_name,start_date,status)
VALUES ('A2', '2008-12-22', 1);
INSERT INTO class(class_name,start_date,status)
VALUES ('B3', current_date, 0);

INSERT INTO student (student_name, adress, phone, status, class_id)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO student (student_name, adress, status, class_id)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO student (student_name, adress, phone, status, class_id)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO subject
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
       
INSERT INTO mark (sub_id, student_id, mark, exam_times)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);