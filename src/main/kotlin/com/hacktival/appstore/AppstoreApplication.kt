package com.hacktival.appstore

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AppstoreApplication

fun main(args: Array<String>) {
	SpringApplication.run(AppstoreApplication::class.java, *args)
}
