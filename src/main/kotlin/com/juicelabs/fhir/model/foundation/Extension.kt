package com.juicelabs.fhir.model.foundation

import com.juicelabs.fhir.model.Base
import java.net.URI
import javax.persistence.Entity

/**
 * https://www.hl7.org/fhir/extensibility.html#Extension
 */
@Entity
open class Extension(
        val uri: URI

//        val value: todo value enum
) : Base()
