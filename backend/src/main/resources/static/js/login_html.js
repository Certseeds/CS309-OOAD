"use strict";


const WrongMention = new Vue({
    el: '#WrongMention',
    data: {message: ''},
});
const LoginButton = new Vue({
    el: '#LoginButton',
    data: {visibility: true}
});
const RegisterLink = new Vue({
    el: '#RegisterLink',
    data: {visibility: true}
})
Vue.prototype.registerClick = function () {
    window.location.assign("http://localhost:8888/register");
}
Vue.prototype.LoginClick = function () {
    const name = inputName.input;
    const pass = passWord.input;
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
    if (count === true) {
        return;
    }
    let httpRequest = new XMLHttpRequest();//第一步：创建需要的对象
    httpRequest.open('POST', 'http://localhost:8888/token', true); //第二步：打开连接
    httpRequest.setRequestHeader("Content-type", "application/json");//设置请求头 注：post方式必须设置请求头（在建立连接后设置请求头）
    httpRequest.send(JSON.stringify({"userName": name, "passWord": pass}));//发送请求 将情头体写在send中
    const tableSubmit = document.getElementById('toTable');

    /**
     * 获取数据后的处理程序
     */
    console.log("12135");
    httpRequest.onreadystatechange = function () {//请求后的回调接口，可将请求成功后要执行的程序写在其中
        if (httpRequest.readyState === 4 && httpRequest.status === 200) {//验证请求是否发送成功
            let response = JSON.parse(httpRequest.responseText);//获取到服务端返回的数据
            console.log(typeof response);
            console.log(typeof response.state);
            console.log(typeof response["state"]);
            if (response.state === 200) {
                console.log();
                tableSubmit[0].name = "state";
                tableSubmit[0].value = "200";
                tableSubmit[1].value = "tokenId";
                tableSubmit[1].value = response.tokenId;
                document.getElementById('toTable').submit();
                WrongMention.message = "the username or password is OK";
            } else {
                WrongMention.message = "the username or password is Wrong";
            }
        }
    };
    //
};
window.onload = function () {
    inputName.input = document.getElementById("useless").innerHTML;
}