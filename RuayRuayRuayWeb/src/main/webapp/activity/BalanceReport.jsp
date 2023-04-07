<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="DAOPackage.DAO,Constr.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="#">Ruay</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link"
						href="../index.jsp">Store</span></a></li>
					<li class="nav-item"><a class="nav-link"
						href="OrderReport.jsp">OrderReport</a></li>
					<li class="nav-item"><a class="nav-link"
						href="SalesReport.jsp">SalesReport</a></li>
					<li class="nav-item"><a class="nav-link"
						href="BalanceReport.jsp">BalanceReport</a></li>
					<li class="nav-item"><a class="nav-link" href="Analisys.jsp">Analisys</a>
					</li>

				</ul>
			</div>
		</div>
	</nav>
	
	<center>
		<br> <br> <br>
		<h2>BalanceReport</h2>
		<br> <br> <br>
	</center>
	<div class="container">
		<table class="table">
			<thead>
				<tr>

					<th scope="col">id</th>
					<th scope="col">goods</th>
					<th scope="col">stock</th>
					<th scope="col"></th>
				</tr>
			</thead>

			<tbody>
				<tr>

					<%
					List<goods> list = DAO.getGoods();
					for (goods sp : list) {
					%>
					<td><%=sp.getfor()%></td>
					<td><%=sp.getName()%></td>
					<td><%=sp.getStocks()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>

</body>
</html>