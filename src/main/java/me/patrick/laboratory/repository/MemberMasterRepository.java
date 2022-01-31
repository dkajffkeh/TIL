package me.patrick.laboratory.repository;

import me.patrick.laboratory.finalvalue.masterEntity.MemberMst;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMasterRepository extends JpaRepository<MemberMst, Long> {


}
