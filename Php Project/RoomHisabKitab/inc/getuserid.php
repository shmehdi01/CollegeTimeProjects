<?php
function getUserID($name){
	$db = getCon();
	$id = 0;
	$query = "SELECT uid FROM user WHERE name = '$name' ";
	$run = $db->query($query);
	while($data = $run->fetchObject()){
		$id = $data->uid;
	}
	return $id;
}
?>