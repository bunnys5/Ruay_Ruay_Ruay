<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="DAOPackage.*,Constr.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container mt-5 text-center py-5">
		<H2>Thank You !!</H2>
		<h5>
			Order products :
			<%=request.getParameter("nameGood")%>
		</h5>
		<h5>
			Quantity :
			<%=request.getParameter("qty")%></h1>
			<a href="index.jsp"><button class="btn btn-outline-dark mt-5">
					Back to Store</button></a>
	</div>
	</div>
	</div>




	<%

			String gid = request.getParameter("idGood");
			String qty = request.getParameter("qty");
			Purchase Add = new Purchase(gid,qty);
			DAO.AddSalesAndUpdateStock(Add);
	%>

</body>
</html>