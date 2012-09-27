<%@ page import="firesystem.OrgClassification" %>



<div class="fieldcontain ${hasErrors(bean: orgClassificationInstance, field: 'parent', 'error')} ">
	<label for="parent">
		<g:message code="orgClassification.parent.label" default="Parent" />
		
	</label>
	<g:select id="parent" name="parent.id" from="${firesystem.OrgClassification.list()}" optionKey="id" value="${orgClassificationInstance?.parent?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: orgClassificationInstance, field: 'childrens', 'error')} ">
	<label for="childrens">
		<g:message code="orgClassification.childrens.label" default="Childrens" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${orgClassificationInstance?.childrens?}" var="c">
    <li><g:link controller="orgClassification" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="orgClassification" action="create" params="['orgClassification.id': orgClassificationInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'orgClassification.label', default: 'OrgClassification')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: orgClassificationInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="orgClassification.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${orgClassificationInstance?.name}"/>
</div>

