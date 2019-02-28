<?php
session_start();
include('../function/connection.php');
$tempUser = $_SESSION['temp_user'];
$onine_query = "UPDATE user_info SET status ='' WHERE user_id ='$tempUser'";
$do_online = mysqli_query($con,$onine_query);
session_destroy();
header("location:../index.php");
 ?>