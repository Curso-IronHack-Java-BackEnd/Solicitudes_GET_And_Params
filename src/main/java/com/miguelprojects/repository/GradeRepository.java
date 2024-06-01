package com.miguelprojects.repository;

import com.miguelprojects.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {

    Grade findByStudentNameAndSectionId(String studentName, String section);
    List<Grade> findByStudentNameContaining(String studentName);
    List<Grade> findByStudentNameLike(String studentName);

    @Query(value="SELECT g.sectionId, AVG(g.score) FROM Grade g GROUP BY g.sectionId ORDER BY AVG(g.score) ASC")
    List<Object[]> findAverageScoreBySection();

    @Query(value="SELECT g.sectionId, AVG(g.score) FROM Grade g GROUP BY g.sectionId HAVING COUNT(*) >= ?1 ORDER BY AVG(g.score)")
    List<Object[]> findAverageScoreBySectionWithCapacity(Long minEnrolled);
    @Query(value="SELECT g.sectionId, AVG(g.score) FROM Grade g GROUP BY g.sectionId HAVING COUNT(*) >= :minEnrolled ORDER BY AVG(g.score)")
    List<Object[]> findAverageScoreBySectionWithCapacity2(@Param("minEnrolled") long minEnrolled);

    @Query(value="SELECT student_name, CAST(AVG(score) AS double) FROM Grade GROUP BY student_name HAVING AVG(score) < :score  ORDER BY student_name DESC", nativeQuery=true)
    List<Object[]> findAverageScoreBySectionWithCapacityNative(@Param("score") double score);

    @Query(value="SELECT g.studentName as Nombre, g.score as Calificacion FROM Grade g WHERE g.score > 50 ORDER BY g.score")
    List<Object[]> findScoreGreaterThan50();

    @Query(value="SELECT g.studentName as Nombre, g.score as Calificación FROM Grade g WHERE g.score > 70 ORDER BY g.studentName")
    List<Object[]> findScoreGreaterThan70Sorted();

    @Query(value="SELECT g.studentName as Nombre, g.sectionId as Seccion FROM Grade g WHERE g.sectionId != 'CS101-A'")
    List<Object[]> studentsExcludingSection();

    @Query("SELECT g.sectionId as Seccion, MAX(g.score) as Calificación FROM Grade g GROUP BY g.sectionId")
    List<Object[]> findMaxScoreBySection();

    @Query("SELECT g.studentName as Nombre, AVG(g.score) as Calificacion FROM Grade g GROUP BY g.studentName HAVING AVG(g.score) < ?1")
    List<Object[]> findByAvgScoreLessThan(Double score);
}
