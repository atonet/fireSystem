
<%@ page import="firesystem.FireFightingFacilitiesStatus" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'fireFightingFacilitiesStatus.label', default: 'FireFightingFacilitiesStatus')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-fireFightingFacilitiesStatus" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-fireFightingFacilitiesStatus" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'fireFightingFacilitiesStatus.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'fireFightingFacilitiesStatus.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'fireFightingFacilitiesStatus.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${fireFightingFacilitiesStatusInstanceList}" status="i" var="fireFightingFacilitiesStatusInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${fireFightingFacilitiesStatusInstance.id}">${fieldValue(bean: fireFightingFacilitiesStatusInstance, field: "name")}</g:link></td>
					
						<td><g:formatDate date="${fireFightingFacilitiesStatusInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${fireFightingFacilitiesStatusInstance.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${fireFightingFacilitiesStatusInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
