package by.bsu.diploma.enrollee.repository;

import by.bsu.diploma.enrollee.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

	List<Subject> findByUniversitiesId(Long universityId);
}
