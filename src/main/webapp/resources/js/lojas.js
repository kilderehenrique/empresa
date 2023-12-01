const tbody = document.getElementById("table-body");
// Modelo da linha da tabela

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
        // Realiza request ao back-end
        resp = await request("http://localhost:8080/lojas/" + id, "DELETE");
    } catch (error) {
        alert("Funcionário não deletado!");
        return;
    }

    // Alerta mensagem se houver
    if(resp.message)
        alert(resp.message);
    
    location.reload();
}

async function list() {
    var resp = undefined;

    // Realiza request ao back-end
    try {
        resp = await request("http://localhost:8080/lojas/", "GET");
    } catch (error) {
        // Mantem tabela padrão
        return;
    }

    var new_tbody = "";

    // Percorrer funcionarios para preencher a tabela
    resp.forEach((funcionario) => {
        // Preenchendo linha
        var newTr = trModel.replaceAll("$cnpj", funcionario.cnpj);
        newTr = newTr.replaceAll("$nome_fantasia", funcionario.nome_fantasia);
        newTr = newTr.replaceAll("$id", funcionario.id);

        new_tbody += newTr;
    });

    // Setando nova tabela no html
    if (new_tbody != null && new_tbody.length != 0) {
        tbody.innerHTML = new_tbody;
    }
}