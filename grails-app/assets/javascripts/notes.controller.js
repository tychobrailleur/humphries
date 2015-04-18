'use strict';

app.controller('NotesController', [ '$scope', 'notesService', '$attrs', function($scope, notesService, $attrs) {
    var ticketId = $attrs.model;
    $scope.notes = notesService.getNotes(ticketId);
} ]);
