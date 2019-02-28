<!DOCTYPE html>

<?php
include('../function/getDp.php');
session_start();
if(!isset($_SESSION['temp_user']))
{
	header('location:index.php');
}
$id = $_GET['id'];
if($_SESSION['temp_user'] == $_GET['id'] ){
	header("location:timeline.php?id=".$id);
}
?>
<?php
	include('../function/connection.php');
 	$query = "SELECT * FROM user_info WHERE user_id ='$id'";
 	$run = mysqli_query($con,$query);
 	$detail = mysqli_fetch_array($run);

 	$name = $detail['f_name']." ".$detail['l_name'];
 	$dp = $detail['profile_pic'];
 	$gen = $detail['gender'];

?>
<html>
<head>
	<title> Timeline</title>
	<link rel="stylesheet" type="text/css" href="../css/home.css"> 
	<link rel="stylesheet" type="text/css" href="../css/userpostarea.css"> 
</head>

<body>
	<?php include('../include/home/headbar.php') ?>
	<div class="main">
		<div id="online-wrapper">
		<?php include('../include/home/online.php'); ?>
		</div>
		<div id="cover-area">
			<div class="cover"><!-- <img src="cover.jpg"> --> </div>
			<div class="profile-pic_area">
		 		<div id="profile-pic"><img src="<?php echo getDp($dp,$id,$gen); ?>"> </div> 
		 		<div id="name-area"> <?php echo  $name ; ?> </div>
		 		<div id="nav-link"> <span> Timeline </span> <span> About </span>  <span>Photo</span>  </div>
			</div>
		</div>
	</div>
 
 <?php include('../include/timeline/userPost.php'); ?>
	
</body>
</html>