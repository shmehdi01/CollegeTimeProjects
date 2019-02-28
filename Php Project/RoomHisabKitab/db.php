<?php
function getCon(){
	$loc = "sqlite:C:/Users/rizwan/Documents/NetBeansProjects/AmmoutCalc/src/Database/amountcalc.sqlite";
	$con = new PDO($loc);
	// if($con){
	// 	echo "work";
	// }
	return $con;
}

?>





