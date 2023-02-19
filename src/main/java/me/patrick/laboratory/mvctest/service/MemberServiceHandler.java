package me.patrick.laboratory.mvctest.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.finalvalue.entity.masterEntity.MemberMst;
import me.patrick.laboratory.repository.MemberMasterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class MemberServiceHandler {

    private final MemberMasterRepository memberMasterRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void memberHandler() {
        MemberMst m = memberMasterRepository.findById(1L).get();
        m.changeName("Patrick");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void memberModifyTest() {
        MemberMst m = memberMasterRepository.findById(18L).get();
        m.changeName("김종구");
    }


}
