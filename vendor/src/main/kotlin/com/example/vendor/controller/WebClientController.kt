package com.example.vendor.controller

import com.example.vendor.dummy.domain.Customer
import com.example.vendor.dummy.domain.CustomerPayload
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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

    @GetMapping("/customers/{id}")
    fun findById(@PathVariable("id") id : Long ) = CustomerPayload(data = customers.find { it.id == id}!!)
}