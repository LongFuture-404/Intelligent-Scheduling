<template>
<div class="storeMain">
    <el-button type="primary" plain class="insert"><router-link :to="{path:'/employeeInsert'}">添加员工</router-link></el-button>
    <table>
        <thead><tr>
            <td>员工编号</td>
            <td>员工姓名</td>
            <td>员工职位</td>
            <td>员工邮件</td>
        </tr></thead>
        <tbody>
            <tr v-for="item in employee">
                <td>{{item['employeeId']}}</td>
                <td>{{item['employeeName']}}</td>
                <td>{{item['employeePosts']}}</td>
                <td>{{item['employeeEmail']}}</td>
                <td><el-button type="primary" plain><router-link :to="{path:'/employeeUpdate',query:{item:JSON.stringify(item)}}">修改员工</router-link></el-button></td>
                <td><el-button type="primary" plain @click="removeEmployee(item)">删除员工</el-button></td>
            </tr>
        </tbody>
    </table>
</div>
</template>

<script setup lang="ts">
import {getCurrentInstance, reactive} from "vue";
import store from "../store";
import {ElMessage} from "element-plus";
import dayjs from "dayjs";
import router from "../router";

let { proxy } = getCurrentInstance();
let employee=reactive([])
const init=()=>{
    Object.keys(employee).forEach((item) => {
        employee.pop()
    })
    proxy.$axios.post('EmployeeController/employeeSelect',proxy.$qs.stringify({
        storesId:store.state.storeId
    })).then(response=> {
        let employees=response.data
        employees.forEach((item, index) => {
                employee.push(item)
        })
    })
}
setTimeout(init,500)

const removeEmployee=(item)=>{
    proxy.$axios.post('EmployeeController/employeeDelete',proxy.$qs.stringify({
        storesId:store.state.storeId,
        employeeId:item.employeeId
    })).then(response=> {
        setTimeout(init,500)
        ElMessage({
            customClass:'focus-message',
            message:'删除成功',
            type:'success'});
    })
}
</script>

<style scoped>
a{
    text-decoration: none;
}
.router-link-active {
    text-decoration: none;
}
.storeMain{
    top: 8%;
}
.insert{
    position: relative;
    left: 35%;
}
table{
    border-collapse: separate;
    border-spacing: 50px 10px;  /* 水平间距 垂直间距 */
}
li{
    list-style-type: none;
}
</style>