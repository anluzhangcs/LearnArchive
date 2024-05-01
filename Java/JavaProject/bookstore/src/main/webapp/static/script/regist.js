$(function () { //页面加载完
    var $msg = $(".errorMsg");

    $("#sub_btn").click(function () {
        if ("/^\w{3,14}$/".test($("#username").val())) {

            if ("/^[0-9a-zA-Z]{6,18}$/".test($("#password").val())) {
                if ($("#password").val == $("#repwd")){
                    if ("/^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$/".test($("#email").val())) {
                        if ($("#code").val() != "abcde") {
                            $msg.html("验证码错误");
                            return false;
                        }
                    } else{
                        $msg.html("邮箱格式不正确");
                        return false;
                    }
                } else{
                    $msg.html("两次密码不一致");
                    return false;
                }
            } else{
                $msg.html("密码不合法");
                return false;
            }

        } else{
            $msg.html("用户名不合法");
            return false;
        }
    });

})