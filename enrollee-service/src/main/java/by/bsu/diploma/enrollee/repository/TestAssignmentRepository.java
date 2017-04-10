package by.bsu.diploma.enrollee.repository;

import by.bsu.diploma.enrollee.domain.TestAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Optional;

public interface TestAssignmentRepository extends JpaRepository<TestAssignment, Long> {

	Optional<TestAssignment> findByEnrolleeIdAndTestId(Long enrolleeId, Long testId);

	List<TestAssignment> findByEnrolleeId(@Param("enrolleeId") Long enrolleeId);

	List<TestAssignment> findByTestRoomUniversityIdAndTestSubjectId(@Param("universityId") Long universityId, @Param("subjectId") Long subjectId);

}
