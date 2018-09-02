package com.juicelabs.fhir.model

import java.net.URI
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/datatypes.html#Identifier
 */

@Entity
data class Identifier(
        val use: String? = null,

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "codeable_concept_id")
        val type: CodeableConcept? = null,

        val system: URI? = null,

        val value: String? = null,

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "period_id")
        val period: Period? = null

        // todo val assigner
): Base()


//class Token(@field:JsonProperty("access_token")
//            private val accessToken: String, @field:JsonProperty("expires_in")
//            private val expiresIn: String, @field:JsonProperty("scope")
//            private val scope: String, @field:JsonProperty("token_type")
//            private val tokenType: String, @field:JsonProperty("refresh_token")
//            private val refreshToken: String, private val foobar: String)
