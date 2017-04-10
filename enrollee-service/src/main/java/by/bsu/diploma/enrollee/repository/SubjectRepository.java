package by.bsu.diploma.enrollee.repository;

import by.bsu.diploma.enrollee.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

	List<Subject> findByUniversityId(@Param("universityId") Long universityId);
}
