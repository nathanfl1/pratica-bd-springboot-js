fetch("http://localhost:8080/api/relatorio")
.then((response) => response.json()).then((response) => {
    console.log(response)
})
