package firesystem

import org.springframework.dao.DataIntegrityViolationException

class BuildingTypeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [buildingTypeInstanceList: BuildingType.list(params), buildingTypeInstanceTotal: BuildingType.count()]
    }

    def create() {
        [buildingTypeInstance: new BuildingType(params)]
    }

    def save() {
        def buildingTypeInstance = new BuildingType(params)
        if (!buildingTypeInstance.save(flush: true)) {
            render(view: "create", model: [buildingTypeInstance: buildingTypeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'buildingType.label', default: 'BuildingType'), buildingTypeInstance.id])
        redirect(action: "show", id: buildingTypeInstance.id)
    }

    def show() {
        def buildingTypeInstance = BuildingType.get(params.id)
        if (!buildingTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'buildingType.label', default: 'BuildingType'), params.id])
            redirect(action: "list")
            return
        }

        [buildingTypeInstance: buildingTypeInstance]
    }

    def edit() {
        def buildingTypeInstance = BuildingType.get(params.id)
        if (!buildingTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'buildingType.label', default: 'BuildingType'), params.id])
            redirect(action: "list")
            return
        }

        [buildingTypeInstance: buildingTypeInstance]
    }

    def update() {
        def buildingTypeInstance = BuildingType.get(params.id)
        if (!buildingTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'buildingType.label', default: 'BuildingType'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (buildingTypeInstance.version > version) {
                buildingTypeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'buildingType.label', default: 'BuildingType')] as Object[],
                        "Another user has updated this BuildingType while you were editing")
                render(view: "edit", model: [buildingTypeInstance: buildingTypeInstance])
                return
            }
        }

        buildingTypeInstance.properties = params

        if (!buildingTypeInstance.save(flush: true)) {
            render(view: "edit", model: [buildingTypeInstance: buildingTypeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'buildingType.label', default: 'BuildingType'), buildingTypeInstance.id])
        redirect(action: "show", id: buildingTypeInstance.id)
    }

    def delete() {
        def buildingTypeInstance = BuildingType.get(params.id)
        if (!buildingTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'buildingType.label', default: 'BuildingType'), params.id])
            redirect(action: "list")
            return
        }

        try {
            buildingTypeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'buildingType.label', default: 'BuildingType'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'buildingType.label', default: 'BuildingType'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
