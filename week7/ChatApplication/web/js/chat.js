function sendChatAJAX() {
    let myForm = document.getElementById('myForm');
    let formData = new FormData(myForm);

    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            
                document.getElementById('ajaxContent').innerHTML += xhr.responseText;
        } else if (xhr.status !== 200) {
            alert('Request failed. Returned status of ' + xhr.status);
        }
    };
    var params = "";
    for (let [name, value] of formData) {
        params += name + "=" + value + "&";
    }
    //xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    params = params.substring(0, params.length - 1);
    //alert(params);
    xhr.open('POST', 'Chat');
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(params);
}


function getChatAJAX() {
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
           // alert(xhr.responseText);
            
            if(xhr.responseText!=="")
                document.getElementById('ajaxContent').innerHTML += xhr.responseText;
            setTimeout(getChatAJAX,1000);
        } else if (xhr.status !== 200) {
            alert('Request failed. Returned status of ' + xhr.status);
        }
    };
    var messages = document.getElementsByTagName("p").length;
    xhr.open('GET', 'Chat?lastID='+messages); 
     xhr.send();
}


setTimeout(getChatAJAX,1000);