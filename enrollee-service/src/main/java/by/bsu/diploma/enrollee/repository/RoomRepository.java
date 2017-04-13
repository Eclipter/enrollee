package by.bsu.diploma.enrollee.repository;

import by.bsu.diploma.enrollee.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

	List<Room> findByUniversityId(Long universityId);
}
