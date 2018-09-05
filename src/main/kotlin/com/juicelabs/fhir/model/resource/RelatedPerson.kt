package com.juicelabs.fhir.model.resource

import com.juicelabs.fhir.model.datatypes.*
import java.time.LocalDate
import javax.persistence.*

@Entity
open class RelatedPerson(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val identifier: List<Identifier>,

        val active: Boolean = false,

        // patient reference todo

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val name: List<HumanName>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val telecom: List<ContactPoint>?,

        val gender: String,

        val birthDate: LocalDate,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val address: List<Address>?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "attachment_id")
        val photo: List<Attachment>,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "period_id")
        val period: Period?
)