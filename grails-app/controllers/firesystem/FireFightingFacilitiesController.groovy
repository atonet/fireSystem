package firesystem

import org.springframework.dao.DataIntegrityViolationException

class FireFightingFacilitiesController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [fireFightingFacilitiesInstanceList: FireFightingFacilities.list(params), fireFightingFacilitiesInstanceTotal: FireFightingFacilities.count()]
    }

    def create() {
        [fireFightingFacilitiesInstance: new FireFightingFacilities(params)]
    }

    def save() {
        def fireFightingFacilitiesInstance = new FireFightingFacilities(params)
        if (!fireFightingFacilitiesInstance.save(flush: true)) {
            render(view: "create", model: [fireFightingFacilitiesInstance: fireFightingFacilitiesInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'fireFightingFacilities.label', default: 'FireFightingFacilities'), fireFightingFacilitiesInstance.id])
        redirect(action: "show", id: fireFightingFacilitiesInstance.id)
    }

    def show() {
        def fireFightingFacilitiesInstance = FireFightingFacilities.get(params.id)
        if (!fireFightingFacilitiesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'fireFightingFacilities.label', default: 'FireFightingFacilities'), params.id])
            redirect(action: "list")
            return
        }

        [fireFightingFacilitiesInstance: fireFightingFacilitiesInstance]
    }

    def edit() {
        def fireFightingFacilitiesInstance = FireFightingFacilities.get(params.id)
        if (!fireFightingFacilitiesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'fireFightingFacilities.label', default: 'FireFightingFacilities'), params.id])
            redirect(action: "list")
            return
        }

        [fireFightingFacilitiesInstance: fireFightingFacilitiesInstance]
    }

    def update() {
        def fireFightingFacilitiesInstance = FireFightingFacilities.get(params.id)
        if (!fireFightingFacilitiesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'fireFightingFacilities.label', default: 'FireFightingFacilities'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (fireFightingFacilitiesInstance.version > version) {
                fireFightingFacilitiesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'fireFightingFacilities.label', default: 'FireFightingFacilities')] as Object[],
                        "Another user has updated this FireFightingFacilities while you were editing")
                render(view: "edit", model: [fireFightingFacilitiesInstance: fireFightingFacilitiesInstance])
                return
            }
        }

        fireFightingFacilitiesInstance.properties = params

        if (!fireFightingFacilitiesInstance.save(flush: true)) {
            render(view: "edit", model: [fireFightingFacilitiesInstance: fireFightingFacilitiesInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'fireFightingFacilities.label', default: 'FireFightingFacilities'), fireFightingFacilitiesInstance.id])
        redirect(action: "show", id: fireFightingFacilitiesInstance.id)
    }

    def delete() {
        def fireFightingFacilitiesInstance = FireFightingFacilities.get(params.id)
        if (!fireFightingFacilitiesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'fireFightingFacilities.label', default: 'FireFightingFacilities'), params.id])
            redirect(action: "list")
            return
        }

        try {
            fireFightingFacilitiesInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'fireFightingFacilities.label', default: 'FireFightingFacilities'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'fireFightingFacilities.label', default: 'FireFightingFacilities'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
