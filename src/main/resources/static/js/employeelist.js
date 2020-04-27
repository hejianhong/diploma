function search() {

    $('#empTable').bootstrapTable("destroy");
    loadTable();
}

function searchgender() {

    $('#empTable').bootstrapTable("destroy");
    loadGender();

}

function preAdd() {

    $("#id").val(0);

}

function saveEmployees() {

    var data = $("#formEmployees").serialize();

    var id = $("#id").val();

    if (id < 1) {

        $.ajax({
            url: '/webapi/employees/insert',
            method: 'post',
            data: data

        }).done(function() {

            loadTable();

            $('#myModal').modal('hide')

        })

    } else {

        $.ajax({
            url: '/webapi/employees/update',
            method: 'put',
            data: data

        }).done(function() {

            loadTable();

            $('#myModal').modal('hide')

        })
    }
}

function editEmployees(id) {

    $('#myModal').modal('show');

    $.ajax({
        url: '/webapi/employees/get/' + id

    }).done(function(rs) {

        $('#id').val(rs.id);
        $('#name').val(rs.name);
        $('#phonenumber').val(rs.phonenumber);
        $('#gender').val(rs.gender);
        $('#shift').val(rs.shift);
        $('#address').val(rs.address);
        $('#registration').val(rs.registration);
        $('#note').val(rs.note);
        $('#number').val(rs.number);

    })

}

function deleteEmployees(id) {

    if (confirm("确定删除？!")) {

        $.ajax({
            url: '/webapi/employees/delete/' + id,
            method: 'delete'

        }).done(function() {

            loadTable();

        });

    }
}

function loadGender() {

    $('#empTable').bootstrapTable({
        url: '/webapi/employees/getbypage',
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
                gender: $("#searchGender").val(),
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
            field: 'phonenumber',
            title: '电话'
        }, {
            field: 'shift',
            title: '班次'
        }, {
            field: 'address',
            title: '地址'
        }, {
            field: 'registration',
            title: '登记日期'
        }, {
            field: 'note',
            title: '备注'
        }, {
            field: 'number',
            title: '员工号'
        }, {
            field: '...',
            title: '操作',
            formatter: addBtton,
            events: {
                'click #edit': function (event, value, row, index){
                    editEmployees(row.id);
                },
                'click #dele': function(event, value, row, index){
                    deleteEmployees(row.id);
                }
            }
        }]
    });

    function addBtton(){

        var html =
            '<a id="edit"><i class="fa fa-pencil-square-o fa-2x" style="color: goldenrod" title="编辑"></i></a>'
            + '<span>  </span>'+'<a id="dele"><i class="fa fa-trash-o fa-2x" style="color: red" title="删除"></i> </a>'

        return html;
    }

}


function loadTable() {

    $('#empTable').bootstrapTable({
        url: '/webapi/employees/getbypagename',
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
                name: $("#searchName").val(),
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
            field: 'phonenumber',
            title: '电话'
        }, {
            field: 'shift',
            title: '班次'
        }, {
            field: 'address',
            title: '地址'
        }, {
            field: 'registration',
            title: '登记日期'
        }, {
            field: 'note',
            title: '备注'
        }, {
            field: 'number',
            title: '员工号'
        }, {
            field: '..',
            title: '操作',
            formatter: addBtton,
            events: {
                'click #edit': function (event, value, row, index){
                    editEmployees(row.id);
                },
                'click #dele': function(event, value, row, index){
                    deleteEmployees(row.id);
                }
            }
        }]
    });

    function addBtton(){

        var html =
            '<a id="edit"><i class="fa fa-pencil-square-o fa-2x"  style="color:goldenrod " title="编辑"></i></a>'
            + '<span>  </span>'+ '<a id="dele"><i class="fa fa-trash-o fa-2x"  style="color: red" title="删除"></i> </a>'
        return html;
    }


} //end of loadTable

$(function() {

    loadTable();

});