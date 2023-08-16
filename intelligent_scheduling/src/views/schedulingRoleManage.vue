<template>
    <div class="storeMain">
        每日最长工作时长:<el-input v-model="data.maxDayTime"></el-input>
        每周最长工作时长:<el-input v-model="data.maxWeekTime"></el-input>
        员工负责客流量:<el-input v-model="data.employeeNeed"></el-input>
        开店准备时间:<el-input v-model="data.beforeTime"></el-input>
        开店员工负责面积:<el-input v-model="data.beforeEmployeeArea"></el-input>
        关店整理时间:<el-input v-model="data.afterTime"></el-input>
        关店员工负责面积:<el-input v-model="data.afterEmployeeArea"></el-input>
        关店基本员工:<el-input v-model="data.afterEmployeeMore"></el-input>
        <el-button class="update" type="primary" plain @click="update">确认</el-button>
    </div>
</template>

<script setup lang="ts">
import {getCurrentInstance, reactive} from "vue";
import store from "../store";
import {ElMessage} from "element-plus";

let { proxy } = getCurrentInstance();
const data=reactive({
    maxDayTime: '',
    maxWeekTime: '',
    employeeNeed: '',
    beforeTime:'',
    beforeEmployeeArea:'',
    afterTime:'',
    afterEmployeeArea:'',
    afterEmployeeMore:''
})
const init=()=>{
    proxy.$axios.post('EmployeeController/scheduling_roleSelect',proxy.$qs.stringify({
        storesId:store.state.storeId
    })).then(response=>{
        data.maxDayTime=response.data.maxDayTime
        data.maxWeekTime=response.data.maxWeekTime
        data.employeeNeed=response.data.employeeNeed
        data.beforeTime=response.data.beforeTime
        data.beforeEmployeeArea=response.data.beforeEmployeeArea
        data.afterTime=response.data.afterTime
        data.afterEmployeeArea=response.data.afterEmployeeArea
        data.afterEmployeeMore=response.data.afterEmployeeMore
    })
}
init()

const update=()=>{
    proxy.$axios.post('EmployeeController/scheduling_roleUpdate',JSON.stringify({
        storesId:store.state.storeId,
        maxDayTime: data.maxDayTime,
        maxWeekTime: data.maxWeekTime,
        employeeNeed: data.employeeNeed,
        beforeTime: data.beforeTime,
        beforeEmployeeArea: data.beforeEmployeeArea,
        afterTime: data.afterTime,
        afterEmployeeArea: data.afterEmployeeArea,
        afterEmployeeMore: data.afterEmployeeMore
    }), {headers: {
            'Content-Type': 'application/json'
        }}).then(response=>{
        ElMessage({
            customClass:'focus-message',
            message:'修改成功',
            type:'success'});
    })
}
</script>

<style scoped>

</style>