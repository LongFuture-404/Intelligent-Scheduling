"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var TimeTable_vue_1 = require("../views/TimeTable.vue");
var myLogin_vue_1 = require("../views/myLogin.vue");
var supplierAllBack_vue_1 = require("../views/supplierAllBack.vue");
var storeManage_vue_1 = require("../views/storeManage.vue");
var employeeManage_vue_1 = require("../views/employeeManage.vue");
var schedulingRoleManage_vue_1 = require("../views/schedulingRoleManage.vue");
var userManage_vue_1 = require("../views/userManage.vue");
var employeeInsert_vue_1 = require("../views/employeeInsert.vue");
var employeeUpdate_vue_1 = require("../views/employeeUpdate.vue");
var routes = [
    { path: '/', meta: { title: '登录页面' }, component: myLogin_vue_1.default },
    { path: '/index', meta: { requiresAuth: true, title: '主页面' }, component: TimeTable_vue_1.default },
    { path: '/white', meta: { title: '空白页面' }, component: supplierAllBack_vue_1.default },
    { path: '/storeManage', meta: { requiresAuth: true, title: '店铺管理页面' }, component: storeManage_vue_1.default },
    { path: '/employeeManage', meta: { requiresAuth: true, title: '员工管理页面' }, component: employeeManage_vue_1.default },
    { path: '/schedulingRoleManage', meta: { requiresAuth: true, title: '排班规则管理页面' }, component: schedulingRoleManage_vue_1.default },
    { path: '/userManage', meta: { requiresAuth: true, title: '用户管理页面' }, component: userManage_vue_1.default },
    { path: '/employeeInsert', meta: { requiresAuth: true, title: '用户添加页面' }, component: employeeInsert_vue_1.default },
    { path: '/employeeUpdate', meta: { requiresAuth: true, title: '用户修改页面' }, component: employeeUpdate_vue_1.default }
];
exports.default = routes;
