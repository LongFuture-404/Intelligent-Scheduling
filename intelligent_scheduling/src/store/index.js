"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var vuex_1 = require("vuex");
var state_1 = require("./state");
var mutations_1 = require("./mutations");
var actions_1 = require("./actions");
var modules_1 = require("./modules");
var vuex_persistedstate_1 = require("vuex-persistedstate");
exports.default = (0, vuex_1.createStore)({
    plugins: [(0, vuex_persistedstate_1.default)({ storage: window.sessionStorage })],
    state: state_1.state,
    mutations: mutations_1.mutations,
    actions: actions_1.actions,
    modules: modules_1.modules
});
