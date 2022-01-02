package me.patrick.laboratory.finalvalue.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
// 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
@Entity
@AllArgsConstructor
@Getter
@Builder
@Setter
@NoArgsConstructor
@ToString(of = {"id","name","career"})
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "coach_id")
    private Long id;

    @Column
    private String name;

    @Column
    private String career;

    @ManyToOne(fetch = FetchType.LAZY,cascade = ALL)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;



}
