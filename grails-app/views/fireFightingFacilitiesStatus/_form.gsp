<%@ page import="firesystem.FireFightingFacilitiesStatus" %>



<div class="fieldcontain ${hasErrors(bean: fireFightingFacilitiesStatusInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="fireFightingFacilitiesStatus.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${fireFightingFacilitiesStatusInstance?.name}"/>
</div>

