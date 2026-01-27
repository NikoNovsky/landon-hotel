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
                            const nameUpdateInput = document.querySelector('input[name="nameUpdate"]');
                            const roomNumberUpdate = document.querySelector('input[name="roomNumberUpdate"]');
                            const bedInfoUpdate = document.querySelector('input[name="bedInfoUpdate"]');

                            nameUpdateInput.value = room.name;
                            roomNumberUpdate.value = room.roomNumber;
                            bedInfoUpdate.value = room.bedInfo;
                            radio.checked = true;
                        });

                        tbody.appendChild(tr);
                    });
                })
                .catch(err => console.error("Error loading all rooms:", err));
        });

        document.getElementById('addRoomForm').addEventListener('submit', e => {
            e.preventDefault()

            fetch('/api/rooms', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    name: e.target.name.value,
                    roomNumber: e.target.roomNumber.value,
                    bedInfo: e.target.bedInfo.value
                })
            })
            location.reload();
        })

        document.getElementById('updateRoomForm').addEventListener('submit', e => {
            e.preventDefault()

            const selected = document.querySelector('input[name="selectedRoom"]:checked');
            const id = selected?.id ? selected.id : null;

            fetch(`/api/rooms/${id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    id: id,
                    name: e.target.nameUpdate.value,
                    roomNumber: e.target.roomNumberUpdate.value,
                    bedInfo: e.target.bedInfoUpdate.value
                })
            })
            location.reload();
        })

        document.getElementById('deleteRoomButton').addEventListener('click', e => {
            e.preventDefault()

            const selected = document.querySelector('input[name="selectedRoom"]:checked');
            const id = selected?.id ? selected.id : null;

            fetch(`/api/rooms/${id}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    id: id
                })
            })
            location.reload();
        })
    };

    document.body.appendChild(bootstrapScript);