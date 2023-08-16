<template>
    <div class="storeMain">
        员工店铺号:<el-input v-model="data.storeId"></el-input>
        员工姓名:<el-input v-model="data.employeeName"></el-input>
        员工职位:<el-input v-model="data.employeePosts"></el-input>
        员工邮件:<el-input v-model="data.employeeEmail"></el-input>
        <el-button class="update" type="primary" plain @click="update">确认</el-button>
    </div>
</template>

<script setup lang="ts">
import {getCurrentInstance, reactive} from "vue";
import store from "../store";
import {ElMessage} from "element-plus";
import router from "../router";

let { proxy } = getCurrentInstance();
let employee=JSON.parse(decodeURIComponent(proxy.$route.query.item))
const data=reactive({
    storeId:store.state.storeId,
    employeeName:employee['employeeName'],
    employeePosts:employee['employeePosts'],
    employeeEmail:employee['employeeEmail']
})

const update=()=>{
    proxy.$axios.post('EmployeeController/employeeUpdate',JSON.stringify({
        storesId:data.storeId,
        employeeId:employee['employeeId'],
        employeeName:data.employeeName,
        employeePosts:data.employeePosts,
        employeeEmail:data.employeeEmail
    }), {headers: {
            'Content-Type': 'application/json'
        }}).then(response=>{
        ElMessage({
            customClass:'focus-message',
            message:'修改成功',
            type:'success'});
    },
    router.push('/employeeManage'))
}
</script>

<style scoped>

</style>