'use strict';

app.service('notesService', [ '$http', function($http) {
    return {
        getNotes: function(ticketId, callback) {
            $http.get('../../ticket/getNotesJSON', { params: {ticketId: ticketId} })
                .success(function(data, status, headers, config) {
                    callback(data);
                });
        },

        addNote: function(ticketId, note, callback) {
            $http.post('../../ticket/addNote', { ticketId: ticketId, noteText: note.text })
                .success(function(data, status, headers, config) {
                    callback(data);
                });
        }
    };
}]);
