let inputConsultar = document.getElementById("inputConsultar")
let botaoConsultar = document.getElementById("botaoConsultar")
botaoConsultar.addEventListener("click", function () {

    //mostrar o parágrafo de resultado
    document.getElementById("result").hidden = false

    //limpar a tabela
    let tabela = document.getElementById("tabela")
    for (let index = 1; index < tabela.rows.length; index++)
        tabela.rows[index].remove()

    let mensagemErro = document.getElementById("mensagemErro");
    
    fetch("http://localhost:8080/api/pacientes", {
        method: "POST",
        body: JSON.stringify({
            codigo: inputConsultar.value,
        })
    }).then((response) => response.json())
        .then((response) => {
            let resultado = JSON.parse(JSON.stringify(response))
            if (resultado.codigo == 0) {
                mensagemErro.hidden = false;
                tabela.hidden = true;
            }
            else {
                let rowCount = tabela.rows.length;
                let row = tabela.insertRow(rowCount);
                row.insertCell(0).innerHTML = resultado.codigo
                row.insertCell(1).innerHTML = resultado.nome
                row.insertCell(2).innerHTML = resultado.idade
                row.insertCell(3).innerHTML = resultado.genero
                row.insertCell(4).innerHTML = resultado.altura
                row.insertCell(5).innerHTML = resultado.peso
                tabela.hidden = false
                mensagemErro.hidden = true
            }
        })
})

let botaoVoltar = document.getElementById("voltar")
botaoVoltar.addEventListener("click", function () {
    location.href = "/"
})