<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <title>${ticket.reference} – ${ticket.name}</title>
        <asset:stylesheet src="ticket.css" />
    </head>
    <body>
        <div id="ticket">
            <h1>${ticket.name}</h1>
        <p>${ticket.reference}</p>
        <p>${ticket.description}</p>

        <dl>
          <dt><g:message code="created.by" /></dt>
          <dd><g:link controller="user" action="show" id="${ticket.creator.id}">${ticket.creator}</g:link></dd>
          <dt><g:message code="assigned.to" /></dt>
          <dd><g:link controller="user" action="show" id="${ticket.assignedTo?.id}">${ticket.assignedTo}</g:link></dd>
          <dt><g:message code="tags" /></dt>
          <dd><g:join in="${ticket.tags*.name}" /></dd>
        </dl>

        <div id="dynamic_notes">
        </div>

        <g:javascript>
            function displayNotes() {
                var noteUrl='<g:createLink controller="ticket" action="getNotesJSON" />';
                jQuery.getJSON(
                    noteUrl,
                    {ticketId : '${ticket.id}'},
                        function(data) {
                        var items = [];
                        // definitely need to use some client-side templating solution
                        $.each(data.notes, function(index, note) {
                            noteHtml = '<li id="note_' + note.id + '">';
                            noteHtml+= '<div class="creationDate">' + note.creationDate +'</div>';
                            noteHtml+= '<div class="author">' + note.creator.name+'</div>';
                            noteHtml+= '<div class="text">' + note.text+'</div>';
                            noteHtml+= '</li>';
                            items.push(noteHtml);
                        });
                        $('#dynamic_notes').html(
                            $('<ul/>', { 'class': 'my-new-list',
                              html: items.join('') }));
                    }
                );
            }

            $(document).ready(function(){
               displayNotes();
             });
        </g:javascript>

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
                                  onSuccess="displayNotes()"
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
