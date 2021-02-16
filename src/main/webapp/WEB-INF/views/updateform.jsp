    <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@ taglib uri ="http://java.sun.com/jsp/jstl/functions" prefix ="fn"%>
     <%@ page session ="false" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Form</title>
<%--<%@ include file = "header.jsp" %>--%>
</head>
<body>

<form action="<c:url value ='/edit_user'/>" method='POST'>
<div> <label>Id:</label>
<input type = "number" name = "id" readonly value = "${user.id}">
</div>

<div> <label>Name:</label>
<input type = "text" name = "name"  value = "${user.name}">
</div>

<div> <label>Username:</label>
<input type = "text" name = "username"  value = "${user.username}">
</div>

<div> <label>Password:</label>
<input type = "password" name = "password"  value = "${user.password}">
</div>

<div> <label>Email:</label>
<input type = "email" name = "email" value = "${user.email}">
</div>

<div> <label>Date:</label>
<input type = "date" name = "dob"  value = "${user.dob}">
</div>

<div> <label>Mobile No:</label>
<input type = "number" name = "mobileNo"  value = "${user.mobileNo}">
</div>

<div> <label>Address:</label>
<input type = "text" name = "address" value = "${user.address}">
</div>

<div>
<label>Gender</label>
<input type = "radio" name = "gender" value = "Male"${user.gender=='Male'?'checked':'' }>Male
<input type = "radio" name = "gender" value = "Female"${user.gender=='Female'?'checked':'' }>Female
<input type = "radio" name = "gender" value = "Other"${user.gender=='Other'?'checked':'' }>Other
</div>

<div>
		<label>Hobbies</label>
		<input type="checkbox" name="hobbies" value = "Trekking" <c:if test = "${fn:contains(user.hobbies, 'Trekking')}">checked</c:if>>Trekking
		<input type="checkbox" name="hobbies" value = "Swimming" <c:if test = "${fn:contains(user.hobbies, 'Swimming')}">checked</c:if>>Swimming
	</div>
	<div>
	<label>Nationality</label>
		<select name =  "nationality">
		
		<option value  =  "Nepali" ${user.nationality=='Nepali'?'selected':'' }> Nepali </option>
		<option value  =  "American" ${user.nationality=='American'?'selected':'' }> American </option>
		<option value  =  "Canadian" ${user.nationality=='Canadian'?'selected':'' }> Canadian </option>
		
		</select>
	</div>
	<div>
	
	<label>Comments</label>
	<textarea rows="5" cols="20"  name =  "comments" ${user.comments}></textarea>
	</div>
<input type = "submit" value = "UPDATE"/>
</form>

</body>
</html>