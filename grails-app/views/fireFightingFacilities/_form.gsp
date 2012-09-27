<%@ page import="firesystem.FireFightingFacilities" %>



<div class="fieldcontain ${hasErrors(bean: fireFightingFacilitiesInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="fireFightingFacilities.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${fireFightingFacilitiesInstance?.name}"/>
</div>

