package me.patrick.laboratory.finalvalue.entity.masterEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "MEMBER_MST")
@ToString
public class MemberMst {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String username;

    private int age;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "member")
    @ToString.Exclude
    private List<OrderMst> orders = new ArrayList<>();

    public void changeName(String username){
        this.username=username;
    }

    public void changeAge(int age){
        this.age=age;
    }

}
