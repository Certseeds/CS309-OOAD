'use strict';

function getMovies() {
    let result;
    let httpRequest = new XMLHttpRequest();//第一步：创建需要的对象
    httpRequest.open('GET', 'http://localhost:8888/movie', true); //第二步：打开连接
    httpRequest.setRequestHeader("Content-type", "application/json");//设置请求头 注：post方式必须设置请求头（在建立连接后设置请求头）
    httpRequest.send();
    /**
     * 获取数据后的处理程序
     */
    httpRequest.onreadystatechange = function () {//请求后的回调接口，可将请求成功后要执行的程序写在其中
        if (httpRequest.readyState === 4 && httpRequest.status === 200) {//验证请求是否发送成功
            console.log(httpRequest.responseText);
            result = JSON.parse(httpRequest.responseText);
            for (let index = 0; index < result.length; index++) {
                console.log(result[index]);
                Vue.set(temp.tableData, index, result[index]);
            }

        }
    };
    return result;
}

const Ctor = Vue.extend({
    data: function () {
        return {
            tableData: []
        }
    }
});
const temp = new Ctor().$mount('#app');
const dialog = Vue.extend({
    data() {
        return {
            dialogTableVisible: false,
            dialogFormVisible: false,
            form: {
                title: '',
                date: '',
                startTime: '',
                duration: '',
                movieHall: '',
                price: '',
                type: '',
            },
            formLabelWidth: '120px'
        };
    }
});
const AddMovieDialog = new dialog().$mount('#AddMovieDialog');

Vue.prototype.deleteMovie = function (paras, index) {
    const httpRequest = new XMLHttpRequest();//第一步：创建需要的对象
    httpRequest.open('DELETE', 'http://localhost:8888/movie', true); //第二步：打开连接
    httpRequest.setRequestHeader("Content-type", "application/json");//设置请求头 注：post方式必须设置请求头（在建立连接后设置请求头）
    httpRequest.send(JSON.stringify({"title": paras}));//发送请求 将情头体写在send中
    /**
     * 获取数据后的处理程序
     */
    console.log("12135");
    httpRequest.onreadystatechange = function () {//请求后的回调接口，可将请求成功后要执行的程序写在其中
        if (httpRequest.readyState === 4 && httpRequest.status === 200) {//验证请求是否发送成功
            let response = JSON.parse(httpRequest.responseText);//获取到服务端返回的数据
            console.log(response);
            if (response !== '') {
                alert("delete success");
                console.log(typeof index);
                Vue.delete(temp.tableData, index);
            } else {
                alert("delete fail");
            }
        }
    };
};

Vue.prototype.outputConsole = function (index) {
    console.log(index);
};
Vue.prototype.AddClick = function (index) {
    console.log("add click");
    const httpRequest = new XMLHttpRequest();//第一步：创建需要的对象
    const sendObjext = {
        "title": AddMovieDialog.form["title"],
        "date": AddMovieDialog.form["date"],
        "startTime": AddMovieDialog.form["startTime"],
        "duration": AddMovieDialog.form["duration"],
        "movieHall": AddMovieDialog.form["movieHall"],
        "price": AddMovieDialog.form["price"],
        "type": AddMovieDialog.form["type"]
    }
    httpRequest.open('POST', 'http://localhost:8888/movie', true); //第二步：打开连接
    httpRequest.setRequestHeader("Content-type", "application/json");//设置请求头 注：post方式必须设置请求头（在建立连接后设置请求头）
    httpRequest.send(JSON.stringify(sendObjext));//发送请求 将情头体写在send中
    /**
     * 获取数据后的处理程序
     */
    httpRequest.onreadystatechange = function () {//请求后的回调接口，可将请求成功后要执行的程序写在其中
        if (httpRequest.readyState === 4 && httpRequest.status === 200) {//验证请求是否发送成功
            let response = JSON.parse(httpRequest.responseText);//获取到服务端返回的数据
            if (response.autoId !== -1) {
                Vue.set(temp.tableData, temp.tableData.length, response);
                Vue.push(temp.tableData.form, response);
                alert('add success');
            } else {
                alert("fail");
            }
        }
    };
}
window.onload = function () {
    const x = getMovies();
}

