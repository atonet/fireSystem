package firesystem

class OrganizationType {
    String name
    Date dateCreated
    Date lastUpdated
    static constraints = {
        name()
        dateCreated()
        lastUpdated()

    }
    String toString() {name}
}
