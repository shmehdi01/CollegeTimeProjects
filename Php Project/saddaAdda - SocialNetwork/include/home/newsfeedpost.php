<?php
function dateFormat($date){
	return date('d.m.Y',strtotime($date));
}
function timeFormat($time){
	return date('g:i:s a',strtotime($time));
}
?>



<?php
	
	$query = "SELECT * FROM user_post ORDER BY post_id DESC";
	$run_query = mysqli_query($con,$query);
	while($all_post = mysqli_fetch_array($run_query)):
		// $post = $all_post['post'];
		// $user_id = $all_post['user_id'];
		// $name = $all_post['profile_name'];
		// $date = $all_post['date'];


?>

<div id="news_feed_post">
	<div id="post_name">
		<span id="post_name_style"> 
			<a href="<?php echo 'user.php?id='.$user_id = $all_post['user_id']; ?>"> <?php echo $name = $all_post['profile_name']; ?> </a>
		</span>
		<br>
		<span style ="color:gray;">
			<small> 
				<?php 
					 $date = $all_post['date']; 
					 echo timeFormat($date)." | ". dateFormat($date);
				?> 
		</small> 
		</span> 
	</div>
	<div id="post_value">
		<span style="color:#000;font-weight:normal;font-size:15px;">
			<?php echo $post = $all_post['post']; ?>
		 </span>
	</div>
	<div id="comment"> Like . Comment</div>
</div>

<?php
endwhile;
?>
