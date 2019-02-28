<div style="padding:10px"><center>
					<center> <span id='notify' style='color:green; font-size:30;'> Data Saved Successfully!!  </span> </center>
				

				<script language="javascript">
				var max_time = 5;
				var cinterval;
 
				function countdown_timer(){
  				// decrease timer
  				max_time--;
  				document.getElementById('countdown').innerHTML = max_time;
  				if(max_time == 0){
    			clearInterval(cinterval);
  					}
				}
				// 1,000 means 1 second.
				cinterval = setInterval('countdown_timer()', 1000);
				</script>
				<p>Wait !! auto redirect in <span id="countdown">5</span> seconds.
				 <meta http-equiv="Refresh" content="5; url=index.php">
				</center>
			</div>