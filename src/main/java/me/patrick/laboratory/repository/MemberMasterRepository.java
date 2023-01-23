package me.patrick.laboratory.repository;

import me.patrick.laboratory.finalvalue.entity.masterEntity.MemberMst;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Entity;
import java.lang.reflect.Member;

public interface MemberMasterRepository extends JpaRepository<MemberMst, Long> {

}
