var color = "";
var letra = "";
var divs = [];

function Ocultar(){
    var x = document.getElementById("div1");
    if (x.style.backgroundColor === "white") {
        x.style.backgroundColor = "red";
    } else {
        x.style.backgroundColor = "white";
    }
}

function tablero(){
    for (let index = 0; index < 5; index++) {
        let divPadre = document.createElement("div");
        const nombreDivPadre = "divPadre-" + index;
        divPadre.id = nombreDivPadre;
        divPadre.classList.add('row');
        document.getElementById("tablero").appendChild(divPadre);
        for (let index2 = 0; index2 < 5; index2++){
            const nombreDiv = "div" + index + "-" + index2;
            let div = document.createElement("div");
            div.id = nombreDiv;
            div.style.width = "50px";
            div.style.height = "50px";
            div.style.background = "white";
            div.style.color = "white";
            div.style.borderStyle ="groove";
            div.style.borderWidthh="thin";
            divPadre.appendChild(div);
        }
    }
    document.getElementById("flexSwitchCheckDefault").disabled = true;
}

function cambiaLetra(letra) {
    this.letra = letra;
    limpiarTablero();
    if(divs != [] ){
        divs = [];
    }
    if(letra == "T" ) {
        divs.push("div0-0");
        divs.push("div0-1");
        divs.push("div0-2");
        divs.push("div0-3");
        divs.push("div0-4");
        divs.push("div1-2");
        divs.push("div2-2");
        divs.push("div3-2");
        divs.push("div4-2");
    }
    else if(letra == "F") {
        divs.push("div0-1");
        divs.push("div0-2");
        divs.push("div0-3");
        divs.push("div1-1");
        divs.push("div2-1");
        divs.push("div2-2");
        divs.push("div3-1");
        divs.push("div4-1");
    }
    else if(letra == "L"){
        divs.push("div0-1");
        divs.push("div1-1");
        divs.push("div2-1");
        divs.push("div3-1");
        divs.push("div4-1");
        divs.push("div4-2");
        divs.push("div4-3");

    }
    else if(letra == "M"){
        divs.push("div0-1");
        divs.push("div0-2");
        divs.push("div0-3");
        divs.push("div1-1");
        divs.push("div2-1");
        divs.push("div2-2");
        divs.push("div2-3");
        divs.push("div3-1");
        divs.push("div3-2");
        divs.push("div3-3");
        divs.push("div4-1");
        divs.push("div4-3");

    }
    if(this.color != "" ){
        cambioColor(this.color);
    }
}

function cambioColor(color) {
    this.color = color;
    if(letra != "") {
        divs.forEach(element => {
            var x = document.getElementById(element);
            x.style.background = color; 
        });
    }
}

function limpiarTablero(){
    console.log("entro", divs);
    divs.forEach(element => {
        var x = document.getElementById(element);
        x.style.background = "white"; 
    });
}