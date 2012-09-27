package firesystem



import org.junit.*
import grails.test.mixin.*

@TestFor(FireFightingFacilitiesController)
@Mock(FireFightingFacilities)
class FireFightingFacilitiesControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/fireFightingFacilities/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.fireFightingFacilitiesInstanceList.size() == 0
        assert model.fireFightingFacilitiesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.fireFightingFacilitiesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.fireFightingFacilitiesInstance != null
        assert view == '/fireFightingFacilities/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/fireFightingFacilities/show/1'
        assert controller.flash.message != null
        assert FireFightingFacilities.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/fireFightingFacilities/list'


        populateValidParams(params)
        def fireFightingFacilities = new FireFightingFacilities(params)

        assert fireFightingFacilities.save() != null

        params.id = fireFightingFacilities.id

        def model = controller.show()

        assert model.fireFightingFacilitiesInstance == fireFightingFacilities
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/fireFightingFacilities/list'


        populateValidParams(params)
        def fireFightingFacilities = new FireFightingFacilities(params)

        assert fireFightingFacilities.save() != null

        params.id = fireFightingFacilities.id

        def model = controller.edit()

        assert model.fireFightingFacilitiesInstance == fireFightingFacilities
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/fireFightingFacilities/list'

        response.reset()


        populateValidParams(params)
        def fireFightingFacilities = new FireFightingFacilities(params)

        assert fireFightingFacilities.save() != null

        // test invalid parameters in update
        params.id = fireFightingFacilities.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/fireFightingFacilities/edit"
        assert model.fireFightingFacilitiesInstance != null

        fireFightingFacilities.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/fireFightingFacilities/show/$fireFightingFacilities.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        fireFightingFacilities.clearErrors()

        populateValidParams(params)
        params.id = fireFightingFacilities.id
        params.version = -1
        controller.update()

        assert view == "/fireFightingFacilities/edit"
        assert model.fireFightingFacilitiesInstance != null
        assert model.fireFightingFacilitiesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/fireFightingFacilities/list'

        response.reset()

        populateValidParams(params)
        def fireFightingFacilities = new FireFightingFacilities(params)

        assert fireFightingFacilities.save() != null
        assert FireFightingFacilities.count() == 1

        params.id = fireFightingFacilities.id

        controller.delete()

        assert FireFightingFacilities.count() == 0
        assert FireFightingFacilities.get(fireFightingFacilities.id) == null
        assert response.redirectedUrl == '/fireFightingFacilities/list'
    }
}
