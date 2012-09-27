<%@ page import="firesystem.OrganizationType" %>



<div class="fieldcontain ${hasErrors(bean: organizationTypeInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="organizationType.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${organizationTypeInstance?.name}"/>
</div>

