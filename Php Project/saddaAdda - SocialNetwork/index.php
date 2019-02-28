<?php
session_start();
if(!isset($_SESSION['temp_user']))
{
	//header('location:login.php');
	include('pages/login.php');
	// echo "sssion not set";
}

else{
	echo "welcome : ".$_SESSION['temp_user'];
	header('location:pages/home.php');
}

/*session_start();
if(isset($_SESSION['temp_user']))
{
	//header('location:login.php');
	header('location:home.php');
	
}*/
?>
