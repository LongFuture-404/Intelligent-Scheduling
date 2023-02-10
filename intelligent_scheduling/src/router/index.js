"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var vue_1 = require("vue");
var vue_router_1 = require("vue-router");
var routes_1 = require("./routes");
var store_1 = require("../store");
var axios_1 = require("axios");
var app = (0, vue_1.createApp)({});
app.config.globalProperties.axios = axios_1.default;
// 解决重复路由报异常问题
// @ts-ignore
var originalPush = axios_1.default.push;
// @ts-ignore
axios_1.default.push = function push(location) {
    return originalPush.call(this, location).catch(function (err) { return err; });
};
var router = (0, vue_router_1.createRouter)({
    history: (0, vue_router_1.createWebHistory)(),
    routes: routes_1.default
});
router.beforeEach(function (to, from, next) {
    if (to.meta.requiresAuth) {
        if (store_1.default.state.user.employeeName === '') {
            document.title = '登录页面';
            // 跳转到登录页面
            next({
                name: '',
                query: {
                    redirect: to.fullPath // 把登录成功需要返回的页面告诉登录页面
                }
            });
        }
        else {
            // @ts-ignore
            document.title = to.meta.title ? to.meta.title : '智能排班';
            next(); // 允许通过
        }
    }
    else {
        // @ts-ignore
        document.title = to.meta.title ? to.meta.title : '智能排班';
        next(); // 允许通过
    }
});
exports.default = router;
