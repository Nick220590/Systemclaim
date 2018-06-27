<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome ${sessionScope.client.name}!!!  <a href="/login">Log out</a></h1>
	<c:if test="${sessionScope.client.status == 'client'}">	
		<div class="divTable">
			<table class="table">
				<tr class="header">
					<th>Id</th>
					<th>Request</th>
					<th>Bid</th>
					<th>Due date</th>
					<th>Status</th>			  
				</tr>
				<c:forEach var="claim" items="${allClaims}">						 
						<tr>				   
							<td>${claim.id}</td>
							<td>${claim.request}</td>
							<td>${claim.bid}</td>
							<td>${claim.dueDate}</td>
							<td>${claim.status}</td>
						</tr>				
				</c:forEach>	
			</table>
		</div>
		<form method="GET" action="/clientStatusRequests">
			<p class="status-submit">
		      <button type="submit" class="status-button">Get status of requests</button>
		    </p>
		</form>
		<form method="POST" action="/clientRequestRegister">
		    <p>
		      <label for="request">Request:</label>
		      <input type="text" name="request" id="request" placeholder="Sell property">
		    </p>
		
		    <p>
		      <label for="bid">Bid:</label>
		      <input type="text" name="bid" id="bid" placeholder="2.56">
		    </p>
		    
		     <p>
			     <label for="date">Date:</label>
	       		 <input type="date" id="date" name="date"/>
			 </p>		
		
		    <p class="request-submit">
		      <button type="submit" class="request-button">Register</button>
		    </p>
		</form> 			
	</c:if>	
	
		<c:if test="${client.status == 'admin'}">	
		<div class="divTable">
			<form method="POST" action="/adminUpdateStatus"><!-- временно GET -->
				<table class="table">
					<tr class="header">
						<th>Id</th>
						<th>Request</th>
						<th>Bid</th>
						<th>Due date</th>
						<th>Status</th>
						<th>Choose action</th>  			  
					</tr>
					<c:forEach var="claim" items="${allClaims}">						 
							<tr>				   
								<td>${claim.id}</td>
								<td>${claim.request}</td>
								<td>${claim.bid}</td>
								<td>${claim.dueDate}</td>
								<td>${claim.status}</td>
								<td>
									<c:if test="${claim.status == 'on consideration'}">
										<p>
											<input type="radio" name="action${claim.id}" value="done">Fulfill<br>
			   								<input type="radio" name="action${claim.id}" value="denied">Deny
		   								</p>
		   							</c:if>	
								</td>
							</tr>				
					</c:forEach>	
				</table>
				<p class="status-submit">
			    	<button type="submit" class="status-button">Update Statuses</button>
			    </p>
			</form> 	
		</div>
		<br><br><br>
		<form method="GET" action="/adminStatusAll">
			<p class="status-submit">
		      <button type="submit" class="status-button">Get All Claims</button>
		    </p>
		</form>
		<form method="GET" action="/adminStatusDone">
			<p class="status-submit">
		      <button type="submit" name="submit" value="done" class="status-button">Get Done Claims</button>
		    </p>
		</form>
		<form method="GET" action="/adminStatusDenied">
			<p class="status-submit">
		      <button type="submit" name="submit" value="denied" class="status-button">Get Denied Claims</button>
		    </p>
		</form>	
	</c:if>		
</body>
</html>