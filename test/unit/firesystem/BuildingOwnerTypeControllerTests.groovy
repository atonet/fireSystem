package firesystem



import org.junit.*
import grails.test.mixin.*

@TestFor(BuildingOwnerTypeController)
@Mock(BuildingOwnerType)
class BuildingOwnerTypeControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/buildingOwnerType/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.buildingOwnerTypeInstanceList.size() == 0
        assert model.buildingOwnerTypeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.buildingOwnerTypeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.buildingOwnerTypeInstance != null
        assert view == '/buildingOwnerType/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/buildingOwnerType/show/1'
        assert controller.flash.message != null
        assert BuildingOwnerType.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/buildingOwnerType/list'


        populateValidParams(params)
        def buildingOwnerType = new BuildingOwnerType(params)

        assert buildingOwnerType.save() != null

        params.id = buildingOwnerType.id

        def model = controller.show()

        assert model.buildingOwnerTypeInstance == buildingOwnerType
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/buildingOwnerType/list'


        populateValidParams(params)
        def buildingOwnerType = new BuildingOwnerType(params)

        assert buildingOwnerType.save() != null

        params.id = buildingOwnerType.id

        def model = controller.edit()

        assert model.buildingOwnerTypeInstance == buildingOwnerType
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/buildingOwnerType/list'

        response.reset()


        populateValidParams(params)
        def buildingOwnerType = new BuildingOwnerType(params)

        assert buildingOwnerType.save() != null

        // test invalid parameters in update
        params.id = buildingOwnerType.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/buildingOwnerType/edit"
        assert model.buildingOwnerTypeInstance != null

        buildingOwnerType.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/buildingOwnerType/show/$buildingOwnerType.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        buildingOwnerType.clearErrors()

        populateValidParams(params)
        params.id = buildingOwnerType.id
        params.version = -1
        controller.update()

        assert view == "/buildingOwnerType/edit"
        assert model.buildingOwnerTypeInstance != null
        assert model.buildingOwnerTypeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/buildingOwnerType/list'

        response.reset()

        populateValidParams(params)
        def buildingOwnerType = new BuildingOwnerType(params)

        assert buildingOwnerType.save() != null
        assert BuildingOwnerType.count() == 1

        params.id = buildingOwnerType.id

        controller.delete()

        assert BuildingOwnerType.count() == 0
        assert BuildingOwnerType.get(buildingOwnerType.id) == null
        assert response.redirectedUrl == '/buildingOwnerType/list'
    }
}
