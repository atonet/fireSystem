
<%@ page import="firesystem.Organization" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'organization.label', default: 'Organization')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-organization" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-organization" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list organization">
			
				<g:if test="${organizationInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="organization.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${organizationInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizationInstance?.address}">
				<li class="fieldcontain">
					<span id="address-label" class="property-label"><g:message code="organization.address.label" default="Address" /></span>
					
						<span class="property-value" aria-labelledby="address-label"><g:fieldValue bean="${organizationInstance}" field="address"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizationInstance?.organizationType}">
				<li class="fieldcontain">
					<span id="organizationType-label" class="property-label"><g:message code="organization.organizationType.label" default="Organization Type" /></span>
					
						<span class="property-value" aria-labelledby="organizationType-label"><g:link controller="organizationType" action="show" id="${organizationInstance?.organizationType?.id}">${organizationInstance?.organizationType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizationInstance?.organizationOtherType}">
				<li class="fieldcontain">
					<span id="organizationOtherType-label" class="property-label"><g:message code="organization.organizationOtherType.label" default="Organization Other Type" /></span>
					
						<g:each in="${organizationInstance.organizationOtherType}" var="o">
						<span class="property-value" aria-labelledby="organizationOtherType-label"><g:link controller="organizationOtherType" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${organizationInstance?.fireFightingPerson}">
				<li class="fieldcontain">
					<span id="fireFightingPerson-label" class="property-label"><g:message code="organization.fireFightingPerson.label" default="Fire Fighting Person" /></span>
					
						<span class="property-value" aria-labelledby="fireFightingPerson-label"><g:fieldValue bean="${organizationInstance}" field="fireFightingPerson"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizationInstance?.fireFightingPersonPhone}">
				<li class="fieldcontain">
					<span id="fireFightingPersonPhone-label" class="property-label"><g:message code="organization.fireFightingPersonPhone.label" default="Fire Fighting Person Phone" /></span>
					
						<span class="property-value" aria-labelledby="fireFightingPersonPhone-label"><g:fieldValue bean="${organizationInstance}" field="fireFightingPersonPhone"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizationInstance?.fireFightingPersonSID}">
				<li class="fieldcontain">
					<span id="fireFightingPersonSID-label" class="property-label"><g:message code="organization.fireFightingPersonSID.label" default="Fire Fighting Person SID" /></span>
					
						<span class="property-value" aria-labelledby="fireFightingPersonSID-label"><g:fieldValue bean="${organizationInstance}" field="fireFightingPersonSID"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizationInstance?.autoFireSystem}">
				<li class="fieldcontain">
					<span id="autoFireSystem-label" class="property-label"><g:message code="organization.autoFireSystem.label" default="Auto Fire System" /></span>
					
						<span class="property-value" aria-labelledby="autoFireSystem-label"><g:formatBoolean boolean="${organizationInstance?.autoFireSystem}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizationInstance?.district}">
				<li class="fieldcontain">
					<span id="district-label" class="property-label"><g:message code="organization.district.label" default="District" /></span>
					
						<span class="property-value" aria-labelledby="district-label"><g:link controller="district" action="show" id="${organizationInstance?.district?.id}">${organizationInstance?.district?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizationInstance?.owner}">
				<li class="fieldcontain">
					<span id="owner-label" class="property-label"><g:message code="organization.owner.label" default="Owner" /></span>
					
						<span class="property-value" aria-labelledby="owner-label"><g:fieldValue bean="${organizationInstance}" field="owner"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizationInstance?.ownerPhone}">
				<li class="fieldcontain">
					<span id="ownerPhone-label" class="property-label"><g:message code="organization.ownerPhone.label" default="Owner Phone" /></span>
					
						<span class="property-value" aria-labelledby="ownerPhone-label"><g:fieldValue bean="${organizationInstance}" field="ownerPhone"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizationInstance?.ownerSID}">
				<li class="fieldcontain">
					<span id="ownerSID-label" class="property-label"><g:message code="organization.ownerSID.label" default="Owner SID" /></span>
					
						<span class="property-value" aria-labelledby="ownerSID-label"><g:fieldValue bean="${organizationInstance}" field="ownerSID"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizationInstance?.orgClassification}">
				<li class="fieldcontain">
					<span id="orgClassification-label" class="property-label"><g:message code="organization.orgClassification.label" default="Org Classification" /></span>
					
						<span class="property-value" aria-labelledby="orgClassification-label"><g:link controller="orgClassification" action="show" id="${organizationInstance?.orgClassification?.id}">${organizationInstance?.orgClassification?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizationInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="organization.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${organizationInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizationInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="organization.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${organizationInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizationInstance?.building}">
				<li class="fieldcontain">
					<span id="building-label" class="property-label"><g:message code="organization.building.label" default="Building" /></span>
					
						<g:each in="${organizationInstance.building}" var="b">
						<span class="property-value" aria-labelledby="building-label"><g:link controller="building" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${organizationInstance?.id}" />
					<g:link class="edit" action="edit" id="${organizationInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
