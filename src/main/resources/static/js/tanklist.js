function search() {

    $('#tanTable').bootstrapTable("destroy");
    loadTable();
}

function searchproduct() {

    $('#tanTable').bootstrapTable("destroy");
    loadProduct();

}

function preAdd() {

    $("#id").val(0);

}

function saveTank() {

    var data = $("#formTank").serialize();

    var id = $("#id").val();

    if (id < 1) {

        $.ajax({
            url: '/webapi/tank/insert',
            method: 'post',
            data: data

        }).done(function() {

            loadTable();

            $('#myModal').modal('hide')

        })

    } else {

        $.ajax({
            url: '/webapi/tank/update',
            method: 'put',
            data: data

        }).done(function() {

            loadTable();

            $('#myModal').modal('hide')

        })
    }
}

function editTank(id) {

    $('#myModal').modal('show');

    $.ajax({
        url: '/webapi/tank/get/' + id

    }).done(function(rs) {

        $('#id').val(rs.id);
        $('#nameoftank').val(rs.nameoftank);
        $('#product').val(rs.product);
        $('#categories').val(rs.categories);
        $('#inventorytonnage').val(rs.inventorytonnage);
        $('#conversionratio').val(rs.conversionratio);
        $('#inventoryfloor').val(rs.inventoryfloor);
        $('#stockupseveral').val(rs.stockupseveral);
        $('#retailprice').val(rs.retailprice);
        $('#note').val(rs.note);
        $('#dateregistration').val(rs.dateregistration);

    })

}

function deleteTank(id) {

    if (confirm("确定删除？!")) {

        $.ajax({
            url: '/webapi/tank/delete/' + id,
            method: 'delete'

        }).done(function() {

            loadTable();

        });

    }
}

function loadProduct() {

    $('#tanTable').bootstrapTable({
        url: '/webapi/tank/getbypage',
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
                product: $("#searchProduct").val(),
            };

            return paraObj;
        },
        columns: [{
            field: 'id',
            title: '序号'
        }, {
            field: 'nameoftank',
            title: '油罐名称'
        }, {
            field: 'product',
            title: '油品名称'
        }, {
            field: 'categories',
            title: '油品种类'
        }, {
            field: 'inventorytonnage',
            title: '库存吨数'
        }, {
            field: 'conversionratio',
            title: '转换比例'
        }, {
            field: 'inventoryfloor',
            title: '库存下限'
        }, {
            field: 'stockupseveral',
            title: '库存升数',
            formatter:function (value,row,index) {
                var a = '<span>'+value+'</span>';
                if (value<=10){
                    a = '<span style="color: red">'+value+'</span>';
                    alert(row.nameoftank+"库存不足!请及时补充");
                }
                return a;
            }
        }, {
            field: 'retailprice',
            title: '零售价格'
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
                    editTank(row.id);
                },
                'click #dele': function(event, value, row, index){
                    deleteTank(row.id);
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

    $('#tanTable').bootstrapTable({
        url: '/webapi/tank/getbypageproduct',
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
                nameoftank: $("#searchNameoftank").val(),
            };

            return paraObj;
        },
        columns: [{
            field: 'id',
            title: '序号'
        }, {
            field: 'nameoftank',
            title: '油罐名称'
        }, {
            field: 'product',
            title: '油品名称'
        }, {
            field: 'categories',
            title: '油品种类'
        }, {
            field: 'inventorytonnage',
            title: '库存吨数'
        }, {
            field: 'conversionratio',
            title: '转换比例'
        }, {
            field: 'inventoryfloor',
            title: '库存下限'
        }, {
            field: 'stockupseveral',
            title: '库存升数',
            formatter:function (value,row,index) {
                var a = '<span>'+value+'</span>';
                if (value<=10){
                    a = '<span style="color: red">'+value+'</span>';
                    alert(row.nameoftank+"库存不足!请及时补充");
                }
                return a;
            }
        }, {
            field: 'retailprice',
            title: '零售价格'
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
                    editTank(row.id);
                },
                'click #dele': function(event, value, row, index){
                    deleteTank(row.id);
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