package me.patrick.laboratory.finalvalue.masterEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.patrick.laboratory.finalvalue.entity.OrderProduct;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "ORDER_MST")
public class OrderMst {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String paymentBankName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "order")
    List<OrderProduct> orderProducts;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private MemberMst member;
}
