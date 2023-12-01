const tbody = document.getElementById("table-body");
const trModel =
'<tr>' +
    '<td>$cnpj</td>' +
    '<td>$nome_fantasia</td>' +
    '<td><a href="form/?id=$id"><img src="../resources/icons/list-icon.png" alt="lista-funcionarios" class="icon"></a></td>' +
    '<td><a href="form/?id=$id"><img src="../resources/icons/edit-icon.png" alt="editar" class="icon"></a></td>' +
    '<td><img onclick="deletar($id)" src="../resources/icons/delete-icon.png" alt="deletar" class="icon hover_pointer"></td>' +
'</tr>';

async function deletar(id) {
    var resp = undefined;

    try {
        resp = await request("http://localhost:8080/lojas/" + id, "DELETE");
    } catch (error) {
        alert("Funcionário não deletado!");
        return;
    }

    alert(resp.message);
    location.reload();
}

async function list() {
    var resp = undefined;

    try {
        resp = await request("http://localhost:8080/lojas/", "GET");
    } catch (error) {
        return;
    }

    var new_tbody = "";

    resp.forEach((funcionario) => {
        var newTr = trModel.replaceAll("$cnpj", funcionario.cnpj);
        newTr = newTr.replaceAll("$nome_fantasia", funcionario.nome_fantasia);
        newTr = newTr.replaceAll("$id", funcionario.id);

        new_tbody += newTr;
    });

    if (new_tbody != null && new_tbody.length != 0) {
        tbody.innerHTML = new_tbody;
    }
}