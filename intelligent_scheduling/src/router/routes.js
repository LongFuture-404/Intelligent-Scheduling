"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var TimeTable_vue_1 = require("../views/TimeTable.vue");
var myLogin_vue_1 = require("../views/myLogin.vue");
var supplierAllBack_vue_1 = require("../views/supplierAllBack.vue");
var routes = [
    { path: '/', meta: { title: '登录页面' }, component: myLogin_vue_1.default },
    { path: '/index', meta: { requiresAuth: true, title: '主页面' }, component: TimeTable_vue_1.default },
    { path: '/white', meta: { title: '空白页面' }, component: supplierAllBack_vue_1.default },
];
exports.default = routes;
