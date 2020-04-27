function search() {

    $('#memTable').bootstrapTable("destroy");
    loadTable();
}

function searchgender() {

    $('#memTable').bootstrapTable("destroy");
    loadGender();

}

function searchisvip(){

    $('#memTable').bootstrapTable("destroy");
    loadIsvip();
}

function preAdd() {

    $("#id").val(0);

}

function saveMembers() {

    var yuan = $("#accumulatedtopup").val();

    var cho = $("#topupamount").val();

    if (Number(cho)>0){

        var now = new Date();
        var year = now.getFullYear();
        var month = now.getMonth()+1;
        var date = now.getDate();
        var hour = now.getHours();//得到小时
        var minu = now.getMinutes();//得到分钟

        var nowtime = year +"年-"+month+"月-"+date+"日-"+hour+"点-"+minu+"分";

        $("#topupdate").val(nowtime);

        $("#accumulatedtopup").val(yuan+cho);
    }



    var data = $("#formMembers").serialize();

    var id = $("#id").val();

    if (id < 1) {

        $.ajax({
            url: '/webapi/members/insert',
            method: 'post',
            data: data

        }).done(function() {

            loadTable();

            $('#myModal').modal('hide')

        })

    } else {

        $.ajax({
            url: '/webapi/members/update',
            method: 'put',
            data: data

        }).done(function() {

            loadTable();

            $('#myModal').modal('hide')

        })
    }
}

function editMembers(id) {

    $('#myModal').modal('show');

    $.ajax({
        url: '/webapi/members/get/' + id

    }).done(function(rs) {

        $('#id').val(rs.id);
        $('#membername').val(rs.membername);
        $('#phonenumber').val(rs.phonenumber);
        $('#gender').val(rs.gender);
        $('#cardnumber').val(rs.cardnumber);
        $('#lplatenumber').val(rs.lplatenumber);
        $('#vehicletype').val(rs.vehicletype);
        $('#vehicletypel').val(rs.vehicletypel);
        $('#entity').val(rs.entity);
        $('#carddate').val(rs.carddate);
        $('#address').val(rs.address);
        $('#note').val(rs.note);
        $('#isvip').val(rs.isvip);

    })

}

function deleteMembers(id) {

    if (confirm("确定删除？!")) {

        $.ajax({
            url: '/webapi/members/delete/' + id,
            method: 'delete'

        }).done(function() {

            loadTable();

        });

    }
}

function loadGender() {

    $('#memTable').bootstrapTable({
        url: '/webapi/members/getbypage',
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
            field: 'membername',
            title: '姓名'
        }, {
            field: 'phonenumber',
            title: '联系电话'
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
            field: 'cardnumber',
            title: '卡号'
        }, {
            field: 'vehicletype',
            title: '车辆类型'
        }, {
            field: 'vehicletypel',
            title: '车辆型号'
        }, {
            field: 'entity',
            title: '单位名称'
        }, {
            field: 'carddate',
            title: '办卡日期'
        }, {
            field: 'address',
            title: '地址'
        }, {
            field: 'note',
            title: '备注'
        }, {
            field: 'initialamount',
            title: '初始金额'
        },{
            field: 'isvip',
            title: '是否是会员',
            formatter: function(value, row, index) {

                if (row.isvip == 1) {
                    return "是会员";
                } else if (row.isvip == 0) {
                    return "非会员";
                }
            }
        },{
            field: 'accumulatedtopup',
            title: '累积充值'
        }, {
            field: '...',
            title: '操作',
            formatter: addBtton,
            events: {
                'click #edit': function (event, value, row, index){
                    editMembers(row.id);
                },
                'click #dele': function(event, value, row, index){
                    deleteMembers(row.id);
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

    $('#memTable').bootstrapTable({
        url: '/webapi/members/getbypagemembername',
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
                membername: $("#searchMembername").val(),
            };

            return paraObj;
        },
        columns: [{
            field: 'id',
            title: '序号'
        }, {
            field: 'membername',
            title: '姓名'
        }, {
            field: 'phonenumber',
            title: '联系电话'
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
            field: 'cardnumber',
            title: '卡号'
        }, {
            field: 'lplatenumber',
            title: '车牌号码'
        }, {
            field: 'vehicletype',
            title: '车辆类型'
        }, {
            field: 'vehicletypel',
            title: '车辆型号'
        }, {
            field: 'entity',
            title: '单位名称'
        }, {
            field: 'carddate',
            title: '办卡日期'
        }, {
            field: 'address',
            title: '地址'
        }, {
            field: 'note',
            title: '备注'
        }, {
            field: 'initialamount',
            title: '初始金额'
        }, {
            field: 'isvip',
            title: '是否是会员',
            formatter: function(value, row, index) {

                if (row.isvip == 1) {
                    return "是会员";
                } else if (row.isvip == 0) {
                    return "非会员";
                }
            }
        }, {
            field: 'accumulatedtopup',
            title: '累积充值'
        },{
            field: '...',
            title: '操作',
            formatter: addBtton,
            events: {
                'click #edit': function (event, value, row, index){
                    editMembers(row.id);
                },
                'click #dele': function(event, value, row, index){
                    deleteMembers(row.id);
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


}//end of loadTable

function loadIsvip() {

    $('#memTable').bootstrapTable({
        url: '/webapi/members/getbypageisvip',
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
                isvip: $("#searchIsvip").val(),
            };

            return paraObj;
        },
        columns: [{
            field: 'id',
            title: '序号'
        }, {
            field: 'membername',
            title: '姓名'
        }, {
            field: 'phonenumber',
            title: '联系电话'
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
            field: 'cardnumber',
            title: '卡号'
        }, {
            field: 'originalamount',
            title: '原始金额'
        }, {
            field: 'lplatenumber',
            title: '车牌号码'
        }, {
            field: 'vehicletype',
            title: '车辆类型'
        }, {
            field: 'vehicletypel',
            title: '车辆型号'
        }, {
            field: 'entity',
            title: '单位名称'
        }, {
            field: 'carddate',
            title: '办卡日期'
        }, {
            field: 'address',
            title: '地址'
        }, {
            field: 'note',
            title: '备注'
        }, {
            field: 'initialamount',
            title: '初始金额'
        },{
            field: 'isvip',
            title: '是否是会员',
            formatter: function(value, row, index) {

                if (row.isvip == 1) {
                    return "是会员";
                } else if (row.isvip == 0) {
                    return "非会员";
                }
            }
        }, {
            field: 'accumulatedtopup',
            title: '累积充值'
        }, {
            field: '...',
            title: '操作',
            formatter: addBtton,
            events: {
                'click #edit': function (event, value, row, index){
                    editMembers(row.id);
                },
                'click #dele': function(event, value, row, index){
                    deleteMembers(row.id);
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