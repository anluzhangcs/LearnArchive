

$(function () { //页面加载函数

    //验证正则表达式
    var phonePatt = /^1[3456789]\d{9}$/;
    var passwordPatt = /^[0-9a-z]{8,14}$/;
    var emailPatt = /^[0-9a-z\.]{3,10}[@gmail.com,@qq.com,@169.com]$/;

    //获取提示栏对象
    var $msg = $(".errorMsg");


    $("#username").blur(function () {
        if (!phonePatt.test($(this).val())) {
            $msg.html("手机号有误!");
        } else {
            $msg.html("");
        }
    });

    $("#password").blur(function () {
        if (!emailPatt.test(this.value)) {
            $msg.html("密码格式有误!");
        }
    });

    $("#repwd").blur(function () {
        if ($("#password").val() != $(this).val()) {
            $msg.html("两次密码不一致!");
        }
    });


    $("#email").blur(function () {
        if (!emailPatt.test(this.value)) {
            $msg.html("邮箱格式有误!");
        }
    });

    $("#code").blur(function () {

        if (this.value != "6nbnp") {
            $msg.html("验证码有误!");
        }
    });


})