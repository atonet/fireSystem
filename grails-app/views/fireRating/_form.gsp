<%@ page import="firesystem.FireRating" %>



<div class="fieldcontain ${hasErrors(bean: fireRatingInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="fireRating.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${fireRatingInstance?.name}"/>
</div>

