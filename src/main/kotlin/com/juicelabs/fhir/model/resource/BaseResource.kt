package com.juicelabs.fhir.model.resource

import com.juicelabs.fhir.model.datatypes.Identifier
import javax.persistence.*

@MappedSuperclass
open class BaseResource (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
    @JoinColumn(name = "patient_id")
    val identifier: List<Identifier>,

    val active: Boolean = false
    )