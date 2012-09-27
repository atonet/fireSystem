
<%@ page import="firesystem.OrgClassification" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'orgClassification.label', default: 'OrgClassification')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-orgClassification" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-orgClassification" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="orgClassification.parent.label" default="Parent" /></th>
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'orgClassification.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'orgClassification.lastUpdated.label', default: 'Last Updated')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'orgClassification.name.label', default: 'Name')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${orgClassificationInstanceList}" status="i" var="orgClassificationInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${orgClassificationInstance.id}">${fieldValue(bean: orgClassificationInstance, field: "parent")}</g:link></td>
					
						<td><g:formatDate date="${orgClassificationInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${orgClassificationInstance.lastUpdated}" /></td>
					
						<td>${fieldValue(bean: orgClassificationInstance, field: "name")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${orgClassificationInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
