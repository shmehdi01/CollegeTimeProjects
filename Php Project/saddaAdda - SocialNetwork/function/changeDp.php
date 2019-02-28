 <?php
	$user_id = $_SESSION['temp_user'] ;
 	if(isset($_POST['upload'])){
 		$dp_name = $_FILES['dp']['name'];
 		$dp_tmp_name = $_FILES['dp']['tmp_name'];

 		$path = "../users/".$_SESSION['gender']."/".$user_id."/profile/".$dp_name;

 		$upload_dp = "UPDATE user_info SET profile_pic ='$dp_name' WHERE user_id ='$user_id' " ;	

 		$run = mysqli_query($con,$upload_dp);

 		if($run){

 			move_uploaded_file($dp_tmp_name, $path);
 			echo "<script> window.open(window.location.href,'_self') </script>";
 			exit();
 		}


 	}

 ?>