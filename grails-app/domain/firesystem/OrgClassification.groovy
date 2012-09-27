package firesystem

class OrgClassification {
    String name
    Date dateCreated
    Date lastUpdated
    static belongsTo = [parent: OrgClassification];
    static hasMany = [childrens: OrgClassification];
    static transients = ['allChildrens']
    static constraints = {
        parent(nullable: true)
    }
    boolean isLeaf() {
        //determines if this node is a leaf node. a leaf is a node with zero childrens
        return childrens.isEmpty()
    }
    def getAllChildrens() {
        childrens ? childrens + childrens*.allChildrens.flatten() : []
    }
    String toString() {name}
}
