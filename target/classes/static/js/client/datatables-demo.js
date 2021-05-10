let client = new Object();
let table = null;
let id = 0;

$(document).ready(() => {
    getAll();
    $("#formModal").submit((e) => {
        e.preventDefault();
        formValidation(this.id ? update : create);
    });
});

function getAll() {
    table = $('#dataTable').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/client/get-all",
            datatype: "json",
            dataSrc: ""
        },
        columns: [
            {
                data: null
            },
            {
                data: "clientName", name: "Name", autoWidth: true
            },
            {
                data: "instansi", name: "Name", autoWidth: true
            },
            {
                data: "email", name: "Email", autoWidth: true
            },
            {
                data: "industryType", name: "Industry Type", autoWidth: true
            },
            {
                data: "location", name: "Location", autoWidth: true
            },
            {
                render: (data, type, row, meta) => {
                    return `
                        <button 
                            class='btn btn-sm btn-primary'
                            data-toggle="modal" 
                            data-target="#clientModal"
                            onclick="getById('${row.clientId}')"
                        >
                            <i class='fa fa-sm fa-pencil'></i>
                        </button>
                        <button class='btn btn-sm btn-danger' onclick='deleteById(${row.clientId})'>
                            <i class='fa fa-sm fa-trash'></i>
                        </button>
                    `;
                }
            }
        ]
    });
    
    table.on('draw.dt', function () {
        var info = table.page.info();
        table.column(0, {search: 'applied', order: 'applied', page: 'applied'}).nodes().each(function (cell, i) {
            cell.innerHTML = i + 1;
        });
    });
}

function getById(id) {
    this.id = id;
    $.ajax({
        url: `/client/${id}`,
        type: 'GET',
        success: (res) => {
            setForm(res);
        }
    });
}

function create() {
    client = {
        clientId: $("#clientId").val(),
        clientName: $("#clientName").val(),
        instansi: $("#instansi").val(),
        email: $("#email").val(),
        industryType: $("#industryType").val(),
        location: $("#location").val()
    };

    $.ajax({
        url: "/client",
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(client),
        success: (res) => {
            table.ajax.reload();
            successAlert("Client Created");
            $("#clientModal").modal("hide");
        },
        error: (err) => {
            errorAlert("Client Failed Created");
        }
    });
}

function update(id) {
    client = {
        clientId: $("#clientId").val(),
        clientName: $("#clientName").val(),
        instansi: $("#instansi").val(),
        email: $("#email").val(),
        industryType: $("#industryType").val(),
        location: $("#location").val()
    };

    $.ajax({
        url: `/client/${this.id}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(client),
        success: (res) => {
            table.ajax.reload();
            successAlert("Client Updated");
            $("#clientModal").modal("hide");
        },
        error: (err) => {
            errorAlert("Client Failed Updated");
        }
    });
}

function deleteById(id) {
    questionAlert("Are you sure?", "Do you want to delete this data?", () => {
        $.ajax({
            url: `/client/${id}`,
            type: 'DELETE',
            success: (res) => {
                table.ajax.reload();
                successAlert("Client Deleted");
            },
            error: (err) => {
                errorAlert("Client failed deleted");
            }
        });
    });
}

function setForm(data) {
    $("#clientId").val(data.clientId);
    $("#clientName").val(data.clientName);
    $("#instansi").val(data.instansi);
    $("#email").val(data.email);
    $("#industryType").val(data.industryType);
    $("#location").val(data.location);
}

function clearForm() {
    idClient = 0;
    $("#clientId").val("");
    $("#name").val("");
    $("#email").val("");
    $("#industryType").val("");
    $("#location").val("");
}