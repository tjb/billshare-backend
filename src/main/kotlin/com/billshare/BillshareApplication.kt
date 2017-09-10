package com.billshare.billshare

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class BillshareApplication

fun main(args: Array<String>) {
    SpringApplication.run(BillshareApplication::class.java, *args)
}
