'use strict';

app.service('notesService', [ '$resource', function($resource) {
    return {
        getNotes: function(ticketId) {
            var Notes = $resource('../../ticket/getNotesJSON', { ticketId: '@id' });
            return Notes.get({ticketId: ticketId});
        }
    };
}]);
