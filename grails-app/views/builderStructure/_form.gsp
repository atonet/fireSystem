<%@ page import="firesystem.BuilderStructure" %>



<div class="fieldcontain ${hasErrors(bean: builderStructureInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="builderStructure.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${builderStructureInstance?.name}"/>
</div>

