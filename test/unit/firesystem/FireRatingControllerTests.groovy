package firesystem



import org.junit.*
import grails.test.mixin.*

@TestFor(FireRatingController)
@Mock(FireRating)
class FireRatingControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/fireRating/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.fireRatingInstanceList.size() == 0
        assert model.fireRatingInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.fireRatingInstance != null
    }

    void testSave() {
        controller.save()

        assert model.fireRatingInstance != null
        assert view == '/fireRating/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/fireRating/show/1'
        assert controller.flash.message != null
        assert FireRating.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/fireRating/list'


        populateValidParams(params)
        def fireRating = new FireRating(params)

        assert fireRating.save() != null

        params.id = fireRating.id

        def model = controller.show()

        assert model.fireRatingInstance == fireRating
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/fireRating/list'


        populateValidParams(params)
        def fireRating = new FireRating(params)

        assert fireRating.save() != null

        params.id = fireRating.id

        def model = controller.edit()

        assert model.fireRatingInstance == fireRating
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/fireRating/list'

        response.reset()


        populateValidParams(params)
        def fireRating = new FireRating(params)

        assert fireRating.save() != null

        // test invalid parameters in update
        params.id = fireRating.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/fireRating/edit"
        assert model.fireRatingInstance != null

        fireRating.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/fireRating/show/$fireRating.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        fireRating.clearErrors()

        populateValidParams(params)
        params.id = fireRating.id
        params.version = -1
        controller.update()

        assert view == "/fireRating/edit"
        assert model.fireRatingInstance != null
        assert model.fireRatingInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/fireRating/list'

        response.reset()

        populateValidParams(params)
        def fireRating = new FireRating(params)

        assert fireRating.save() != null
        assert FireRating.count() == 1

        params.id = fireRating.id

        controller.delete()

        assert FireRating.count() == 0
        assert FireRating.get(fireRating.id) == null
        assert response.redirectedUrl == '/fireRating/list'
    }
}
