<template>
  <el-dialog class="UpdateScheduling" title="修改员工排班信息如下:" :show-close="false" v-model="showDia" width="40%">

    <div v-if="data.operation==='updateScheduling'">
【{{data.employee.employeeName}}】【{{data.employee.employeePosts}}】【{{data.employee.startTime}}】【{{data.employee.endTime}}】修改员工排班信息
     <div class="employeeSelect">
         换班日期:<input class="input-group-text" v-model="data.scheduling.date">
         开始时间:<input class="input-group-text" v-model="data.scheduling.startTime">
         结束时间:<input class="input-group-text" v-model="data.scheduling.endTime">
      </div>
      <div class="employeeSelect" style="left: 30%;top: 10px">
        <select class="form-select form-select-sm">
           <option v-for="item in employees.length">{{ employees[item-1] }}</option>
        </select>
        <el-button @click="changeChoose($event)" class="btn btn-primary auto update" type="primary">换班查询</el-button>
      </div>
    </div>

    <div v-if="data.operation==='addScheduling'">
      <div class="employeeSelect">
          排班日期:<input class="input-group-text" v-model="data.scheduling.date">
          开始时间:<input class="input-group-text" v-model="data.scheduling.startTime">
          结束时间:<input class="input-group-text" v-model="data.scheduling.endTime">
      </div>
      <div class="employeeSelect" style="left: 30%;top: 10px">
        <select class="form-select form-select-sm">
          <option v-for="item in employees.length">{{ employees[item-1] }}</option>
        </select>
        <el-button @click="changeChoose($event)" class="btn btn-primary auto insert" type="primary">添加查询</el-button>
      </div>
    </div>

    <div v-if="data.operation==='updateScheduling'">
	<el-button @click="removeChoose" class="remove btn btn-primary auto" type="primary">确定删除</el-button>
    </div>

    <template v-slot:footer>
      <div class="button">
        <el-button @click="confirmDia" class="btn btn-primary auto" type="primary">确定</el-button>
        <el-button @click="closeDia" class="btn btn-primary auto" plain>取消</el-button>
      </div>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import {ref, defineEmits, defineExpose, getCurrentInstance, reactive} from 'vue'
let { proxy } = getCurrentInstance();
import store from "../store/index.ts";

const data = ref({
  employee: {
    employeeName:'',
    employeePosts:'',
    startTime:'',
    endTime:''
  },
  schedulingCol:'',
  operation:'',
  scheduling:{
    date:'',
    startTime: '',
    endTime:''
  }
})
let weekJS = reactive([]);
const emit = defineEmits([ 'confirmDia'])
let showDia = ref<boolean>(false)
let theOperation;
const openUpdateDia= (employee,week,storeId,schedulingCol): void => {
  store.commit('setStoreId', storeId)
  weekJS = week;
  data.value.operation='updateScheduling'
  data.value.employee=employee;
  data.value.schedulingCol=schedulingCol
  showDia.value = true
}
const openAddDia= (week,storeId,schedulingCol): void => {
  store.commit('setStoreId', storeId)
  weekJS = week;
  data.value.operation='addScheduling'
  data.value.schedulingCol=schedulingCol
  showDia.value = true
}
const closeDia = (): void => {showDia.value = false
  Object.keys(data.value.scheduling).forEach((key)=>{
    data.value.scheduling[key] = '';
  })
  Object.keys(employees).forEach((item) => {
    employees.pop()
  })
}
const confirmDia = (): void => {
  if(data.value.operation==='addScheduling'){
      proxy.$axios.post('EmployeeController/UpdateScheduling',proxy.$qs.stringify({
          operation:theOperation,
          weekJS:weekJS
      },{arrayFormat:'brackets'})).then(response=> {

      })
    emit( 'confirmDia','弹窗内容添加排班事件处理完毕，信息传给父组件')
  }
  if(data.value.operation==='updateScheduling'){
      proxy.$axios.post('EmployeeController/UpdateScheduling',proxy.$qs.stringify({
          operation:theOperation,
          schedulingCol:data.value.schedulingCol,
          weekJS:weekJS
      },{arrayFormat:'brackets'})).then(response=> {

      })
    emit( 'confirmDia','弹窗内容换班事件处理完毕，信息传给父组件')
  }
}

let employees=reactive([])
const changeChoose=(event)=>{
  //换班时对排班时长进行判断符合条件才能换班
  Object.keys(employees).forEach((item) => {
    employees.pop()
  })
  let domClass=event.currentTarget.getAttribute("class")
  if(domClass.includes("update")){
    theOperation="update"
  }
  if(domClass.includes("insert")){
    theOperation="insert"
  }
  proxy.$axios.post('EmployeeController/UpdateSelectScheduling?operation='+theOperation+'&schedulingCol='+data.value.schedulingCol,JSON.stringify({
        storesId:store.state.storeId,
        date:data.value.scheduling.date,
        startTime:data.value.scheduling.startTime,
        endTime:data.value.scheduling.endTime,
        weekJS:weekJS,
  }), {headers: {
          'Content-Type': 'application/json'
    }}).then(response=>{
    for(let item in response.data){
      employees.push(response.data[item])
    }
  })
}
// vue3中规定，使用了<script setup>的组件是默认私有的:
//一个父组件无法访问到一个使用了<script setup>的子组件中的任何东西，除非子组件在其中通过defineExpose宏显式暴露
defineExpose({
  openUpdateDia,openAddDia,closeDia})

</script>

<style scoped lang="scss">
div.employeeSelect{
  position: relative;
  display: flex;
  flex-direction: row;
  gap: 20px;
}
.input-group-text{
  width: 100px;
  height: 30px;
}
.form-select{
  width: 200px;
  height: 35px;
}
div.button{
  position: relative;
  width: 200px;
  height: 40px;
  margin-left:35%;
  margin-right:auto;
  display: flex;
  flex-direction: row;
  gap: 40px;
}
.remove{
  background-color: orangered;
  position: relative;
  left: 25%;
  top: 20px;
}
</style>
<style lang="scss">
.UpdateScheduling{
  z-index: 10;
  position: absolute;
  width: 50%;
  height: 40%;
  background-color: deepskyblue;
  border: deepskyblue solid 1px;
}
</style>