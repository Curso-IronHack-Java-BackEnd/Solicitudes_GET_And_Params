CREATE TABLE course
(
course_code VARCHAR(6) NOT NULL,
course_name VARCHAR(255),
PRIMARY KEY (course_code)
);

CREATE TABLE section
(
id VARCHAR(8) NOT NULL,
course_code VARCHAR(6),
room_num SMALLINT,
instructor VARCHAR(255),
PRIMARY KEY (id),
FOREIGN KEY (course_code) REFERENCES course(course_code)
);

CREATE TABLE grade
(
id INT NOT NULL AUTO_INCREMENT,
student_name VARCHAR(255),
section_id VARCHAR(8),
score INT,
PRIMARY KEY (id),
FOREIGN KEY (section_id) REFERENCES section(id)
);


INSERT INTO course (course_code, course_name) VALUES
('CS101', 'Intro to Java'),
('CS103',  'Databases');

INSERT INTO section (id, course_code, room_num, instructor) VALUES
('CS101-A', 'CS101', 1802, 'Balderez'),
('CS101-B', 'CS101',  1650, 'Su'),
('CS103-A', 'CS103',  1200, 'Rojas'),
('CS103-B', 'CS103',  1208, 'Tonno');

INSERT INTO grade (student_name, section_id, score) VALUES
('Maya Charlotte', 'CS101-A', 98),
('James Fields', 'CS101-A', 82),
('Michael Alcocer', 'CS101-B', 65),
('Maya Charlotte', 'CS103-A', 89),
('Tomas Lacroix', 'CS101-A', 99),
('Sara Bisat', 'CS101-A', 87),
('James Fields', 'CS101-B', 46),
('Helena Sepulvida', 'CS103-A', 72);

-- findAverageScoreBySection
SELECT section_id as Seccion, AVG(score) as Calificacion
FROM grade
GROUP BY section_id ORDER BY AVG(score) ASC;

-- findAverageScoreBySectionWithCapacity(Long minEnrolled)
SELECT section_id, AVG(score)
FROM grade GROUP BY section_id
HAVING COUNT(*) >= ?1 ORDER BY AVG(score);

-- findAverageScoreBySectionWithCapacity2(@Param("minEnrolled") long minEnrolled)
SELECT section_id, AVG(score)
FROM grade GROUP BY grade.section_id
HAVING COUNT(*) >= :minEnrolled ORDER BY AVG(score);

-- findAverageScoreBySectionWithCapacityNative(@Param("score") double score);
SELECT student_name, CAST(AVG(score) AS double)
FROM Grade GROUP BY student_name
HAVING AVG(score) < :score  ORDER BY student_name DESC;

-- findScoreGreaterThan50();
SELECT student_name as Nombre, score as Calificacion
FROM grade WHERE score > 50 ORDER BY score;

-- findScoreGreaterThan70Sorted();
SELECT student_name as Nombre, score as Calificación
FROM grade WHERE score > 70 ORDER BY student_name;

-- studentsExcludingSection();
SELECT student_name as Nombre, section_id as Seccion
FROM grade WHERE section_id != 'CS101-A';

-- findMaxScoreBySection();
SELECT section_id as Seccion, MAX(score) as Calificación
FROM grade
GROUP BY section_id;

-- findByAvgScoreLessThan(Double score);
SELECT student_name as Nombre, AVG(score) as Calificacion
FROM grade GROUP BY student_name HAVING AVG(score) < ?1;