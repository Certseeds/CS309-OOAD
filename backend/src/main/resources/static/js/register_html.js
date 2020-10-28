"use strict";
const confirmPassWord = new Vue({
    el: '#confirmPassWord',
    data: {input: ''}
})
const confirmPassWordMention = new Vue({
    el: '#confirmPassWordMention',
    data: {message: ''}
});
const RegisterButton = new Vue({
    el: '#RegisterButton',
    data: {visibility: true}
});
const LoginLink = new Vue({
    el: '#LoginLink',
    data: {visibility: true}
})
Vue.prototype.loginLink = function () {
    window.location.assign("http://localhost:8888/login");
}
Vue.prototype.RegisterClick = function () {
    const name = inputName.input;
    const pass = passWord.input;
    const confirmpass = confirmPassWord.input;
    let count = false;
    if (name.length === 0) {
        Vue.set(inputMention, 'message', "user name should't be none");
        count = true;
    } else {
        Vue.set(inputMention, 'message', '')
    }
    if (pass.length === 0) {
        Vue.set(passWordMention, 'message', "password should't be none");
        count = true;
    } else {
        Vue.set(passWordMention, 'message', '')
    }
    if (confirmpass.length === 0) {
        Vue.set(confirmPassWordMention, 'message', "confirm password should't be none");
        count = true;
    } else {
        Vue.set(confirmPassWordMention, 'message', '');
    }
    if (pass !== confirmpass) {
        Vue.set(confirmPassWordMention, 'message', 'two passwords are not same');
        count = true;
    }
    if (count === true) {
        return;
    }
    let httpRequest = new XMLHttpRequest();//第一步：创建需要的对象
    httpRequest.open('POST', 'http://localhost:8888/user', true); //第二步：打开连接
    httpRequest.setRequestHeader("Content-type", "application/json");//设置请求头 注：post方式必须设置请求头（在建立连接后设置请求头）
    httpRequest.send(JSON.stringify({"userName": name, "passWord": pass}));//发送请求 将情头体写在send中
    /**
     * 获取数据后的处理程序
     */
    httpRequest.onreadystatechange = function () {//请求后的回调接口，可将请求成功后要执行的程序写在其中
        if (httpRequest.readyState === 4 && httpRequest.status === 200) {//验证请求是否发送成功
            let response = parseInt(httpRequest.responseText);//获取到服务端返回的数据
            if (response !== 200) {
                console.log(response);
                Vue.set(inputMention, 'message', 'this username has been registered');
            } else {
                Vue.set(inputMention, 'message', '');
                Vue.set(passWordMention, 'message', '');
                Vue.set(confirmPassWordMention, 'message', '');
                window.location.assign(String.format("http://localhost:8888/login/{0}", name));
            }
        }
    };
    //
};