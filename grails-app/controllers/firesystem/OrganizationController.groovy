package firesystem

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON

class OrganizationController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [organizationInstanceList: Organization.list(params), organizationInstanceTotal: Organization.count()]
    }

    def create() {
        [organizationInstance: new Organization(params)]
    }

    def save() {
        def organizationInstance = new Organization(params)
        if (!organizationInstance.save(flush: true)) {
            render(view: "create", model: [organizationInstance: organizationInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'organization.label', default: 'Organization'), organizationInstance.id])
        redirect(action: "show", id: organizationInstance.id)
    }

    def show() {
        def organizationInstance = Organization.get(params.id)
        if (!organizationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'organization.label', default: 'Organization'), params.id])
            redirect(action: "list")
            return
        }

        [organizationInstance: organizationInstance]
    }



    def edit() {
        def organizationInstance = Organization.get(params.id)
        if (!organizationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'organization.label', default: 'Organization'), params.id])
            redirect(action: "list")
            return
        }

        [organizationInstance: organizationInstance]
    }

    def update() {
        def organizationInstance = Organization.get(params.id)
        if (!organizationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'organization.label', default: 'Organization'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (organizationInstance.version > version) {
                organizationInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'organization.label', default: 'Organization')] as Object[],
                        "Another user has updated this Organization while you were editing")
                render(view: "edit", model: [organizationInstance: organizationInstance])
                return
            }
        }

        organizationInstance.properties = params

        if (!organizationInstance.save(flush: true)) {
            render(view: "edit", model: [organizationInstance: organizationInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'organization.label', default: 'Organization'), organizationInstance.id])
        redirect(action: "show", id: organizationInstance.id)
    }

    def delete() {
        def organizationInstance = Organization.get(params.id)
        if (!organizationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'organization.label', default: 'Organization'), params.id])
            redirect(action: "list")
            return
        }

        try {
            organizationInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'organization.label', default: 'Organization'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'organization.label', default: 'Organization'), params.id])
            redirect(action: "show", id: params.id)
        }
    }

    def search = {
        def searchResults
        if (!params.q?.trim()) {
            render(action: "list")
        }
        searchResults = Organization.search(params.q, params)
        flash.message = "关于 ' ${params.q} ' 一共找到 ${searchResults.total} 笔记录 "
        flash.q = params.q
        render(view: "list", model: [organizationInstanceList: searchResults.results, organizationInstanceTotal: searchResults.total, params: params])

    }

    def listAsJson() {
        render Organization.list(params) as JSON
    }

    def showAsJson() {
        def organizationInstance = Organization.get(params.id)
        if (!organizationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'organization.label', default: 'Organization'), params.id])
            redirect(action: "list")
            return
        }

        render organizationInstance as JSON
    }

    def searchAsJson = {
        def searchResults
        if (!params.q?.trim()) {
            return [:]
        }
        searchResults = Organization.search(params.q, params)
        render searchResults.results as JSON
    }

}
