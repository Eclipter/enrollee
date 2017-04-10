package by.bsu.diploma.enrollee.repository;

import by.bsu.diploma.enrollee.domain.Enrollee;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnrolleeRepository extends UserBaseRepository<Enrollee> {

	List<Enrollee> findByTestAssignmentsId(@Param("testAssignmentId") Long testAssignmentId);
}
