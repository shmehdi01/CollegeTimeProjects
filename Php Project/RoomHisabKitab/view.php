<?php
require_once('db.php');
include('/inc/getuserid.php');
$db = getCon();
?>

<style type="text/css">
#table-area{
	overflow-y:scroll;
	height: 650px;
	width: auto;
	float: right;
}
#option-table-area{
	float: left;
}
#month-table{
	border: 1px solid black;
	height: auto;
	width: auto;
	font-family: arial;
}
#month-table tr{

}
</style>

<?php
function viewRecords($table){
	$db = getCon();
	$sql = "SELECT * FROM $table";
	$run = $db->query($sql);
	echo "<table id='month-table'>";
	echo "<th> Name </th> <th> Purpose </th> <th> Amount </th> <th> Date </th>";
	while($data = $run->fetchObject()){
		echo "<tr>";
		echo  "<td>" . $data->name. "</td> <td>". $data->purpose . " </td> <td>". $data->amount. " </td> <td> ".$data->date . "</td>";
		echo "</tr>";
		
	}
	echo "</table>";
}
?>

<div id="option-table-area"> 
		<form method="post" action="">
		<!--FETCH TABLE LIST FROM DB-->
		<?php include('/inc/table.php'); ?>
		<button name="show"> Show Table</button>
	</form>
</div>


<?php
function showTable(){
if(isset($_POST['show'])) {
	$table = $_POST['table'];
	echo "<center> <b> $table  </b> </center>";
	viewRecords($table);
}
}
?>


<div id="table-area">
	<?php showTable(); ?>
 </div>

