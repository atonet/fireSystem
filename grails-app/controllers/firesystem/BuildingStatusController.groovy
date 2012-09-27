package firesystem

import org.springframework.dao.DataIntegrityViolationException

class BuildingStatusController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [buildingStatusInstanceList: BuildingStatus.list(params), buildingStatusInstanceTotal: BuildingStatus.count()]
    }

    def create() {
        [buildingStatusInstance: new BuildingStatus(params)]
    }

    def save() {
        def buildingStatusInstance = new BuildingStatus(params)
        if (!buildingStatusInstance.save(flush: true)) {
            render(view: "create", model: [buildingStatusInstance: buildingStatusInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'buildingStatus.label', default: 'BuildingStatus'), buildingStatusInstance.id])
        redirect(action: "show", id: buildingStatusInstance.id)
    }

    def show() {
        def buildingStatusInstance = BuildingStatus.get(params.id)
        if (!buildingStatusInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'buildingStatus.label', default: 'BuildingStatus'), params.id])
            redirect(action: "list")
            return
        }

        [buildingStatusInstance: buildingStatusInstance]
    }

    def edit() {
        def buildingStatusInstance = BuildingStatus.get(params.id)
        if (!buildingStatusInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'buildingStatus.label', default: 'BuildingStatus'), params.id])
            redirect(action: "list")
            return
        }

        [buildingStatusInstance: buildingStatusInstance]
    }

    def update() {
        def buildingStatusInstance = BuildingStatus.get(params.id)
        if (!buildingStatusInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'buildingStatus.label', default: 'BuildingStatus'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (buildingStatusInstance.version > version) {
                buildingStatusInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'buildingStatus.label', default: 'BuildingStatus')] as Object[],
                        "Another user has updated this BuildingStatus while you were editing")
                render(view: "edit", model: [buildingStatusInstance: buildingStatusInstance])
                return
            }
        }

        buildingStatusInstance.properties = params

        if (!buildingStatusInstance.save(flush: true)) {
            render(view: "edit", model: [buildingStatusInstance: buildingStatusInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'buildingStatus.label', default: 'BuildingStatus'), buildingStatusInstance.id])
        redirect(action: "show", id: buildingStatusInstance.id)
    }

    def delete() {
        def buildingStatusInstance = BuildingStatus.get(params.id)
        if (!buildingStatusInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'buildingStatus.label', default: 'BuildingStatus'), params.id])
            redirect(action: "list")
            return
        }

        try {
            buildingStatusInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'buildingStatus.label', default: 'BuildingStatus'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'buildingStatus.label', default: 'BuildingStatus'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
