function search() {

    $('#casTable').bootstrapTable("destroy");
    loadTable();
}

function searchproduct() {

    $('#casTable').bootstrapTable("destroy");
    loadProduct();

}

function searchcardnumber(){

    $('#casTable').bootstrapTable("destroy");
    loadCardnumber();
}


function preAdd() {

    $("#id").val(0);

}

function saveCast() {

    var num = $("#numberof").val() * $("#unitprice").val();

    $("#paidin").val(num);

    $("#receivableamount").val(num);

    $("#cumulative").val(num);

    if ($("#receivableamount").val(num)>0){

        var now = new Date();
        var year = now.getFullYear();
        var month = now.getMonth()+1;
        var date = now.getDate();
        var hour = now.getHours();//得到小时
        var minu = now.getMinutes();//得到分钟

        var nowtime = year +"年-"+month+"月-"+date+"日-"+hour+"点-"+minu+"分";

        $("#comeontime").val(nowtime);
    }

    var data = $("#formCast").serialize();

    var id = $("#id").val();

    if (id < 1) {

        $.ajax({
            url: '/webapi/cast/insert',
            method: 'post',
            data: data

        }).done(function() {

            loadTable();

            $('#myModal').modal('hide')

        })

    } else {

        $.ajax({
            url: '/webapi/cast/update',
            method: 'put',
            data: data

        }).done(function() {

            loadTable();

            $('#myModal').modal('hide')

        })
    }

    var nameoftank = $("#nameoftank").val();

    var numb = $("#numberof").val();

    $.ajax({
        url:"/webapi/tank/getby/" + nameoftank
    }).done(function(rs){

        rs.stockupseveral = rs.stockupseveral - numb;

        var da = {
            id:rs.id,
            nameoftank:rs.nameoftank,
            product:rs.product,
            categories:rs.categories,
            inventorytonnage:rs.inventorytonnage,
            conversionratio:rs.conversionratio,
            inventoryfloor:rs.inventoryfloor,
            stockupseveral:rs.stockupseveral,
            retailprice:rs.retailprice,
            note:rs.note,
            dateregistration:rs.dateregistration
        }

        $.ajax({
            url:"/webapi/tank/update",
            method:"put",
            data:da
        })
    })
}

function editCast(id) {

    $('#myModal').modal('show');

    $.ajax({
        url: '/webapi/cast/get/' + id

    }).done(function(rs) {

        $('#id').val(rs.id);
        $('#cardnumber').val(rs.cardnumber);
        $('#lplatenumber').val(rs.lplatenumber);
        $('#nameoftank').val(rs.nameoftank);
        $('#product').val(rs.product);
        $('#numberof').val(rs.numberof);
        $('#unitprice').val(rs.unitprice);
        $('#receivableamount').val(rs.receivableamount);
        $('#paidin').val(rs.paidin);
        $('#comeontime').val(rs.comeontime);
        $('#termsofpayment').val(rs.termsofpayment);
        $('#cumulative').val(rs.cumulative);

    })

}


function loadProduct() {

    $('#casTable').bootstrapTable({
        url: '/webapi/cast/getbypageproduct',
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
            field: 'cardnumber',
            title: '卡号'
        }, {
            field: 'lplatenumber',
            title: '车牌号码'
        }, {
            field: 'nameoftank',
            title: '油罐名称'
        }, {
            field: 'product',
            title: '油品名称'
        }, {
            field: 'numberof',
            title: '数量'
        }, {
            field: 'unitprice',
            title: '单价'
        }, {
            field: 'receivableamount',
            title: '应收金额'
        }, {
            field: 'paidin',
            title: '实收金额'
        }, {
            field: 'comeontime',
            title: '加油时间'
        }, {
            field: 'termsofpayment',
            title: '付款方式'
        }, {
            field: 'cumulative',
            title: '累积消费'
        }]
    });

}

function loadCardnumber() {

    $('#casTable').bootstrapTable({
        url: '/webapi/cast/getbypagecardnumber',
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
                cardnumber: $("#searchCardnumber").val(),
            };

            return paraObj;
        },
        columns: [{
            field: 'id',
            title: '序号'
        }, {
            field: 'cardnumber',
            title: '卡号'
        }, {
            field: 'lplatenumber',
            title: '车牌号码'
        }, {
            field: 'nameoftank',
            title: '油罐名称'
        }, {
            field: 'product',
            title: '油品名称'
        }, {
            field: 'numberof',
            title: '数量'
        }, {
            field: 'unitprice',
            title: '单价'
        }, {
            field: 'receivableamount',
            title: '应收金额',
            formatter:function (value,row,index) {

                var totl;

                totl = row.numberof * row.unitprice;

                return totl;
            }
        }, {
            field: 'paidin',
            title: '实收金额',
            formatter:function (value ,row,index) {

                var tru;

                tru = row.numberof * row.unitprice;

                return tru;
            }
        }, {
            field: 'comeontime',
            title: '加油时间'
        }, {
            field: 'termsofpayment',
            title: '付款方式'
        }, {
            field: 'cumulative',
            title: '累积消费'
        }]
    });


}//end of loadTable


function loadTable() {

    $('#casTable').bootstrapTable({
        url: '/webapi/cast/getbypagenameoftank',
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
            field: 'cardnumber',
            title: '卡号'
        }, {
            field: 'lplatenumber',
            title: '车牌号码'
        }, {
            field: 'nameoftank',
            title: '油罐名称'
        }, {
            field: 'product',
            title: '油品名称'
        }, {
            field: 'numberof',
            title: '数量'
        }, {
            field: 'unitprice',
            title: '单价'
        }, {
            field: 'receivableamount',
            title: '应收金额'
        }, {
            field: 'paidin',
            title: '实收金额'
        }, {
            field: 'comeontime',
            title: '加油时间'
        }, {
            field: 'termsofpayment',
            title: '付款方式'
        }, {
            field: 'cumulative',
            title: '累积消费'
        }]
    });

}

$(function() {

    loadTable();

});