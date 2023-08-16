"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.mutations = void 0;
var mutations = {
    addUser: function (state, employee) {
        state.user.employeeId = employee.employeeId;
        state.user.employeeName = employee.employeeName;
    },
    setStoreId: function (state, storeId) {
        state.storeId = storeId;
    }
};
exports.mutations = mutations;
