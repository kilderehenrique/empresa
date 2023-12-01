import { request } from "./request.js";

async function deletarRegistro(id) {
    resquest("/funcionarios/"+id, "DELETE");
}

const tableBody = document.getElementById("table-body");
var newTableBody = "";

var funcionarios = await resquest("/funcionarios/", "GET");

if(funcionarios != undefined) {
    funcionarios.forEach(funcionario => {
        
    });
}
