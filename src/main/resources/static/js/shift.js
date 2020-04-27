function searchshift() {

    $('#shiTable').bootstrapTable("destroy");

    loadByShift();
}



function loadByShift() {

    $('#shiTable').bootstrapTable({
        url: '/webapi/employees/getbypageshift',
        striped: true,
        pagination: true,
        singleSelect: false,
        pageSize: 3,
        pageNumber: 1,
        sidePagination: "server",
        queryParams: function(params) {

            var paraObj = {
                size: params.limit,
                page: params.offset / params.limit,
                sort: "id",
                direct: "desc",
                shift: $("#searchShift").val(),
            };

            return paraObj;
        },
        columns: [{
            field: 'id',
            title: '序号'
        }, {
            field: 'name',
            title: '姓名'
        }, {
            field: 'gender',
            title: '性别',
            formatter: function(value, row, index) {

                if (row.gender == 1) {
                    return "男";
                } else if (row.gender == 0) {
                    return "女";
                }
            }
        }, {
            field: 'shift',
            title: '班次'
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

    loadByShift();

});