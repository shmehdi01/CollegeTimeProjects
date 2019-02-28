<?php include('db.php'); ?>
<?php

function formatTime($time){
		
		return date('g	:i a' ,  strtotime($time));
	}

		$query = "SELECT * FROM chat ORDER BY id DESC";
		//$run = mysqli_query($con,$query);
		$run = $con->query($query);
		while($row = mysqli_fetch_array($run)) 
		{
			echo "<div id='chat'>";
			echo "<span id='name'>" . $row['name'] . " : </span>";
			echo "<span id='msg'>" . $row['msg'] . "</span>";
			echo "<span id='time'>" . formatTime($row['time']) . "</span>";
			echo "</div>";
		}
		?>