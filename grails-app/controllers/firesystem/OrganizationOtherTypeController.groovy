package firesystem

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON

class OrganizationOtherTypeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [organizationOtherTypeInstanceList: OrganizationOtherType.list(params), organizationOtherTypeInstanceTotal: OrganizationOtherType.count()]
    }

    def create() {
        [organizationOtherTypeInstance: new OrganizationOtherType(params)]
    }

    def save() {
        def organizationOtherTypeInstance = new OrganizationOtherType(params)
        if (!organizationOtherTypeInstance.save(flush: true)) {
            render(view: "create", model: [organizationOtherTypeInstance: organizationOtherTypeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'organizationOtherType.label', default: 'OrganizationOtherType'), organizationOtherTypeInstance.id])
        redirect(action: "show", id: organizationOtherTypeInstance.id)
    }

    def show() {
        def organizationOtherTypeInstance = OrganizationOtherType.get(params.id)
        if (!organizationOtherTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'organizationOtherType.label', default: 'OrganizationOtherType'), params.id])
            redirect(action: "list")
            return
        }

        [organizationOtherTypeInstance: organizationOtherTypeInstance]
    }

    def edit() {
        def organizationOtherTypeInstance = OrganizationOtherType.get(params.id)
        if (!organizationOtherTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'organizationOtherType.label', default: 'OrganizationOtherType'), params.id])
            redirect(action: "list")
            return
        }

        [organizationOtherTypeInstance: organizationOtherTypeInstance]
    }

    def update() {
        def organizationOtherTypeInstance = OrganizationOtherType.get(params.id)
        if (!organizationOtherTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'organizationOtherType.label', default: 'OrganizationOtherType'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (organizationOtherTypeInstance.version > version) {
                organizationOtherTypeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'organizationOtherType.label', default: 'OrganizationOtherType')] as Object[],
                        "Another user has updated this OrganizationOtherType while you were editing")
                render(view: "edit", model: [organizationOtherTypeInstance: organizationOtherTypeInstance])
                return
            }
        }

        organizationOtherTypeInstance.properties = params

        if (!organizationOtherTypeInstance.save(flush: true)) {
            render(view: "edit", model: [organizationOtherTypeInstance: organizationOtherTypeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'organizationOtherType.label', default: 'OrganizationOtherType'), organizationOtherTypeInstance.id])
        redirect(action: "show", id: organizationOtherTypeInstance.id)
    }

    def delete() {
        def organizationOtherTypeInstance = OrganizationOtherType.get(params.id)
        if (!organizationOtherTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'organizationOtherType.label', default: 'OrganizationOtherType'), params.id])
            redirect(action: "list")
            return
        }

        try {
            organizationOtherTypeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'organizationOtherType.label', default: 'OrganizationOtherType'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'organizationOtherType.label', default: 'OrganizationOtherType'), params.id])
            redirect(action: "show", id: params.id)
        }
    }

    def listAsJson() {
        render OrganizationOtherType.list(params) as JSON
    }
}
