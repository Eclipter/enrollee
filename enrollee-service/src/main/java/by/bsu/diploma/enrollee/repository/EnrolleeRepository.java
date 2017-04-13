package by.bsu.diploma.enrollee.repository;

import by.bsu.diploma.enrollee.domain.Enrollee;

import java.util.List;

public interface EnrolleeRepository extends UserBaseRepository<Enrollee> {

	List<Enrollee> findByTestAssignmentsId(Long testAssignmentId);
}
