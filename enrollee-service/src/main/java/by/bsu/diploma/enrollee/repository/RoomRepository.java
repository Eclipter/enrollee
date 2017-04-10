package by.bsu.diploma.enrollee.repository;

import by.bsu.diploma.enrollee.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

	List<Room> findByUniversityId(@Param("universityId") Long universityId);
}
