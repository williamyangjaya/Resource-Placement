let employee = new Object();
let table = null;
let id = 0;
let val = [];

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
            url: "/employee/get-all",
            datatype: "json",
            dataSrc: ""
        },
        columns: [
            {
                data: null
            },
            {
                data: "name", name: "Name", autoWidth: true
            },
            {
                data: "gender", name: "Gender", autoWidth: true
            },
            {
                data: "birthDate", name: "Birthdate", autoWidth: true
            },
            {
                data: "email", name: "Email", autoWidth: true
            },
            {
                data: "jabatan", name: "Jabatan", autoWidth: true
            },
//            {
//                data: "skillsList",
//                render: function (value, type, row) {
//                    var val = [];
//                    $.each(value, function (i, v) {
//                        val.push(v['label']);
//                    });
//                    return val;
//                }
//            },
            {
                render: (data, type, row, meta) => {
                    return `
                        <button 
                            class='btn btn-sm btn-primary'
                            data-toggle="modal" 
                            data-target="#employeeModal"
                            onclick="getById('${row.empId}')"
                        >
                            <i class='fa fa-sm fa-pencil'></i>
                        </button>
                        <button class='btn btn-sm btn-danger' onclick='deleteById(${row.empId})'>
                            <i class='fa fa-sm fa-trash'></i>
                        </button>
                    `;
                }
            }
        ],
        columnDefs: [
            {targets: 3, render: function (data)
                {
                    return moment(data).format('Do MMMM YYYY');
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
        url: `/employee/${id}`,
        type: 'GET',
        success: (res) => {
            setForm(res);
        }
    });
}

function create() {
    employee = {
        empId: $("#empId").val(),
        name: $("#name").val(),
        gender: $("#gender").val(),
        birthDate: $("#birthdate").val(),
        email: $("#email").val(),
        jabatan: $("#jabatan").val(),
        skillsList: $("#skill").val()
    };

    $.ajax({
        url: "/employee",
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(employee),
        success: (res) => {
            table.ajax.reload();
            successAlert("Employee Created");
            $("#employeeModal").modal("hide");
        },
        error: (err) => {
            errorAlert("Employee Failed Created");
        }
    });
}

function update(id) {
    employee = {
        empId: $("#empId").val(),
        name: $("#name").val(),
        gender: $("#gender").val(),
        birthDate: $("#birthdate").val(),
        email: $("#email").val(),
        jabatan: $("#jabatan").val(),
        skillsList: [
            {                
                skillId: $("#skillId").val(),
                label: $("#skillLabel").val()
            }
        ]
    };

    $.ajax({
        url: `/employee/${this.id}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(employee),
        success: (res) => {
            table.ajax.reload();
            successAlert("Employee Updated");
            $("#employeeModal").modal("hide");
        },
        error: (err) => {
            errorAlert("Employee Failed Updated");
        }
    });
}

function deleteById(id) {
    questionAlert("Are you sure?", "Do you want to delete this data?", () => {
        $.ajax({
            url: `/employee/${id}`,
            type: 'DELETE',
            success: (res) => {
                table.ajax.reload();
                successAlert("Employee Deleted");
            }
        });
    });
}

function valueSkillsListId(data) {
    $.each(data.skillsList, function (i, v) {
        val.push(data.skillsList[i].skillId);
    });
    return val;
}

function valueSkillsListLabel(data) {
    $.each(data.skillsList, function (i, v) {
        val.push(data.skillsList[i].label);
    });
    return val;
}

function setForm(data) {
    $("#empId").val(data.empId);
    $("#name").val(data.name);
    $("#gender").val(data.gender);
    $("#birthdate").val(data.birthDate);
    $("#email").val(data.email);
    $("#jabatan").val(data.jabatan);
//    $("#skillId").val(valueSkillsListId(data));
//    $("#skillLabel").val(valueSkillsListLabel(data));
}

function clearForm() {
    idEmployee = 0;
    $("#empId").val("");
    $("#name").val("");
    $("#gender").val("");
    $("#birthDate").val("");
    $("#email").val("");
    $("#jabatan").val("");
//    $("#skill").val("");
}