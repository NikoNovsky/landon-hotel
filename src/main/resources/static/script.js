const bootstrapScript = document.createElement("script");
    bootstrapScript.src = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js";
    bootstrapScript.integrity = "sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm";
    bootstrapScript.crossOrigin = "anonymous";

    bootstrapScript.onload = () => {
        document.getElementById("loadRooms").addEventListener("click", () => {
            fetch("/api/rooms")
                .then(res => res.json())
                .then(data => {
                    const tbody = document.getElementById("tbody");
                    tbody.innerHTML = "";

                    data.forEach(room => {
                        const tr = document.createElement("tr");
                        const firstColumn = document.createElement("td");
                        const secondColumn = document.createElement("td");
                        const thirdColumn = document.createElement("td");
                        const fourthColumn = document.createElement("td");
                        const radio = document.createElement("input");

                        firstColumn.textContent = room.roomNumber;
                        secondColumn.textContent = room.name;
                        thirdColumn.textContent = room.bedInfo;
                        radio.type = "radio";
                        radio.name = "selectedRoom";
                        radio.id = room.id;

                        fourthColumn.appendChild(radio);
                        tr.appendChild(firstColumn);
                        tr.appendChild(secondColumn);
                        tr.appendChild(thirdColumn);
                        tr.appendChild(fourthColumn);

                        tr.addEventListener("click", () => {
                            radio.checked = true;
                        });

                        tbody.appendChild(tr);
                    });
                })
                .catch(err => console.error("Error loading all rooms:", err));
        });
    };

    document.body.appendChild(bootstrapScript);