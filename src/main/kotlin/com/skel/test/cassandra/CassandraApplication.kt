package com.skel.test.cassandra

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CassandraApplication

fun main(args: Array<String>) {
    runApplication<CassandraApplication>(*args)
}
