package com.module.vendor.controller

import com.module.vendor.controller.payload.TestListPayload
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/kotlin")
class VendorKotlinTestController {

    @GetMapping("/test")
    fun testMethod() : String {
        return "Hello World"
    }

    @GetMapping("/test/list")
    fun testListMethod() : List<TestListPayload> {
        return listOf(TestListPayload("title1","content1"), TestListPayload("title","content2"));
    }

    @PostMapping("/order")
    fun createOrder() : String = "Order Created"

    @PatchMapping("/order")
    fun rollbackOrder() : String = "Order Rollback"

    @PostMapping("/payment")
    fun createPayment() : String = "Payment Created"

    @PatchMapping("/payment")
    fun rollbackPayment() : String = "Rollback Created"

    @PostMapping("/bill")
    fun getBull() : String = "Bill"


}