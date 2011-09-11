<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <title>${ticket.reference} – ${ticket.name}</title>
    </head>
    <body>
        <h1>${ticket.name}</h1>
        <p>${ticket.reference}</p>
        <p>${ticket.description}</p>
        <g:if test="${ticket.notes}">
            <ul>
            <g:each in="${ticket.notes}" var="note">
                <li>
                    ${note.text}
                </li>
            </g:each>
            </ul>
        </g:if>
    </body>
</html>

