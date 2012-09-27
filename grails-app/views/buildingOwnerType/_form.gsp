<%@ page import="firesystem.BuildingOwnerType" %>



<div class="fieldcontain ${hasErrors(bean: buildingOwnerTypeInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="buildingOwnerType.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${buildingOwnerTypeInstance?.name}"/>
</div>

