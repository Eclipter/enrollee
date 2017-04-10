package by.bsu.diploma.enrollee.repository;

import by.bsu.diploma.enrollee.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {

	List<Test> findByRoomUniversityId(@Param("universityId") Long universityId);

	@Query("SELECT test From Test test WHERE test.room.university.id = :universityId AND test.subject.id = :subjectId AND test.room.capacity > size(test.testAssignments)")
	List<Test> findByRoomUniversityIdAndSubjectId(@Param("universityId") Long universityId, @Param("subjectId") Long subjectId);

	Test findFirstByRoomIdAndDate(@Param("roomId") Long roomId, @Param("date") LocalDateTime date);
}
