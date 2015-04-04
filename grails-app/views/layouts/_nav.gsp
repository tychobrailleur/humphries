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
