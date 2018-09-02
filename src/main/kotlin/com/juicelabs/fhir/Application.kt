package com.juicelabs.fhir

import org.h2.tools.Server
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Application {

    @Bean
    fun exposeH2Port(): CommandLineRunner {
        return CommandLineRunner {
            val server = Server.createTcpServer().start()
            println("Running on H2 port: " + server.port + " " + server.url)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}