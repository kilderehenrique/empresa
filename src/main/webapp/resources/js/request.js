async function request(url, melthod, body) {
    var result = undefined;
    var response = undefined; 

    try {
        // Realiza request com retorno JSON
        response = await fetch(url, {
            method: melthod,
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(body),
        });

        result = await response.json();
        console.log("Success:", result);
    } catch (error) {
        console.error("Error:", error);
    }

    return result;
}