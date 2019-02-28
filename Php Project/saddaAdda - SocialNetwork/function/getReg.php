 <?php 
				include('connection.php');
				if(isset($_POST['get-reg'])){

					$f_name = $_POST['f_name'];
					$l_name = $_POST['l_name'];
					$u_email = $_POST['u_email'];
					$u_pass = $_POST['u_pass'];
					$u_birth = $_POST['u_birth'];
					$gender = $_POST['gen'];
					$profile_pic = "default.jpg";

					$check = "SELECT * FROM user WHERE user_email = '$u_email'";
					$run_check = mysqli_query($con, $check);

					$result = mysqli_num_rows($run_check);
					if($result>0){
						echo "email is alreay registered";
						exit();
					}
					else {

					 	$query1 = "INSERT INTO user_info(f_name,l_name,u_birth,profile_pic,gender) VALUES('$f_name','$l_name','$u_birth','$profile_pic','$gender')";
					 	$query2 = "INSERT INTO user(user_email,user_pass) VALUES ('$u_email','$u_pass')";
					 	$run_query1=mysqli_query($con,$query1);
					 	$run_query2=mysqli_query($con,$query2);
					 	if($run_query1 && $run_query2)
					 	{
					 		$path_user = "users/".$gender."/".$u_email;
					 		$path_profile = "users/".$gender."/".$u_email."/profile";
					 		$path_cover = "users/".$gender."/".$u_email."/cover";
					 		$path_post = "users/".$gender."/".$u_email."/post";

					 		mkdir($path_user, 0 , true);
					 		mkdir($path_profile, 0 , true);
					 		mkdir($path_cover, 0 , true);
					 		mkdir($path_post, 0 , true);
					 		
					 		echo "<script> alert('reg suc') </script>";
					 		header("location:login.php");
					 	}

					}
				}

			?>