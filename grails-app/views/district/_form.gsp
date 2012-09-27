<%@ page import="firesystem.District" %>



<div class="fieldcontain ${hasErrors(bean: districtInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="district.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${districtInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: districtInstance, field: 'city', 'error')} required">
	<label for="city">
		<g:message code="district.city.label" default="City" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="city" name="city.id" from="${firesystem.City.list()}" optionKey="id" required="" value="${districtInstance?.city?.id}" class="many-to-one"/>
</div>

