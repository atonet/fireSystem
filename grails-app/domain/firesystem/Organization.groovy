package firesystem

class Organization {
    String name
    String address
    OrganizationType organizationType
    static hasMany = [organizationOtherType: OrganizationOtherType, building: Building]
    District district
    String owner
    String ownerPhone
    String ownerSID
    String fireFightingPerson
    String fireFightingPersonPhone
    String fireFightingPersonSID
    boolean autoFireSystem
    OrgClassification orgClassification
    Date dateCreated
    Date lastUpdated
    static searchable = true
    static constraints = {
        name()
        address()
        organizationType()
        organizationOtherType()
        fireFightingPerson()
        fireFightingPersonPhone()
        fireFightingPersonSID()
        autoFireSystem()
        district()
        owner()
        ownerPhone()
        ownerSID()
        orgClassification(nullable:true)
        dateCreated()
        lastUpdated()
    }
    static mapping = {
        sort dateCreated: "desc"
    }

    String toString() {name}
}
