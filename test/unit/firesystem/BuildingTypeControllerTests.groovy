package firesystem



import org.junit.*
import grails.test.mixin.*

@TestFor(BuildingTypeController)
@Mock(BuildingType)
class BuildingTypeControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/buildingType/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.buildingTypeInstanceList.size() == 0
        assert model.buildingTypeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.buildingTypeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.buildingTypeInstance != null
        assert view == '/buildingType/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/buildingType/show/1'
        assert controller.flash.message != null
        assert BuildingType.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/buildingType/list'


        populateValidParams(params)
        def buildingType = new BuildingType(params)

        assert buildingType.save() != null

        params.id = buildingType.id

        def model = controller.show()

        assert model.buildingTypeInstance == buildingType
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/buildingType/list'


        populateValidParams(params)
        def buildingType = new BuildingType(params)

        assert buildingType.save() != null

        params.id = buildingType.id

        def model = controller.edit()

        assert model.buildingTypeInstance == buildingType
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/buildingType/list'

        response.reset()


        populateValidParams(params)
        def buildingType = new BuildingType(params)

        assert buildingType.save() != null

        // test invalid parameters in update
        params.id = buildingType.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/buildingType/edit"
        assert model.buildingTypeInstance != null

        buildingType.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/buildingType/show/$buildingType.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        buildingType.clearErrors()

        populateValidParams(params)
        params.id = buildingType.id
        params.version = -1
        controller.update()

        assert view == "/buildingType/edit"
        assert model.buildingTypeInstance != null
        assert model.buildingTypeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/buildingType/list'

        response.reset()

        populateValidParams(params)
        def buildingType = new BuildingType(params)

        assert buildingType.save() != null
        assert BuildingType.count() == 1

        params.id = buildingType.id

        controller.delete()

        assert BuildingType.count() == 0
        assert BuildingType.get(buildingType.id) == null
        assert response.redirectedUrl == '/buildingType/list'
    }
}
