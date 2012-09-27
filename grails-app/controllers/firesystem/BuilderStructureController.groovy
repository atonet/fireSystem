package firesystem

import org.springframework.dao.DataIntegrityViolationException

class BuilderStructureController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [builderStructureInstanceList: BuilderStructure.list(params), builderStructureInstanceTotal: BuilderStructure.count()]
    }

    def create() {
        [builderStructureInstance: new BuilderStructure(params)]
    }

    def save() {
        def builderStructureInstance = new BuilderStructure(params)
        if (!builderStructureInstance.save(flush: true)) {
            render(view: "create", model: [builderStructureInstance: builderStructureInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'builderStructure.label', default: 'BuilderStructure'), builderStructureInstance.id])
        redirect(action: "show", id: builderStructureInstance.id)
    }

    def show() {
        def builderStructureInstance = BuilderStructure.get(params.id)
        if (!builderStructureInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'builderStructure.label', default: 'BuilderStructure'), params.id])
            redirect(action: "list")
            return
        }

        [builderStructureInstance: builderStructureInstance]
    }

    def edit() {
        def builderStructureInstance = BuilderStructure.get(params.id)
        if (!builderStructureInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'builderStructure.label', default: 'BuilderStructure'), params.id])
            redirect(action: "list")
            return
        }

        [builderStructureInstance: builderStructureInstance]
    }

    def update() {
        def builderStructureInstance = BuilderStructure.get(params.id)
        if (!builderStructureInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'builderStructure.label', default: 'BuilderStructure'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (builderStructureInstance.version > version) {
                builderStructureInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'builderStructure.label', default: 'BuilderStructure')] as Object[],
                        "Another user has updated this BuilderStructure while you were editing")
                render(view: "edit", model: [builderStructureInstance: builderStructureInstance])
                return
            }
        }

        builderStructureInstance.properties = params

        if (!builderStructureInstance.save(flush: true)) {
            render(view: "edit", model: [builderStructureInstance: builderStructureInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'builderStructure.label', default: 'BuilderStructure'), builderStructureInstance.id])
        redirect(action: "show", id: builderStructureInstance.id)
    }

    def delete() {
        def builderStructureInstance = BuilderStructure.get(params.id)
        if (!builderStructureInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'builderStructure.label', default: 'BuilderStructure'), params.id])
            redirect(action: "list")
            return
        }

        try {
            builderStructureInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'builderStructure.label', default: 'BuilderStructure'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'builderStructure.label', default: 'BuilderStructure'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
