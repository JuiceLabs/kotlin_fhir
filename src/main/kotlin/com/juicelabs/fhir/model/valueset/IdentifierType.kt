package com.juicelabs.fhir.model.valueset

/**
 * https://www.hl7.org/fhir/valueset-identifier-type.html
 */
enum class IdentifierType(description: String) {
    DL("Driver's license number"),
    PPN("Passport number"),
    BRN("Breed Registry Number"),
    MR("Medical record number"),
    MCN("Microchip Number"),
    EN("Employer number"),
    TAX("Tax ID number"),
    NIIP("National Insurance Payor Identifier (Payor)"),
    PRN("Provider number"),
    MD("Medical License number"),
    DR("Donor Registration Number"),
    ACSN("Accession ID")
}