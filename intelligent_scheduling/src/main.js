"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var vue_1 = require("vue");
var store_1 = require("./store");
var App_vue_1 = require("./App.vue");
var router_1 = require("./router");
var jquery_1 = require("jquery");
require("bootstrap/dist/css/bootstrap.css");
require("bootstrap/dist/js/bootstrap.min.js");
// @ts-ignore
var element_plus_1 = require("element-plus");
require("element-plus/dist/index.css");
//配置请求数据
var axios_1 = require("axios");
// @ts-ignore
var qs_1 = require("qs");
require("font-awesome/css/font-awesome.min.css");
// //ts全局配置Axios
// declare module '@vue/runtime-core' {
//     interface ComponentCustomProperties {
//         $axios: AxiosInstance;
//     }
// }
var app = (0, vue_1.createApp)(App_vue_1.default);
app.config.globalProperties.$ = jquery_1.default;
axios_1.default.defaults.baseURL = '/api';
app.config.globalProperties.$axios = axios_1.default;
app.config.globalProperties.$qs = qs_1.default;
//【给页面设置标题】vue页面中使用 v-title data-title="添加新闻"
// app.directive('title', {
//     mounted(el){
//         document.title = el.dataset.title
//     }
// })
app.use(element_plus_1.default);
app.use(store_1.default);
app.use(router_1.default).mount('#app');
