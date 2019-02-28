<head>
	<style type="text/css">
	#member-box{
		margin-bottom: 5px;
		height: 30px;
		line-height: 30px;
		width: 190px;
		background-color: #fff;
		font-size: 16px;
		font-weight: lighter;
		border-top: 1px solid #e6e6e6;
		text-transform: capitalize;
		

	}
	#member-box a{
		text-decoration: none;
		color: #000;
	}
	#member-box span{
		float: left;
		padding-left: 5px;
	
	}
	
	#member-box img{
		float: left;
		height: 30px;
		width: 30px;
	}
	#titlebar{
		height: 30px;
		line-height: 30px;
		width: 200px;
		background-color: #7ac043;
		color: #fff;
		font-size: 20px;
		font-weight: bold;
		position: fixed;
		bottom: 10px;
		border: 1px solid #66a235;
		cursor: pointer;
	}
	#all_mem{
		display: none;
		padding: 5px;
		height: auto;
		width: auto;
		background-color: #fff;
		box-shadow: 0 0 5px #ccc;
		position: fixed;
		bottom: 35px;
		overflow-y:scroll; 
	}
	</style>
	<script type="text/javascript" src="../script/jq.js"></script>
	<script type="text/javascript">
			$(document).ready(function(){
			$('#titlebar').click(function(){
				$('#all_mem').stop().slideToggle();
			});
		});
	
	</script>
</head>

 

 <div id="all_mem">

	<?php 
	include('../function/connection.php');
	$query = "SELECT * FROM user_info ORDER BY RAND()";
	$run = mysqli_query($con,$query);
	while($mem = mysqli_fetch_array($run)):
	
?>

<div id="member-box">
	 <a href="<?php echo 'user.php?id='.$mem['user_id']; ?>">
	 <img src="<?php  echo getDp($mem['profile_pic'],$mem['user_id'],$mem['gender']); ?>"> 
	<span><?php echo $mem['f_name']; ?></span> </a>
	 <span style="float:right; color:#42b72a;padding-right:10px;"><strong><?php echo $mem['status']; ?></strong></span>
</div>	

<?php endwhile; ?>

</div>
<div id="titlebar">  Members </div>
