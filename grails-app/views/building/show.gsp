
<%@ page import="firesystem.Building" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'building.label', default: 'Building')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-building" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-building" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list building">
			
				<g:if test="${buildingInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="building.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${buildingInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.address}">
				<li class="fieldcontain">
					<span id="address-label" class="property-label"><g:message code="building.address.label" default="Address" /></span>
					
						<span class="property-value" aria-labelledby="address-label"><g:fieldValue bean="${buildingInstance}" field="address"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.organization}">
				<li class="fieldcontain">
					<span id="organization-label" class="property-label"><g:message code="building.organization.label" default="Organization" /></span>
					
						<g:each in="${buildingInstance.organization}" var="o">
						<span class="property-value" aria-labelledby="organization-label"><g:link controller="organization" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.district}">
				<li class="fieldcontain">
					<span id="district-label" class="property-label"><g:message code="building.district.label" default="District" /></span>
					
						<span class="property-value" aria-labelledby="district-label"><g:link controller="district" action="show" id="${buildingInstance?.district?.id}">${buildingInstance?.district?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.occupies}">
				<li class="fieldcontain">
					<span id="occupies-label" class="property-label"><g:message code="building.occupies.label" default="Occupies" /></span>
					
						<span class="property-value" aria-labelledby="occupies-label"><g:fieldValue bean="${buildingInstance}" field="occupies"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.buildArea}">
				<li class="fieldcontain">
					<span id="buildArea-label" class="property-label"><g:message code="building.buildArea.label" default="Build Area" /></span>
					
						<span class="property-value" aria-labelledby="buildArea-label"><g:fieldValue bean="${buildingInstance}" field="buildArea"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.maxPersonNum}">
				<li class="fieldcontain">
					<span id="maxPersonNum-label" class="property-label"><g:message code="building.maxPersonNum.label" default="Max Person Num" /></span>
					
						<span class="property-value" aria-labelledby="maxPersonNum-label"><g:fieldValue bean="${buildingInstance}" field="maxPersonNum"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.upperArea}">
				<li class="fieldcontain">
					<span id="upperArea-label" class="property-label"><g:message code="building.upperArea.label" default="Upper Area" /></span>
					
						<span class="property-value" aria-labelledby="upperArea-label"><g:fieldValue bean="${buildingInstance}" field="upperArea"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.underArea}">
				<li class="fieldcontain">
					<span id="underArea-label" class="property-label"><g:message code="building.underArea.label" default="Under Area" /></span>
					
						<span class="property-value" aria-labelledby="underArea-label"><g:fieldValue bean="${buildingInstance}" field="underArea"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.upperFloor}">
				<li class="fieldcontain">
					<span id="upperFloor-label" class="property-label"><g:message code="building.upperFloor.label" default="Upper Floor" /></span>
					
						<span class="property-value" aria-labelledby="upperFloor-label"><g:fieldValue bean="${buildingInstance}" field="upperFloor"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.height}">
				<li class="fieldcontain">
					<span id="height-label" class="property-label"><g:message code="building.height.label" default="Height" /></span>
					
						<span class="property-value" aria-labelledby="height-label"><g:fieldValue bean="${buildingInstance}" field="height"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.contact}">
				<li class="fieldcontain">
					<span id="contact-label" class="property-label"><g:message code="building.contact.label" default="Contact" /></span>
					
						<span class="property-value" aria-labelledby="contact-label"><g:fieldValue bean="${buildingInstance}" field="contact"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.contactPhone}">
				<li class="fieldcontain">
					<span id="contactPhone-label" class="property-label"><g:message code="building.contactPhone.label" default="Contact Phone" /></span>
					
						<span class="property-value" aria-labelledby="contactPhone-label"><g:fieldValue bean="${buildingInstance}" field="contactPhone"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.buildingOwnerType}">
				<li class="fieldcontain">
					<span id="buildingOwnerType-label" class="property-label"><g:message code="building.buildingOwnerType.label" default="Building Owner Type" /></span>
					
						<span class="property-value" aria-labelledby="buildingOwnerType-label"><g:link controller="buildingOwnerType" action="show" id="${buildingInstance?.buildingOwnerType?.id}">${buildingInstance?.buildingOwnerType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.buildingType}">
				<li class="fieldcontain">
					<span id="buildingType-label" class="property-label"><g:message code="building.buildingType.label" default="Building Type" /></span>
					
						<span class="property-value" aria-labelledby="buildingType-label"><g:link controller="buildingType" action="show" id="${buildingInstance?.buildingType?.id}">${buildingInstance?.buildingType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.buildingStatus}">
				<li class="fieldcontain">
					<span id="buildingStatus-label" class="property-label"><g:message code="building.buildingStatus.label" default="Building Status" /></span>
					
						<span class="property-value" aria-labelledby="buildingStatus-label"><g:link controller="buildingStatus" action="show" id="${buildingInstance?.buildingStatus?.id}">${buildingInstance?.buildingStatus?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.buildingFinishDate}">
				<li class="fieldcontain">
					<span id="buildingFinishDate-label" class="property-label"><g:message code="building.buildingFinishDate.label" default="Building Finish Date" /></span>
					
						<span class="property-value" aria-labelledby="buildingFinishDate-label"><g:formatDate date="${buildingInstance?.buildingFinishDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.refugeFloorNum}">
				<li class="fieldcontain">
					<span id="refugeFloorNum-label" class="property-label"><g:message code="building.refugeFloorNum.label" default="Refuge Floor Num" /></span>
					
						<span class="property-value" aria-labelledby="refugeFloorNum-label"><g:fieldValue bean="${buildingInstance}" field="refugeFloorNum"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.refugeFloorArea}">
				<li class="fieldcontain">
					<span id="refugeFloorArea-label" class="property-label"><g:message code="building.refugeFloorArea.label" default="Refuge Floor Area" /></span>
					
						<span class="property-value" aria-labelledby="refugeFloorArea-label"><g:fieldValue bean="${buildingInstance}" field="refugeFloorArea"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.refugeFloorAddress}">
				<li class="fieldcontain">
					<span id="refugeFloorAddress-label" class="property-label"><g:message code="building.refugeFloorAddress.label" default="Refuge Floor Address" /></span>
					
						<span class="property-value" aria-labelledby="refugeFloorAddress-label"><g:fieldValue bean="${buildingInstance}" field="refugeFloorAddress"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.fireLiftNum}">
				<li class="fieldcontain">
					<span id="fireLiftNum-label" class="property-label"><g:message code="building.fireLiftNum.label" default="Fire Lift Num" /></span>
					
						<span class="property-value" aria-labelledby="fireLiftNum-label"><g:fieldValue bean="${buildingInstance}" field="fireLiftNum"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.fireLiftAddress}">
				<li class="fieldcontain">
					<span id="fireLiftAddress-label" class="property-label"><g:message code="building.fireLiftAddress.label" default="Fire Lift Address" /></span>
					
						<span class="property-value" aria-labelledby="fireLiftAddress-label"><g:fieldValue bean="${buildingInstance}" field="fireLiftAddress"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.builderStructure}">
				<li class="fieldcontain">
					<span id="builderStructure-label" class="property-label"><g:message code="building.builderStructure.label" default="Builder Structure" /></span>
					
						<span class="property-value" aria-labelledby="builderStructure-label"><g:link controller="builderStructure" action="show" id="${buildingInstance?.builderStructure?.id}">${buildingInstance?.builderStructure?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.fireRating}">
				<li class="fieldcontain">
					<span id="fireRating-label" class="property-label"><g:message code="building.fireRating.label" default="Fire Rating" /></span>
					
						<span class="property-value" aria-labelledby="fireRating-label"><g:link controller="fireRating" action="show" id="${buildingInstance?.fireRating?.id}">${buildingInstance?.fireRating?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.fireFightingFacilitiesStatus}">
				<li class="fieldcontain">
					<span id="fireFightingFacilitiesStatus-label" class="property-label"><g:message code="building.fireFightingFacilitiesStatus.label" default="Fire Fighting Facilities Status" /></span>
					
						<span class="property-value" aria-labelledby="fireFightingFacilitiesStatus-label"><g:link controller="fireFightingFacilitiesStatus" action="show" id="${buildingInstance?.fireFightingFacilitiesStatus?.id}">${buildingInstance?.fireFightingFacilitiesStatus?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.fireControlRoomAddress}">
				<li class="fieldcontain">
					<span id="fireControlRoomAddress-label" class="property-label"><g:message code="building.fireControlRoomAddress.label" default="Fire Control Room Address" /></span>
					
						<span class="property-value" aria-labelledby="fireControlRoomAddress-label"><g:fieldValue bean="${buildingInstance}" field="fireControlRoomAddress"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.fireFightingFacilities}">
				<li class="fieldcontain">
					<span id="fireFightingFacilities-label" class="property-label"><g:message code="building.fireFightingFacilities.label" default="Fire Fighting Facilities" /></span>
					
						<g:each in="${buildingInstance.fireFightingFacilities}" var="f">
						<span class="property-value" aria-labelledby="fireFightingFacilities-label"><g:link controller="fireFightingFacilities" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="building.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${buildingInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="building.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${buildingInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.comment}">
				<li class="fieldcontain">
					<span id="comment-label" class="property-label"><g:message code="building.comment.label" default="Comment" /></span>
					
						<span class="property-value" aria-labelledby="comment-label"><g:fieldValue bean="${buildingInstance}" field="comment"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.neighborBuildingStatus}">
				<li class="fieldcontain">
					<span id="neighborBuildingStatus-label" class="property-label"><g:message code="building.neighborBuildingStatus.label" default="Neighbor Building Status" /></span>
					
						<span class="property-value" aria-labelledby="neighborBuildingStatus-label"><g:fieldValue bean="${buildingInstance}" field="neighborBuildingStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${buildingInstance?.underFloor}">
				<li class="fieldcontain">
					<span id="underFloor-label" class="property-label"><g:message code="building.underFloor.label" default="Under Floor" /></span>
					
						<span class="property-value" aria-labelledby="underFloor-label"><g:fieldValue bean="${buildingInstance}" field="underFloor"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${buildingInstance?.id}" />
					<g:link class="edit" action="edit" id="${buildingInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
