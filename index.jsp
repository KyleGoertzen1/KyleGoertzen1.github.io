<!--<!DOCTYPE html>
<html>
	<title>Schedule</title>
	<style> 
		#nicer
		{
			border: 1px solid black;
			background-color: lightblue;
			width: 500px;
			height: 150px;
			position: relative;
			top: 20px;
			left: 900px;
		}
		
		#notes
		{
			border: 1px solid black;
			background-color: lightblue;
			width: 500px;
			height: 150px;
			position: relative;
			top: 20px;
			left: 900px;
		}
	</style>
	<body background="icon.jpg">
		
		
		<div id = "notes">
		<h1 style="color:black;">Database</h1>
		<button onclick="show()">Show Info For Database Administration</button>
		<button onclick="hide()">Hide</button>
		</div>
		<div id="nicer">
		<p style="color:black;"></p>
		</div>
		
		<div id = "notes">
		<h1 style="color:black;">Emerging Trends</h1>
		<button onclick="show2()">Show Info For Emerging Trends</button>
		<button onclick="hide2()">Hide</button>
		</div>
		<div id="nicer">
		<p style="color:black;"></p>
		</div>
		
		<div id = "notes">
		<h1 style="color:black;">Security</h1>
		<button onclick="show3()">Security For Software Developers</button>
		<button onclick="hide3()">Hide</button>
		</div>
		<div id="nicer">
		<p style="color:black;"></p>
		</div>
		
		<div id = "notes">
		<h1 style="color:black;">OS</h1>
		<button onclick="show4()">Operating Systems</button>
		<button onclick="hide4()">Hide</button>
		</div>
		<div id="nicer">
		<p style="color:black;"></p>
		</div>
		
		<div id = "notes">
		<h1 style="color:black;">Capstone</h1>
		<button onclick="show5()">Show Info For Capstone</button>
		<button onclick="hide5()">Hide</button>
		</div>
		<div id="nicer">
		<p style="color:black;"></p>
		</div>
	
			<script>
				function show()
				{
					document.querySelectorAll("p")[0].innerHTML = "Assignment 2, Lab 10. Look at the PFile modifier update command, resync the SPFile and back up to trace -> Module 3 and 4. Module 6 Slide 4.";
				}
				
				function hide()
				{
					document.querySelectorAll("p")[0].innerHTML = "";
				}
				
				function show2()
				{
					document.querySelectorAll("p")[1].innerHTML = "Blog post three.";
				}
				
				function hide2()
				{
					document.querySelectorAll("p")[1].innerHTML = "";
				}
				
				function show3()
				{
					document.querySelectorAll("p")[2].innerHTML = "March 13th midterm. 1440/1500. Find vulnerability for assignment two. CVE: https://www.cvedetails.com/cve/CVE-2018-6469/ -> Github: https://github.com/AntsKnows/CVE/blob/master/WP_Plugin_Flickr-rss.";
				}
				
				function hide3()
				{
					document.querySelectorAll("p")[2].innerHTML = "";
				}
				
				function show4()
				{
					document.querySelectorAll("p")[3].innerHTML = "March 16th midterm. Queue === FIFO (Higher priority preemptive 'P4' is moved to the start of the queue, the interrupted is put at the end of the queue).";
				}
				
				function hide4()
				{
					document.querySelectorAll("p")[3].innerHTML = "";
				}
				
				function show5()
				{
					document.querySelectorAll("p")[4].innerHTML = "Test UserBroker";
				}
				
				function hide5()
				{
					document.querySelectorAll("p")[4].innerHTML = "";
				}
			</script>
	</body>
</html>
-->

<!DOCTYPE html>
<html>
<head>
<style>
#example1 {
    padding: 1000px;
    background: url(pic.jpg);
    background-repeat: no-repeat;
	background-size: 2560px 1536px;
}
</style>
</head>
<body>
	<a href="news.html">Stock</a> | <a href="info.html">Reference</a>
	<div id="example1">
	</div>
</body>
</html>