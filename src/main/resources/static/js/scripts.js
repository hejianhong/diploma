
var code ; //在全局定义验证码



function createCode(){
    code = "";
    var codeLength = 4;//验证码的长度
    var checkCode = document.getElementById("code");
    var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',
        'S','T','U','V','W','X','Y','Z');//随机数
    for(var i = 0; i < codeLength; i++) {//循环操作
        var index = Math.floor(Math.random()*36);//取得随机数的索引（0~35）
        code += random[index];//根据索引取得随机数加到code上
    }
    checkCode.value = code;//把code值赋给验证码
}
//校验验证码
function validate(){


    var inp = $(".Captcha");

    var inputCode = inp.val();

    if(inputCode.length <= 0) { //若输入的验证码长度为0
        alert("请输入验证码！"); //则弹出请输入验证码

        return false;
    }else if(inputCode != code ) { //若输入的验证码与产生的验证码不一致时
        alert("验证码输入错误！"); //则弹出验证码输入错误
        createCode();//刷新验证码
        $(".Captcha").innerText = "";//清空文本框
        return false;
    }else { //输入正确时
        alert("验证码正确,正在跳转...");

        login();
    }

}


function login() {

    var name = $(".username").val();

    var password = $(".password").val();


    $.ajax({
        url: "/webapi/login/login",
        data:{

            username:name,
            password:password
        }

    }).done(function (rs) {

        if(rs>=0){
            window.location.href="/information/Employees/employeeslist";
        }else {
            alert("对不起，不存在该用户！");
        }

    });

}


function loginlast() {

    validate();


}



$(window).on('load', function() {

    $('.page-container form').submit(function(){
        var username = $(this).find('.username').val();
        var password = $(this).find('.password').val();
        if(username == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '27px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.username').focus();
            });
            return false;
        }

        if(password == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '96px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.password').focus();
            });
            return false;
        }

        validate();


    });

    $('.page-container form .username, .page-container form .password').keyup(function(){
        $(this).parent().find('.error').fadeOut('fast');
    });

});
