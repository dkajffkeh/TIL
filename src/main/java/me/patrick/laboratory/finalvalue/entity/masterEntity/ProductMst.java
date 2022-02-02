package me.patrick.laboratory.finalvalue.entity.masterEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Table(name ="PRODUCT_MST")
public class ProductMst {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String productName;

    private int productPrice;
}
