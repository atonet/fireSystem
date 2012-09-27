package firesystem

import org.springframework.dao.DataIntegrityViolationException

class FireFightingFacilitiesStatusController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [fireFightingFacilitiesStatusInstanceList: FireFightingFacilitiesStatus.list(params), fireFightingFacilitiesStatusInstanceTotal: FireFightingFacilitiesStatus.count()]
    }

    def create() {
        [fireFightingFacilitiesStatusInstance: new FireFightingFacilitiesStatus(params)]
    }

    def save() {
        def fireFightingFacilitiesStatusInstance = new FireFightingFacilitiesStatus(params)
        if (!fireFightingFacilitiesStatusInstance.save(flush: true)) {
            render(view: "create", model: [fireFightingFacilitiesStatusInstance: fireFightingFacilitiesStatusInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'fireFightingFacilitiesStatus.label', default: 'FireFightingFacilitiesStatus'), fireFightingFacilitiesStatusInstance.id])
        redirect(action: "show", id: fireFightingFacilitiesStatusInstance.id)
    }

    def show() {
        def fireFightingFacilitiesStatusInstance = FireFightingFacilitiesStatus.get(params.id)
        if (!fireFightingFacilitiesStatusInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'fireFightingFacilitiesStatus.label', default: 'FireFightingFacilitiesStatus'), params.id])
            redirect(action: "list")
            return
        }

        [fireFightingFacilitiesStatusInstance: fireFightingFacilitiesStatusInstance]
    }

    def edit() {
        def fireFightingFacilitiesStatusInstance = FireFightingFacilitiesStatus.get(params.id)
        if (!fireFightingFacilitiesStatusInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'fireFightingFacilitiesStatus.label', default: 'FireFightingFacilitiesStatus'), params.id])
            redirect(action: "list")
            return
        }

        [fireFightingFacilitiesStatusInstance: fireFightingFacilitiesStatusInstance]
    }

    def update() {
        def fireFightingFacilitiesStatusInstance = FireFightingFacilitiesStatus.get(params.id)
        if (!fireFightingFacilitiesStatusInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'fireFightingFacilitiesStatus.label', default: 'FireFightingFacilitiesStatus'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (fireFightingFacilitiesStatusInstance.version > version) {
                fireFightingFacilitiesStatusInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'fireFightingFacilitiesStatus.label', default: 'FireFightingFacilitiesStatus')] as Object[],
                        "Another user has updated this FireFightingFacilitiesStatus while you were editing")
                render(view: "edit", model: [fireFightingFacilitiesStatusInstance: fireFightingFacilitiesStatusInstance])
                return
            }
        }

        fireFightingFacilitiesStatusInstance.properties = params

        if (!fireFightingFacilitiesStatusInstance.save(flush: true)) {
            render(view: "edit", model: [fireFightingFacilitiesStatusInstance: fireFightingFacilitiesStatusInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'fireFightingFacilitiesStatus.label', default: 'FireFightingFacilitiesStatus'), fireFightingFacilitiesStatusInstance.id])
        redirect(action: "show", id: fireFightingFacilitiesStatusInstance.id)
    }

    def delete() {
        def fireFightingFacilitiesStatusInstance = FireFightingFacilitiesStatus.get(params.id)
        if (!fireFightingFacilitiesStatusInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'fireFightingFacilitiesStatus.label', default: 'FireFightingFacilitiesStatus'), params.id])
            redirect(action: "list")
            return
        }

        try {
            fireFightingFacilitiesStatusInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'fireFightingFacilitiesStatus.label', default: 'FireFightingFacilitiesStatus'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'fireFightingFacilitiesStatus.label', default: 'FireFightingFacilitiesStatus'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
