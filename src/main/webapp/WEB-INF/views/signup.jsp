<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>SignUp form</title>

</head>
<body>
	<form action="<c:url value = '/add_user'/>" method='POST' class = "form-horizontal">
		<fieldset>
		<legend>Enter your credentials</legend>
		<div>
			<label>Username:</label> <input type="text" name="username" class="form-control"><br>
			
		</div>

		<div>
			<label>Password:</label> <input type="password" name="password" class="form-control"><br>
			
		</div>

		<div>
			<label>Email:</label> <input type="email" name="email" class="form-control"><br>
			
		</div>

		<div>
			<label>Address:</label> <input type="text" name="address" class="form-control"><br>
			
		</div>

		<div>
			<label>Date:</label> <input type="date" name="dob" class="form-control"><br>
			
		</div>

		<div>
			<label>Mobile No:</label> <input type="number" name="mobileNo" class="form-control"><br>
			
		</div>

		<div>
			<label>Gender:</label> 
			<input type="radio" name="gender" value="Male">Male
			<input type="radio" name="gender" value="Female">Female
			<input type="radio" name="gender" value="Other">Other
		</div>
		
		<div>
			<label>Hobbies:</label>  
			<input type="checkbox" name="hobbies" value="Trekking" >Trekking 
				<input type="checkbox" name="hobbies" value="Swimming" >Swimming
		</div>
		
		<div>
			<label>Nationality:</label> <select name="nationality">
			<option value="">Choose one</option>
				<option value="Nepali">Nepali</option>
				<option value="American">American</option>
				<option value="Canadian">Canadian</option>
			</select>
		</div>
		 <label>Comments:</label><br>
		<textarea name="comments" rows="5" cols="40">
</textarea>
		<br> <input type="submit" value="Submit"class="btn btn-primary" />
		</fieldset>
	</form>
	<a href = "/list_user">User List</a>
</body>
</html>