

function sendAjaxGET() {
    let myForm = document.getElementById('myForm');
    let formData = new FormData(myForm);

    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('ajaxContent')
                    .innerHTML = xhr.responseText;
            // $("#myForm").hide();
        } else if (xhr.status !== 200) {
            alert('Request failed. Returned status of ' + xhr.status);
        }
    };
    var params = "";
    for (let [name, value] of formData) {
        params += name + "=" + value + "&";
    }
    params = params.substring(0, params.length - 1);
    xhr.open('GET', 'Echo?' + params);
    xhr.send();
}

function sendAjaxPOST() {
    let myForm = document.getElementById('myForm');
    let formData = new FormData(myForm);

    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('ajaxContent')
                    .innerHTML = xhr.responseText;
            // $("#myForm").hide();
        } else if (xhr.status !== 200) {
            alert('Request failed. Returned status of ' + xhr.status);
        }
    };
    var params = "";
    for (let [name, value] of formData) {
        params += name + "=" + value + "&";
    }
    params = params.substring(0, params.length - 1);
    xhr.open('POST', 'Echo');
    xhr.send(params);
}
