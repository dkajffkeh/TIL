package me.patrick.laboratory.mokito;

import me.patrick.laboratory.finalvalue.entity.masterEntity.MemberMst;
import me.patrick.laboratory.mvctest.service.MemberService;
import me.patrick.laboratory.repository.MemberMasterRepository;
import me.patrick.laboratory.repository.OrderMasterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @Mock
    MemberMasterRepository memberMasterRepository;

    @Mock
    OrderMasterRepository orderMasterRepository;

    @Test
    void memberIfExistTest(){

        MemberService memberService = new MemberService(memberMasterRepository,orderMasterRepository);
        MemberMst memberMst = MemberMst.builder()
                        .memberMstId("MM20220212000003")
                        .age(33)
                        .build();
        /*when(memberMasterRepository.findById(any())).thenReturn(Optional.of(memberMst));*/

        /*Optional<MemberMst> memberMst1 = memberService.executor();*/
        /*assertTrue(memberMst1.isPresent());*/
        /*assertEquals("MM20220212000003", memberMst1.get().getMemberMstId());*/

        /*doThrow(new RuntimeException()).when(memberMasterRepository).findById(any());
        assertThrows(RuntimeException.class, memberService::executor);*/

        when(memberMasterRepository.findById(any()))
                .thenReturn(Optional.of(memberMst)) // 첫호출
                .thenThrow(new RuntimeException()) // 두번째 호출
                .thenReturn(Optional.empty()); // 세번째 호출

        assertEquals("MM20220212000003", memberService.executor().get().getMemberMstId());

        assertThrows(RuntimeException.class, memberService::executor);

        assertEquals(Optional.empty(), memberService.executor());
    }

    @Test
    void verifyTest(){

        MemberService memberService = new MemberService(memberMasterRepository,orderMasterRepository);
        MemberMst memberMst = MemberMst.builder()
                .memberMstId("MM20220212000003")
                .age(33)
                .build();
        when(memberMasterRepository.findById(any())).thenReturn(Optional.of(memberMst));

        assertEquals(memberMst, memberService.executor().get());

        verify(memberMasterRepository,times(1)).delete(any(MemberMst.class));
        verify(memberMasterRepository,never()).deleteAll();

        InOrder inOrder = inOrder(memberMasterRepository);
        inOrder.verify(memberMasterRepository).findById(any(String.class));

    }

    @Test
    void bddStyleTest(){
        MemberService memberService = new MemberService(memberMasterRepository,orderMasterRepository);
        MemberMst memberMst = MemberMst.builder()
                .memberMstId("MM20220212000003")
                .age(33)
                .build();
        // given
        given(memberMasterRepository.findById(any(String.class))).willReturn(Optional.of(memberMst));

        // when
        Optional<MemberMst> optionalMemberMst = memberService.executor();

        // then
        assertEquals(memberMst, optionalMemberMst.get());
        then(memberMasterRepository).should(times(1)).findById(any(String.class));


    }


}
