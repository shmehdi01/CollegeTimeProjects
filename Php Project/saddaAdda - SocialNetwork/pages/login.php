<!DOCTYPE html>




<html>
<head>
	<title>Sadda Adda - The Bachelor Place</title>
	<link rel="stylesheet" type="text/css" href="css/login-style.css" >

	<script type="text/javascript" src="script/jq.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#reg').click(function(){
				$('.register').stop().slideToggle('500');
			});
		});
	</script>
</head>
<body>
	<div class="main-wrapper">
		<span id="reg" > Register Here </span>
		<div id="head-wrapper">
			<div id="logo"> <img src="image/logo.png">  </div>
		</div>
		<div class="content-wrapper"> 
			 <div id="login-block"> 
			 	<form method="post">
			 		<table>
			 			<tr>
			 				<td><span>Username : </span> </td> <td> <input  type="text" name="user" required placeholder=""/> </td>
			 			</tr>

			 			<tr>
			 				<td> <span>Password  :</span> </td>  <td> <input type="password" name="pass"required placeholder=""/></td>
			 			</tr>
			 			
			 			<tr>
			 				<td colspan="1"> <small style="color:gray;"><a href="#">Forget Password??</a></small> </td>
			 				<td colspan="1"><button style="float:right" name="get-login"> Log In</button> </td>
			 			</tr>

			 		


			 		
			 		</table>
			 	</form>

			 	<?php include('function/getLogin.php') ?>

			 </div>
			 <div id="image-block"> <img src="image/4.png" height="350" width="590"> </div>
		</div>
		<footer>
			<div id="foot"> Sadda Adda - The Bachelor Place &copy; <?php echo date('Y'); ?></div>
		</footer>
	 </div>

</body>
</html>

<?php
error_reporting(E_ALL & ~E_NOTICE);
session_start();
if(isset($_SESSION['temp_user']))
{
	header('location:index.php');
	//echo "session is not set";
} 


 ?>

 <?php include('register.php'); ?>
 <?php include('function/getReg.php'); ?>
		

		