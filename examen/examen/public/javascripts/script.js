/*document.addEventListener('DOMContentLoaded', () => {   
    const myInput = document.getElementById('myInput');
    const myModal = document.getElementById('myModal');

    const modalBodyInput = myModal.querySelector('.modal-body #comercio');
    myModal.querySelector('.modal-body #comercio').value ;
    console.log(modalBodyInput, 'modalbody');


    myInput.addEventListener('shown.bs.modal', () => {
        modalBodyInput.value() = this.producto;
        myInput.focus()
    })
  });*/


function cargar(id, comercio, producto, precio) {

    const myInput = document.getElementById('myInput');
    const myModal = document.getElementById('myModal');

    const modalBodyInput = myModal.querySelector('.modal-body #comercio');

    myModal.querySelector('.modal-body #producto').value = producto;
    myModal.querySelector('.modal-body #comercio').value = comercio;
    myModal.querySelector('.modal-body #precio').value = precio;

    document.getElementById("MyForm").action = "/productos/update/"+id;
}
    function limpiar() {
    const myInput = document.getElementById('myInput');
    const myModal = document.getElementById('myModal');

    myModal.querySelector('.modal-body #producto').value = "";
    myModal.querySelector('.modal-body #comercio').value = "";
    myModal.querySelector('.modal-body #precio').value = "";

    document.getElementById("MyForm").action = "/productos/new";
    
}
