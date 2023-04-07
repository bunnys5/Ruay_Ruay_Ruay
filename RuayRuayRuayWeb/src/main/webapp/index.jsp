<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="DAOPackage.*,Constr.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="#">Ruay</a>
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="activity/Analisys.jsp">Analisys</a>
					</li>

				</ul>
			</div>
		</div>
	</nav>

	<div class="container-md">
		<table class="table table-primary">
			<thead>
				<tr>
					<th scope="col">Number</th>
					<th scope="col">Catagory 1</th>
					<th scope="col">Catagory 2</th>
					<th scope="col">Catagory 3</th>
					<th scope="col">Name</th>
					<th scope="col">Price</th>
					<th scope="col">Stocks</th>
				</tr>

			</thead>
			<tbody>
				<tr>

					<%
					List<goods> list = DAO.getGoods();
					for (goods g : list) {
					%>
					<td><%=g.getfor()%></td>
					<td><%=g.getlv1()%></td>
					<td><%=g.getlv2()%></td>
					<td><%=g.getlv3()%></td>
					<td><%=g.getName()%></td>
					<td><%=g.getPrice()%></td>
					<td><%=g.getStocks()%></td>
					<td><a href="Purchase.jsp?id=<%= g.getid()%>&Name=<%= g.getName()%>&Unit_Price=<%= g.getPrice()%>"><button class="btn btn-outline-dark">Purchase</button></a></td>
				</tr>
				<%
				}
				%>
			</tbody>



		</table>


	</div>


</body>
</html>