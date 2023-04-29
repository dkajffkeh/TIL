package me.patrick.laboratory.finalvalue.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import me.patrick.laboratory.finalvalue.entity.masterEntity.OrderMst;

@Getter
@AllArgsConstructor
public class MemberDto {

    private String memberMstId;

    private String username;

    private int age;

    private List<OrderMst> orders;

    public MemberDto(int age) {
        this.age = age;
    }

    public MemberDto() {
        throw new IllegalArgumentException("에러 발생");
    }

}
