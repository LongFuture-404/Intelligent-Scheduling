import {state} from "./state";

const mutations={
    addUser(state,employee){
        state.user.employeeId=employee.employeeId
        state.user.employeeName=employee.employeeName
    }
}

export {mutations};