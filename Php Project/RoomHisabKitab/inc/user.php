Select Name : <select name="user">
<?php
$query = "SELECT * FROM user";
$run = $db->query($query);
while($data = $run->fetchObject()){

	echo "

		 <option> $data->name </option> 

	";
}
?>
</select> <p>