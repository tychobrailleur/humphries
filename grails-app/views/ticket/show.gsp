<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
    <title>${ticket.reference} – ${ticket.name}</title>
    <asset:stylesheet src="ticket.css" />
    <asset:javascript src="ticket.js" />
  </head>
  <body>
    <div id="ticket" ng-controller="NotesController" model="${ticket.id}">
      <div class="breadcrumb"><g:link controller="project" action="show" id="${ticket.project.id}">${ticket.project.name}</g:link> &gt; ${ticket.reference}</div>

      <h1>${ticket.name}</h1>
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

      <div id="notes">
        <h2>Notes</h2>
        <ul>
          <li ng-repeat="note in notes.notes">
            <div ng-class-odd="'odd'" ng-class-even="'even'">
              <div class="author">{{note.creator.name}}</div>
              <div class="createDate">{{note.creationDate | date:"dd/MM/yyyy 'at' h:mma"}}</div>
            <div class="text">{{note.text}}</div>
            </div>
          </li>
        </ul>
        <p ng-if="!notes.notes">Currently no notes.</p>
      </div>

        <sec:ifNotLoggedIn>
        You must be logged in to add a note
        </sec:ifNotLoggedIn>

        <sec:ifLoggedIn>
          <dl>
            <dt>Add a new note:</dt>
            <dd>
              <div id="message"></div>
              <form>
                <input type="hidden" name="ticketId" value="${ticket.id}" ng-model="note.ticketId">
                <textarea rows="5" cols="70" name="noteText" placeholder="Your Note..." required ng-model="note.text"></textarea><br>
                <button ng-click="addNote()">Add Note</button>
              </form>
            </dd>
          </dl>
        </sec:ifLoggedIn>
    </div>
  </body>
</html>
