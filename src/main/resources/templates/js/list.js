let tabela = document.getElementById("tabela")
let conteudo
let selectOption = document.getElementById("selecao");
let aux
selectOption.addEventListener("change", function () {
    
    limparTabela()
    fetch("http://localhost:8080/api/lista", {
        method: "POST",
        body: JSON.stringify({
            arg: selectOption.options[selectOption.selectedIndex].value,
        })
    }).then((response) => response.json())
        .then((response) => {
            conteudo = JSON.parse(JSON.stringify(response))
            for (let i = 0; i < conteudo.length; i++) {
                let rowCount = tabela.rows.length;
                let row = tabela.insertRow(rowCount);
                row.insertCell(0).innerHTML = conteudo[i].codigo
                row.insertCell(1).innerHTML = conteudo[i].nome
                row.insertCell(2).innerHTML = conteudo[i].idade
                row.insertCell(3).innerHTML = conteudo[i].genero
                row.insertCell(4).innerHTML = conteudo[i].altura
                row.insertCell(5).innerHTML = conteudo[i].peso
            }
        });
    //limparTabela()
    tabela.hidden = false;
})

let botaoVoltar = document.getElementById("voltar")
botaoVoltar.addEventListener("click", function () {
    location.href = "/"
})

function limparTabela()
{
    let tam = tabela.rows.length - 1
    for (let index = tam; index >= 1; index--){
        tabela.rows[index].remove()    
        tam = tabela.rows.length - 1
    }

    // for (let index = 1; index < tam; index++){
    //     console.log(tabela.rows[index])
    // }
    
}
