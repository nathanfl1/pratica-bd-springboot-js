function mensagens(i, response) {
    switch (i) {
        case 0:
            return "Foram cadastrados <strong>" + response.quantidadePacientes + "</strong> pacientes."
        case 1: return "A média de idade dos homens é <strong>" + response.media.toFixed(2) + "</strong> anos."
        case 2: return "Existem <strong>" + response.mulheres + "</strong> mulheres ente 1,60 e 1,70 com mais de 70kg."
        case 3: return "Existem <strong>" + response.pessoas + "</strong> pacientes entre 18 e 25 anos."
        case 4: return "Paciente(s) mais velho(s): <strong>" + response.maisVelhos + "</strong>"
        case 5: return "Mulher(es) mais baixa(s): <strong>" + response.mulheresMaisBaixas + "</strong>"
        default: return

    }
}

fetch("http://localhost:8080/api/relatorio")
    .then((response) => response.json()).then((response) => {
        if (response.quantidadePacientes == 0) {
            document.getElementById("mensagemErro").hidden = false
            return
        }
        let paragrafos = document.querySelectorAll(".paragrafos")
        for (let index = 0; index < paragrafos.length; index++)
            paragrafos[index].innerHTML = mensagens(index, response)

    })


let botaoVoltar = document.getElementById("voltar")
botaoVoltar.addEventListener("click", function () {
    location.href = "/"
})