function search() {

    $('#addTable').bootstrapTable("destroy");
    loadTable();
}

function searchaddress() {

    $('#addTable').bootstrapTable("destroy");
    loadAddress();

}

function preAdd() {

    $("#id").val(0);

}

function saveSupplier() {

    var data = $("#formSupplier").serialize();

    var id = $("#id").val();

    if (id < 1) {

        $.ajax({
            url: '/webapi/supplier/insert',
            method: 'post',
            data: data

        }).done(function() {

            loadTable();

            $('#myModal').modal('hide')

        })

    } else {

        $.ajax({
            url: '/webapi/supplier/update',
            method: 'put',
            data: data

        }).done(function() {

            loadTable();

            $('#myModal').modal('hide')

        })
    }
}

function editSupplier(id) {

    $('#myModal').modal('show');

    $.ajax({
        url: '/webapi/supplier/get/' + id

    }).done(function(rs) {

        $('#id').val(rs.id);
        $('#name').val(rs.name);
        $('#address').val(rs.address);
        $('#thecontact').val(rs.thecontact);
        $('#phone').val(rs.phone);
        $('#fax').val(rs.fax);
        $('#email').val(rs.email);
        $('#ein').val(rs.ein);
        $('#whereitis').val(rs.whereitis);
        $('#note').val(rs.note);
        $('#dateregistration').val(rs.dateregistration);

    })

}

function deleteSupplier(id) {

    if (confirm("确定删除？!")) {

        $.ajax({
            url: '/webapi/supplier/delete/' + id,
            method: 'delete'

        }).done(function() {

            loadTable();

        });

    }
}

function loadAddress() {

    $('#addTable').bootstrapTable({
        url: '/webapi/supplier/getbypage',
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
                address: $("#searchAddress").val(),
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
            field: 'address',
            title: '地址'
        }, {
            field: 'thecontact',
            title: '联系人'
        }, {
            field: 'phone',
            title: '电话'
        }, {
            field: 'fax',
            title: '传真号'
        }, {
            field: 'email',
            title: '电子邮件'
        }, {
            field: 'ein',
            title: '税号'
        }, {
            field: 'whereitis',
            title: '开户行'
        }, {
            field: 'note',
            title: '备注'
        }, {
            field: 'dateregistration',
            title: '登记日期'
        }, {
            field: '...',
            title: '操作',
            formatter: addBtton,
            events: {
                'click #edit': function (event, value, row, index){
                    editSupplier(row.id);
                },
                'click #dele': function(event, value, row, index){
                    deleteSupplier(row.id);
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

    $('#addTable').bootstrapTable({
        url: '/webapi/supplier/getbypageaddress',
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
            field: 'address',
            title: '地址'
        }, {
            field: 'thecontact',
            title: '联系人'
        }, {
            field: 'phone',
            title: '电话'
        }, {
            field: 'fax',
            title: '传真号'
        }, {
            field: 'email',
            title: '电子邮件'
        }, {
            field: 'ein',
            title: '税号'
        }, {
            field: 'whereitis',
            title: '开户行'
        }, {
            field: 'note',
            title: '备注'
        }, {
            field: 'dateregistration',
            title: '登记日期'
        }, {
            field: '...',
            title: '操作',
            formatter: addBtton,
            events: {
                'click #edit': function (event, value, row, index){
                    editSupplier(row.id);
                },
                'click #dele': function(event, value, row, index){
                    deleteSupplier(row.id);
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