<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
    <title>${ticket.reference} – ${ticket.name}</title>
    <asset:stylesheet src="ticket.css" />
    <asset:javascript src="ticket.js" />
  </head>
  <body>
    <div id="ticket">
      <h1>${ticket.name}</h1>
      <p>${ticket.reference}</p>
      <p>${ticket.description}</p>
      
      <dl>
        <dt><g:message code="created.by" /></dt>
        <dd><friendly:link controller="user" action="show" model="${ticket.creator}">${ticket.creator.displayName}</friendly:link></dd>
        <dt><g:message code="assigned.to" /></dt>
        <dd><span id="assignee"><g:if test="${ticket.assignedTo}"><friendly:link controller="user" action="show" model="${ticket.assignedTo}">${ticket.assignedTo.displayName}</friendly:link></g:if>
          <g:else>
            &ndash;
          </g:else></span> (<g:remoteLink action="assignToMe" id="${ticket.id}" onSuccess="updateAssignee(data)">Assign to me</g:remoteLink>)</dd>
        <dt>Status:</dt>
        <dd>${ticket.state.name}</dd>
        <dt><g:message code="tags" /></dt>
        <dd><tag:list model="${ticket}" /></dd>
      </dl>
      
      <div ng-controller="NotesController" model="${ticket.id}">
        <ul>
          <li ng-repeat="note in notes.notes">
            <div class="createDate">{{note.creationDate}}</div>
            <div class="author">{{note.creator.name}}</div>
            <div class="text">{{note.text}}</div>
          </li>
        </ul>
      </div>

        <sec:ifNotLoggedIn>
        You must be logged in to add a note
        </sec:ifNotLoggedIn>

        <sec:ifLoggedIn>
          <dl>
            <dt>Add a new note:</dt>
            <dd>
              <div id="message"></div>
              <g:formRemote url="[controller: 'ticket', action :'addNote']"
                            update="message"
                            name="addNoteForm">
                <input type="hidden" name="ticketId" value="${ticket.id}"/>
                <textarea rows="2" cols="20" name="noteText"">your note</textarea>
                <g:submitButton name="Add Note" />
              </g:formRemote>
            </dd>
          </dl>
        </sec:ifLoggedIn>
    </div>
  </body>
</html>
