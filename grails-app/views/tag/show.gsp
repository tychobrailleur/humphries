<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
    <title>${tag.name}</title>
    <asset:stylesheet src="ticket.css" />
  </head>
  <body>
    <div id="tag">
      <h1>Tag: ${tag.name}</h1>

      <h2>Projects</h2>

      <ul>
        <g:each in="${projects}" var="project">
          <li><g:link controller="project" action="show" id="${project.id}">${project.name}</g:link></li>
        </g:each>
      </ul>

      <h2>Tickets</h2>

      <ul>
        <g:each in="${tickets}" var="ticket">
          <li><g:link controller="ticket" action="show" id="${ticket.id}">${ticket.name}</g:link></li>
        </g:each>
      </ul>
    </div>
  </body>
</html>
