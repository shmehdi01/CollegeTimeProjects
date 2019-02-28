<head>
	<style type="text/css">
	body{
		
	}

		.popUp{
			position: absolute;
			top: 218px;
			left: 40px;
			background-color: #fff;
			height: 80px;
			width: 200px;
			border-radius: 10px 10px  200px 200px;
			box-shadow: 0 0 10px #7ac043;
			padding: 10px;
			line-height: 20px;
			display: none;
		}
		.popUp #inp{
			/*visibility: hidden;*/
		
		}
		.popUp button{
			height: 40px;
			width: 80px;
			background-color: #7ac043;
			color: #fff;
			border:0;
			cursor: pointer;
			box-shadow: 0 0 2px #ccc;
		}
		
	</style>
</head>


<div class="popUp">
	<div>
		<form method="post" enctype="multipart/form-data">
		<input  type = "file"  id ="inp" name="dp" accept="image/*" required />
		<p>
		<center><button name="upload" >Upload</button></center>

	</form>
	</div>
 </div>



<?php include('../function/changeDp.php'); ?>