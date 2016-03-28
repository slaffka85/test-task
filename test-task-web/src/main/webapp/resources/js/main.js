drawEmployeeTable = function(data) {
    var $employeeTable = $("#employee_table");
    $employeeTable.html('')
    $employeeTable.append('<tr><td>id</td><td>name</td><td>email</td><td>phone</td></tr>')
    $(data).each(function () {
        $employeeTable
            .append('<tr>' +
            '<td>' + this.id + '</td>' +
            '<td>' + this.name + '</td>' +
            '<td>' + this.email + '</td>' +
            '<td>' + this.phone + '</td>' +
            '</tr>');
    });
}

fillEmployeeTable = function() {
    $.ajax({
        method: "GET",
        cache: false,
        url: "employeeServlet",
        success: function (data) {
            if (data !== null && data !== 'undefined' && data.length !== 0) {
                drawEmployeeTable(data);
            }
        }
    });
}

addNewEmployee = function() {
    var employee = {};
    employee.name = $('#employee_form #employee_name').val();
    employee.email = $('#employee_form #employee_email').val();
    employee.phone = $('#employee_form #employee_phone').val();

    $.ajax({
        url: 'employeeServlet',
        method: "POST",
        dataType: 'json',
        data: JSON.stringify(employee),
        complete: function () {
            fillEmployeeTable();
        }
    });
}

$(document).ready(function(){
    fillEmployeeTable();

    $("#add_employee_btn").click(function() {
        addNewEmployee();
    });
});
