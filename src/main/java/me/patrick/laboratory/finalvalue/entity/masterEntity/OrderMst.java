package me.patrick.laboratory.finalvalue.entity.masterEntity;

import static me.patrick.laboratory.common.type.OrderStatus.DONE;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.patrick.laboratory.common.type.OrderStatus;
import me.patrick.laboratory.finalvalue.entity.OrderProduct;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String paymentBankName;

    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "order")
    @ToString.Exclude
    List<OrderProduct> orderProducts;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "order")
    @ToString.Exclude
    List<PaymentMst> payments;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private MemberMst member;

    public void changeBankName(String bankName){
        this.paymentBankName = bankName;
    }

    public void processDone(){
        this.orderStatus = DONE;
    }
}
