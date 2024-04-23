package me.patrick.laboratory.repository;

import me.patrick.laboratory.finalvalue.entity.masterEntity.OrderMst;
import org.springframework.data.repository.Repository;

public interface OrderMasterRepository extends Repository<OrderMst, Long> {

    OrderMst findById(Long id);

}
