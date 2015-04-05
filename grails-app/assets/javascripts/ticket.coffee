@updateAssignee = (data) ->
    slug = data.assignedTo.slug
    displayName = data.assignedTo.displayName
    $('#assignee').html('<a href="/humphries/user/show/' + slug + '">' + displayName + '</a>')
