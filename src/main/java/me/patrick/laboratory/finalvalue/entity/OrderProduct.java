package me.patrick.laboratory.finalvalue.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.patrick.laboratory.common.idgenerator.SeqGenerator;
import me.patrick.laboratory.finalvalue.entity.masterEntity.OrderMst;
import me.patrick.laboratory.finalvalue.entity.masterEntity.ProductMst;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Table(name ="ORDER_PRODUCT_INFO")
public class OrderProduct {


    private static final String PROCEDURE_PARAM = "ORDER_PRODUCT_INF";

    @Id
    @GenericGenerator(name = "idGeneratorOrderProductInf", //@GeneratedValue의 generator modifier에서 사용할 이름
            strategy = "me.patrick.laboratory.common.idgenerator.SeqGenerator", // IdentifierGenerator 인터페이스를 구현한 클래스 이름. 전체 패키지를 포함한 클래스 이름을 적어야 합니다.
            parameters = @org.hibernate.annotations.Parameter( // Configurable 인터페이스 구현 클래스에 넘겨줄 파라미터 설정
                    name = SeqGenerator.SEQ_GENERATOR_PARAM_KEY, // 파라미터의 키 이름. SeqGenerator 클래스에 선언해둔 상수를 사용
                    value = PROCEDURE_PARAM // 위의 name modifier에 선언한 키에 넘겨줄 파라미터 값
            )
    )
    @GeneratedValue(generator = "idGeneratorOrderProductInf")
    @Column
    private String orderProductInfId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_mst_id")
    private OrderMst order;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_mst_id")
    private ProductMst product;

    @Column
    private int quantity;

}
