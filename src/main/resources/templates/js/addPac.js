
let botaoEnviar = document.getElementById("enviar");
let div = document.getElementById("mensagens")
let preenchido = false;
botaoEnviar.addEventListener("click", function () {
    document.getElementById("mensagemSucesso").hidden = true
    for (let item of document.querySelectorAll(".mensagem"))
        item.remove()
    
    let inputs = document.querySelectorAll(".inputs")
    for (let input of inputs) {
        if (input.value == "") {
            if (!preenchido) {
                let p = document.createElement("p")
                p.innerHTML = "Preencha todos os campos!!!"
                p.classList.add("mensagem")
                div.appendChild(p);
            }
            preenchido = true;
            return
        }
    }
    let inputGen = document.getElementById("genero");
    console.log(document.getElementById("idade").value)
    fetch("http://localhost:8080/api/cadastrar", {
        method: "POST",
        body: JSON.stringify({
            nome: document.getElementById("nome").value,
            idade: document.getElementById("idade").value,
            genero: inputGen.options[inputGen.selectedIndex].value,
            altura: document.getElementById("altura").value,
            peso: document.getElementById("peso").value,
        })
    }).then((response) => {
        if (response.status == 400) {
            let p = document.createElement("p")
            p.innerHTML = "Usuário já existe"
            p.classList.add("mensagem")
            div.appendChild(p);
        }
        else if (response.status == 500) {
            let p = document.createElement("p")
            p.innerHTML = "Houve um erro interno no servidor."
            p.classList.add("mensagem")
            div.appendChild(p);
        }
        else
            document.getElementById("mensagemSucesso").hidden = false
        
    })
})

let botaoVoltar = document.getElementById("voltar")
botaoVoltar.addEventListener("click", function () {
    location.href = "/"
})