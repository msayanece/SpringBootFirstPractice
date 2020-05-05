<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring Boot Practice</title>
<!-- Bootstrap -->
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<a class="navbar-brand navbar-light" href="/">Spring Boot
					Practice</a>
			</div>
		</div>
		<!-- /.container-fluid -->
	</nav>

	<!-- JUMBOTRON -->
	<div class="jumbotron text-center">
		<div class="container">
			<h1>Welcome To The Spring Boot Practice</h1>
			<p>This website will be used for practicing the Spring Boot along
				with JPA, Thymeleaf, jQuery, Bootstrap etc.</p>
		</div>
	</div>

	<div class="container">
		<h3 class="page-header">Add New Customer</h3>
	</div>

	<!-- FORMS -->
	<div class="container">
		<form>
			<div class="form-group">
				<label>Name</label> <input name="name" type="text"
					class="form-control" placeholder="Add Name">
			</div>

			<div class="form-group">
				<label>Email</label> <input name="email" type="email"
					class="form-control" placeholder="Add Email">
			</div>

			<div class="form-group">
				<label>Phone</label> <input name="phone" type="number"
					class="form-control" placeholder="Add Phone">
			</div>

			<div class="form-group">
				<label>Address</label>
				<textarea class="form-control" name="address"
					placeholder="Add Full Address"></textarea>
			</div>

			<div class="form-group">
				<label>Date of Birth</label> <input name="dob" type="date"
					class="form-control" name="phone" placeholder="Add Date">
			</div>

			<div class="form-group">
				<label>Gender</label> <select name="gender" class="form-control">
					<option value="male">Male</option>
					<option value="female">Female</option>
					<option value="other">Other</option>
				</select>
			</div>

			<div class="form-group">
				<label>Bank Branch</label> <select name="branch"
					class="form-control">
					<option value="basirhat">Basirhat</option>
					<option value="birati">Birati</option>
				</select>
			</div>
			<div class="btn-group">
				<label>Branch Type</label> <br> <label class="radio-inline"><input
					type="radio" name="branchType" value="Savings" checked>Savings</label>
				<label class="radio-inline"><input type="radio"
					name="branchType" value="Current">Current</label>
			</div>
			<div class="checkbox">
				<label> <input name="tnc" type="checkbox"> I accept
					the terms and conditions.
				</label>
			</div>
			<button id="form-submit" type="submit" class="btn btn-primary">Submit</button>
		</form>

	</div>

	<div class="container" id="customer-table-container">
	
		<div class="container">
			<h3 class="page-header">Customers Details</h3>
		</div>

		<!-- TABLES -->
		<div class="container">
			<table class="table table-striped table-bordered table-hover"
				id="customer-table">
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Address</th>
					<th>Gender</th>
					<th>Branch</th>
				</tr>
				<tr>
					<td>John Doe</td>
					<td>jd@gmail.com</td>
					<td>7908021153</td>
					<td>Basirhat, Bagati Natun Para, P.O- Bhabla, P.S- Basirhat,
						PIN 743422</td>
					<td>Male</td>
					<td>Basirhat</td>
				</tr>
			</table>
		</div>
	</div>

	<hr>

	<!-- GRIDS -->
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-sm-8 col-xs-8">
				<p>All right reserved to Sayan Mukherjee. Any use of this
					content will be punishable and finable of Rs. 10000. Any use of the
					used code cannot be used by any other than Mr. Sayan Mukherjee</p>
			</div>
			<div class="col-md-4 col-sm-4 col-xs-4">
				<p>@Copyright by Sayan Mukherjee</p>
			</div>
		</div>
	</div>

	<div style="height: 20px"></div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="/resources/js/index.js"></script>
</body>
</html>
