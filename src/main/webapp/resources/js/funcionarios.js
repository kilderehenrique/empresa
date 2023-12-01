const tbody = document.getElementById("table-body");

// Modelo da linha da tabela
const trModel =
    '<tr>' +
        '<td>$nome</td>' +
        '<td>$idade</td>' +
        '<td>$telefone</td>' +
        '<td>$email</td>' +
        '<td>$loja</td>' +
        '<td>$cargo</td>' +
        '<td>$salario</td>' +
        '<td><a href="form/?id=$id"><img src="../resources/icons/edit-icon.png" alt="editar" class="icon"></a></td>' +
        '<td><img onclick="deletar($id)" src="../resources/icons/delete-icon.png" alt="deletar" class="icon hover_pointer"></td>' +
    '</tr>';

async function deletar(id) {
    var resp = undefined;

    try {
        // Realiza request ao back-end
        resp = await request("http://localhost:8080/funcionarios/" + id, "DELETE");
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
        resp = await request("http://localhost:8080/funcionarios/", "GET");
    } catch (error) {
        // Mantem tabela padrão
        return;
    }

    var new_tbody = "";

    // Percorrer funcionarios para preencher a tabela
    resp.forEach((funcionario) => {
        // Preenchendo linha
        var newTr = trModel.replaceAll("$nome", funcionario.nome);
        newTr = newTr.replaceAll("$idade", funcionario.idade);
        newTr = newTr.replaceAll("$id", funcionario.id);
        newTr = newTr.replaceAll("$telefone", funcionario.telefone);
        newTr = newTr.replaceAll("$email", funcionario.email);
        newTr = newTr.replaceAll("$loja", funcionario.loja != null && funcionario.loja.cnpj ? funcionario.loja.cnpj : "Não registrado");
        newTr = newTr.replaceAll("$cargo", funcionario.cargo != null && funcionario.cargo.nome ? funcionario.cargo.nome : "Não registrado");
        newTr = newTr.replaceAll("$salario", funcionario.cargo != null && funcionario.cargo.salario ? funcionario.cargo.salario : "Não registrado");

        new_tbody += newTr;
    });

    // Setando nova tabela no html
    if (new_tbody != null && new_tbody.length != 0) {
        tbody.innerHTML = new_tbody;
    }
}