package me.patrick.laboratory.mvctest.service;

import me.patrick.laboratory.repository.MemberMasterRepository;
import me.patrick.laboratory.repository.OrderMasterRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class MemberServiceTest {

    @Mock
    MemberMasterRepository memberMasterRepository;

    @Mock
    OrderMasterRepository orderMasterRepository;

    @Mock
    MemberServiceHandler memberServiceHandler;

    @Test
    @DisplayName("MockTest")
    void createUserTest() {
        MemberService memberService =
                new MemberService(
                        memberMasterRepository,
                        orderMasterRepository,
                        memberServiceHandler
                );
    }
}