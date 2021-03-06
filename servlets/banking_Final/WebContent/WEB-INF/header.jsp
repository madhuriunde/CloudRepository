<%
	String username = "Guest";
	boolean loggedIn = false;

	if (request.getSession().getAttribute("name") != null) {
		username = (String) session.getAttribute("name");
		loggedIn = true;
	}
%>
<header>
	<nav class="navbar navbar-expand-sm bg-success navbar-dark">
		<a class="navbar-brand" href="#">Welcome to Central Bank Of India</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navList" aria-controls="navList" aria-expanded="true"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navList">
			<ul class="navbar-nav mr-auto">
				<%
					if (loggedIn) {
				%>
				<li class="nav-item"><a class="nav-link" href="makeTransaction">Transaction</a></li>
				<li class="nav-item"><a class="nav-link" href="showAll">Show All</a></li>
				<li class="nav-item"><a class="nav-link" href="CSV">Get CSV</a></li>

				
				<%
					}
				%>

			</ul>
			<ul class="navbar-nav ml-auto">

				<li class="nav-item"><a class="nav-link" href="#"> <i
						class="fa fa-user" aria-hidden="true"></i> <%=username%>
				</a></li>
				<%
					if (loggedIn) {
				%>
				<li class="nav-item"><a class="nav-link" href="logout"><i
						class="fa fa-sign-out" aria-hidden="true"></i> Logout </a></li>
				<%
					} else {
				%>
				<li class="nav-item"><a class="nav-link" href="login"><i
						class="fa fa-sign-in" aria-hidden="true"></i> Login</a></li>
				<%
					}
				%>
			</ul>
		</div>
	</nav>
</header>