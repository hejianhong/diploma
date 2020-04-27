function subqd(nu) {

    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth()+1;
    var date = now.getDate();
    var hour = now.getHours();//得到小时
    var minu = now.getMinutes();//得到分钟

    var nowtime = year +"年-"+month+"月-"+date+"日-"+hour+"点-"+minu+"分";

    var succ = "签到成功" + "("+ nowtime + ")";


    var a = document.getElementById("usernumber");

    nu = a.value;

    alert("工号：" + nu + "签到成功！");

    console.log(nu);


    $.ajax({

        url: '/webapi/employees/getby/' + nu
    }).done(function(rs) {

        $('#id').val(rs.id);
        $('#name').val(rs.name);
        $('#phonenumber').val(rs.phonenumber);
        $('#gender').val(rs.gender);
        $('#shift').val(rs.shift);
        $('#address').val(rs.address);
        $('#registration').val(rs.registration);
        $('#note').val(succ);
        $('#number').val(rs.number);

        var data = $("#formEmployees").serialize();

        $.ajax({
            url:'/webapi/employees/update',
            method:'put',
            data:data
        }).done({

        })

    })

}