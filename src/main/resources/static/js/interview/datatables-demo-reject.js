let interview = new Object();
let table = null;
let id = 0;
let val = [];

$(document).ready(() => {
    getAll();
    $("#formModalAdd").submit((e) => {
        e.preventDefault();
        formValidation(create);
    });
    $("#formModalEdit").submit((e) => {
        e.preventDefault();
        formValidation(update);
    });
    $("#formModalReject").submit((e) => {
        e.preventDefault();
        formValidation(update2);
    });
});

function getAll() {
    table = $('#dataTable').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/interview/get-all",
            datatype: "json",
            dataSrc: "",
        },        
        columns: [
            {
                data: null
            },
            {
                data: "empId.name", name: "Employee", autoWidth: true
            },
            {
                data: "interviewDate", name: "Interview Date", autoWidth: true
            },
            {
                data: "interviewVia", name: "Interview Via", autoWidth: true
            },
            {
                data: "clientId.instansi", name: "Client", autoWidth: true
            },
            {
                data: "resultDate", name: "Result Date", autoWidth: true
            },
            {
                data: "result", name: "Result", autoWidth: true
            }
        ],
        searchCols:[
            null,
            null,
            null,
            null,
            null,
            null,
            {"search":'REJECT'}
        ],
        columnDefs: [
            {targets: 2, render: function (data)
                {
                    return moment(data).format('Do MMMM YYYY');
                }
            },
            {targets: 5, render: function (data)
                {
                    return moment(data).format('Do MMMM YYYY');
                }
            },
            {
                targets: 6,
                visible: false
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
        url: `/interview/${id}`,
        type: 'GET',
        success: (res) => {
            setForm(res);
        }
    });
}

function getById2(id) {
    this.id = id;
    $.ajax({
        url: `/interview/${id}`,
        type: 'GET',
        success: (res) => {
            setForm2(res);
        }
    });
}

function create() {
    interview = {
        interviewId: $("#interviewIdAdd").val(),
        interviewDate: $("#interviewDateAdd").val(),
        resultDate: $("#resultDateAdd").val(),
        result: $("#resultAdd").val(),
        status: $("#statusAdd").val(),
        interviewVia: $("#interviewViaAdd").val(),
        note: $("#noteAdd").val(),
        clientId: {
            clientId: $("#clientIdAdd").val()
        },
        empId: {
            empId: $("#empIdAdd").val()
        }
    };

    $.ajax({
        url: "/interview",
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(interview),
        success: (res) => {
            table.ajax.reload();
            successAlert("Interview Created");
            $("#interviewModalAdd").modal("hide");
        },
        error: (err) => {
            errorAlert("Interview Failed Created");
        }
    });
}

function update(id) {
    interview = {
        interviewId: $("#interviewIdEdit").val(),
        interviewDate: $("#interviewDateEdit").val(),
        resultDate: $("#resultDateEdit").val(),
        result: $("#resultEdit").val(),
        status: $("#statusEdit").val(),
        interviewVia: $("#interviewViaEdit").val(),
        note: $("#noteEdit").val(),
        clientId: {
            clientId: $("#clientIdEdit").val()
        },
        empId: {
            empId: $("#empIdEdit").val()
        }
    };

    $.ajax({
        url: `/interview/${this.id}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(interview),
        success: (res) => {
            table.ajax.reload();
            successAlert("Interview Updated");
            $("#interviewModalEdit").modal("hide");
        },
        error: (err) => {
            errorAlert("Interview Failed Updated");
        }
    });
}

function update2(id) {
    interview = {
        interviewId: $("#interviewIdReject").val(),
        interviewDate: $("#interviewDateReject").val(),
        resultDate: $("#resultDateReject").val(),
        result: $("#resultReject").val(),
        status: $("#statusReject").val(),
        interviewVia: $("#interviewViaReject").val(),
        note: $("#noteReject").val(),
        clientId: {
            clientId: $("#clientIdReject").val()
        },
        empId: {
            empId: $("#empIdReject").val()
        }
    };

    $.ajax({
        url: `/interview/${this.id}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(interview),
        success: (res) => {
            table.ajax.reload();
            successAlert("Interview Updated");
            $("#interviewModalReject").modal("hide");
        },
        error: (err) => {
            errorAlert("Interview Failed Updated");
        }
    });
}

//function deleteById(id) {
//    questionAlert("Are you sure?", "Do you want to delete this data?", () => {
//        $.ajax({
//            url: `/interview/${id}`,
//            type: 'DELETE',
//            success: (res) => {
//                table.ajax.reload();
//                successAlert("Interview Deleted");
//            }
//        });
//    });
//}

function setForm(data) {
    $("#interviewIdEdit").val(data.interviewId);
    $("#interviewDateEdit").val(data.interviewDate);
//    $("#resultEdit").val(data.result);
//    $("#resultDateEdit").val(data.resultDate);
    $("#statusEdit").val(data.status);
    $("#interviewViaEdit").val(data.interviewVia);
    $("#noteEdit").val(data.note);
    $("#clientIdEdit").val(data.clientId.clientId);
    $("#empIdEdit").val(data.empId.empId);
}

function setForm2(data) {
    $("#interviewIdReject").val(data.interviewId);
    $("#interviewDateReject").val(data.interviewDate);
//    $("#resultReject").val(data.result);
//    $("#resultDateReject").val(data.resultDate);
    $("#statusReject").val(data.status);
    $("#interviewViaReject").val(data.interviewVia);
    $("#noteReject").val(data.note);
    $("#clientIdReject").val(data.clientId.clientId);
    $("#empIdReject").val(data.empId.empId);
}

function clearForm() {
    idInterview = 0;
    $("#interviewId").val("");
    $("#interviewDate").val("");
    $("#resultDate").val("");
    $("#result").val("");
    $("#clientId").val("");
    $("#empId").val("");
}

$(function () {
    var dtToday = new Date();

    var month = dtToday.getMonth() + 1;
    var day = dtToday.getDate();
    var year = dtToday.getFullYear();
    if (month < 10)
        month = '0' + month.toString();
    if (day < 10)
        day = '0' + day.toString();

    var maxDate = year + '-' + month + '-' + day;

    $('#interviewDateAdd').attr('min', maxDate);
});

$('#interviewViaAdd').on('change', function () {
    var selection = $(this).val();
    $('#noteAdd').toggle($(this).val() == "ONLINE");
    $('#notelabel').toggle($(this).val() == "ONLINE");
});