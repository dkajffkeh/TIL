package me.patrick.laboratory.repository;

import me.patrick.laboratory.finalvalue.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface MemberRepository extends JpaRepository<Member,Long> , MemberCustomRepository {

    @Query("select m from Member m where m.id = :id")
    Member findByMemberByMemberId(Long id);

    Member findMemberById(Long id);

}
