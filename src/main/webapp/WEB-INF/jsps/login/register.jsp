<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Register User</title>
<style>
.jumbotron {
    background-color: #6CC8CC;
    color: #fff;
    padding: 100px 25px;
    font-family: Montserrat, sans-serif;
  }
h2 {
    font-size: 24px;
    text-transform: uppercase;
    color: #303030;
    font-weight: 600;
    margin-bottom: 30px;
  }
  .loginfooter {
	background-color: #6CC8CC;
    letter-spacing: 4px;
    border-radius: 0;
	width: 100%;
	box-sizing: border-box;
	padding: 14px 16px;
	width: 100%;
}
.loginfooter a {
    color: #fff !important;
    float: center;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
  border: 1px solid #6CC8CC;
  display: inline-block;
  width: 100%;
  height: 100%;
  }
  .loginfooter a:hover{
    color: #6CC8CC !important;
    background-color: #fff !important;
  }
   .neomorphism{
  	width: 85%;
  	margin: 0 auto;
  	border-radius: 16px;
	background: #ffffff;
	box-shadow:  10px 10px 21px #8a8a8a, 
             -10px -10px 21px #ffffff;
    font-family: Montserrat, sans-serif;
    padding: 30px;
    padding-top: 50px;
  }
</style>
</head>
<body>
<div class="jumbotron text-center">
  <h1>Connect-And-Learn</h1> 
  <p>Learn or Teach your fav hobby !</p> 
</div>

<h2 class="text-center">User Registration:-</h2><br />
<div class="neomorphism">
<form class="form-horizontal" action="registerUser" method="post">

<div class="form-group">
  <label class="col-md-4 control-label">First Name</label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input class="form-control" id="firstname" placeholder="Enter First Name" type="text" name="firstName" />
   </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" >Last Name</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input type="text" name="lastName" placeholder="Last Name" class="form-control"/>
    </div>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" >Date of birth</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
  <input type="date" name="dateOfBirth" placeholder="YYYY-MM-DD" class="form-control"/>
    </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" >Gender</label> 
   <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  		<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
    	<label class="radio-inline"><input type="radio" name="gender" value="male"/>Male</label>
    	<label class="radio-inline"><input type="radio" name="gender" value="female"/>Female</label>
    	<label class="radio-inline"><input type="radio" name="gender" value="not_specified"/>Not Specified</label>
    	</div>
    </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" >Country</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-globe"></i></span>
  <input type="text" name="country" placeholder="Country" class="form-control" /> 
    </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" >Phone Number</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
  <input type="text" name="phoneNumber" placeholder="+1234567890" class="form-control" /> 
    </div>
  </div>
</div>
 <div class="form-group">
  <label class="col-md-4 control-label">E-Mail</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
  <input name="email" placeholder="abcdef@ghi.xyz" class="form-control"  type="email">
    </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" >Password</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input type="password" name="password"  placeholder="Password" class="form-control">
    </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" >Confirm Password</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input type="password" name="confirmPassword" placeholder="Confirm Password" class="form-control">
    </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4"><br>
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<button type="submit" class="btn btn-warning" >&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspREGISTER <span class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</button>
  </div>
  </div>    
</form>
</div>

</br>
<div class="loginfooter">
	<a href="showLogin">Already a member? Click here  to go to the login page.</a>
</div>
</body>
</html>

