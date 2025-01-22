document.addEventListener("DOMContentLoaded", () => {
    var botones = document.getElementsByClassName("go-btn");

    //añadimos un evento a cada boton que contenga la clase go-btn
    Array.from(botones).forEach((boton) => {
        boton.addEventListener("click", callServlet);
        boton.addEventListener("click", () => {
            console.log("Botón pulsado");
        });
    });

    // la funciona para llavar al servlet pasandole el path del elemento actual que se ha clickado
    function callServlet(event) {
        // Obtenemos el data-path, que es un atributo del elemento clickado
        const resourcePath = event.target.getAttribute("data-path");

        if (resourcePath) {
            // Redirigimos a la url del servlet con formato json
            window.location.href = `${resourcePath}.json`;
        } else {
            console.error("Resource path not found for the clicked button.");
        }
    }
});