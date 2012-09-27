package firesystem



import org.junit.*
import grails.test.mixin.*

@TestFor(BuildingStatusController)
@Mock(BuildingStatus)
class BuildingStatusControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/buildingStatus/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.buildingStatusInstanceList.size() == 0
        assert model.buildingStatusInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.buildingStatusInstance != null
    }

    void testSave() {
        controller.save()

        assert model.buildingStatusInstance != null
        assert view == '/buildingStatus/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/buildingStatus/show/1'
        assert controller.flash.message != null
        assert BuildingStatus.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/buildingStatus/list'


        populateValidParams(params)
        def buildingStatus = new BuildingStatus(params)

        assert buildingStatus.save() != null

        params.id = buildingStatus.id

        def model = controller.show()

        assert model.buildingStatusInstance == buildingStatus
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/buildingStatus/list'


        populateValidParams(params)
        def buildingStatus = new BuildingStatus(params)

        assert buildingStatus.save() != null

        params.id = buildingStatus.id

        def model = controller.edit()

        assert model.buildingStatusInstance == buildingStatus
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/buildingStatus/list'

        response.reset()


        populateValidParams(params)
        def buildingStatus = new BuildingStatus(params)

        assert buildingStatus.save() != null

        // test invalid parameters in update
        params.id = buildingStatus.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/buildingStatus/edit"
        assert model.buildingStatusInstance != null

        buildingStatus.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/buildingStatus/show/$buildingStatus.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        buildingStatus.clearErrors()

        populateValidParams(params)
        params.id = buildingStatus.id
        params.version = -1
        controller.update()

        assert view == "/buildingStatus/edit"
        assert model.buildingStatusInstance != null
        assert model.buildingStatusInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/buildingStatus/list'

        response.reset()

        populateValidParams(params)
        def buildingStatus = new BuildingStatus(params)

        assert buildingStatus.save() != null
        assert BuildingStatus.count() == 1

        params.id = buildingStatus.id

        controller.delete()

        assert BuildingStatus.count() == 0
        assert BuildingStatus.get(buildingStatus.id) == null
        assert response.redirectedUrl == '/buildingStatus/list'
    }
}
