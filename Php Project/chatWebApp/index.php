<!DOCTYPE html>
<?php include('db.php'); ?>
<html>
	<head>
		<title> Chat System </title>
		<link rel="stylesheet" type="text/css" href="style.css" media="all">
		<script>
			function ajax(){
				
				req = new  XMLHttpRequest();
				
				req.onreadystatechange = function(){
					
					if(req.readyState == 4 && req.status == 200 ) {
						
						document.getElementById('getChat').innerHTML = req.responseText;
					}
				}
				req.open('GET','chat.php', true);
				req.send();
			}
			setInterval(function(){ajax()},1000);
		</script>
	</head>
	
<body onload="ajax();">

<div id="main">

	<div id="head"> 
	 Chat - Box 
	</div>

	<div id="chatbox">
		<div id="getChat"></div>
	</div>

	
	<div id="formbox">
		<form action="index.php" method="post">
			<input type="text" name="name" placeholder="Enter Your Name" required />
			<br>
			<textarea rows="4" cols="50" name="msg" placeholder="Write your msg here..."></textarea>
			<input id = "ok" type="submit" name="submit" value="Send" />
		</form>	

<?php
	if(isset($_POST['submit']))
	{
		$name = $_POST['name'];
		$msg = $_POST['msg'];
		$insert = "INSERT INTO chat(name, msg) VALUE('$name', '$msg')";
		
		//$insert_data = mysqli_query($con,$insert);
		 $insert_data = $con->query($insert);
		if($insert_data)
		{
			echo "<embed loop='false' src='chat.wav' hidden='true' autoplay='true'>";
		}
			
		header("location: index.php");

	}
	

?>

	</div>
</div>




</body>
</html>