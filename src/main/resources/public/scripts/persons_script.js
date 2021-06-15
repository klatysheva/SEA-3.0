//var para = document.getElementById("id_link001");
//para.textContent = "Erleben, was verbindet!";

//  fetch("http://localhost:8080/personen.json");
//  var cell = document.getElementById("IdSabine");
//	fetch("personen.json")
//		.then( irgendwas => irgendwas.json() )
//		.then(myjson => console.log(myjson.personen[0].vorname));// json einlesen

function getImg(salutation) {
	switch (salutation) {
		case "Mr":
			return 'images/man.png';
		case "Mrs":
		case "Miss":
			return 'images/woman.png';
		default:
			return 'images/questionMark.png';
	}
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

	var jsonDataString = `{"name": "${name}", "surname": "${surname}", "salutation": "${salutation}"}`;
		console.log(jsonDataString);

	fetch("http://localhost:8080/json/person", {
		method: 'POST',  // or PUT
		body: jsonDataString,
		headers: {
			'Content-Type': 'application/json'
        }
	});
}

var input = document.getElementById("id004");
input.addEventListener("click",onInputClick);

function getJson(meta) { 	// meta beinhaltet json mit allen kommunikations-metadaten
	return meta.json();	    // meta.json ist der reine json-inhalt
}

function getTxtFromJsonAndPackInHTML(myjson) {

	var tablePersons = document.getElementById("id_tbl001");
	var i = 0;
	for (var laufvariable of myjson.personen) {
		tablePersons.insertAdjacentHTML("beforeend",
			"<tr>"
			+ `<td> ${++i} </td>`
			+ "<td><img src='" + getImg(laufvariable.salutation) + "'></td>"
			+ "<td>" + laufvariable.salutation + "</td>"
			+ "<td>" + laufvariable.name + "</td>"
			+ "<td>" + laufvariable.surname + "</td>"
			+ "</tr>")
			//	document.getElementById("IdAnredeHerr").textContent = laufvariable.anrede;
			//	document.getElementById("IdVornameMicki").textContent = laufvariable.vorname;
			//	document.getElementById("IdNachnameMaus").textContent = laufvariable.nachname;
	}
}

fetch("http://localhost:8080/json/persons/all")
	.then(getJson) 					  	 // entspricht: .then( irgendwas => irgendwas.json() )
	.then(getTxtFromJsonAndPackInHTML)  // entpricht: cell.textContent = myjson.persons[0].vorname);