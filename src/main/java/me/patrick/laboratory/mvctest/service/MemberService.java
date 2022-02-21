package me.patrick.laboratory.mvctest.service;

import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.finalvalue.entity.masterEntity.MemberMst;
import me.patrick.laboratory.repository.MemberMasterRepository;
import me.patrick.laboratory.repository.OrderMasterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class MemberService {

    private final MemberMasterRepository memberMasterRepository;
    private final OrderMasterRepository orderMasterRepository;

    public MemberService(MemberMasterRepository memberMasterRepository, OrderMasterRepository orderMasterRepository) {
        assert memberMasterRepository != null;
        assert orderMasterRepository != null;
        this.memberMasterRepository = memberMasterRepository;
        this.orderMasterRepository = orderMasterRepository;
    }

    @Transactional
    public Optional<MemberMst> executor() {
        Optional<MemberMst> memberMst = memberMasterRepository.findById("MM20220212000003");
        memberMasterRepository.delete(memberMst.get());
        /*memberMst.orElseThrow(() -> new RuntimeException("haha"));*/
        return memberMst;
    }
}