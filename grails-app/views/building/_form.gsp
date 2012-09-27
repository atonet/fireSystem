<%@ page import="firesystem.Building" %>



<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="building.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${buildingInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'address', 'error')} ">
	<label for="address">
		<g:message code="building.address.label" default="Address" />
		
	</label>
	<g:textField name="address" value="${buildingInstance?.address}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'organization', 'error')} ">
	<label for="organization">
		<g:message code="building.organization.label" default="Organization" />
		
	</label>
	
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'district', 'error')} required">
	<label for="district">
		<g:message code="building.district.label" default="District" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="district" name="district.id" from="${firesystem.District.list()}" optionKey="id" required="" value="${buildingInstance?.district?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'occupies', 'error')} ">
	<label for="occupies">
		<g:message code="building.occupies.label" default="Occupies" />
		
	</label>
	<g:textField name="occupies" value="${buildingInstance?.occupies}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'buildArea', 'error')} ">
	<label for="buildArea">
		<g:message code="building.buildArea.label" default="Build Area" />
		
	</label>
	<g:textField name="buildArea" value="${buildingInstance?.buildArea}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'maxPersonNum', 'error')} ">
	<label for="maxPersonNum">
		<g:message code="building.maxPersonNum.label" default="Max Person Num" />
		
	</label>
	<g:textField name="maxPersonNum" value="${buildingInstance?.maxPersonNum}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'upperArea', 'error')} ">
	<label for="upperArea">
		<g:message code="building.upperArea.label" default="Upper Area" />
		
	</label>
	<g:textField name="upperArea" value="${buildingInstance?.upperArea}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'underArea', 'error')} ">
	<label for="underArea">
		<g:message code="building.underArea.label" default="Under Area" />
		
	</label>
	<g:textField name="underArea" value="${buildingInstance?.underArea}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'upperFloor', 'error')} ">
	<label for="upperFloor">
		<g:message code="building.upperFloor.label" default="Upper Floor" />
		
	</label>
	<g:textField name="upperFloor" value="${buildingInstance?.upperFloor}"/>
</div>
<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'underFloor', 'error')} ">
    <label for="underFloor">
        <g:message code="building.underFloor.label" default="Under Floor" />

    </label>
    <g:textField name="underFloor" value="${buildingInstance?.underFloor}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'height', 'error')} ">
	<label for="height">
		<g:message code="building.height.label" default="Height" />
		
	</label>
	<g:textField name="height" value="${buildingInstance?.height}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'contact', 'error')} ">
	<label for="contact">
		<g:message code="building.contact.label" default="Contact" />
		
	</label>
	<g:textField name="contact" value="${buildingInstance?.contact}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'contactPhone', 'error')} ">
	<label for="contactPhone">
		<g:message code="building.contactPhone.label" default="Contact Phone" />
		
	</label>
	<g:textField name="contactPhone" value="${buildingInstance?.contactPhone}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'buildingOwnerType', 'error')} required">
	<label for="buildingOwnerType">
		<g:message code="building.buildingOwnerType.label" default="Building Owner Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="buildingOwnerType" name="buildingOwnerType.id" from="${firesystem.BuildingOwnerType.list()}" optionKey="id" required="" value="${buildingInstance?.buildingOwnerType?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'buildingType', 'error')} required">
	<label for="buildingType">
		<g:message code="building.buildingType.label" default="Building Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="buildingType" name="buildingType.id" from="${firesystem.BuildingType.list()}" optionKey="id" required="" value="${buildingInstance?.buildingType?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'buildingStatus', 'error')} required">
	<label for="buildingStatus">
		<g:message code="building.buildingStatus.label" default="Building Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="buildingStatus" name="buildingStatus.id" from="${firesystem.BuildingStatus.list()}" optionKey="id" required="" value="${buildingInstance?.buildingStatus?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'buildingFinishDate', 'error')} required">
	<label for="buildingFinishDate">
		<g:message code="building.buildingFinishDate.label" default="Building Finish Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="buildingFinishDate" precision="day"  value="${buildingInstance?.buildingFinishDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'refugeFloorNum', 'error')} ">
	<label for="refugeFloorNum">
		<g:message code="building.refugeFloorNum.label" default="Refuge Floor Num" />
		
	</label>
	<g:textField name="refugeFloorNum" value="${buildingInstance?.refugeFloorNum}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'refugeFloorArea', 'error')} ">
	<label for="refugeFloorArea">
		<g:message code="building.refugeFloorArea.label" default="Refuge Floor Area" />
		
	</label>
	<g:textField name="refugeFloorArea" value="${buildingInstance?.refugeFloorArea}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'refugeFloorAddress', 'error')} ">
	<label for="refugeFloorAddress">
		<g:message code="building.refugeFloorAddress.label" default="Refuge Floor Address" />
		
	</label>
	<g:textField name="refugeFloorAddress" value="${buildingInstance?.refugeFloorAddress}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'fireLiftNum', 'error')} ">
	<label for="fireLiftNum">
		<g:message code="building.fireLiftNum.label" default="Fire Lift Num" />
		
	</label>
	<g:textField name="fireLiftNum" value="${buildingInstance?.fireLiftNum}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'fireLiftAddress', 'error')} ">
	<label for="fireLiftAddress">
		<g:message code="building.fireLiftAddress.label" default="Fire Lift Address" />
		
	</label>
	<g:textField name="fireLiftAddress" value="${buildingInstance?.fireLiftAddress}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'builderStructure', 'error')} required">
	<label for="builderStructure">
		<g:message code="building.builderStructure.label" default="Builder Structure" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="builderStructure" name="builderStructure.id" from="${firesystem.BuilderStructure.list()}" optionKey="id" required="" value="${buildingInstance?.builderStructure?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'fireRating', 'error')} required">
	<label for="fireRating">
		<g:message code="building.fireRating.label" default="Fire Rating" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="fireRating" name="fireRating.id" from="${firesystem.FireRating.list()}" optionKey="id" required="" value="${buildingInstance?.fireRating?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'fireFightingFacilitiesStatus', 'error')} required">
	<label for="fireFightingFacilitiesStatus">
		<g:message code="building.fireFightingFacilitiesStatus.label" default="Fire Fighting Facilities Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="fireFightingFacilitiesStatus" name="fireFightingFacilitiesStatus.id" from="${firesystem.FireFightingFacilitiesStatus.list()}" optionKey="id" required="" value="${buildingInstance?.fireFightingFacilitiesStatus?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'fireControlRoomAddress', 'error')} ">
	<label for="fireControlRoomAddress">
		<g:message code="building.fireControlRoomAddress.label" default="Fire Control Room Address" />
		
	</label>
	<g:textField name="fireControlRoomAddress" value="${buildingInstance?.fireControlRoomAddress}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'fireFightingFacilities', 'error')} ">
	<label for="fireFightingFacilities">
		<g:message code="building.fireFightingFacilities.label" default="Fire Fighting Facilities" />
		
	</label>
	<g:select name="fireFightingFacilities" from="${firesystem.FireFightingFacilities.list()}" multiple="multiple" optionKey="id" size="5" value="${buildingInstance?.fireFightingFacilities*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'comment', 'error')} ">
	<label for="comment">
		<g:message code="building.comment.label" default="Comment" />
		
	</label>
	<g:textField name="comment" value="${buildingInstance?.comment}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'neighborBuildingStatus', 'error')} ">
	<label for="neighborBuildingStatus">
		<g:message code="building.neighborBuildingStatus.label" default="Neighbor Building Status" />
		
	</label>
	<g:textField name="neighborBuildingStatus" value="${buildingInstance?.neighborBuildingStatus}"/>
</div>


