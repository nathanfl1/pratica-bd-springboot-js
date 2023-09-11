let botaoExcluir = document.getElementById("botaoExcluir")
let inputExcluir = document.getElementById("inputExcluir")
let mensagemErro = document.getElementById("mensagemErro")
botaoExcluir.addEventListener("click", function () {
    if (inputExcluir.value == "") 
    {
        mensagemErro.hidden = false
        return
    }

    else
        mensagemErro.hidden = true
    fetch("http://localhost:8080/api/excluir", {
        method: "POST",
        body: JSON.stringify({
            codigo: inputExcluir.value,
        })
    }).then((response) => {
        console.log(JSON.parse(JSON.stringify(response.json())))
        document.getElementById("mensagemSucesso").hidden = false;
    })
})