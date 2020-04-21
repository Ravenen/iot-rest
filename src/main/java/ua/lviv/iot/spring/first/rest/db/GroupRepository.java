package ua.lviv.iot.spring.first.rest.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.spring.first.rest.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
}
