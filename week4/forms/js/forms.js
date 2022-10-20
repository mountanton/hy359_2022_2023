
function plainJS() {
    var elements = document.getElementById("myForm").elements;
    var obj ={};
    for(var i = 0 ; i < elements.length ; i++){
        var item = elements.item(i);
      console.log(item.type);
        if(item.type==="checkbox")
        obj[item.name] = item.checked;
        else if(item.type==="radio" && item.checked===true)
          obj[item.name] = item.value;
        else if(item.type==="text"){
          obj[item.name] = item.value;
        }
    }
    document.getElementById("message").innerHTML ="<h3>Plain JS with elements</h3>"+ JSON.stringify(obj);
    return false;
}

function plainJS2() {
  document.getElementById("message").innerHTML ="<h3>Plain JS with array</h3>";
  var sport= document.forms["myForm"]["sport"].value;
  var name=document.forms["myForm"]["name"].value;
  var team=document.forms["myForm"]["options"].value;
  var check=document.forms["myForm"]["check"].checked;
  document.getElementById("message").innerHTML +="sport:"+sport+"<br>";
  document.getElementById("message").innerHTML +="name:"+name+"<br>";
  document.getElementById("message").innerHTML +="team:"+team+"<br>";
  document.getElementById("message").innerHTML +="check:"+check+"<br>";
}

function plainJS3() {
  document.getElementById("message").innerHTML ="<h3>Plain JS with ids</h3>";
  var sport;
   if(document.getElementById("tennis").checked===true){
	  sport= document.getElementById("tennis").value;
  }
  else if(document.getElementById("nba").checked===true){
	  sport= document.getElementById("nba").value;
  }
  var name=document.getElementById("myName").value;
  var team=document.getElementById("options").value;
  var check=document.getElementById("check").checked;
  document.getElementById("message").innerHTML +="sport:"+sport+"<br>";
  document.getElementById("message").innerHTML +="name:"+name+"<br>";
  document.getElementById("message").innerHTML +="team:"+team+"<br>";
  document.getElementById("message").innerHTML +="check:"+check+"<br>";
}



function jQueryAsParameters(){
  var data=$('#myForm').serialize();
  $("#message").html("<h3>JQuery As Parameters</h3>");
   $("#message").append(data);
}


function jQueryAsArray(){
  var data=$('#myForm').serializeArray();
    $( "#message" ).html("<h3>jQuery As Array to JSON</h3>");
   $( "#message" ).append(JSON.stringify(data));
}

function withFormData(){
  let myForm = document.getElementById('myForm');
   $( "#message" ).html("<h3>With form data</h3>");
  let formData = new FormData(myForm);
  //formData.country="ellada";
  formData.append("country","ellada");
  for(let [name, value] of formData) {
   $( "#message" ).append(name+" "+ value+"<br>"); // key1 = value1, then key2 = value2
  }
}

function withFormDataToJSON(){
  let myForm = document.getElementById('myForm');
  const formData = new FormData(myForm)
  const data = {};
  $( "#message" ).html("<h3>With form data to JSON</h3>");
  formData.forEach((value, key) => (data[key] = value));
  $( "#message" ).append(JSON.stringify(data));
}

function withFormDataToJSON_and_Extra_Fields_and_Remove(){
  let myForm = document.getElementById('myForm');
  const formData = new FormData(myForm)
  formData.append("country","ellada");
  formData.append("hobby","twitter");
  formData.delete("sport")
  const data = {};
  $( "#message" ).html("<h3>With form data to JSON and extra fields and remove</h3>");
  formData.forEach((value, key) => (data[key] = value));
  $( "#message" ).append(JSON.stringify(data));
}