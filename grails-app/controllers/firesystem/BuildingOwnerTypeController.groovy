package firesystem

import org.springframework.dao.DataIntegrityViolationException

class BuildingOwnerTypeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [buildingOwnerTypeInstanceList: BuildingOwnerType.list(params), buildingOwnerTypeInstanceTotal: BuildingOwnerType.count()]
    }

    def create() {
        [buildingOwnerTypeInstance: new BuildingOwnerType(params)]
    }

    def save() {
        def buildingOwnerTypeInstance = new BuildingOwnerType(params)
        if (!buildingOwnerTypeInstance.save(flush: true)) {
            render(view: "create", model: [buildingOwnerTypeInstance: buildingOwnerTypeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'buildingOwnerType.label', default: 'BuildingOwnerType'), buildingOwnerTypeInstance.id])
        redirect(action: "show", id: buildingOwnerTypeInstance.id)
    }

    def show() {
        def buildingOwnerTypeInstance = BuildingOwnerType.get(params.id)
        if (!buildingOwnerTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'buildingOwnerType.label', default: 'BuildingOwnerType'), params.id])
            redirect(action: "list")
            return
        }

        [buildingOwnerTypeInstance: buildingOwnerTypeInstance]
    }

    def edit() {
        def buildingOwnerTypeInstance = BuildingOwnerType.get(params.id)
        if (!buildingOwnerTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'buildingOwnerType.label', default: 'BuildingOwnerType'), params.id])
            redirect(action: "list")
            return
        }

        [buildingOwnerTypeInstance: buildingOwnerTypeInstance]
    }

    def update() {
        def buildingOwnerTypeInstance = BuildingOwnerType.get(params.id)
        if (!buildingOwnerTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'buildingOwnerType.label', default: 'BuildingOwnerType'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (buildingOwnerTypeInstance.version > version) {
                buildingOwnerTypeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'buildingOwnerType.label', default: 'BuildingOwnerType')] as Object[],
                        "Another user has updated this BuildingOwnerType while you were editing")
                render(view: "edit", model: [buildingOwnerTypeInstance: buildingOwnerTypeInstance])
                return
            }
        }

        buildingOwnerTypeInstance.properties = params

        if (!buildingOwnerTypeInstance.save(flush: true)) {
            render(view: "edit", model: [buildingOwnerTypeInstance: buildingOwnerTypeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'buildingOwnerType.label', default: 'BuildingOwnerType'), buildingOwnerTypeInstance.id])
        redirect(action: "show", id: buildingOwnerTypeInstance.id)
    }

    def delete() {
        def buildingOwnerTypeInstance = BuildingOwnerType.get(params.id)
        if (!buildingOwnerTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'buildingOwnerType.label', default: 'BuildingOwnerType'), params.id])
            redirect(action: "list")
            return
        }

        try {
            buildingOwnerTypeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'buildingOwnerType.label', default: 'BuildingOwnerType'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'buildingOwnerType.label', default: 'BuildingOwnerType'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
