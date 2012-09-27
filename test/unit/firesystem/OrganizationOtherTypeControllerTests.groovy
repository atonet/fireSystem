package firesystem



import org.junit.*
import grails.test.mixin.*

@TestFor(OrganizationOtherTypeController)
@Mock(OrganizationOtherType)
class OrganizationOtherTypeControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/organizationOtherType/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.organizationOtherTypeInstanceList.size() == 0
        assert model.organizationOtherTypeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.organizationOtherTypeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.organizationOtherTypeInstance != null
        assert view == '/organizationOtherType/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/organizationOtherType/show/1'
        assert controller.flash.message != null
        assert OrganizationOtherType.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/organizationOtherType/list'


        populateValidParams(params)
        def organizationOtherType = new OrganizationOtherType(params)

        assert organizationOtherType.save() != null

        params.id = organizationOtherType.id

        def model = controller.show()

        assert model.organizationOtherTypeInstance == organizationOtherType
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/organizationOtherType/list'


        populateValidParams(params)
        def organizationOtherType = new OrganizationOtherType(params)

        assert organizationOtherType.save() != null

        params.id = organizationOtherType.id

        def model = controller.edit()

        assert model.organizationOtherTypeInstance == organizationOtherType
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/organizationOtherType/list'

        response.reset()


        populateValidParams(params)
        def organizationOtherType = new OrganizationOtherType(params)

        assert organizationOtherType.save() != null

        // test invalid parameters in update
        params.id = organizationOtherType.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/organizationOtherType/edit"
        assert model.organizationOtherTypeInstance != null

        organizationOtherType.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/organizationOtherType/show/$organizationOtherType.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        organizationOtherType.clearErrors()

        populateValidParams(params)
        params.id = organizationOtherType.id
        params.version = -1
        controller.update()

        assert view == "/organizationOtherType/edit"
        assert model.organizationOtherTypeInstance != null
        assert model.organizationOtherTypeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/organizationOtherType/list'

        response.reset()

        populateValidParams(params)
        def organizationOtherType = new OrganizationOtherType(params)

        assert organizationOtherType.save() != null
        assert OrganizationOtherType.count() == 1

        params.id = organizationOtherType.id

        controller.delete()

        assert OrganizationOtherType.count() == 0
        assert OrganizationOtherType.get(organizationOtherType.id) == null
        assert response.redirectedUrl == '/organizationOtherType/list'
    }
}
