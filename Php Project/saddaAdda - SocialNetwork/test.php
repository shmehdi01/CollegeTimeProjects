<?php
if(isset($_POST['up']))
{
 $tmp = $_FILES['file'];
 print_r($tmp);
$path = "user/default.jpg";
//move_uploaded_file[$tmp,$path];
}

?>

<form method="post" enctype="multipart/form-data">
<input type="file" name="file"/>
<button name="up"> upload </button>
</form>