package me.patrick.laboratory.finalvalue.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.patrick.laboratory.finalvalue.masterEntity.OrderMst;
import me.patrick.laboratory.finalvalue.masterEntity.ProductMst;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Table(name ="ORDER_PRODUCT_INFO")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_mst_id")
    private OrderMst order;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_mst_id")
    private ProductMst product;

    @Column
    private int quantity;

}
