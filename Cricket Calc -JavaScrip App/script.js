var sixs = 0;
var fours = 0;
var singles = 0;
var doubles = 0;
var triples = 0;
var wides = 0;
var noBall = 0;
var ball = 0;
var wkt = 0;
var dot = 0;
var extras = 0;
function catchs()
{
 wkt++;
 ball++;
 document.getElementById("ball").value = ball;
 document.getElementById("wkt").value = wkt;
  };
function noball()
{
 noBall+=1;
 document.getElementById("noball").value = noBall;
 };
function wide()
{
 wides+=1;
 document.getElementById("wide").value = wides;
 };
function six()
{
 sixs+=1;
 ball++;
 document.getElementById("ball").value = ball;
 document.getElementById("six").value = sixs;
  };
function four()
{
 fours+=1;
 ball++;
 document.getElementById("ball").value = ball;
 document.getElementById("four").value = fours;
 };
function double()
{
 doubles+=1;
 ball++;
 document.getElementById("ball").value = ball;
 document.getElementById("two").value = doubles;
 };
function single()
{
 singles+=1;
 ball++;
 document.getElementById("ball").value = ball;
 document.getElementById("one").value = singles;
 };
function dotb()
{
 ball++;
 document.getElementById("ball").value = ball;
 dot+=1;
 document.getElementById("dot").value = dot;
 };
function triple()
{
 triples++;
 ball++;
 document.getElementById("ball").value = ball;
 document.getElementById("triple").value = triples;
 };

function total()
{
var s = document.getElementById("six").value;
var f = document.getElementById("four").value;
var t = document.getElementById("two").value;
var o = document.getElementById("one").value;
var trip = document.getElementById("triple").value;
var wd = document.getElementById("wide").value;
var nb = document.getElementById("noball").value;
var bowl = document.getElementById("ball").value;
var selectover = document.getElementById("sover").value;
var extrn1 = document.getElementById("extbx1").value;
var extrn2 = document.getElementById("extbx2").value;
var extrn3 = document.getElementById("extbx3").value;
var extrn4 = document.getElementById("extbx4").value;
var extrn5 = document.getElementById("extbx5").value;
var extrn6 = document.getElementById("extbx6").value;
var total = parseInt(o)*1 +  parseInt(t)*2 + parseInt(trip)*3 + parseInt(f)*4 + parseInt(s)*6 + parseInt(wd)*1 + parseInt(nb)*1 + parseInt(extrn1) + parseInt(extrn2) + parseInt(extrn3) + parseInt(extrn4) + parseInt(exxtr1) +  parseInt(exxtr2) ;
var ovr = bowl/6;
var rb = bowl - parseInt(ovr)*6 ;
var povr = parseInt(ovr)+parseInt(rb)*0.1;
var rr = total/povr;
document.getElementById("total").value = total;
document.getElementById("rr").value = rr;
document.getElementById("ovr").value = povr.toFixed(1);
if(povr==selectover)
{
document.getElementById("inning").innerHTML = ("Inning completed,, Please take screenshot for save data");
}
};

function i2()
{
var target = document.getElementById("target").value;
var score = document.getElementById("total").value;
var getovr = document.getElementById("sover").value;
var runover = document.getElementById("ovr").value; 
var getball = document.getElementById("ball").value;
var restbowl = getovr*6 - parseInt(getball);
var restovr = parseFloat(getovr) - parseFloat(runover);
var need = parseInt(target) - parseInt(score);
var rrr = need/restovr;
document.getElementById("p1").innerHTML = need;
document.getElementById("p2").innerHTML = restovr.toFixed(1);
document.getElementById("p3").innerHTML = restbowl;
document.getElementById("p4").innerHTML = (rrr).toFixed(3);

if(need<=0)
{
 document.getElementById("p5").innerHTML = "won the match";
 }
else if(need < target && restovr ==0)
 {
  document.getElementById("p5").innerHTML = "loss the match";
  }
};

var ex1=0,ex2=0,ex3=0,ex4=0,exxtr1=0,exxtr2=0;
function extra()
{
extras++;
document.getElementById("excount").value = extras;
};
function ext1()
{
	ex1+=1;
	document.getElementById("extbx1").value = ex1;
};
function ext2()
{
	ex2+=2;
	document.getElementById("extbx2").value = ex2;
};
function ext3()
{
	ex3+=3;
	document.getElementById("extbx3").value = ex3;
};
function ext4()
{
	ex4+=4;
	document.getElementById("extbx4").value = ex4;
};
function extr1()
{
	exxtr1+=4;
	document.getElementById("extbx5").value = exxtr1;
};
function extr2()
{
	exxtr2+=6;
	document.getElementById("extbx6").value = exxtr2;
};
var lb = 0;
function legby()
{
	lb++;
	ball++;
	document.getElementById("ball").value = ball;
	document.getElementById("lb").value = lb;
};
fh = 0;
function freehit()
{
	fh++;
	document.getElementById("fh").value = fh;
};