
<form method="post">
	<textarea placeholder="what are you doing now?" name="u_post" required></textarea>
	<button name="update-post"> Post </button>
</form>
<?php
if(isset($_POST['update-post']))
{
	$post = $_POST['u_post'];
	$user_id = $_SESSION['temp_user'];
	$profile_name =  $_SESSION['name'];

	$query_insert = "INSERT INTO user_post(user_id,profile_name,post) VALUES('$user_id','$profile_name','$post')";
	$insert = mysqli_query($con,$query_insert);

	if($insert){
		header("location:home.php");
		exit();
	}
}

?>
