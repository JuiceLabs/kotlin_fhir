package com.juicelabs.fhir.model.subs;

import com.juicelabs.fhir.model.Base
import com.juicelabs.fhir.model.datatypes.Period
import javax.persistence.*

@Entity
@Table(name = "LocationBackbone")
data class Location(
//        val location todo ref

        val status: String, // todo code

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "period_id")
        val period: Period?
): Base()

