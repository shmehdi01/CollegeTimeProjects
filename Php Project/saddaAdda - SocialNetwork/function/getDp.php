<?php
function getDp($dp,$id,$gen){
		if($dp=='default.gif' || $dp==""){
		return $img_path = "../default/default.gif" ;
	}	
		else return $img_path = "../users/".$gen."/".$id."/profile/".$dp;
	}

	?>