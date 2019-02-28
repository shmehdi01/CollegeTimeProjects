<div id="head-bar">
	 <span style="font-family:Broadway; padding-left:100px;">Sadda Adda</span>
	 <input id="search-box" type="text" placeholder="Search.." name="search"> <button id="btn"name="get-search"> Search</button>
	 <div id="head-nav"> 
	 	<span><a href="home.php"> Home </a> </span>
	 	<span style="text-transform: capitalize"><a href="<?php echo 'timeline.php?id='.$user_id; ?>"> <?php echo  $_SESSION['firstName']; ?></a> </span>
	 	<span><a href="../pages/logout.php"> Logout </a> </span>  
	 </div>
</div>