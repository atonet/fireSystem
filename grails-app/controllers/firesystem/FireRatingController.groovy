package firesystem

import org.springframework.dao.DataIntegrityViolationException

class FireRatingController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [fireRatingInstanceList: FireRating.list(params), fireRatingInstanceTotal: FireRating.count()]
    }

    def create() {
        [fireRatingInstance: new FireRating(params)]
    }

    def save() {
        def fireRatingInstance = new FireRating(params)
        if (!fireRatingInstance.save(flush: true)) {
            render(view: "create", model: [fireRatingInstance: fireRatingInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'fireRating.label', default: 'FireRating'), fireRatingInstance.id])
        redirect(action: "show", id: fireRatingInstance.id)
    }

    def show() {
        def fireRatingInstance = FireRating.get(params.id)
        if (!fireRatingInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'fireRating.label', default: 'FireRating'), params.id])
            redirect(action: "list")
            return
        }

        [fireRatingInstance: fireRatingInstance]
    }

    def edit() {
        def fireRatingInstance = FireRating.get(params.id)
        if (!fireRatingInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'fireRating.label', default: 'FireRating'), params.id])
            redirect(action: "list")
            return
        }

        [fireRatingInstance: fireRatingInstance]
    }

    def update() {
        def fireRatingInstance = FireRating.get(params.id)
        if (!fireRatingInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'fireRating.label', default: 'FireRating'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (fireRatingInstance.version > version) {
                fireRatingInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'fireRating.label', default: 'FireRating')] as Object[],
                        "Another user has updated this FireRating while you were editing")
                render(view: "edit", model: [fireRatingInstance: fireRatingInstance])
                return
            }
        }

        fireRatingInstance.properties = params

        if (!fireRatingInstance.save(flush: true)) {
            render(view: "edit", model: [fireRatingInstance: fireRatingInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'fireRating.label', default: 'FireRating'), fireRatingInstance.id])
        redirect(action: "show", id: fireRatingInstance.id)
    }

    def delete() {
        def fireRatingInstance = FireRating.get(params.id)
        if (!fireRatingInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'fireRating.label', default: 'FireRating'), params.id])
            redirect(action: "list")
            return
        }

        try {
            fireRatingInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'fireRating.label', default: 'FireRating'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'fireRating.label', default: 'FireRating'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
