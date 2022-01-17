package me.patrick.laboratory.finalvalue.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "member")
/*@ToString(of = {"id", "username", "age"})*/
public class Member {

    @Id
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
    @Column(name = "member_id")
    private Long id;

    private String username;

    private int age;

   /* @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "member")
    private List<Team> teams;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,  mappedBy = "member")
    private List<Coach> coachs;*/

    public void changeName(String name){
        this.username = name;
    }

}
