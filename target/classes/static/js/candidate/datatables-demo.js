let interview = new Object();
let id = 0;

//FOR PAGINATION
let totalRecords = 0;
let records = [];
let displayRecords = [];
let recPerPage = 3;
let page = 1;
let totalPages = 0;


$(document).ready(() => {
    getCardDevelop();

    $("#formModalAdd").submit((e) => {
        e.preventDefault();
        formValidation(create);
    });
});

function getCardDevelop() {
    $.ajax({
        url: '/employee/get-all-skill',
        type: 'GET',
        async: true,
        dataType: 'json',
        success: function (data) {
            records = data;
//            console.log(records);

            Object.filter = (obj, predicate) =>
                Object.keys(obj)
                        .filter(key => predicate(obj[key]))
                        .reduce((data, key) => Object.assign(data, {[key]: obj[key]}), {});

            var filtered = Object.filter(data, s => s.empskills[0]);

            console.log(filtered);
            
            console.log(records);

            var keyArr = [];
            var count = Object.keys(filtered).length;
            var skillArr = [];
            for (var key in filtered) {
                if (filtered.hasOwnProperty(key)) {
                    keyArr.push(key);
                }
            }
            
            for (let i = 0; i < count; i++) {
                skillArr.push(filtered[keyArr[i]].empskills.length);
            }
            

            for (let j = 0; j < skillArr.length; j++) {
                for (let k = 0; k < skillArr[j]; k++) {
                }
            }

            totalRecords = count;
            totalPages = Math.ceil(totalRecords / recPerPage);
//            console.log(totalPages);
            apply_pagination();
        }
    });
}

function apply_pagination() {
    $("#content").twbsPagination({
        totalPages: totalPages,
        visiblePages: 3,
        onPageClick: function (data, page) {

        Object.filter = (obj, predicate) =>
                Object.keys(obj)
                        .filter(key => predicate(obj[key]))
                        .reduce((records, key) => Object.assign(records, {[key]: obj[key]}), {});

            var filtered = Object.filter(records, s => s.empskills[0]);

            var keyArr = [];
            var count = Object.keys(filtered).length;
            var skillArr = [];
            
            var entries = Object.values(filtered);
            
            for (var key in filtered) {
                if (filtered.hasOwnProperty(key)) {
                    keyArr.push(key);
                }
            }
            
            for (let i = 0; i < count; i++) {
                skillArr.push(filtered[keyArr[i]].empskills.length);
            }

            for (let j = 0; j < skillArr.length; j++) {
                for (let k = 0; k < skillArr[j]; k++) {
                }
            }

            
            displayRecordsIndex = Math.max(page - 1, 0) * recPerPage;
//                  console.log(displayRecordsIndex);
            endRec = (displayRecordsIndex) + recPerPage;

            displayRecords = entries.slice(displayRecordsIndex, endRec);
            
            
            
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

//            console.log(displayRecords);

            let element = "";
            $('#content-candidate').html('');
            for (let i = 0; i < displayRecords.length; i++) {
                element = element +
                        `<div class="col-xl-4 col-sm-6 mb-5">
    <div class="bg-white rounded shadow-sm py-5 px-4">
                <div class="filter-by">
        <img src="${urls[sum]}" alt="" width="100" class="img-fluid rounded-circle mb-3 img-thumbnail shadow-sm">
        <div class="mb-0">${displayRecords[i].empskills[0].empId.name}</div>
        <div class="mb-0">${displayRecords[i].empskills[0].empId.gender}</div>
        <div id="date" class="mb-0">${displayRecords[i].empskills[0].empId.birthDate}</div>
        <div class="mb-0">${displayRecords[i].empskills[0].empId.email}</div>
        <div class="mb-0">${displayRecords[i].empskills[0].empId.jabatan}</div>
        <div class="mb-0">${displayRecords[i].empskills[0].skillId.label}</div>
        <div class="mb-0">${displayRecords[i].empskills[1].skillId.label}</div>
        
        <ul class="social mb-0 list-inline mt-3">
            <li class="list-inline-item"><a href="#" class="social-link"><i class="fa fa-facebook-f"></i></a></li>
            <li class="list-inline-item"><a href="#" class="social-link"><i class="fa fa-twitter"></i></a></li>
            <li class="list-inline-item"><a href="#" class="social-link"><i class="fa fa-instagram"></i></a></li>
            <li class="list-inline-item"><a href="#" class="social-link"><i class="fa fa-linkedin"></i></a></li>
        </ul>
        <div id="content-candidate">
    <br>
    <br>
    <button type="button" onclick="getById('${displayRecords[0].empskills[0].empId.empId}')" class="btn btn-outline-info" data-toggle="modal" data-target="#interviewModalAdd">
                
    Choose Candidate
    </button>
        </div>
    </div>
 </div>
</div>

`;

//                }
            }
            $("#content-candidate").append(element);

//            getAll();
        }
    });
}