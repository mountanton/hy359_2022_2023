var cnt=0;
function deleteRowOfArray(cell){
	var d = cell.parentNode.parentNode.rowIndex;
	document.getElementById("tableNew").deleteRow(d);
}
function addRow() {
	if(document.getElementById("tableNew")===null){
		var divTable = document.getElementById("myTable").innerHTML="<table id='tableNew'></table>";
	}
	var table = document.getElementById("tableNew");
	var row = table.insertRow(table.rows.length);
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	if(cnt===0){
		cell1.outerHTML = "<th>"+document.getElementById("text1").value+"</th>";
		cell2.outerHTML = "<th>"+document.getElementById("text2").value+"</th>";
		cell3.outerHTML = "<th>"+'Delete'+"</th>";
		cnt++;
	}
	else{
		cell1.innerHTML = document.getElementById("text1").value;
		cell2.innerHTML = document.getElementById("text2").value;
		const pos=table.rows.length-1;
		cell3.innerHTML ="<button type='button' onclick='deleteRowOfArray(this)'>Delete this row</button>";
	}
}