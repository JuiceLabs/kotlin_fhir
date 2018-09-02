package com.juicelabs.fhir

import com.juicelabs.fhir.model.Address
import com.juicelabs.fhir.model.Patient
import org.springframework.data.repository.CrudRepository


interface PatientRepository : CrudRepository<Patient, Long> {
//    fun findByCode(code: String): Icd9Dx
//
//    fun findByLongNameContaining(phrase: String): List<Icd9Dx>
}

//interface AddressRepository : CrudRepository<Address, Long>
