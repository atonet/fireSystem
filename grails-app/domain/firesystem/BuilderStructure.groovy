package firesystem

class BuilderStructure {
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
