package me.patrick.laboratory.repository;

import me.patrick.laboratory.finalvalue.entity.masterEntity.OrderMst;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMst, Long> {


}
