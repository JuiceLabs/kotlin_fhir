package com.juicelabs.fhir

import com.juicelabs.fhir.model.Patient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong
import javax.persistence.EntityManager
import javax.transaction.Transactional

@RestController
class GreetingController {

    val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(counter.incrementAndGet(), "Hello, $name")

}


data class Greeting(val id: Long, val content: String)

@RestController
@RequestMapping("/patient")
class PatientController @Autowired constructor(val repository: PatientRepository, val entityManager: EntityManager) {

    @PostMapping
    @Transactional // not here?
    fun addPatient(@RequestBody patient: Patient): String {
        println(patient)
        entityManager.persist(patient)
        print("ID: " + patient.id)
        return "foo"
    }

    @GetMapping
    fun getPatient(): Patient? {
        return null
    }

}



