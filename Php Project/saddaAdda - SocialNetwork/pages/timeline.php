<!DOCTYPE html>

<?php
include('../function/getDp.php');
session_start();
if(!isset($_SESSION['temp_user']))
{
	header('location:index.php');
}
include('../function/userData.php');
$id = $_GET['id'];
?>

<html>
<head>
	<title> Timeline</title>
	<link rel="stylesheet" type="text/css" href="../css/home.css"> 
	<link rel="stylesheet" type="text/css" href="../css/userpostarea.css"> 
	<style type="text/css">
	#changeDp{
		position: absolute;
		left: 5px;
		top: 8px;
		background-color: #666;
		padding: 2px;
		color: #fff;
		border-radius: 5px;
		cursor: pointer;
		display: none;
		opacity: 0.8;
	}
	#changeDpOption{
		height: 114px;
		padding: 10px;
		background-color: #fff;
		border-radius: 10px;
		box-shadow: 0 0 100px #333;
		position: absolute;
		left: 370px;
		display: none;
	}
	#areaStyle{
			height: 10px;
			width: 350px;
			padding: 50px;
			background-color: #fff;
			border: 1px dotted #ccc;
			border-radius: 10px;
	}
	#changeDpOption #closePop{
		float: right;
		cursor: pointer;
		font-size: 25px;
		color: #7ac043;
		padding-right: 10px;
	}
	#changeDpOption #removeBtn{
		color: #fff;
		background-color: #333;
		padding: 0px;
		position: absolute;
		top: 10px;
		border-radius: 5px;
		cursor: pointer;
		border: 0px;
	}
	#changeDpOption button{
			height: 40px;
			width: 80px;
			background-color: #7ac043;
			color: #fff;
			border:0;
			cursor: pointer;
			box-shadow: 0 0 2px #ccc;
		}

		#changeCover{
			position: absolute;
			top: 80px;
			left: 100px;
			background-color: #666;
			color: #fff;
			padding: 5px;
			padding-right: 15px;
			font-family: arial;
			border-radius: 10px;
			opacity: 0.8;
			display: none;
			cursor: pointer;
		}
		
	</style>
	<script type="text/javascript" src="../script/jq.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			// Change DP JQuery

			$('#profile-pic').mouseenter(function(){
				$('#changeDp').fadeIn();
			});
			$('#profile-pic').mouseleave(function(){
				$('#changeDp').fadeOut();
			});
			$('#changeDp').click(function(){
				$('#changeDpOption').fadeToggle();
			});
			$('#closePop').click(function(){
				$('#changeDpOption').hide();
			});

			// Change cover JQuery

			$('.cover').mouseenter(function(){
				$('#changeCover').fadeIn();
			});
			$('.cover').mouseleave(function(){
				$('#changeCover').fadeOut();
			});
			$('#changeCover').click(function(){
				$('#changeDpOption').fadeToggle();
			});
			$('#closePop').click(function(){
				$('#changeDpOption').hide();
			});
		});
	</script>
</head>

<body>
	<?php include('../include/home/headbar.php') ?>
	<div class="main">

		<div id="online-wrapper">
		<?php include('../include/home/online.php'); ?>
		</div>
		<div id="cover-area"> 
			<div class="cover"> <img src="cover.jpg"> <span id="changeCover"> &#9998; Change Cover </span> </div>
			<div class="profile-pic_area">
		 		<div id="profile-pic"><span id="changeDp"> &#9998; </span><img src="<?php echo getDp($_SESSION['dp'],$_SESSION['temp_user'],$_SESSION['gen']); ?>"> </div> 
		 		<div id="name-area"> <?php echo  $_SESSION['name']; ?> </div>
		 		<div id="nav-link"> <span> Timeline </span> <span> About </span>  <span>Photo</span>  </div>
			</div>
		</div>
	</div>

			<div id="changeDpOption"> <div id="closePop"> &#10006; </div> 
				<div id="areaStyle" > 
					<form method="post" enctype="multipart/form-data">
						<input type="file"  name="dp" accept="image/*" required/> 
						<button name="upload"> Upload </button>
					</form>


				
			</div>
			<form method="post"><button name="removeDp" id="removeBtn"> &#9988; remove image </button> </form>
			</div>
			<?php include('../function/changeDp.php'); ?>
			<?php
				if(isset($_POST['removeDp'])){
					$remove = mysqli_query($con,"UPDATE user_info SET profile_pic ='' WHERE user_id ='$user_id' ");
					if($remove){
						echo "<script> window.open(window.location.href,'_self') </script>";
					}
				}
			 ?>

  <?php include('../include/timeline/userPost.php'); ?>
			
</body>
</html>