function onloading_1(){
    document.getElementById("button1").click();
    document.getElementById("button1").click();
}


function onClickAddFlight() {
    let plate_number = document.querySelector('form input[name = "plate-number"]').value;
    // 粤B A1B2X | 粤B(D/F)7D99W
    let Entrance_Number = document.querySelector('form input[name = "Entrance_Number"]').value;
    // 1~7
    let staff_numbers = document.querySelector('form input[name = "staff_numbers"]').value;
    // 8位数字,3/5开头
    // let year = document.querySelector('form input [id = "year"]');
    // let month = document.querySelector('form input [id = "month"]');
    // let day = document.querySelector('form input [id = "day"]');
    let year = document.getElementById('year').value;
    let month = document.getElementById('month').value;
    let day = document.getElementById('day').value;
    let ahour = document.querySelector('form select[id = "ahour"]').value;
    let aminute = document.querySelector('form select[id = "aminute"]').value;
    let dhour = document.querySelector('form select[id = "dhour"]').value;
    let dminute = document.querySelector('form select[id = "dminute"]').value;
    // 出发时间在到达时间之后 D after than A
    //牌照号码,日期,ArrivalTime为主键
    //若Status为In,Departure Time为'--'
    if (validateInput(plate_number, Entrance_Number, staff_numbers, year, month, day, ahour, aminute, dhour, dminute)) {
        addRow();
        alert("Success!");
    }
}

function addRow() {
    let bodyObj = document.getElementById('tbody');
    if (bodyObj == null) {
        alert("Body of Table not exist");
        return;
    }
    let year = document.getElementById('year').value;
    let month = document.getElementById('month').value;
    let day = document.getElementById('day').value;
    let dhour = document.getElementById('dhour').value;
    let dminute = document.getElementById('dminute').value;
    let ahour = document.getElementById('ahour').value;
    let aminute = document.getElementById('aminute').value;
    let rowCount = bodyObj.rows.length;
    let cellCount = bodyObj.rows[0].cells.length;
    let status = document.getElementsByName("status");
    bodyObj.style.display = "";
    let newRow = bodyObj.insertRow(rowCount++);
    newRow.insertCell(0).innerHTML = "粤B" + document.forms[0]["plate-number"].value;
    newRow.insertCell(1).innerHTML = document.forms[0]["Entrance_Number"].value;
    newRow.insertCell(2).innerHTML = year + "." + month + "." + day;
    newRow.insertCell(3).innerHTML = ahour + ":" + aminute;
    newRow.insertCell(4).innerHTML = (status[0].checked  === true ?"--": (dhour + ":" + dminute));
    newRow.insertCell(5).innerHTML = document.forms[0]["staff_name"].value;
    newRow.insertCell(6).innerHTML = document.forms[0]["staff_numbers"].value;
    newRow.insertCell(7).innerHTML = (status[0].checked === true ?"In":"Out");
    newRow.insertCell(8).innerHTML = bodyObj.rows[0].cells[cellCount - 1].innerHTML;
    bodyObj.rows[0].style.display = "none";

}

function validateInput(plate_number, Entrance_Number, staff_numbers, year, month, day, ahour, aminute, dhour, dminute) {
    let plate_NumberRegex_1 = new RegExp(/^[A-Z0-9]{5}$/);
    let plate_NumberRegex_2 = new RegExp(/^[DF][A-Z0-9]{5}$/)
    let entrance_NumberRegex = new RegExp(/^[1-7]$/);
    let staff_numbersRegex = new RegExp(/^[35][0-9]{7}$/);
    let datas = getTableContent('table');
    let Judgement_data_single = true;
    let status = document.getElementsByName('status');
    if (!status[0].checked && !status[1].checked){
        alert("you must choose one status!");
        return false;
    }
    if (!plate_NumberRegex_1.test(plate_number) && !plate_NumberRegex_2.test(plate_number)) {
        alert("Invalid plateNumber");
        return false;
    }
    if (!entrance_NumberRegex.test(Entrance_Number)) {
        alert("Invalid Entrance Number.");
        return false;
    }
    if
    (!staff_numbersRegex.test(staff_numbers)) {
        alert("Invalid staff numbers.");
        return false;
    }
    if ((ahour > dhour) || (ahour == dhour && aminute >= dminute)) {
        alert("Departure Time Must be after the Arrival Time!")
        return false;
    }

    for(let i = 2; i < datas.length; i++){
        if (datas[i][0] === ("粤B"+plate_number) && datas[i][2] === (year + "." + month + "." + day) && datas[i][3] === (ahour + ":" + aminute)) {
            Judgement_data_single = false;
        }
    }
    if (!Judgement_data_single) {
        alert("There already exist one plate number in this time!")
        return false;
    }
    return true;
}

function getTableContent(id) {
    var table = document.getElementById(id);
    var data = [];
    rows = table.rows.length;
    for(var i = 0; i < rows; i++){
        cells = table.rows[i].cells.length;
        if (!data[i]) {
            data[i] = [];
        }
        for(var j = 0; j < cells; j++){
            data[i][j] = table.rows[i].cells[j].innerHTML;
        }
    }
    return data;
}

function initial() {
    initial_Fact("year", 2000, 2020, 1);
    initial_Fact("dhour", 0, 23, 1);
    initial_Fact("dminute", 0, 55, 5);
    initial_Fact("ahour", 0, 23, 1);
    initial_Fact("aminute", 0, 55, 5);
    onloading_1();
    //initial_Addition("aminute", 0, 55, 5, "+1");
}

function initial_Fact(Str, begin, end, middle) {
    let temp = document.getElementById(Str);
    temp.innerHTML = "";
    temp.options.add(new Option("--", null));
    for(let i = begin; i <= end; i += middle){
        if (RegExp(/^[0-9]$/).test(i)){
            temp.options.add(new Option("0"+i, "0"+i));
        }else{
            temp.options.add(new Option(i, i));
        }
    }
}

function initial_Addition(Str, begin, end, middle, addention) {
    let temp = document.getElementById(Str);
    for(let i = begin; i <= end; i += middle){
        temp.options.add(new Option((i + addention), (i + addention)))
    }
}

function setMonth() {
    let month = document.getElementById("month");
    month.innerHTML = "";
    month.options.add(new Option("--", null));
    for(let i = 1; i <= 12; i++){
        month.options.add(new Option(i, i));
    }
    setDay();
}

function setDay() {
    let year = document.getElementById("year").value;
    let month = document.getElementById("month").value;
    let day = document.getElementById("day");
    let dayNumber = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    day.innerHTML = "";
    day.options.add(new Option("--", null));
    for(let i = 1; i <= dayNumber[month - 1]; i++){
        day.options.add(new Option(i, i));
    }
    if (month === 2 && ((year % 4 === 0 && year % 100 !== 0) || (year % 400 === 0))) {
        day.options.add(new Option(29, 29));
    }
}


function removeRow(inputobj) {
    if (inputobj == null) return;
    let parentTD = inputobj.parentNode;
    let parentTR = parentTD.parentNode;
    let parentTBODY = parentTR.parentNode;
    parentTBODY.removeChild(parentTR);
}
