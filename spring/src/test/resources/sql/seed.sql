USE lmstest;

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE students;
TRUNCATE TABLE klasses;
TRUNCATE TABLE teachers;
TRUNCATE TABLE registrations;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO students (email) VALUES
  ('ricky.bobby@allstate.com'),
  ('bbb@aol.com'),
  ('ccc@aol.com'),
  ('ddd@aol.com');

INSERT INTO teachers (name, age, gender) VALUES
  ('t1', 35, 'MALE'),
  ('t2', 21, 'FEMALE'),
  ('t3', 68, 'FEMALE');

INSERT INTO klasses (credits, department, fee, name, semester, teacher_id) VALUES
  (4, 'SCIENCE', 500.0, 'Physics 101', '2017-01-25 00:00:00', 1),
  (3, 'ENGINEERING', 550.0, 'Electrical Engineering 101', '2018-01-25 00:00:00', 2),
  (2, 'SCIENCE', 430.0, 'Calculus 101', '2019-01-25 00:00:00', 2);

INSERT INTO registrations (student_id, klass_id) VALUES
  (1, 1),
  (2, 1),
  (3, 1),
  (1, 2),
  (2, 2),
  (3, 2),
  (1, 3),
  (2, 3),
  (3, 3);