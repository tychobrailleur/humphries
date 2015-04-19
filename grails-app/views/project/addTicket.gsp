<%@ page import="org.humphries.Project" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
  </head>
  <body>
    <div class="nav">
      <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
      <span class="menuButton"><g:link class="list" action="list">Create Ticket</g:link></span>
    </div>
    <div class="body">
      <g:form action="saveTicket" method="POST">
        <input type="hidden" name="projectId" value="${project.id}">
        
        <label for="name">Name</label>
        <input type="text" id="name" name="name">

        <label for="description">Description</label>
        <textarea id="description" name="description" cols="20" rows="10"></textarea>

        <div class="buttons">
          <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
        </div>
      </g:form>
    </div>
  </body>
</html>
