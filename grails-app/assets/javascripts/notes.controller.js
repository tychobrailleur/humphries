'use strict';

app.controller('NotesController', [ '$scope', 'notesService', '$attrs', function($scope, notesService, $attrs) {
    var ticketId = $attrs.model;
    notesService.getNotes(ticketId, function(data) {
        $scope.notes = data;
    });

    $scope.addNote = function() {
        var note = $scope.note;
        notesService.addNote(ticketId, note, function(data) {
            $scope.notes = data;
        });
    };
} ]);
