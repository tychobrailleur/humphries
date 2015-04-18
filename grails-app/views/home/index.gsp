<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
  </head>
  <body>
    <div id="projects">
      <h3>Projects</h3>
      <ul>
        <g:each in="${projects}" status="i" var="project">
          <li><g:link controller="project" action="show" id="${project.id}">${project.name}</g:link></li>
        </g:each>
      </ul>

      <sec:ifAllGranted roles="ROLE_ADMIN">
        <g:link controller="project" action="create"><span class="glyphicon glyphicon-plus"></span> Create Project</g:link></li>
      </sec:ifAllGranted>
    </div>

    <div id="recent-tickets">
      <h3>Recent Tickets</h3>
      <ul>
        <g:each in="${recentTickets}" status="i" var="ticket">
          <li><g:link controller="ticket" action="show" id="${ticket.reference}">${ticket.name}</g:link></li>
        </g:each>
      </ul>
    </div>
  </body>
</html>
