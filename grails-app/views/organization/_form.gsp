<%@ page import="firesystem.Organization" %>



<div class="fieldcontain ${hasErrors(bean: organizationInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="organization.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${organizationInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organizationInstance, field: 'address', 'error')} ">
	<label for="address">
		<g:message code="organization.address.label" default="Address" />
		
	</label>
	<g:textField name="address" value="${organizationInstance?.address}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organizationInstance, field: 'organizationType', 'error')} required">
	<label for="organizationType">
		<g:message code="organization.organizationType.label" default="Organization Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="organizationType" name="organizationType.id" from="${firesystem.OrganizationType.list()}" optionKey="id" required="" value="${organizationInstance?.organizationType?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organizationInstance, field: 'organizationOtherType', 'error')} ">
	<label for="organizationOtherType">
		<g:message code="organization.organizationOtherType.label" default="Organization Other Type" />
		
	</label>
	<g:select name="organizationOtherType" from="${firesystem.OrganizationOtherType.list()}" multiple="multiple" optionKey="id" size="5" value="${organizationInstance?.organizationOtherType*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organizationInstance, field: 'fireFightingPerson', 'error')} ">
	<label for="fireFightingPerson">
		<g:message code="organization.fireFightingPerson.label" default="Fire Fighting Person" />
		
	</label>
	<g:textField name="fireFightingPerson" value="${organizationInstance?.fireFightingPerson}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organizationInstance, field: 'fireFightingPersonPhone', 'error')} ">
	<label for="fireFightingPersonPhone">
		<g:message code="organization.fireFightingPersonPhone.label" default="Fire Fighting Person Phone" />
		
	</label>
	<g:textField name="fireFightingPersonPhone" value="${organizationInstance?.fireFightingPersonPhone}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organizationInstance, field: 'fireFightingPersonSID', 'error')} ">
	<label for="fireFightingPersonSID">
		<g:message code="organization.fireFightingPersonSID.label" default="Fire Fighting Person SID" />
		
	</label>
	<g:textField name="fireFightingPersonSID" value="${organizationInstance?.fireFightingPersonSID}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organizationInstance, field: 'autoFireSystem', 'error')} ">
	<label for="autoFireSystem">
		<g:message code="organization.autoFireSystem.label" default="Auto Fire System" />
		
	</label>
	<g:checkBox name="autoFireSystem" value="${organizationInstance?.autoFireSystem}" />
</div>

<div class="fieldcontain ${hasErrors(bean: organizationInstance, field: 'district', 'error')} required">
	<label for="district">
		<g:message code="organization.district.label" default="District" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="district" name="district.id" from="${firesystem.District.list()}" optionKey="id" required="" value="${organizationInstance?.district?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organizationInstance, field: 'owner', 'error')} ">
	<label for="owner">
		<g:message code="organization.owner.label" default="Owner" />
		
	</label>
	<g:textField name="owner" value="${organizationInstance?.owner}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organizationInstance, field: 'ownerPhone', 'error')} ">
	<label for="ownerPhone">
		<g:message code="organization.ownerPhone.label" default="Owner Phone" />
		
	</label>
	<g:textField name="ownerPhone" value="${organizationInstance?.ownerPhone}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organizationInstance, field: 'ownerSID', 'error')} ">
	<label for="ownerSID">
		<g:message code="organization.ownerSID.label" default="Owner SID" />
		
	</label>
	<g:textField name="ownerSID" value="${organizationInstance?.ownerSID}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organizationInstance, field: 'orgClassification', 'error')} ">
	<label for="orgClassification">
		<g:message code="organization.orgClassification.label" default="Org Classification" />
		
	</label>
	<g:select id="orgClassification" name="orgClassification.id" from="${firesystem.OrgClassification.list()}" optionKey="id" value="${organizationInstance?.orgClassification?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organizationInstance, field: 'building', 'error')} ">
	<label for="building">
		<g:message code="organization.building.label" default="Building" />
		
	</label>
	<g:select name="building" from="${firesystem.Building.list()}" multiple="multiple" optionKey="id" size="5" value="${organizationInstance?.building*.id}" class="many-to-many"/>
</div>

