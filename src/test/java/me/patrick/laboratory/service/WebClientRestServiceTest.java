package me.patrick.laboratory.service;

import me.patrick.laboratory.param.Customer;
import me.patrick.laboratory.param.ResultEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WebClientRestServiceTest {

    @Autowired
    private WebClientRestService webClientRestService;

    @Test
    @DisplayName("postTest")
    void postTest() {



    }

    @Test
    @DisplayName("getTest")
    void getTest() {

        final ResultEntity<Customer> res = webClientRestService.requestGet(
                "/v1/customers/{id}",
                Customer.class,
                null
                );

        assertEquals(res.getCode(),"000000");

    }

}