
function getJson(meta) { 	// meta beinhaltet json mit allen kommunikations-metadaten
	return meta.json();	    // meta.json ist der reine json-inhalt
}

function getTxtFromJsonAndPackInHTML(myjson) {

	var tablePersonsBody = document.getElementById("id_tbl001_tb");
	var i = 0;
    tablePersonsBody.innerHTML=""; // delete old data to re-download the whole table body
	for (var indexVariable of myjson.persons) {
		tablePersonsBody.insertAdjacentHTML("beforeend",
			"<tr>"
			+ `<td> ${++i} </td>`
			+ "<td>" + indexVariable.id + "</td>"
			+ "<td><img src='" + getImg(indexVariable.salutation) + "'></td>"
			+ "<td>" + indexVariable.salutation + "</td>"
			+ "<td>" + indexVariable.firstname + "</td>"
			+ "<td>" + indexVariable.lastname + "</td>"
			+ "<td>" + indexVariable.dob + "</td>"
			+ "<td>" + indexVariable.version + "</td>"
			+ "</tr>")
	}
}

function getImg(salutation) {
	switch (salutation) {
		case "Mr":
		case "Mr.":
			return 'images/man.png';
		case "Mrs.":
		case "Mrs":
		case "Miss":
			return 'images/woman.png';
		default:
			return 'images/questionMark.png';
	}
}

function refreshTable() {
	fetch("/json/persons/all")
	.then(getJson)
	.then(getTxtFromJsonAndPackInHTML)
	}

function onRefreshClick(event) {
	event.preventDefault();      // verhindert dass das event von Browser verwendet wird (verhindert GET-Request)
	console.log("click");


    refreshTable();
}

function onInputClick(event) {
	event.preventDefault();      // verhindert dass das event von Browser verwendet wird (verhindert GET-Request)
	console.log("click");
	var salutation = document.getElementById("id001").value;
	console.log(salutation);
	var name = document.getElementById("id002").value;
	console.log(name);
	var surname = document.getElementById("id003").value;
	console.log(surname);
	var dob = document.getElementById("idDOB").value;
	console.log(dob);

	var jsonDataString = `{"firstname": "${name}", "lastname": "${surname}", "salutation": "${salutation}", "dob": "${dob}"}`;
		console.log(jsonDataString);

	fetch("http://localhost:8080/json/person", {
		method: 'POST',  // or PUT
		body: jsonDataString,
		headers: {
			'Content-Type': 'application/json'
        }
	})
	.then(refreshTable);
}

function onUpdateClick(event) {
	event.preventDefault();      // verhindert dass das event von Browser verwendet wird (verhindert GET-Request)
	console.log("click");
	var salutation = document.getElementById("id001").value;
	console.log(salutation);
	var name = document.getElementById("id002").value;
	console.log(name);
	var surname = document.getElementById("id003").value;
	console.log(name);
	var id = document.getElementById("id004").value;
	console.log(id);
	var dob = document.getElementById("idDOB").value;
	console.log(dob);
	var version = document.getElementById("idVer").value;
	console.log(version);

	var jsonDataString = `{"id": "${id}","firstname": "${name}", "lastname": "${surname}", "salutation": "${salutation}", "dob": "${dob}", "version": "${version}"}`;
		console.log(jsonDataString);

	fetch(`http://localhost:8080/json/person`, {
		method: 'PUT',
		body: jsonDataString,
		headers: {
			'Content-Type': 'application/json'
        }
	})
	.then(refreshTable);
}


function onClearClick(event) {
	event.preventDefault();      // verhindert dass das event von Browser verwendet wird (verhindert GET-Request)
	console.log("click");

	fetch("http://localhost:8080/json/persons/deleteall", {
        method: 'DELETE'
        }
	)
	.then(refreshTable);

}


function onDeleteClick(event) {
	event.preventDefault();      // verhindert dass das event von Browser verwendet wird (verhindert GET-Request)
	console.log("click");

	var id = document.getElementById("id005").value;
	console.log(id);

	var jsonDataString = `{"id": "${id}"}`;
		console.log(jsonDataString);

	var url = `http://localhost:8080/json/person/${id}`
	console.log(url);

	fetch(url, {
		method: 'DELETE'
	}
	)
	.then(refreshTable);
}

refreshTable();

//Add listeners:
var refreshTableButton = document.getElementById("refreshTableButton");
refreshTableButton.addEventListener("click",onRefreshClick);

var addPersonButton = document.getElementById("addPersonButton");
addPersonButton.addEventListener("click",onInputClick);

var updPersonButton = document.getElementById("updatePersonButton");
updPersonButton.addEventListener("click",onUpdateClick);

var deletePersonButton = document.getElementById("deletePersonButton");
deletePersonButton.addEventListener("click",onDeleteClick);

var clearTableButton = document.getElementById("clearTableButton");
clearTableButton.addEventListener("click",onClearClick);
