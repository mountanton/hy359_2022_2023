function hideShow(){
	if(document.getElementById("pwd").type==="text"){
      document.getElementById("pwd").type="password";
        document.getElementById("myB").value="Show Password";
    }
    else{
      document.getElementById("pwd").type="text";
        document.getElementById("myB").value="Hide Password";
    }
	
}

function submit(){
	var basket=document.getElementById("nba").checked;
	var tenis=document.getElementById("tenis").checked;
	if(basket===true && tenis===false) {
		document.getElementById("image").innerHTML="<img width=300 src='img/ante.jpg' alt='Antetokounmpo'/>";
		document.getElementById("output").style.backgroundColor="orange";		
	}
	else if(basket===true && tenis===true) {
		document.getElementById("image").innerHTML="<img width=300 src='img/antetsip.jpg' alt='Antetokounmpo Tsitsip'/>";	
		document.getElementById("output").style.backgroundColor="cyan";
	}
	else if(basket===false && tenis===true) {
		document.getElementById("image").innerHTML="<img width=300  src='img/tsitsipas.jpg' alt='Tsitsip'/>";	
		document.getElementById("output").style.backgroundColor="yellow";
	}
	else{
		document.getElementById("output").style.backgroundColor="red";
		document.getElementById("image").innerHTML="<img width=300  src='img/poiotita.gif' alt='Tsitsipas'/>";	
	//	document.getElementById("image").innerHTML="De paizeis me poiotitaaaaa";
		
	}

}

function welcome(){
	var name=document.getElementById("fname").value;
	document.getElementById("message").innerHTML="Welcome "+name;
	if(name==="stefanos"){
		document.getElementById("lname").value="tsitsipas";
		document.getElementById("tenis").checked=true;
	}
}


function surname(){
	var surname=document.getElementById("lname").value;
	var msg="Ti kaneis?";
if(surname.endsWith("akis")){
	msg="Inta Kaneis? Tinos eisai esy?";
}
	document.getElementById("message").innerHTML+="<br>"+msg;
}


const form  = document.getElementById('signup');

form.addEventListener('submit', (event) => {
   submit();
	event.preventDefault();
});