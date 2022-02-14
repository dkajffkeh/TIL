package me.patrick.laboratory.finalvalue.entity.masterEntity;

import lombok.*;
import me.patrick.laboratory.common.idgenerator.SeqGenerator;
import me.patrick.laboratory.finalvalue.entity.OrderProduct;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
@ToString
@Table(name = "ORDER_MST")
public class OrderMst {

    private static final String PROCEDURE_PARAM = "ORDER_MST";

    @Id
    @GenericGenerator(name = "idGeneratorOrderMst", //@GeneratedValue의 generator modifier에서 사용할 이름
            strategy = "me.patrick.laboratory.common.idgenerator.SeqGenerator", // IdentifierGenerator 인터페이스를 구현한 클래스 이름. 전체 패키지를 포함한 클래스 이름을 적어야 합니다.
            parameters = @org.hibernate.annotations.Parameter( // Configurable 인터페이스 구현 클래스에 넘겨줄 파라미터 설정
                    name = SeqGenerator.SEQ_GENERATOR_PARAM_KEY, // 파라미터의 키 이름. SeqGenerator 클래스에 선언해둔 상수를 사용
                    value = PROCEDURE_PARAM // 위의 name modifier에 선언한 키에 넘겨줄 파라미터 값
            )
    )
    @GeneratedValue(generator = "idGeneratorOrderMst")
    @Column
    private String orderMstId;

    @Column
    private String paymentBankName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "order")
    @ToString.Exclude
    List<OrderProduct> orderProducts;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private MemberMst member;
}
