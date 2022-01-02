package me.patrick.laboratory.repository;

import me.patrick.laboratory.finalvalue.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach,Long> {

}
