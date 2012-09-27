package firesystem

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON

class BuildingController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [buildingInstanceList: Building.list(params), buildingInstanceTotal: Building.count()]
    }



    def create() {
        [buildingInstance: new Building(params)]
    }

    def save() {
        def buildingInstance = new Building(params)
        if (buildingInstance.hasErrors()) {
            println $ {buildingInstance.errors}
        }
        if (!buildingInstance.save(flush: true)) {
            render(view: "create", model: [buildingInstance: buildingInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'building.label', default: 'Building'), buildingInstance.id])
        redirect(action: "show", id: buildingInstance.id)
    }

    def show() {
        def buildingInstance = Building.get(params.id)
        if (!buildingInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'building.label', default: 'Building'), params.id])
            redirect(action: "list")
            return
        }

        [buildingInstance: buildingInstance]
    }


    def edit() {
        def buildingInstance = Building.get(params.id)
        if (!buildingInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'building.label', default: 'Building'), params.id])
            redirect(action: "list")
            return
        }

        [buildingInstance: buildingInstance]
    }

    def update() {
        def buildingInstance = Building.get(params.id)
        if (!buildingInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'building.label', default: 'Building'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (buildingInstance.version > version) {
                buildingInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'building.label', default: 'Building')] as Object[],
                        "Another user has updated this Building while you were editing")
                render(view: "edit", model: [buildingInstance: buildingInstance])
                return
            }
        }

        buildingInstance.properties = params

        if (!buildingInstance.save(flush: true)) {
            render(view: "edit", model: [buildingInstance: buildingInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'building.label', default: 'Building'), buildingInstance.id])
        redirect(action: "show", id: buildingInstance.id)
    }

    def delete() {
        def buildingInstance = Building.get(params.id)
        if (!buildingInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'building.label', default: 'Building'), params.id])
            redirect(action: "list")
            return
        }

        try {
            buildingInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'building.label', default: 'Building'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'building.label', default: 'Building'), params.id])
            redirect(action: "show", id: params.id)
        }
    }

    def search = {
        //render Customer.search(params.q, params)
        // if( ${params.q}) { redirect(action: "list", params: params)}

        def searchResults
        if (!params.q?.trim()) {
            return [:]
        }
        searchResults = Building.search(params.q, params)
        flash.message = "关于 ' ${params.q} ' 一共找到 ${searchResults.total} 笔记录 "
        flash.q = params.q
        [customerInstanceList: searchResults.results, customerInstanceTotal: searchResults.total, params: params]
    }

    def listAsJson() {
        render Building.list() as JSON
    }

    def listByOrgAsJson() {
        Organization org = Organization.get(params.id)
        render org.getBuilding() as JSON
    }

    def showAsJson() {
        def buildingInstance = Building.get(params.id)
        render buildingInstance as JSON
    }

    def searchAsJson = {
        def searchResults
        if (!params.q?.trim()) {
            return [:]
        }
        searchResults = Building.search(params.q, params)
        render searchResults.results as JSON
    }
}
