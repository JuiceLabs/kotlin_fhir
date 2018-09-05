package com.juicelabs.fhir.model.subs

import com.juicelabs.fhir.model.Base
import com.juicelabs.fhir.model.datatypes.*
import java.io.Serializable
import javax.persistence.*

@Entity
data class Contact(
        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "contact_id")
        val relationship: List<CodeableConcept>?,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "human_name_id")
        val name: HumanName?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "contact_id")
        val telecom: List<ContactPoint>,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "address_id")
        val address: Address?,

        val gender: String?,

//        val organization: ref...  todo fix

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "period_id")
        val period: Period?
) : Base(), Serializable
