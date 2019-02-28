<?php

include('connection.php');

if(isset($_POST['get-login'])){
	$user = $_POST['user'];
	$pass = $_POST['pass'];

	$check= "SELECT * FROM user WHERE  user_pass = '$pass'  AND (user_name = '$user' OR user_email = '$user')";
	$run_check = mysqli_query($con,$check);
	$result = mysqli_num_rows($run_check);
	
	

	if($result>0){

		$data = mysqli_fetch_array($run_check);
		$tempUser = $data['user_id'];
		$email = $data['user_email'];
		$query_detail = "SELECT * FROM user_info WHERE user_id='$tempUser'";
		$get_detail = mysqli_query($con,$query_detail);
		$user_detail = mysqli_fetch_array($get_detail);

			$_SESSION['name'] = $user_detail['f_name'] ." ".$user_detail['l_name'];
			$_SESSION['gen'] = $user_detail['gender'];
			$_SESSION['birthday'] = $user_detail['u_birth'];
			$_SESSION['profile_pic'] = $user_detail['profile_pic'];
			$_SESSION['city'] = $user_detail['u_city'];
			$_SESSION['college'] = $user_detail['u_college'];
			$_SESSION['mobile'] = $user_detail['u_mob'];

			$_SESSION['email'] = $email;

		$sym = mysql_real_escape_string('&bull;');
		$onine_query = "UPDATE user_info SET status ='$sym' WHERE user_id ='$tempUser'";
		$do_online = mysqli_query($con,$onine_query);

		session_start();
		$_SESSION['temp_user'] = $tempUser;
		header("location:home.php");
	}
		else echo "<span style='color:red;font-size:16px;'>Username/Password is incorrect !! </span>" ;


}


?>
