<?php
require_once('db.php');
include('/inc/lastupdate.php');
include('/inc/getuserid.php');
$db = getCon();
?>

<!DOCTYPE html>
<html>
<head>
	<title> Update Entry</title>
	<style type="text/css">
	body{
		padding: 0px;
		margin: 0px;
	}
	#main-area{
		height: auto;
		width: 600px;
		margin: auto;
		text-align: center;
		font-family: arial;
		border: 2px solid #42bcbf;
		border-radius: 5px;
		padding: 20px;
	}
	#main-area input{
		height: 30px;
		width: 300px;
		text-align: center;
		font-size: 20px;
	}

	#main-area select{
		height: 30px;
		width: 200px;
		font-size: 20px;
	}
	#main-area button{
		height: 30px;
		width: 200px;
		font-size: 18px;
		background-color: wheat;
		border: 0px;
		border-radius: 5px;
		cursor: pointer;
	}

	#Last-update{
		height: auto;
		width: 600px;
		margin: auto;
		padding: 5px;
		background-color: #fff;
		font-family: arial;
		text-align: center;
		font-size: 18;
	}
	#header{
		height: 30px;
		width: auto;
		margin: auto;
		text-align: center;
		font-size: 18px;
		font-family: arial;

	}
	#app-name{
		height: 80px;
		width: 700px;	
		font-family: arial;
		font-size: 25px;
		line-height: 80px;
		margin: auto;
		position: relative;
		top: 27px;
	
	}
	#app-name img {
		height: 80px;
		float: left;
	}
	#logo{
		height: 100px;
	}
	#usersExp{
		width: 620px;
		height: auto;
		padding: 10px;
		background-color: #fff;
		margin: auto;
		margin-top:5px;
		font-family: arial;
		border: 2px solid #42bcbf;
	}

	</style>
</head>

<body>

	<div id="header"> 
		<img id="logo" src="img/logo.png">  
	 </div>
	</center>
	<div id="app-name"> 
		<img src="img/acnt.png"> 
		<label style="color:#42bcbf; margin-left:5px; float:left;"> Accountancy </label>
		<label style="color:#06abb; margin-right:30px; font-size:14px; float:right;"><?php echo "Today is " . date('d/M/Y') ?></label>
	</div>

 <div id="main-area">

	<form method="post" action="">
		<!--FETCH TABLE LIST FROM DB-->
		<?php include('/inc/table.php'); ?>
		<p>
		<!--FETCH USER LIST FROM DB-->
		<?php include('/inc/user.php'); ?>
	
		<input type="number" name="amount" min="1" placeholder="Enter amount" required/> <p>
		<input type="text" name="purpose" placeholder="Write Purpose" required/> <p>
		<input type="date" date-date="" date-date-format="DD MMMM YYYY" name="date" required   />  <p>
		<button name="submit">Save Data</button>
	</form>
</div>
 <!--lastupdate-->
			<?php lastUpdate(); ?>
		 <div id="usersExp"> 
		 	<center> <label style="font-size:25px; color:green;"> <?php echo  getLastTableName(); ?>  </label> </center> <p>
		 	<center><?php  calUserAmt(); ?> </center>
		 	<hr color="#42bcbf">
		 	<label style="font-size:13px; color:gray;float:left"> Total Amount :  <?php echo  getTotalAmt(); ?> Rs.  </label> 
		 	<label style="font-size:13px; color:gray; float:right;"> Per Head Amount :  <?php echo  calPerHead(); ?> Rs.  </label> <p>
		 </div>

		

</body>


<?php
if(isset($_POST['submit'])){

	//GETTING DATA FROM FORUM
	$table = $_POST['table'];
	$name = $_POST['user'];
	$amount = $_POST['amount'];
	$purpose = $_POST['purpose'];
	$date = $_POST['date'];
	$uid = getUserID($name);

	//FORMATIN DATE
	$date = strtotime($date);
	$date = date('d/M/Y', $date); // 08/Apr/2017

	$sql = "INSERT INTO $table(uid,amount,purpose,date,name) VALUES('$uid','$amount','$purpose','$date','$name')";

	//INSERTING DATA INTO DATABASE
	$run = $db->query($sql);
	if($run){
		echo "<script> alert('Data Saved'); </script>";
		header("location:info.php");
	}
	
}
?>


</html>