package by.bsu.diploma.enrollee.repository;

import by.bsu.diploma.commons.domain.TestAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TestAssignmentRepository extends JpaRepository<TestAssignment, Long> {

	Optional<TestAssignment> findByEnrolleeIdAndTestId(Long enrolleeId, Long testId);

	List<TestAssignment> findByEnrolleeId(Long enrolleeId);

	List<TestAssignment> findByTestRoomUniversityIdAndTestSubjectId(Long universityId, Long subjectId);

}
