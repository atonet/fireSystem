<%@ page import="firesystem.BuildingStatus" %>



<div class="fieldcontain ${hasErrors(bean: buildingStatusInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="buildingStatus.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${buildingStatusInstance?.name}"/>
</div>

