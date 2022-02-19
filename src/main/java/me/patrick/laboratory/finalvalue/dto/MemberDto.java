package me.patrick.laboratory.finalvalue.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.patrick.laboratory.finalvalue.entity.masterEntity.OrderMst;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class MemberDto {

    private String memberMstId;

    private String username;

    @Setter
    private int age;

    private List<OrderMst> orders;

    public MemberDto(int age) {
        this.age = age;
    }

    public MemberDto(){
        throw new IllegalArgumentException("에러 발생");
    }

    public MemberDto(String username, int age) {
        this.username = username;
        this.age = age;
    }

}
