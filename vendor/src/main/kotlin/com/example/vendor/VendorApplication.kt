package com.example.vendor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VendorApplication

fun main(args: Array<String>) {
    runApplication<VendorApplication>(*args)
}
