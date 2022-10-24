var winResult=["3-0","3-1","3-2"]
var winGIFs=["winGifs/win1.gif","winGifs/win2.gif","winGifs/win3.gif"]
var lossResult=["0-3","1-3","2-3"]
var lossGIFs=["lossGifs/loss1.gif","lossGifs/loss2.gif","lossGifs/loss3.gif"]
var currentRound=["R128","R64","R32","R16","QF","SF","F"];
var player=["Kokkinakis","Monfils","Wawrinka","Kyrgios","Federer","Nadal","Djokovic"];
var easyMode=[98,95,95,90,90,80,80]; //46%
//var easyMode=[100,100,100,100,100,100,100]; //cheat mode
var mediumMode=[95,90,85,80,70,60,55]; //13%
var hardMode=[95,85,75,65,55,45,35]; //3.4%
var veryHardMode=[80,70,60,50,40,30,20]; //0.4%
var audio=new Audio();


const game = {
  attempts: 0,
  roundPossibilities: null,
  started: false,
  bestRound: -1,
  currentRoundID:-1
};


function initBoard(){
   init();
   document.getElementById('play').style.visibility = 'hidden'
   document.getElementById('playAgain').style.visibility = 'hidden'
    game.attempts++;
    document.getElementById("attempts").innerHTML="<h2>Total Attempts:"+game.attempts+"</h2>";
}

function init(){
	var table = document.getElementById('table');
	var tr = document.createElement('tr');
  
		for (var i = 2; i>=0; i--) {
		  var tr = document.createElement('tr');
		  for (var j = 1; j <=5; j++) {
		  var td1 = document.createElement('td');
		  var num=i*5+j;
		  td1.innerHTML="<div id='x"+num+"'><img  src='imagesWithoutTsitsipas/"+num+".jpg'  height=160 width=150></div>";
		  tr.appendChild(td1);
		  }
		  table.appendChild(tr);
		}	
		
	
}

function reDraw(){
	for(i=1;i<=15;i++){
		 document.getElementById("x"+i).innerHTML="<img  src='imagesWithoutTsitsipas//"+i+".jpg'  height=160 width=150></div>";
	}
	game.attempts++;
	document.getElementById("attempts").innerHTML="<h2>Total Attempts:"+game.attempts+"</h2>";
}

function setMode(modeSelection){
	if(modeSelection==="Easy")
	 game.roundPossibilities=easyMode;
	else if(modeSelection==="Medium")
	 game.roundPossibilities=mediumMode;
	else if(modeSelection==="Hard")
	 game.roundPossibilities=hardMode;
	else if(modeSelection==="Very Hard")
	 game.roundPossibilities=veryHardMode;
}