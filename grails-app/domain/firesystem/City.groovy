package firesystem

class City {
    String name
    static hasMany = [district:District]
    Date dateCreated
    Date lastUpdated
    static constraints = {
        name()
        district()
        dateCreated()
        lastUpdated()
    }
    String toString() {name}
}
