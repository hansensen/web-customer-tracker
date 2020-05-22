<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title> List Customers </title>
	
	<link type="text/css"
			rel="stylesheet"
			href="${pageCOntext.request.contextPath}/web-customer-tracker/resources/css/style.css" />
	</head>

<body>

	<div id ="wrapper">
		<div id="header">
			<h2> CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<!-- add new button -->
			
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"
			/>
		
		
			<table>
				<tr>
					<th> First Name</th>
					<th> Last Name </th>
					<th> Email </th>
					<th> Action </th>
				</tr>
				<c:forEach var="tmpCustomer" items="${customers}">
				
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tmpCustomer.id}" />
					</c:url>
					
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tmpCustomer.id}" />
					</c:url>
					
					<tr>
						<td> ${tmpCustomer.firstName} </td>
						<td> ${tmpCustomer.lastName} </td>
						<td> ${tmpCustomer.email} </td>
						<td> 
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			
			</table>
		</div>
	</div>

</body>

</html>