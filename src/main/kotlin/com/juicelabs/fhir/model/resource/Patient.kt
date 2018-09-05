package com.juicelabs.fhir.model.resource

import com.juicelabs.fhir.model.datatypes.*
import com.juicelabs.fhir.model.subs.Animal
import com.juicelabs.fhir.model.subs.Communication
import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/patient.html
 */

@Entity
open class Patient(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "identifier_id")
        val identifier: List<Identifier>,

        val active: Boolean = false,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val name: List<HumanName>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val telecom: List<ContactPoint>?,

        val gender: String,
        val birthDate: LocalDate,
        val deceasedBoolean: Boolean = false,
        val deceasedDateTime: LocalDate? = null,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val address: List<Address>?,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "codeable_concept_id")
        val maritalStatus: CodeableConcept?,

        val multipleBirthBoolean: Boolean = false,
        val multipleBirthInteger: Int? = null,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "attachment_id")
        val photo: Attachment?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val contact: List<ContactPoint>?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val animal: List<Animal>?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val communication: List<Communication>?
//        val generalPractitioner: // todo
        // val managingOrganization: // todo
        // val link: // todd
) : Serializable





//
///**
// * https://www.hl7.org/fhir/valueset-marital-status.html
// */
//enum class MaritalStatusCode(display: String, definition: String) {
//    A("Annulled", "Marriage contract has been declared null and to not have existed"),
//    D("Divorced", "Marriage contract has been declared dissolved and inactive"),
//    I("Interlocutory", "Subject to an Interlocutory Decree."),
//    L("Legally Separated", "Legally Separated"),
//    M("Married", "A current marriage contract is active"),
//    P("Polygamous", "More than 1 current spouse"),
//    S("Never Married", "No marriage contract has ever been entered"),
//    T("Domestic partner", "Person declares that a domestic partner relationship exists."),
//    U("unmarried", "Currently not in a marriage contract."),
//    W("Widowed", "The spouse has died"),
//    UNK("unknown", "Description:A proper value is applicable, but not known.")
//}
//
//@Entity
//data class MaritalStatusCoding(
//        val code: MaritalStatusCode? = null
//): Base()
//
//@Entity
//data class MaritalStatusConcept(
//        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
//        @JoinColumn(name = "codeable_concept_id")
//        val coding: List<MaritalStatusCoding>,
//
//        val text: String? = null
//): Base()
//
///**
// * Code System Content
// */
//
//enum class CodeSystemContent(description: String) {
//    BP("Billing contact person"),
//    C("Emergency Contact"),
//    CP("Contact person"),
//    E("Employer"),
//    EP("Emergency contact person"),
//    F("Federal Agency"),
//    I("Insurance Company"),
//    N("Next-of-Kin	Kontaktperson"),
//    O("Other"),
//    PR("Person preparing referral"),
//    S("State Agency"),
//    U("Unknown")
//}
//
//@Entity
//data class RelationshipCoding(
//        val code: CodeSystemContent? = null
//): Base()
//
//@Entity
//data class RelationshipConcept(
//        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
//        @JoinColumn(name = "codeable_concept_id")
//        val coding: List<RelationshipCoding>,
//
//        val text: String? = null
//): Base()
