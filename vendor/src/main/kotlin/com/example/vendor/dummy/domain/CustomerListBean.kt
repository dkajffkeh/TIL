package com.example.vendor.dummy.domain

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CustomerListBean {

    @Bean
    fun customers() : MutableList<Customer> {
        return mutableListOf(
            Customer(1,"유","호연"),
            Customer(2,"홍","지운"),
            Customer(3,"김","종구"),
            Customer(4,"조","은채"),
            Customer(5,"허","수영"),
        )
    }
}