document.getElementById("enviar").addEventListener("click", function () {
    let count = 0

    let nomeV = document.getElementById("nome").value;
    if (nomeV == "") {
        nomeV = null
        count++
    }
    let codigoV = document.getElementById("inputAlterar").value
    if (codigoV == "") {
        codigoV = null
        document.getElementById("mensagemErro").hidden = false;
        document.getElementById("mensagemErro2").hidden = true;
        return
    }
    let idadeV = document.getElementById("idade").value
    if (idadeV == "") {
        idadeV = null
        count++
    }
    let generoV = document.getElementById("genero").options[document.getElementById("genero").selectedIndex].value
    if (generoV == "") {
        generoV = null
        count++
    }
    let pesoV = document.getElementById("peso").value
    if(pesoV == "")
    {
        pesoV = null
        count++
    }
    let alturaV = document.getElementById("altura").value;
    if (alturaV == "") {
        alturaV = null
        count++;
    }
    if(count == 5)
    {
        document.getElementById("mensagemErro2").hidden = false;
        document.getElementById("mensagemErro").hidden = true;
        return
    }

    fetch("http://localhost:8080/api/alterar", {
        method: "POST",
        body: JSON.stringify({
            codigo: codigoV,
            nome: nomeV,
            idade: idadeV,
            genero: generoV,
            peso: pesoV,
            altura: alturaV,

        })
    }).then((response) => {
        if (response.status == 200) {
            document.getElementById("mensagemSucesso").hidden = false;
            document.getElementById("mensagemErro").hidden = true;
            document.getElementById("mensagemErro2").hidden = true;
            document.getElementById("mensagemErro3").hidden = true;
            document.getElementById("mensagemErro4").hidden = true;
        }
        else if (response.status == 400) {
            document.getElementById("mensagemErro3").hidden = false;
            document.getElementById("mensagemSucesso").hidden = true;
            document.getElementById("mensagemErro").hidden = true;
            document.getElementById("mensagemErro2").hidden = true;
            document.getElementById("mensagemErro4").hidden = true;
        }
        else
        {
            document.getElementById("mensagemErro3").hidden = true;
            document.getElementById("mensagemSucesso").hidden = true;
            document.getElementById("mensagemErro").hidden = true;
            document.getElementById("mensagemErro2").hidden = true;
            document.getElementById("mensagemErro4").hidden = false;
        }
    })
})