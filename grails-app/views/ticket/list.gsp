<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <title>Humphries – Ticket List</title>
    </head>
    <body>
    <g:each var="ticket" in="${tickets}">
        <h1>${ticket.name}</h1>
        <p>${ticket.reference}</p>
        <p>${ticket.description}</p>

        <dl>
          <dt><g:message code="created.by" /></dt>
          <dd>${ticket.creator}</dd>
        </dl>

        <div id="dynamic_notes">
            <g:if test="${ticket.notes}">
                <ul>
                <g:each in="${ticket.notes}" var="note">
                    <li id="note_${note.id}">
                        <div class="creationDate">${note.creationDate}</div>
                        <div class="author">${note.creator.name}</div>
                        <div class="text">${note.text}</div>
                    </li>
                </g:each>
                </ul>
            </g:if>
        </div>
    </g:each>
</body>
</html>
