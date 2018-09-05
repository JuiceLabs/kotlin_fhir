package com.juicelabs.fhir.model.foundation

import com.juicelabs.fhir.model.Base
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToMany


/**
 * https://www.hl7.org/fhir/backboneelement.html
 */
@Entity
open class BackboneElement(

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "extension_id")
        val modifierExtension: List<Extension>
) : Base()