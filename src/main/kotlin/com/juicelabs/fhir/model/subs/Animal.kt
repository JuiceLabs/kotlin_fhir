package com.juicelabs.fhir.model.subs

import com.juicelabs.fhir.model.Base
import com.juicelabs.fhir.model.datatypes.CodeableConcept
import java.io.Serializable
import javax.persistence.*

@Entity
data class Animal(
        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "species_code_id")
        val species: CodeableConcept?,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "breed_id")
        val breed: CodeableConcept?,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "gender_status_id")
        val genderStatus: CodeableConcept?
) : Base(), Serializable