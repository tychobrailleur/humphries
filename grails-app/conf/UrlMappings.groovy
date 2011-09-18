class UrlMappings {

  static mappings = {
    "/$controller/$action?/$id?" {
      constraints {
        // apply constraints here
      }
    }

    // home page is currently the list of tickets
    "/" {
      controller = 'ticket'
      action = 'list'
    }

    "500"(view:'/error')
  }
}
