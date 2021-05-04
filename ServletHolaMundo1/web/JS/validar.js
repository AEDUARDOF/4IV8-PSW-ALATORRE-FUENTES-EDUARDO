/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validarn(e){
    let valorR = document.getElementsByName(edad);
    let valorE = document.getElementsByName(ideliminar);
    let valorIDA = document.getElementsByName(idactualizar);
    let valorA = document.getElementsByName(edad_a);
    var teclado = (document.all)?e.keyCode:e.which;
    if(teclado == 8)return true;

    var patron = /(^[\d]+$){1}/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function validare(formulario){
    let valorR = document.getElementsByName(edad);
    let valorE = document.getElementsByName(ideliminar);
    let valorIDA = document.getElementsByName(idactualizar);
    let valorA = document.getElementsByName(edad_a);

    var patron = /(^[\d]+$){1}/;

    if (patron.test(valorR)){
       alert("El ID cumple  con los requisitos");
    } else {
       alert("El ID no cumple con los requisitos");
    }
    
    if (patron.test(valorE)){
       alert("El ID cumple  con los requisitos");
    } else {
       alert("EL ID no cumple con los requisitos");
    }
    
    if (patron.test(valorIDA)){
       alert("La edad cumple  con los requisitos");
    } else {
       alert("La edad no cumple con los requisitos");
    }
    
    if (patron.test(valorA)){
       alert("La edad cumple  con los requisitos");
    } else {
       alert("La edad no cumple con los requisitos");
    }
    
    if (valorR==''){
       alert("La edad cumple  con los requisitos");
    } else {
       alert("Llene el campo de edad");
    }
    
    if (valorE==''){
       alert("El ID cumple  con los requisitos");
    } else {
       alert("Llene el campo de ID a eliminar");
    }
    
    if (valorIDA==''){
       alert("El ID cumple  con los requisitos");
    } else {
       alert("Llene el campo de ID a actualizar");
    }
    
    if (valorA==''){
       alert("La edad cumple  con los requisitos");
    } else {
       alert("Llene el campo de edad");
    }
}

function validarp(e){
    var teclado = (document.all)?e.keyCode:e.which;
    if(teclado == 8)return true;

    var patron = /[a-zA-Z]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
    
}

function validarcA(e){
    let valor = document.getElementsByName(correo_a);
    let pruebac = /\b[\w\.-]+@[\w\.-]+\.\w{2,4}\b/gi;
    if (pruebac.test(valor)){
       alert("La dirección de email " + valor + " es correcta!.");
      } else {
       alert("La dirección de email es incorrecta!.");
    }
}

function validarcR(e){
    let valor = document.getElementsByName(correo);
    let pruebac = /\b[\w\.-]+@[\w\.-]+\.\w{2,4}\b/gi;
    if (pruebac.test(valor)){
       alert("La dirección de email " + valor + " es correcta!.");
      } else {
       alert("La dirección de email es incorrecta!.");
    }
}



