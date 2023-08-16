import {state} from "./state";

const mutations={
    addUser(state,employee){
        state.user.employeeId=employee.employeeId
        state.user.employeeName=employee.employeeName
    },
    setStoreId(state,storeId){
        state.storeId=storeId
    }
}

export {mutations};