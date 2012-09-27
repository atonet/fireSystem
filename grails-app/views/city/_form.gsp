<%@ page import="firesystem.City" %>



<div class="fieldcontain ${hasErrors(bean: cityInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="city.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${cityInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: cityInstance, field: 'district', 'error')} ">
	<label for="district">
		<g:message code="city.district.label" default="District" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${cityInstance?.district?}" var="d">
    <li><g:link controller="district" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="district" action="create" params="['city.id': cityInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'district.label', default: 'District')])}</g:link>
</li>
</ul>

</div>

