package firesystem

import org.springframework.dao.DataIntegrityViolationException

class OrgClassificationController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [orgClassificationInstanceList: OrgClassification.list(params), orgClassificationInstanceTotal: OrgClassification.count()]
    }

    def create() {
        [orgClassificationInstance: new OrgClassification(params)]
    }

    def save() {
        def orgClassificationInstance = new OrgClassification(params)
        if (!orgClassificationInstance.save(flush: true)) {
            render(view: "create", model: [orgClassificationInstance: orgClassificationInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'orgClassification.label', default: 'OrgClassification'), orgClassificationInstance.id])
        redirect(action: "show", id: orgClassificationInstance.id)
    }

    def show() {
        def orgClassificationInstance = OrgClassification.get(params.id)
        if (!orgClassificationInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'orgClassification.label', default: 'OrgClassification'), params.id])
            redirect(action: "list")
            return
        }

        [orgClassificationInstance: orgClassificationInstance]
    }

    def edit() {
        def orgClassificationInstance = OrgClassification.get(params.id)
        if (!orgClassificationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'orgClassification.label', default: 'OrgClassification'), params.id])
            redirect(action: "list")
            return
        }

        [orgClassificationInstance: orgClassificationInstance]
    }

    def update() {
        def orgClassificationInstance = OrgClassification.get(params.id)
        if (!orgClassificationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'orgClassification.label', default: 'OrgClassification'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (orgClassificationInstance.version > version) {
                orgClassificationInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'orgClassification.label', default: 'OrgClassification')] as Object[],
                          "Another user has updated this OrgClassification while you were editing")
                render(view: "edit", model: [orgClassificationInstance: orgClassificationInstance])
                return
            }
        }

        orgClassificationInstance.properties = params

        if (!orgClassificationInstance.save(flush: true)) {
            render(view: "edit", model: [orgClassificationInstance: orgClassificationInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'orgClassification.label', default: 'OrgClassification'), orgClassificationInstance.id])
        redirect(action: "show", id: orgClassificationInstance.id)
    }

    def delete() {
        def orgClassificationInstance = OrgClassification.get(params.id)
        if (!orgClassificationInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'orgClassification.label', default: 'OrgClassification'), params.id])
            redirect(action: "list")
            return
        }

        try {
            orgClassificationInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'orgClassification.label', default: 'OrgClassification'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'orgClassification.label', default: 'OrgClassification'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
