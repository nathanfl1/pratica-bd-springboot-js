let botao = document.getElementById("botao")
let botaoConsultar = document.getElementById("consultar")
let botaoExcluir = document.getElementById("excluir")
let botaoAlterar = document.getElementById("alterar")
let conteudo
botao.addEventListener("click", function(){
    location.href = "/relatorio"
})

let botaoAdd = document.getElementById("add")
botaoAdd.addEventListener("click", function () {
    location.href = "/cadastrar"
})

botaoConsultar.addEventListener("click", function () {
    location.href = "/consultar"
})

botaoExcluir.addEventListener("click", function () {
    location.href = "/excluir"
})
botaoAlterar.addEventListener("click", function () {
    location.href = "/alterar"
})