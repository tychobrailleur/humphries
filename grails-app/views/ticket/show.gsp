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
                      
                        <div class="text"> ${note.text}</div>
                    </li>
                </g:each>
                </ul>
            </g:if>
        </div>


        <g:javascript>
            function displayNotes() {
                var noteUrl='<g:createLink controller="ticket" action="getNotesJSON" />';
                jQuery.getJSON(
                    noteUrl,
                    {ticketId : '${ticket.id}'},
                    function(data ) {
                        var items = [];
                        // definitely need to use some client-side templating solution
                        $.each(data.notes, function(index,  note) {
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
               //displayNotes();
             });
        </g:javascript>

        <sec:ifNotLoggedIn>
        You must be logged in to add a note
        </sec:ifNotLoggedIn>

        <sec:ifLoggedIn>
            Add a new note :

            <div id="message" ></div>
            <g:formRemote url="[controller: 'ticket', action :'addNote']"
                onSuccess="displayNotes()"
                name="addNoteForm">
                <input type="hidden" name="ticketId" value="${ticket.id}"/>
                <textarea rows="2" cols="20" name=noteText>your note</textarea>
                <input type="submit" value="add Note" />
        </g:formRemote>
        </sec:ifLoggedIn>
    </body>
</html>

