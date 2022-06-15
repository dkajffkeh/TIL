package me.patrick.laboratory.finalvalue.entity.masterEntity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
@Table(name = "PAYMENT_MST")
public class PaymentMst {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_mst_id")
    private OrderMst order;

    @Column
    private int productPrice;

}
