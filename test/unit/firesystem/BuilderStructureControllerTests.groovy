package firesystem



import org.junit.*
import grails.test.mixin.*

@TestFor(BuilderStructureController)
@Mock(BuilderStructure)
class BuilderStructureControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/builderStructure/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.builderStructureInstanceList.size() == 0
        assert model.builderStructureInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.builderStructureInstance != null
    }

    void testSave() {
        controller.save()

        assert model.builderStructureInstance != null
        assert view == '/builderStructure/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/builderStructure/show/1'
        assert controller.flash.message != null
        assert BuilderStructure.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/builderStructure/list'


        populateValidParams(params)
        def builderStructure = new BuilderStructure(params)

        assert builderStructure.save() != null

        params.id = builderStructure.id

        def model = controller.show()

        assert model.builderStructureInstance == builderStructure
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/builderStructure/list'


        populateValidParams(params)
        def builderStructure = new BuilderStructure(params)

        assert builderStructure.save() != null

        params.id = builderStructure.id

        def model = controller.edit()

        assert model.builderStructureInstance == builderStructure
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/builderStructure/list'

        response.reset()


        populateValidParams(params)
        def builderStructure = new BuilderStructure(params)

        assert builderStructure.save() != null

        // test invalid parameters in update
        params.id = builderStructure.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/builderStructure/edit"
        assert model.builderStructureInstance != null

        builderStructure.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/builderStructure/show/$builderStructure.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        builderStructure.clearErrors()

        populateValidParams(params)
        params.id = builderStructure.id
        params.version = -1
        controller.update()

        assert view == "/builderStructure/edit"
        assert model.builderStructureInstance != null
        assert model.builderStructureInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/builderStructure/list'

        response.reset()

        populateValidParams(params)
        def builderStructure = new BuilderStructure(params)

        assert builderStructure.save() != null
        assert BuilderStructure.count() == 1

        params.id = builderStructure.id

        controller.delete()

        assert BuilderStructure.count() == 0
        assert BuilderStructure.get(builderStructure.id) == null
        assert response.redirectedUrl == '/builderStructure/list'
    }
}
