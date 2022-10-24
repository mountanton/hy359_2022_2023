
function tempMove(from,to){
	if(from!==0)
	     document.getElementById("x"+from).innerHTML="<img  src='imagesWithoutTsitsipas/"+from+".jpg'  height=160 width=150></div>"
	document.getElementById("x"+to).innerHTML="<img  src='imagesWithTsitsipas/"+to+"T.jpg'  height=160 width=150></div>";
}

function movePlayer(from,to){

	if(from==0){
		var myTimeout = setTimeout(tempMove,0,0,1);
		myTimeout = setTimeout(tempMove,500,1,2);
	}
	else if (from==14){		
		var myTimeout = setTimeout(tempMove,0,14,15);
	}
	else{
		var myTimeout = setTimeout(tempMove,0,from,from+1);		
		myTimeout = setTimeout(tempMove,500,from+1,to);
	}
}


function randomNumberOfSets(){
   let val= Math.floor(Math.random() * 3);
   return val;
  
}

function randomResult(winningPossibilities){
  let value = Math.floor(Math.random() * 100)+1;
  if(value<=winningPossibilities)
    return true;
  else
    return false;
}



function move(){
  game.currentRoundID+=1;
  audio.pause();
  if(game.started==false){
	var modeSelection=document.getElementById("mode").value;
	document.getElementById("modeSelection").innerHTML="<h2>Mode: "+modeSelection+" </h2>";
	game.started=true;
	setMode(modeSelection);
	document.getElementById('modeText').style.visibility = 'hidden';
  }
  
  if(game.currentRoundID<7){
     document.getElementById("currentStatus").innerHTML="<img src='https://media.istockphoto.com/photos/blue-tennis-court-and-illuminated-indoor-arena-with-fans-upper-front-picture-id1176735816?k=20&m=1176735816&s=612x612&w=0&h=HQAZzGz7mUjP5M5e77Ns8eaUu0JYQvo00GERcl8C3rs=' height=100 width=200/>";
     document.getElementById('move').style.visibility = 'hidden';
     document.getElementById("play").innerHTML="Play vs "+player[game.currentRoundID];
	 document.getElementById("matchResult").innerHTML="";
     document.getElementById('play').style.visibility = 'visible';
	 movePlayer(game.currentRoundID*2,(game.currentRoundID+1)*2)
	 if (game.bestRound<game.currentRoundID) {
		game.bestRound=game.currentRoundID;
		 document.getElementById("bestRound").innerHTML="<h2>Best Round: "+currentRound[game.bestRound]+"</h2>";
	 }
  }
  else{
    document.getElementById("currentStatus").innerHTML="<img src='winGifs/cup.gif'   height=100 width=200/>";
    document.getElementById('move').style.visibility = 'hidden'
    document.getElementById("play").innerHTML="Play";
	playSound("winner.mp3")
	 movePlayer(14,15)
    document.getElementById("results").innerHTML+="You Are the Champion!!";
     document.getElementById("matchResult").innerHTML="<h3> Epaixes me Poiotita!!!</h3>";
	 document.getElementById("bestRound").innerHTML="<h2>Best Round: W</h2>";
	 document.getElementById('playAgain').style.visibility = 'visible';
	  document.getElementById('playAgain').innerHTML = 'Play New Game';
  }
}

function playAgain(){
   if(game.currentRoundID===7)
	location.reload();
   document.getElementById("results").innerHTML="";
   document.getElementById("matchResult").innerHTML="";
   document.getElementById("move").innerHTML="Move To the Next Round"
   document.getElementById("currentStatus").innerHTML="<img src='https://media.istockphoto.com/photos/blue-tennis-court-and-illuminated-indoor-arena-with-fans-upper-front-picture-id1176735816?k=20&m=1176735816&s=612x612&w=0&h=HQAZzGz7mUjP5M5e77Ns8eaUu0JYQvo00GERcl8C3rs=' height=100 width=200/>";
   document.getElementById('move').style.visibility = 'visible';
    document.getElementById('bestRound').style.visibility = 'visible';
   document.getElementById('play').style.visibility = 'hidden';
   document.getElementById('playAgain').style.visibility = 'hidden';
   document.getElementById("play").innerHTML="Play";
   reDraw();
   audio.pause();
   game.currentRoundID=-1;
}

function updateHTML(pos,res){
  audio.pause();
  if(res===true){
    document.getElementById("matchResult").innerHTML="<h3>"+currentRound[game.currentRoundID]+". You Won: "+winResult[pos]+" vs "+ player[game.currentRoundID]+"</h3>";
	document.getElementById("results").innerHTML+=currentRound[game.currentRoundID]+". You Won: "+winResult[pos]+" vs "+ player[game.currentRoundID]+" <br>";
    document.getElementById('move').style.visibility = 'visible'
	
	document.getElementById('move').innerHTML="Move to the Next Round";
    document.getElementById("currentStatus").innerHTML="<img src='"+winGIFs[pos]+"' height=100 width=200/>";
    if(currentRound[game.currentRoundID]=="F"){
        document.getElementById("move").innerHTML="You are the Winner!!";
		playSound('stefWin.mp3');
		 document.getElementById("currentStatus").innerHTML="<img src='winGifs/winFinal.gif' height=100 width=200/>";
    }
	else{
	 document.getElementById("currentStatus").innerHTML="<img src='"+winGIFs[pos]+"' height=100 width=200/>";
	 playSound('winSmall.mp3');
		
	}
  }
  else{
   document.getElementById("matchResult").innerHTML="<h3> "+currentRound[game.currentRoundID]+". You Lost: "+lossResult[pos]+" vs "+ player[game.currentRoundID]+" </h3><br>";
    document.getElementById("results").innerHTML+=currentRound[game.currentRoundID]+". You Lost: "+lossResult[pos]+" vs "+ player[game.currentRoundID]+" <br>";
    document.getElementById('playAgain').style.visibility = 'visible'
	playSound('lost.mp3');
        document.getElementById("currentStatus").innerHTML="<img src='"+lossGIFs[pos]+"' height=100 width=200/>";

	
  }
}

function playSound(fileName){
audio = new Audio("sounds/"+fileName);
audio.play();
audio.addEventListener('ended', function() {
    this.currentTime = 0;
    this.play();
}, false);
}

function play(){
  document.getElementById('play').style.visibility = 'hidden'
  playSound("playing.mp3")
  document.getElementById("currentStatus").innerHTML="<img src='https://www.gizmodo.com.au/wp-content/uploads/sites/2/2015/07/01/1320504025725955175.gif?quality=80&resize=1280,720' height=100 width=200/>";
  var setsPlayed=randomNumberOfSets();
  var tsitsipasWinner=randomResult(game.roundPossibilities[game.currentRoundID]); //true or false
  var result=setTimeout(updateHTML, 2000+1000*setsPlayed, setsPlayed, tsitsipasWinner);
}