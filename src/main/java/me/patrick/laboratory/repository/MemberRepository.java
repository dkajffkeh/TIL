package me.patrick.laboratory.repository;

import me.patrick.laboratory.finalvalue.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface MemberRepository extends JpaRepository<Member,Long>  {

}
