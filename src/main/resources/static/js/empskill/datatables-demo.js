let empskill = new Object();
let table = null;
let id = 0;
let userId = 0;

$(document).ready(() => {
    getUserId();
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
            url: `/empskill/skill/${userId}`,
            datatype: "json",
            dataSrc: ""
        },
        columns: [
            {
                data: null
            },
            {
                data: "empId.name", name: "Employee Name", autoWidth: true
            },
            {
                data: "skillId.label", name: "Skill", autoWidth: true
            },
            {
                render: (data, type, row, meta) => {
                    return `
                        <button 
                            class='btn btn-sm btn-primary'
                            data-toggle="modal" 
                            data-target="#empSkillModal"
                            onclick="getById('${row.empskillId}')"
                        >
                            <i class='fa fa-sm fa-pencil'></i>
                        </button>
                        <button class='btn btn-sm btn-danger' onclick='deleteById(${row.empskillId})'>
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
        url: `/empskill/${id}`,
        type: 'GET',
        success: (res) => {
            setForm(res);
        }
    });
}

function getUserId() {
    $.ajax({
        url: "/user",
        type: 'GET',
//        contentType: 'application/json',
//        data: JSON.stringify(registration),
        success: (res) => {
            console.log(res);
            userId = res;
            getAll();
        },
        error: (err) => {
        }
    });
}

function create() {
    empskill = {
        empskillId: $("#empskillId").val(),
        empId: {
            empId: $("#empId").val()
        },
        skillId: {
            skillId: $("#skillId").val()
        }
    };

    $.ajax({
        url: "/empskill",
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(empskill),
        success: (res) => {
            table.ajax.reload();
            successAlert("Employee Skill Created");
            $("#empSkillModal").modal("hide");
        },
        error: (err) => {
            errorAlert("Employee Skill Failed Created");
        }
    });
}

function update(id) {
    empskill = {
        empskillId: $("#empskillId").val(),
        empId: {
            empId: $("#empId").val()
        },
        skillId: {
            skillId: $("#skillId").val()
        }
    };

    $.ajax({
        url: `/empskill/${this.id}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(empskill),
        success: (res) => {
            table.ajax.reload();
            successAlert("Employee Skill Updated");
            $("#empSkillModal").modal("hide");
        },
        error: (err) => {
            errorAlert("Employee Skill Failed Updated");
        }
    });
}

function deleteById(id) {
    questionAlert("Are you sure?", "Do you want to delete this data?", () => {
        $.ajax({
            url: `/empskill/${id}`,
            type: 'DELETE',
            success: (res) => {
                table.ajax.reload();
                successAlert("Employee Skill Deleted");
            }
        });
    });
}

function setForm(data) {
    $("#empskillId").val(data.empskillId);
    $("#empId").val(data.empId.empId);
    $("#skillId").val(data.skillId.skillId);
}

function clearForm() {
    idEmpSkill = 0;
    $("#empskillId").val("");
    $("#empId").val("");
    $("#skillId").val("");
}
