function searchcardnumber(){

    $('#topTable').bootstrapTable("destroy");
    loadCardnumber();
}


function preAdd() {

    $("#id").val(0);

}

function saveTop() {

    var topupnum = $("#topupamount").val();

    var card = $("#cardnumber").val();

    card = parseInt(card);

    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth()+1;
    var date = now.getDate();
    var hour = now.getHours();//得到小时
    var minu = now.getMinutes();//得到分钟

    var nowtime = year +"年-"+month+"月-"+date+"日-"+hour+"点-"+minu+"分";



    $.ajax({
        url:'/webapi/members/getby/'+card
    }).done(function (rs) {

        var data = {
            cardnumber:card,
            topupamount:topupnum,
            topupdate:nowtime,
            originalamount:rs.initialamount
        }

        $.ajax({
            url: '/webapi/topup/insert',
            method: 'post',
            data: data

        }).done(function() {

            loadCardnumber();

            $('#myModal').modal('hide');
        })

    })


    $.ajax({
        url:'/webapi/members/getby/'+card
    }).done(function(rs){

        // console.log(rs);
        var newa = parseFloat(rs.initialamount) + parseFloat(topupnum);

        var newb = parseFloat(rs.accumulatedtopup) + parseFloat(topupnum);

        var da = {
            id:rs.id,
            cardnumber:rs.cardnumber,
            membername:rs.membername,
            gender:rs.gender,
            lplatenumber:rs.lplatenumber,
            vehicletype:rs.vehicletype,
            vehicletypel:rs.vehicletypel,
            phonenumber:rs.phonenumber,
            entity:rs.entity,
            carddate:rs.carddate,
            address:rs.address,
            note:rs.note,
            initialamount:newa,
            isvip:rs.isvip,
            accumulatedtopup:newb
        }


        $.ajax({
            url:'/webapi/members/update',
            method:'put',
            data:da
        }).done(function(){
            console.log("充值成功");
        })
    })

}

function loadCardnumber() {

    $('#topTable').bootstrapTable({
        url: '/webapi/topup/getbypagecardnumber',
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
            field: 'originalamount',
            title: '原始金额'
        }, {
            field: 'topupamount',
            title: '充值金额'
        }, {
            field: 'topupdate',
            title: '充值日期'
        }]
    });


}//end of loadTable


$(function() {

    loadCardnumber();

});