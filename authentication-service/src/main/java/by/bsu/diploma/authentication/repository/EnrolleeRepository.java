package by.bsu.diploma.authentication.repository;

import by.bsu.diploma.commons.domain.Enrollee;

import java.util.List;

public interface EnrolleeRepository extends UserBaseRepository<Enrollee> {

	List<Enrollee> findByTestAssignmentsId(Long testAssignmentId);
}
