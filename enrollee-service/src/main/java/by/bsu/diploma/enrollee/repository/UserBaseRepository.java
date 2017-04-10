package by.bsu.diploma.enrollee.repository;

import by.bsu.diploma.enrollee.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface UserBaseRepository<U extends User> extends JpaRepository<U, Long> {

	Optional<U> findByEmail(String email);
}
