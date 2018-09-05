package com.juicelabs.fhir.model.datatypes

import com.juicelabs.fhir.model.Base
import java.io.Serializable
import java.net.URI
import java.sql.Timestamp
import javax.persistence.*

/**
 * import com.sun.xml.internal.ws.api.message.Attachment
 */

@Entity
data class Attachment(
        val contentType: String?,
        val language: String?,
        val data: Byte?,
        val uri: URI?,
        val size: Int,
        val hash: Byte?,
        val title: String,
        val creation: Timestamp // todo right type?
): Base(), Serializable