<%@ page import="firesystem.OrganizationOtherType" %>



<div class="fieldcontain ${hasErrors(bean: organizationOtherTypeInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="organizationOtherType.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${organizationOtherTypeInstance?.name}"/>
</div>

