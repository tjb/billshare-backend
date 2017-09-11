package com.billshare.billshare

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = arrayOf("com.billshare"))
@EnableJpaRepositories(basePackages = arrayOf("com.billshare"))
@EntityScan(basePackages = arrayOf("com.billshare"))
class BillshareApplication

fun main(args: Array<String>) {
    SpringApplication.run(BillshareApplication::class.java, *args)
}
