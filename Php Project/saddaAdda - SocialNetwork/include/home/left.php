
<?php
	// $dp = $_SESSION['profile_pic'];
	// $gen = $_SESSION['gen'];
	$query = "SELECT * FROM user_post WHERE user_id='$user_id'";
	$run_query = mysqli_query($con,$query);
	$count_post = mysqli_num_rows($run_query);

?>
<head><style type="text/css">
#change{
	position: absolute;
	top: 50px;
	height: 200px;
	width: 200px;
	/*background-color: silver;*/
	border-radius: 200px;
	opacity: 1;
	display: none;
}
#change span{
	color: #fff;
	background-color: #666;
	opacity: 0.8;
	position: relative;
	top: 10px;
	border-radius: 5px;
	cursor: pointer;
	padding: 5px;
}

</style>
<script type="text/javascript" src="../script/jq.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
 	$('#pro-pic').mouseenter(function(){
 		$('#change').fadeIn('fast');
 		$('#showPop').text('change');
 	});
 	$('#pro-pic').mouseleave(function(){
 		$('#change').fadeOut('fast');
 		$('#showPop').text('change');
 	});

 	$('#showPop').click(function(){
 		$('.popUp').slideToggle();
 		$('#showPop').text('cancle');
 	});

 });
</script>
</head>


<div class="left-side"> 
	<div id="pro-pic"> 
		<img src="<?php echo getDp($dp,$user_id,$gen); ?>">
		<div id="change"> <span id="showPop"> </div>
	</div>
	<div id="name" style="text-transform: capitalize;"> <?php echo  $_SESSION['name']; ?> </div>
		<div id="side-nav">
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="#">Message(0)</a></li>
				<li><a href="#">Notification(0)</a></li>
				<li><a href="#">All Post(<?php echo $count_post; ?>)</a></li>
				<li><a href="<?php echo 'timeline.php?id='.$user_id; ?>">Timeline</a></li>
				<li><a href="logout.php">Logout</a></li>
			</ul>
		 </div>
	</div>


