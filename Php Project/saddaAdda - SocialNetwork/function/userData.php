<?php
include('../function/connection.php');
$user_id = $_SESSION['temp_user'];
$query=  "SELECT * FROM user_info WHERE user_id ='$user_id'";
$run = mysqli_query($con,$query);
$get = mysqli_fetch_array($run);
$dp = $_SESSION['dp'] = $get['profile_pic'];
$gen = $_SESSION['gender'] = $get['gender'];
$firstName = $_SESSION['firstName'] = $get['f_name'];
$lastName = $_SESSION['lastName'] = $get['l_name'];
$birthday = $_SESSION['birthday'] = $get['u_birth'];
$city = $_SESSION['city'] = $get['u_city'];
$college = $_SESSION['college'] = $get['u_college'];
$mobile = $_SESSION['mobile'] = $get['u_mob'];
?>