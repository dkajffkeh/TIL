package me.patrick.laboratory.repository;

import me.patrick.laboratory.finalvalue.entity.masterEntity.PaymentMst;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentMst,Long> {

}
