document.addEventListener("DOMContentLoaded", () => {

    document.querySelectorAll(".showJson").forEach((button) => {
        button.addEventListener("click", (event) => {
            console.log("Mostrar Informacion");

            // Find the closest .component parent
            const parentDiv = event.target.closest(".component");
            if (!parentDiv) {
                console.error("No parent with class 'component' found.");
                return;
            }

            // Select all <p> elements inside the parentDiv
            const allInfo = parentDiv.querySelectorAll("p");

            const employeeData = {};

            // Log the text content of each <p> element
            allInfo.forEach((element) => {
                const text = element.textContent.split(": ");
                if (text.length === 2) {
                    // Use the left side of the split text as the key and the right side as the value
                    employeeData[text[0].trim()] = text[1].trim();
                }
            });
            const newTab = window.open();
            newTab.document.write("<pre>" + JSON.stringify(employeeData, null, 2) + "</pre>")
            window.open(JSON.stringify(employeeData, null, 2));
        });
    });
    
    const selectedCompany = document.querySelector(".selectedCompany");
    const companyDiv = document.querySelector("#companyDiv");

    // Crear un observer para detectar cambios en el contenido del <p>
    const observer = new MutationObserver(() => {

        // Quitar todas las clases actuales

        switch (properties.company) {
            case ("Accenture"):
                companyDiv.classList.add(".employee-background-component-accenture");
                break;
            case ("NTT Data"):
                companyDiv.classList.add(".employee-background-component-ntt");
                break;
            case ("BSoccer"):
                companyDiv.classList.add(".employee-background-component-bsoccer");
                break;
        }
    });

    // Configurar el observer para observar cambios en el texto del <p>
    observer.observe(selectedCompany, { childList: true, subtree: true });

});
