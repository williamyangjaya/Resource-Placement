let interview = new Object();
let id = 0;
$(document).ready(() => {
    getAll();

    $("#formModalAdd").submit((e) => {
        e.preventDefault();
        formValidation(create);
    });
});

function getAll() {
    $.ajax({
        url: "/employee/get-all-skill",
        type: "GET",
        success: (res) => {
//            arr.push(filtered);
//            console.log(arr);
//            var filtered = Object.fromEntries(
//                    Object.entries(res).filter(([key,value])=> console.log(value.empskills)));
//            console.log(filtered);

//            var newArray = res.filter(e => console.log(e.empskills));
//                console.log(el.empskills.length>0);
//                return el.empskills;
//                return el[0].empId.jabatan == "Developer";

//            var arr = [];
//            arr = [...arr, filtered];

//            var x = JSON.parse(JSON.stringify(arr[0]));
//            console.log(x.property_actually_now_defined);

            Object.filter = (obj, predicate) =>
                Object.keys(obj)
                        .filter(key => predicate(obj[key]))
                        .reduce((res, key) => Object.assign(res, {[key]: obj[key]}), {});

            var filtered = Object.filter(res, s => s.empskills[0]);

            var urls = ["https://d19m59y37dris4.cloudfront.net/university/1-1-1/img/teacher-4.jpg",
                "https://i.ibb.co/8YqjHnR/asd1.png",
                "https://i.ibb.co/2sVtBWW/p1.png",
                "https://i.ibb.co/kDHtTfP/p2.png",
                "https://i.ibb.co/84QVf2J/p1.png",
                "https://i.ibb.co/H471Zmw/l1.png",
                "https://i.ibb.co/pyTTnJQ/2.png",
                "https://i.ibb.co/CsKsPTF/1.png",
                "https://i.ibb.co/pxKzqqs/4.png",
                "https://i.ibb.co/TRpVMY2/3.png"
            ];

            let element = "";
            var keyArr = [];
            var count = Object.keys(filtered).length;
            var skillArr = [];
            for (var key in filtered) {
                if (filtered.hasOwnProperty(key)) {
                    keyArr.push(key);
//                    console.log(key + " -> " + filtered[key]);
                }
            }

            for (let i = 0; i < count; i++) {
                skillArr.push(filtered[keyArr[i]].empskills.length);
//                console.log(filtered[keyArr[i]].empskills.length);
            }
//            console.log(skillArr);

//        <div class="mb-0">${filtered[keyArr[i]].empskills[1].skillId.label}</div>

            for (let j = 0; j < skillArr.length; j++) {
                for (let k = 0; k < skillArr[j]; k++) {
//                    console.log(k);
                }
            }
            
//            console.log(count);
//            console.log(skillArr.length);
            for (let i = 0; i < count; i++) {
//                for (let j = 0; j < skillArr[i]; j++) {
//                    console.log(filtered[0].empskills[0].skillId.label);
                    element = element +
                            `<div class="col-xl-4 col-sm-6 mb-5">
    <div class="bg-white rounded shadow-sm py-5 px-4">
        <img src="${urls[i]}" alt="" width="100" class="img-fluid rounded-circle mb-3 img-thumbnail shadow-sm">
        <div class="mb-0">${filtered[keyArr[i]].empskills[0].empId.name}</div>
        <div class="mb-0">${filtered[keyArr[i]].empskills[0].empId.gender}</div>
        <div id="date" class="mb-0">${filtered[keyArr[i]].empskills[0].empId.birthDate}</div>
        <div class="mb-0">${filtered[keyArr[i]].empskills[0].empId.email}</div>
        <div class="mb-0">${filtered[keyArr[i]].empskills[0].empId.jabatan}</div>
        <div class="mb-0">${filtered[keyArr[i]].empskills[0].skillId.label}</div>
        <div class="mb-0">${filtered[keyArr[i]].empskills[1].skillId.label}</div>
        
        <ul class="social mb-0 list-inline mt-3">
            <li class="list-inline-item"><a href="#" class="social-link"><i class="fa fa-facebook-f"></i></a></li>
            <li class="list-inline-item"><a href="#" class="social-link"><i class="fa fa-twitter"></i></a></li>
            <li class="list-inline-item"><a href="#" class="social-link"><i class="fa fa-instagram"></i></a></li>
            <li class="list-inline-item"><a href="#" class="social-link"><i class="fa fa-linkedin"></i></a></li>
        </ul>
        <div id="content-candidate">
    <br>
    <br>
    <button type="button" onclick="getById('${filtered[keyArr[i]].empskills[0].empId.empId}')" class="btn btn-outline-info" data-toggle="modal" data-target="#interviewModalAdd">
    Choose Candidate
    </button>
        </div>
    </div>
</div>
`;

//                }
            }
            $("#content-candidate").append(element);
        }
    });
}

function getById(id) {
    this.id = id;
    $.ajax({
        url: `/interview/${id}`,
        type: 'GET',
        success: (res) => {
            setForm(res);
            $("#empName").val(res.empId.empId)
            $("#empName").text(res.empId.name)
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
            empId: $("#empName").val()
        }
    };

    $.ajax({
        url: "/interview",
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(interview),
        success: (res) => {
            console.log(res);
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
            successAlert("Interview Updated");
            $("#interviewModalEdit").modal("hide");
        },
        error: (err) => {
            errorAlert("Interview Failed Updated");
        }
    });
}

function deleteById(id) {
    questionAlert("Are you sure?", "Do you want to delete this data?", () => {
        $.ajax({
            url: `/interview/${id}`,
            type: 'DELETE',
            success: (res) => {
                successAlert("Interview Deleted");
            }
        });
    });
}

function setForm(data) {
    $("#interviewIdEdit").val(data.interviewId);
    $("#interviewDateEdit").val(data.interviewDate);
    $("#resultDateEdit").val(data.resultDate);
    $("#resultEdit").val(data.result);
    $("#clientIdEdit").val(data.clientId.clientId);
    $("#empIdEdit").val(data.empId.empId);
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