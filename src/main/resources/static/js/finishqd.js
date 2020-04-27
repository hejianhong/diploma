function loadTable() {

    $('#empTable').bootstrapTable({
        url: '/webapi/employees/getbypagename',
        striped: true,
        pagination: true,
        singleSelect: false,
        pageSize: 3,
        pageNumber: 1,
        sidePagination: "server",

        columns: [{
            field: 'id',
            title: '序号'
        }, {
            field: 'name',
            title: '姓名'
        }, {
            field: 'note',
            title: '备注'
        }, {
            field: 'number',
            title: '员工号'
        }]
    });


} //end of loadTable

$(function() {

    loadTable();

});