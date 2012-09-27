package firesystem

class District {
    String name
    static belongsTo = [city:City]
    Date dateCreated
    Date lastUpdated
    static constraints = {
        name()
        city()
        dateCreated()
        lastUpdated()
    }
    String toString() {name}
}
