<!DOCTYPE html>

<?php
include('../function/getDp.php');
session_start();
if(!isset($_SESSION['temp_user']))
{
	header('location:index.php');
}
include('../function/userData.php');

?>


<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="../css/home.css"> 
	<style type="text/css">
	
	</style>
</head>
<body>
	<?php include('../include/home/headbar.php') ?>
	<div class="main">
		<?php include('../include/home/left.php') ?>
		<div class="content-wrapper">
			<div class="post-box">
				<?php include('../include/home/postbox.php') ?>
			</div>

			<div class="new_feed">
				<?php include('../include/home/newsfeedpost.php') ?>
			</div>
		</div>
		<?php include('../include/popUpChange.php');?>
		<div id="online-wrapper">

		<?php include('../include/home/online.php'); ?>
		
		</div>
	 </div>


</body>
</html>