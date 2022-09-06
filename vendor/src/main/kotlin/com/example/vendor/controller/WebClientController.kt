package com.example.vendor.controller

import com.example.vendor.dummy.domain.Customer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class WebClientController(
    private val customers : MutableList<Customer>
) {

    @GetMapping("/test")
    fun webClientHost() = "Hello World";

    @GetMapping("/find/all")
    fun findAll() = customers;

    @GetMapping("")
    fun findByLastname(lastName : String) : Customer {
        return customers.find { it.lastName.equals(lastName) } ?: throw RuntimeException("Error");
    }
}