const UpdatedialogObject = Vue.extend({
    data() {
        return {
            UpdatedialogTableVisible: false,
            UpdatedialogFormVisible: false,
            form: {
                title: '',
                date: '',
                startTime: '',
                duration: '',
                movieHall: '',
                price: '',
                type: '',
            },
            formLabelWidth: '120px'
        };
    }
});
let autoIdTransfer;
let UpdateIndex;
const UpdateMovieDialog = new UpdatedialogObject().$mount('#UpdateMovieDialog');
Vue.prototype.UpdateMovieOpen = function (parms, index) {
    UpdateMovieDialog.UpdatedialogFormVisible = true;
    console.log(parms);
    let key_list = [];
    for (let key in parms) {
        key_list.push(key);
    }
    for (const addMovieDialogElement of key_list) {
        Vue.set(UpdateMovieDialog.form, addMovieDialogElement, parms[addMovieDialogElement])
    }
    autoIdTransfer = parms["autoId"];
    UpdateIndex = index;
};
Vue.prototype.UpdateMovie = function () {
    const sendObject = {
        "autoId": autoIdTransfer,
        "title": UpdateMovieDialog.form["title"],
        "date": UpdateMovieDialog.form["date"],
        "startTime": UpdateMovieDialog.form["startTime"],
        "duration": UpdateMovieDialog.form["duration"],
        "movieHall": UpdateMovieDialog.form["movieHall"],
        "price": UpdateMovieDialog.form["price"],
        "type": UpdateMovieDialog.form["type"]
    }
    const httpRequest = new XMLHttpRequest();//第一步：创建需要的对象
    httpRequest.open('PUT', 'http://localhost:8888/movie', true); //第二步：打开连接
    httpRequest.setRequestHeader("Content-type", "application/json");//设置请求头 注：post方式必须设置请求头（在建立连接后设置请求头）
    httpRequest.send(JSON.stringify(sendObject));//发送请求 将情头体写在send中
    /**
     //  * 获取数据后的处理程序
     //  */
    httpRequest.onreadystatechange = function () {//请求后的回调接口，可将请求成功后要执行的程序写在其中
        if (httpRequest.readyState === 4 && httpRequest.status === 200) {//验证请求是否发送成功
            let response = JSON.parse(httpRequest.responseText);//获取到服务端返回的数据
            alert("Update success");
            sendObject.autoId = response.autoId;
            Vue.set(temp.tableData, UpdateIndex, sendObject);
        }
    };
};

const searchDateInput = new Vue({
    el: '#searchDate',
    data: {input: ''}
});
const searchMovieHallInput = new Vue({
    el: '#searchMovieHall',
    data: {input: ''}
});
const searchButton = new Vue({el: '#SearchButton'});
Vue.prototype.searchDataAndMovieHall = function () {
    console.log("take in");
    for (let i = temp.tableData.length; i >= 0; i--) {
        console.log(temp.tableData[i]);
        Vue.delete(temp.tableData, i);
    }
    const httpRequest = new XMLHttpRequest();//第一步：创建需要的对象
    httpRequest.open('GET',
        String.format('http://localhost:8888/movie/{0}/{1}', searchDateInput.input, searchMovieHallInput.input),
        true); //第二步：打开连接
    httpRequest.setRequestHeader("Content-type", "application/json");//设置请求头 注：post方式必须设置请求头（在建立连接后设置请求头）
    httpRequest.send();
    /**
     * 获取数据后的处理程序
     */
    httpRequest.onreadystatechange = function () {//请求后的回调接口，可将请求成功后要执行的程序写在其中
        if (httpRequest.readyState === 4 && httpRequest.status === 200) {//验证请求是否发送成功
            console.log(httpRequest.responseText);
            let result = JSON.parse(httpRequest.responseText);
            for (let index = 0; index < result.length; index++) {
                console.log(result[index]);
                Vue.set(temp.tableData, index, result[index]);
            }
        }
    };
    console.log("take out");
}
