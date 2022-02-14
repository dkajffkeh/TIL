package me.patrick.laboratory.finalvalue.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.patrick.laboratory.finalvalue.entity.masterEntity.OrderMst;

import java.util.List;

@Getter
@AllArgsConstructor
public class MemberDto {

    private String memberMstId;

    private String username;

    private int age;

    private List<OrderMst> orders;
}
