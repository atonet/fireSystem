package firesystem



import org.junit.*
import grails.test.mixin.*

@TestFor(FireFightingFacilitiesStatusController)
@Mock(FireFightingFacilitiesStatus)
class FireFightingFacilitiesStatusControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/fireFightingFacilitiesStatus/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.fireFightingFacilitiesStatusInstanceList.size() == 0
        assert model.fireFightingFacilitiesStatusInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.fireFightingFacilitiesStatusInstance != null
    }

    void testSave() {
        controller.save()

        assert model.fireFightingFacilitiesStatusInstance != null
        assert view == '/fireFightingFacilitiesStatus/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/fireFightingFacilitiesStatus/show/1'
        assert controller.flash.message != null
        assert FireFightingFacilitiesStatus.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/fireFightingFacilitiesStatus/list'


        populateValidParams(params)
        def fireFightingFacilitiesStatus = new FireFightingFacilitiesStatus(params)

        assert fireFightingFacilitiesStatus.save() != null

        params.id = fireFightingFacilitiesStatus.id

        def model = controller.show()

        assert model.fireFightingFacilitiesStatusInstance == fireFightingFacilitiesStatus
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/fireFightingFacilitiesStatus/list'


        populateValidParams(params)
        def fireFightingFacilitiesStatus = new FireFightingFacilitiesStatus(params)

        assert fireFightingFacilitiesStatus.save() != null

        params.id = fireFightingFacilitiesStatus.id

        def model = controller.edit()

        assert model.fireFightingFacilitiesStatusInstance == fireFightingFacilitiesStatus
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/fireFightingFacilitiesStatus/list'

        response.reset()


        populateValidParams(params)
        def fireFightingFacilitiesStatus = new FireFightingFacilitiesStatus(params)

        assert fireFightingFacilitiesStatus.save() != null

        // test invalid parameters in update
        params.id = fireFightingFacilitiesStatus.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/fireFightingFacilitiesStatus/edit"
        assert model.fireFightingFacilitiesStatusInstance != null

        fireFightingFacilitiesStatus.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/fireFightingFacilitiesStatus/show/$fireFightingFacilitiesStatus.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        fireFightingFacilitiesStatus.clearErrors()

        populateValidParams(params)
        params.id = fireFightingFacilitiesStatus.id
        params.version = -1
        controller.update()

        assert view == "/fireFightingFacilitiesStatus/edit"
        assert model.fireFightingFacilitiesStatusInstance != null
        assert model.fireFightingFacilitiesStatusInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/fireFightingFacilitiesStatus/list'

        response.reset()

        populateValidParams(params)
        def fireFightingFacilitiesStatus = new FireFightingFacilitiesStatus(params)

        assert fireFightingFacilitiesStatus.save() != null
        assert FireFightingFacilitiesStatus.count() == 1

        params.id = fireFightingFacilitiesStatus.id

        controller.delete()

        assert FireFightingFacilitiesStatus.count() == 0
        assert FireFightingFacilitiesStatus.get(fireFightingFacilitiesStatus.id) == null
        assert response.redirectedUrl == '/fireFightingFacilitiesStatus/list'
    }
}
