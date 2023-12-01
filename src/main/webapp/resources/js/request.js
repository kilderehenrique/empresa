
async function request(url, method, body) {
    var response = undefined;

    await fetch(url, 
        {
            method: method,
            body: JSON.stringify(body)
        }
    ).then(resp => {
        resp = response;
    }).catch(erro => alert(erro));


    return response;
}
