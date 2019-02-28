<?php
function getLastTableName(){
$db = getCon();
$name = "";
$sql = "SELECT name FROM tableinfo WHERE tableid IN (SELECT MAX(tableid) FROM tableinfo)";	
$run = $db->query($sql);
	while($data = $run->fetchObject()){
		$name = $data->name;
	}
	return $name;
}


?>

<?php
function lastUpdate(){
	$db = getCon();
	$table = getLastTableName();
	$sql = "SELECT * FROM $table WHERE entid IN (SELECT MAX(entid) FROM $table)";
	$run = $db->query($sql);
	while($data = $run->fetchObject()){
		echo 
		"
			<div id='Last-update'> <i> Last updated </i> : by 
			<font color='#0000ff'> <b> $data->name </b> </font>
			of Rs.$data->amount for 
			<font color='#066bba'>  $data->purpose </font>
			updated on <font color='#ff0000'> $data->entrydate </font>

			</div>
		";
	}

}
?>

<?php
function getTotalAmt(){
	$db = getCon();
	$total = 0;
	$table = getLastTableName();
	$sql = "SELECT SUM(amount) as total FROM $table";
	$run = $db->query($sql);
	while($data = $run->fetchObject()){
		$total = $data->total;
	}
	return $total;
}

?>

<?php 
function totalMem(){
	$db = getCon();
	$total = 0;
	$table = getLastTableName();
	$sql = "SELECT COUNT(DISTINCT(uid)) as user FROM $table";
	$run = $db->query($sql);
	while($data = $run->fetchObject()){
		$total = $data->user;
	}
	return $total;
}

?>

<?php
function calPerHead(){
	$total = getTotalAmt();
	$user = totalMem();
	$per = $total/$user;
	return round($per,2);
}
?>


<?php
function calUserAmt(){
	$color =  array("#0000ff","#ff0000","#00ff00","#e7e7000","#f0gb00");
	$i=rand(0,2);
	$word = " will pay ";
	$db = getCon();
	$table = getLastTableName();
	$sql = "SELECT DISTINCT(name)  FROM $table ";
	$run = $db->query($sql);
	while($data = $run->fetchObject()){
		$name = $data->name;
		$total = getUserAmt($name);
		$rem = calPerHead() - $total;
		if($rem < 0){
			$word = " will get ";
			$rem = -1*$rem;
		}
		else{
			$word = " will pay ";
		}
		$i=rand(0,4);
		echo "<font color = '$color[$i]' >". $name.  " </font> spend  <b> ". $total. " rs. </b>".  " and ". $word .$rem.  " rs.". " <p>"; //₹
		$i=rand(0,3);
		
	}
}

?>



<?php
function getUserAmt($name){
	$db = getCon();
	$total = 0;
	$table = getLastTableName();
	$sql = "SELECT SUM(amount) as total FROM $table WHERE name='$name'";
	$run = $db->query($sql);
	while($data = $run->fetchObject()){
		$total = $data->total;
	}
	return $total;

}

?>