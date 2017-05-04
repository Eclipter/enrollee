package by.bsu.diploma.enrollee.repository;

import by.bsu.diploma.commons.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {

	List<Test> findByRoomUniversityId(Long universityId);

	@Query("SELECT test From Test test WHERE test.room.university.id = :universityId AND test.subject.id = :subjectId AND test.room.capacity > size(test.testAssignments)")
	List<Test> findByRoomUniversityIdAndSubjectId(Long universityId, Long subjectId);

	Test findFirstByRoomIdAndDate(Long roomId, LocalDateTime date);
}
