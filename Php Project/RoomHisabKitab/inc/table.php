Select Table : 
<select  name="table" id="tab"> 
<?php
$query = "SELECT * FROM tableinfo";
$run = $db->query($query);
while($data = $run->fetchObject()){

	echo "

		 <option selected> $data->name </option> 

	";
}
?>
</select> 