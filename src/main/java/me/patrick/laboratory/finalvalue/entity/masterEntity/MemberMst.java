package me.patrick.laboratory.finalvalue.entity.masterEntity;

import lombok.*;
import me.patrick.laboratory.common.idgenerator.SeqGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "MEMBER_MST")
@ToString
public class MemberMst {

    private static final String PROCEDURE_PARAM = "MEMBER_MST";

    @Id
    @GenericGenerator(name = "idGeneratorMemberMst", //@GeneratedValue의 generator modifier에서 사용할 이름
            strategy = "me.patrick.laboratory.common.idgenerator.SeqGenerator", // IdentifierGenerator 인터페이스를 구현한 클래스 이름. 전체 패키지를 포함한 클래스 이름을 적어야 합니다.
            parameters = @org.hibernate.annotations.Parameter( // Configurable 인터페이스 구현 클래스에 넘겨줄 파라미터 설정
                    name = SeqGenerator.SEQ_GENERATOR_PARAM_KEY, // 파라미터의 키 이름. SeqGenerator 클래스에 선언해둔 상수를 사용
                    value = PROCEDURE_PARAM // 위의 name modifier에 선언한 키에 넘겨줄 파라미터 값
            )
    )
    @GeneratedValue(generator = "idGeneratorMemberMst")
    @Column
    private String memberMstId;

    private String username;

    private int age;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "member")
    @ToString.Exclude
    private List<OrderMst> orders = new ArrayList<>();

    public void changeName(String username) {
        this.username = username;
    }

    public void changeAge(int age) {
        this.age = age;
    }

}
