package by.bsu.diploma.enrollee.repository;

import by.bsu.diploma.enrollee.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

	List<Document> findByEnrolleeId(Long enrolleeId);
}
