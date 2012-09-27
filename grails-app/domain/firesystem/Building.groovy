package firesystem

class Building {
    String name
    String address
    District district
    String occupies //占地面积
    String buildArea //建筑面积
    String maxPersonNum//容纳人数
    String upperArea //地上建筑面积
    String underArea //地下建筑面积
    String upperFloor//地上层数
    String underFloor//地下层数
    String height //高度
    String contact //联系人
    String contactPhone//联系人电话
    BuildingOwnerType buildingOwnerType //独占，分享
    BuildingType buildingType  //建筑分类
    BuildingStatus buildingStatus//在建，已建
    Date buildingFinishDate  //竣工时间
    String refugeFloorNum  //避难层层数
    String refugeFloorArea         //  避难层面积
    String refugeFloorAddress     //避难层位置
    String fireLiftNum                //消防电梯个数
    String fireLiftAddress  //消防电梯位置
    BuilderStructure builderStructure //建筑结构
    FireRating fireRating //防火等级
    FireFightingFacilitiesStatus fireFightingFacilitiesStatus
    String fireControlRoomAddress                   //监控室位置
    String neighborBuildingStatus
    String comment

    Date dateCreated
    Date lastUpdated
    static searchable = true
    static hasMany = [fireFightingFacilities: FireFightingFacilities, organization: Organization]  //消防设施
    static belongsTo = Organization
//    static transients = ['builderStructureName', "buildingOwnerTypeName", "buildingTypeName", "buildingStatusName", "fireRatingName", "fireFightingFacilitiesStatusName", "districtName"]
    static constraints = {
        name()
        address()
        organization()
        district()
        occupies()
        buildArea()
        maxPersonNum()
        upperArea()
        underArea()
        upperFloor()
        underFloor()
        height()
        contact()
        contactPhone()
        buildingOwnerType()
        buildingType()
        buildingStatus()
        buildingFinishDate()
        refugeFloorNum()
        refugeFloorArea()
        refugeFloorAddress()
        fireLiftNum()
        fireLiftAddress()
        builderStructure()
        fireRating()
        fireFightingFacilitiesStatus()
        fireControlRoomAddress()
        fireFightingFacilities()
        neighborBuildingStatus()
        dateCreated()
        lastUpdated()
    }
    static mapping = {
        sort dateCreated: "desc"
    }

    String toString() {name}
}
