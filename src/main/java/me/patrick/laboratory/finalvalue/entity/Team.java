package me.patrick.laboratory.finalvalue.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY,cascade = ALL)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(
            fetch = FetchType.EAGER,
            mappedBy = "team"
           )
    private Coach coach;

    public Team(String name) {
        this.name = name;
    }


}
