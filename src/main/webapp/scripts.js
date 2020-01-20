//<!-- pokazkolorwzleceniu(this)  disabled="disabled" -->
//NAZWA KLIENTA DYNAMICZNIE GENEROWANA PO NUMERZE
function wstawNazweKlienta(input_obj)
{
	
	const datalist_numerKlienta = document.getElementById("datalist_numerKlienta");
	
	let pobrana_nazwa='';
	
	let nazwaKlienta = document.getElementById("nazwaKlienta1");
	
	
	
	for (let index=0;index<datalist_numerKlienta.options.length;index++) {
		if (datalist_numerKlienta.options[index].value === input_obj.value) {
			
			pobrana_nazwa = datalist_numerKlienta.options[index].getAttribute('data-nazwa_klienta');
			console.log(nazwaKlienta);
			break;
		}
	}
	
	//console.log(input_obj_id);
	
	nazwaKlienta.value = pobrana_nazwa;
	
	return;
}






//{
//var element = document.getElementById("numerKlienta1").value;
//var element2 = document.getElementById("nazwaKlienta1");
//var element3 = document.getElementById("nazwaKlienta").options[element-1].value;
//console.log(element3);
//element2.value = element3;
//	}


//PODGLĄD KOLORU W OKIENKU WPROWADZANIA ZLECENIA
function pokazKolor(input_obj){
	
	const datalist_kolory = document.getElementById("datalist_kolory");
	
	let rgb='';
	
	let out_color = document.getElementById(input_obj.id+"out");
	
	console.log(datalist_kolory.id);
	
	for (let index=0;index<datalist_kolory.options.length;index++) {
		if (datalist_kolory.options[index].value === input_obj.value) {
			
			rgb = datalist_kolory.options[index].getAttribute('data-rgb');
			
			break;
		}
	}
	
	//console.log(input_obj_id);
	
	out_color.style.backgroundColor = "rgb("+rgb+")";
	
	return;
}

//PODGLĄD KOLORU W OKIENKU WPROWADZONEGO ZLECENIA
function pokazkolorwzleceniu(input_obj){
	
	const datalist_kolory = document.getElementById("datalist_kolory");
	
	let rgb='';
	
	let out_color = document.getElementById(input_obj.id);
	
	console.log(input_obj.id);
	
	for (let index=0;index<datalist_kolory.options.length;index++) {
		if (datalist_kolory.options[index].value === input_obj.id) {
			
			rgb = datalist_kolory.options[index].getAttribute('data-rgb');
			
			break;
		}
	}
	
	//console.log(input_obj_id);
	console.log(rgb);
	out_color.style.backgroundColor = "rgb("+rgb+")";
	
	return;
}

function myFunction() {
	  alert("Welcome!");
	}

//WSTAWIA SZEROKOSC MATERIAŁU NA PODSTAWIE DANYCH Z WYKROJNIKA
function szerokosc_papieru(input_obj){
	
	const datalist_wykrojniki = document.getElementById("datalist_wykrojniki");
	
	let szerokosc_papieru='';
	
	let szerokoscSurowca = document.getElementById("szerokoscSurowca");
	
	console.log(datalist_kolory.id);
	
	for (let index=0;index<datalist_wykrojniki.options.length;index++) {
		if (datalist_wykrojniki.options[index].value === input_obj.value) {
			
			szerokosc_papieru = datalist_wykrojniki.options[index].getAttribute('data-szerokosc_papieru');
			
			break;
		}
	}
	
	//console.log(input_obj_id);
	
	szerokoscSurowca.value = szerokosc_papieru;
	
	return;
}

function parseJSON() {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
	    var myObj = JSON.parse(this.responseText);
	    //alert(myObj);
	   let x, i;
	    for (i = 0; i < myObj.length; i++) {
	    	  x += myObj[i].colorId + "<br>";
	    	}
	    	document.getElementById("result").innerHTML = x;

	    }

	  }
	xmlhttp.open("GET", "json_demo.txt", true);
	xmlhttp.send();
	};



