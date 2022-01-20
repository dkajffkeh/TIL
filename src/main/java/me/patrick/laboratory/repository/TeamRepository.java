package me.patrick.laboratory.repository;

import me.patrick.laboratory.finalvalue.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {

    Team findFirstById(Long id);
}
