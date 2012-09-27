
<%@ page import="firesystem.Building" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'building.label', default: 'Building')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-building" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-building" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'building.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="address" title="${message(code: 'building.address.label', default: 'Address')}" />
					
						<th><g:message code="building.district.label" default="District" /></th>
					
						<g:sortableColumn property="occupies" title="${message(code: 'building.occupies.label', default: 'Occupies')}" />
					
						<g:sortableColumn property="buildArea" title="${message(code: 'building.buildArea.label', default: 'Build Area')}" />
					
						<g:sortableColumn property="maxPersonNum" title="${message(code: 'building.maxPersonNum.label', default: 'Max Person Num')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${buildingInstanceList}" status="i" var="buildingInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${buildingInstance.id}">${fieldValue(bean: buildingInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: buildingInstance, field: "address")}</td>
					
						<td>${fieldValue(bean: buildingInstance, field: "district")}</td>
					
						<td>${fieldValue(bean: buildingInstance, field: "occupies")}</td>
					
						<td>${fieldValue(bean: buildingInstance, field: "buildArea")}</td>
					
						<td>${fieldValue(bean: buildingInstance, field: "maxPersonNum")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${buildingInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
