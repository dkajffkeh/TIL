package me.patrick.laboratory.finalvalue.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
/*@ToString(of = {"id", "username", "age"})*/
public class Member {

    @Id
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
    @Column(name = "member_id")
    private Long id;

    private String username;

    private int age;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "member")
    private List<Team> teams;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,  mappedBy = "member")
    private List<Coach> coachs;

}
