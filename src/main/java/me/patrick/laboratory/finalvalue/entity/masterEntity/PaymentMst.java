package me.patrick.laboratory.finalvalue.entity.masterEntity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
@ToString
@Table(name = "PAYMENT_MST")
public class PaymentMst {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private OrderMst orderMst;
}
