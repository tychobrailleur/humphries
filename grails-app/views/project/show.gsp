<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
    <asset:stylesheet src="ticket.css" />
  </head>
  <body>
    <div id="project">
      <h1>${project.name}</h1>
      <p>${project.description}</p>
      <dl>
        <dt>Code:</dt>
        <dd>${project.code}</dd>
        <dt><g:message code="tags" /></dt>
        <dd><tag:list model="${project}" /></dd>
        <dt>Members:</dt>
        <dd>
          <ul>
            <g:each in="${project.members}" var="member">
              <li><friendly:link controller="user" action="show" model="${member}">${member.displayName}</friendly:link></li>
            </g:each>
          </ul>
        </dd>
      </dl>

      <div id="tickets">
        <h3>Tickets</h3>
        <ul>
          <g:each in="${project.tickets}" var="ticket">
            <li><g:link controller="ticket" action="show" params="${[id: ticket.reference]}">${ticket.name}</g:link></li>
          </g:each>
        </ul>
      </div>

      <div id="actions">
        <ul>
          <li><g:link controller="project" action="addTicket" id="${project.id}"><span class="glyphicon glyphicon-plus"></span> Create Ticket</g:link></li>
          <li><g:link controller="project" action="addMember" id="${project.id}"><span class="glyphicon glyphicon-plus"></span> Add Member</g:link></li>
        </ul>
      </div>
    </div>
  </body>
</html>
