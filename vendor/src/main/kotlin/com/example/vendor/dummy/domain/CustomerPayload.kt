package com.example.vendor.dummy.domain

data class CustomerPayload(
    val code : String = "000000",
    val message : String = "OK",
    val data : Customer
)
