document.addEventListener("DOMContentLoaded", function () {
    console.log("DOM fully loaded and parsed");

    let fetchTriggered = false;

    const observerTarget = document.querySelector("body");
    if (!observerTarget) {
        console.error("Observer target (body) not found");
        return;
    }

    const observer = new MutationObserver((mutationsList, observer) => {
        mutationsList.forEach(() => {

            const pageNameField = document.querySelector("input[name='pageName']");
            if (pageNameField && !fetchTriggered && !pageNameField.value) {
                console.log("Input field 'pageName' found and empty:", pageNameField);

                const currentPath = document.querySelector("input[name='parentPath']")?.value || "default-path";

                fetchTriggered = true; 
                fetch(`/bin/generate-page-name?path=${encodeURIComponent(currentPath)}`)
                    .then((response) => response.json())
                    .then((data) => {
                        if (data.generatedName) {
                            console.log("Generated name from servlet:", data.generatedName);

                            // Set the value of the pageName field if it's still empty
                            if (!pageNameField.value) {
                                pageNameField.value = data.generatedName;

                                // Dispatch a change event to notify AEM
                                const event = new Event("change", { bubbles: true });
                                pageNameField.dispatchEvent(event);
                                console.log("Change event dispatched for 'pageName' field");

                                observer.disconnect();
                                console.log("MutationObserver disconnected");
                            } else {
                                console.log("Field 'pageName' already has a value:", pageNameField.value);
                            }
                        }
                    })
                    .catch((error) => {
                        console.error("Error fetching generated name from servlet:", error);
                    });
            }
        });
    });

    observer.observe(observerTarget, {
        childList: true, // Observe when children are added or removed
        subtree: true,   // Observe changes in all descendants
    });
});
