getPurchases('/api/products/');
async function getPurchases(url = '/api/products/', data = {}) {
    const response = await fetch(url, {
        method: "GET",
        headers: {
            'Content-Type': 'application/json'
        }
    });

    //body: JSON.stringify(data), // body data type must match "Content-Type" header
    if (response.ok) {
        const json = await response.json();

        let element = document.getElementById("product_list");

        for (let index in json) {
            
            let textNode = document.createElement('div');
            let swBox = document.createElement('input');
            let deleteButton = document.createElement("button");
            swBox.setAttribute('type', 'checkbox');
            textNode.textContent = json[index].description;
            deleteButton.appendChild(document.createTextNode("Delete"));
            element.append(textNode);
            textNode.append(swBox);
            textNode.append(deleteButton);
            deleteButton.onclick = function () {
                deleteItem(json[index].id);
            };
        }
    } else {
        alert("Ошибка HTTP: " + response.status);
    }
}



async function addPurchase() {
    let newItemTitle = document.getElementById("productsDescription").value;
    const response = await fetch('/api/products/', {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(
            {
                description: newItemTitle,
                purchased: false
            }
        )
    });
    if (response.ok) {
        await getPurchases('/api/products/');
    } else {
        alert("Ошибка HTTP: " + response.status);
    }
}

async function deleteItem(id) {

    let response = await fetch('/api/products/' + encodeURIComponent(id),
        {method: 'DELETE'});
    if (response.ok) {
        await getPurchases('/api/products/');
    } else {
        alert("Ошибка HTTP: " + response.status);
    }
}
