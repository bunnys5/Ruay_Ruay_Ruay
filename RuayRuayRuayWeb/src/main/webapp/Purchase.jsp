<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container mt-5 ">
		<H2>Purchase Order</H2>
		<div>
			<form action="thankyou.jsp" method="post">
				<div class=" mb-3 row">
					<h5 class="col-sm-2 col-form-label ">ID :</h5>
					<div class="col-sm-2">
						<input type="test" class="form-control-plaintext" id="idGood"
							name="idGood" value=" <%=request.getParameter("id")%>">
					</div>
				</div>


				<div class=" mb-3 row">
					<h5 class="col-sm-2 col-form-label ">Products Name :</h5>
					<div class="col-sm-2">
						<input type="test" class="form-control-plaintext" id="nameGood"
							name="nameGood" value="<%=request.getParameter("Name")%>">
					</div>
				</div>

				<div class=" mb-3 row">
					<h5 class="col-sm-2 col-form-label ">Price :</h5>
					<div class="col-sm-2">
						<input type="test" class="form-control-plaintext" id="priceGood"
							name="priceGood" value="<%=request.getParameter("Unit_Price")%> ">
					</div>
				</div>

				<!-- <h5>Quantitys  &nbsp; </h5> -->
				<div class=" mb-3 row">
					<h5 class="col-sm-2 col-form-label ">Quantitys :</h5>
					<div class="col-sm-2">
						<input type="numbers" class="form-control" id="qty" name="qty"
							required>
						<td><a href="thankyou.jsp"><button
									class=" mt-5  btn btn-outline-dark">Check Out</button></a></td>
					</div>
				</div>
			</form>

		</div>
	</div>

</body>
</html>