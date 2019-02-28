<html>
<head>
	<title></title>
	<style type="text/css">
	.register{
	opacity: 1;
	background-color: #7ac043;
	height: auto;
	width: 600px;
	position: absolute;
	top:20px;
	right:80px;
	color: #fff;
	padding:10px;
	font-family: Calibri;
	font-size: 20px;
	display: none;
	box-shadow: 2px 2px 5px #ccc;
	
	}

	.register span{
		opacity: 1;
		text-align: right;
	}
	

	.register form input{
	height: 40px;
	width: 300px;
	padding: 4px;
	padding-left: 20px;
	font-weight: bold;
	font-size: 16px;
	border: 0px;
	}

	.register form input[type=radio]{
		width: 40px;
		height: 40px;
		float: left;
	}


	.register button{
		opacity: 1;
	height: 30px;
	width: 100px;
	font-size: 16px;
	background-color:#ef3125;
	border: 0px;
	float: right;
	
	color: #fff;
	font-weight: bold;
	}

	.register button:hover{
	background-color:  #efb112;
	color: #ef3125;
	transition:all 0.5s ease;

	}
	.register #head{
		/*background-color: red;*/
		height: 40px;
		width: auto;
		line-height: 40px;
		padding: 20px;
		font-size: 50px;
		text-align: center;
		border-bottom: 1px solid #8ec95f;
	}

	.register table {
		margin: auto;
		margin-top: 30px;

	}

	.register table tr td {
		font-size: 20px;
		text-align: right;
		width: auto;
		height: auto;
	}



	</style>
</head>
<body>
	<div class="register">
		<div id="head"> Register Today </div>
		<form id="forum" method="post">
			<table>
				<tr>
					<td><span>First Name :</span> </td> <td> <input type="text" name="f_name" required/></td>
				</tr>
				<tr>
					<td><span>Last Name :</span> </td> <td> <input type="text" name="l_name" required/> </td>
				</tr>
				<tr>
					<td><span>Email :</td> <td></span> <input type="email" name="u_email" required/> </td>
				</tr>
				<tr>
					<td><span>password :</span> </td> <td><input type="password" name="u_pass" required/> </td>
				</tr>
				<tr>
					<td><span>Birthday :</span></td> <td><input type="date" name="u_birth" required/> </td>
				</tr>
				<tr> 
					<td> </td>
					<td style="text-align:left; float:left; height:40px; line-height:40px;"> Male: </td><td  style="text-align:left; float:left;"> <input type="radio" name="gen" value="male"required> </td> 
					<td style="text-align:left; float:left; height:40px; line-height:40px;"> Female : </td> <td style="text-align:left; float:left;"><input type="radio" name="gen" value="female" required> </td>
				</tr>

				<tr>
					<td colspan="2="><button name="get-reg"> Sign Up</button> </td>
				</tr>
		</table>
		</form>
		
		

 	</div>
</body>
</html>