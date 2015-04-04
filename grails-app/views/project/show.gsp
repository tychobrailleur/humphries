
<%@ page import="org.humphries.Project" %>
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
                <dd><g:join in="${project.tags*.name}" /></dd>
                <dt>Members:</dt>
                <dd>
                    <ul>
                        <g:each in="${project.members}" var="member">
                            <li><g:link controller="user" action="show" id="${member.id}">${member.displayName}</g:link></li>
                </g:each></ul></dd>
            </dl>
            
        </div>
    </body>
</html>
