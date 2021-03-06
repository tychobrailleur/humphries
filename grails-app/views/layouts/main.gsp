<!DOCTYPE html>
<html>
  <head>
      <title><g:layoutTitle default="Humphries" /></title>
      <asset:stylesheet href="main.css"/>
    <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
    <g:layoutHead />
    <g:javascript library="application" />
    <g:javascript library="jquery" plugin="jquery"/>
    <link href='//fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
    <asset:stylesheet src="app.css" />
    <asset:stylesheet src="main.css" />
    <script src="${resource(dir:'js',file:'angular.min.js')}" type="text/javascript"></script>
    <script src="${resource(dir:'js',file:'angular-resource.min.js')}" type="text/javascript"></script>
  </head>
  <body ng-app="humphriesApp">
    <div id="spinner" class="spinner" style="display:none;">
      <img src="${resource(dir:'images',file:'spinner.gif')}" alt="${message(code:'spinner.alt',default:'Loading...')}" />
    </div>
    <div id="header"><h1><span><a href="/humphries">Humphries</a></span></h1></div>
    <div id="info">
      <ul>
        <sec:ifNotLoggedIn>
          <li><g:link controller="login" action="auth">Login</g:link></li>
        </sec:ifNotLoggedIn>
        <sec:ifLoggedIn>
          <li>Hiya, <sec:username /></li>
          <li><g:link controller="logout">Sign out</g:link></li>
        </sec:ifLoggedIn>
      </ul>
    </div>
    <div id="content">
      <g:layoutBody />
    </div>
    <asset:javascript src="app.js" />
  </body>
</html>
