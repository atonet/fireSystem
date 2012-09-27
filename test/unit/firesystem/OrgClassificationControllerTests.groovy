package firesystem



import org.junit.*
import grails.test.mixin.*

@TestFor(OrgClassificationController)
@Mock(OrgClassification)
class OrgClassificationControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/orgClassification/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.orgClassificationInstanceList.size() == 0
        assert model.orgClassificationInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.orgClassificationInstance != null
    }

    void testSave() {
        controller.save()

        assert model.orgClassificationInstance != null
        assert view == '/orgClassification/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/orgClassification/show/1'
        assert controller.flash.message != null
        assert OrgClassification.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/orgClassification/list'


        populateValidParams(params)
        def orgClassification = new OrgClassification(params)

        assert orgClassification.save() != null

        params.id = orgClassification.id

        def model = controller.show()

        assert model.orgClassificationInstance == orgClassification
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/orgClassification/list'


        populateValidParams(params)
        def orgClassification = new OrgClassification(params)

        assert orgClassification.save() != null

        params.id = orgClassification.id

        def model = controller.edit()

        assert model.orgClassificationInstance == orgClassification
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/orgClassification/list'

        response.reset()


        populateValidParams(params)
        def orgClassification = new OrgClassification(params)

        assert orgClassification.save() != null

        // test invalid parameters in update
        params.id = orgClassification.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/orgClassification/edit"
        assert model.orgClassificationInstance != null

        orgClassification.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/orgClassification/show/$orgClassification.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        orgClassification.clearErrors()

        populateValidParams(params)
        params.id = orgClassification.id
        params.version = -1
        controller.update()

        assert view == "/orgClassification/edit"
        assert model.orgClassificationInstance != null
        assert model.orgClassificationInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/orgClassification/list'

        response.reset()

        populateValidParams(params)
        def orgClassification = new OrgClassification(params)

        assert orgClassification.save() != null
        assert OrgClassification.count() == 1

        params.id = orgClassification.id

        controller.delete()

        assert OrgClassification.count() == 0
        assert OrgClassification.get(orgClassification.id) == null
        assert response.redirectedUrl == '/orgClassification/list'
    }
}
