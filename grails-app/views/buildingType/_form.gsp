<%@ page import="firesystem.BuildingType" %>



<div class="fieldcontain ${hasErrors(bean: buildingTypeInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="buildingType.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${buildingTypeInstance?.name}"/>
</div>

