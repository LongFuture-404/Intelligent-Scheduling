<template>
    <div class="selectWeek">
      <button type="button" class="btn btn-primary" @click="lastWeek">上一周</button>
      <button type="button" class="btn btn-primary" @click="thisWeek">本周</button>
      <button type="button" class="btn btn-primary" @click="nextWeek">下一周</button>
    </div>
    <table>
      <tr hidden="hidden">{{storeId}}</tr>
      <tr>
        <td>星期数/时间</td>
        <td>{{weekJS[0]}}<br>星期一</td>
        <td>{{weekJS[1]}}<br>星期二</td>
        <td>{{weekJS[2]}}<br>星期三</td>
        <td>{{weekJS[3]}}<br>星期四</td>
        <td>{{weekJS[4]}}<br>星期五</td>
        <td>{{weekJS[5]}}<br>星期六</td>
        <td>{{weekJS[6]}}<br>星期日</td>
      </tr>
      <tr>
        <td>8:00~<br>11:00</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td>11:00~<br>13:00</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td>13:00~<br>15:00</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td>15:00~<br>17:00</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td>17:00~<br>19:00</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td>19:00~<br>21:00</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td>21:00~<br>23:00</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
    </table>
  <button type="button" class="btn btn-primary auto" @click="AutoScheduling">自动生成</button>
</template>

<script setup lang="ts">
import {getCurrentInstance, reactive, ref} from "vue";
import store from "../store";
import dayjs from "dayjs";

let now = new Date();
let day = now.getDay();
let oneDayTime = 24 * 60 * 60 * 1000;
let MondayTime = '';
let weekJS = reactive([]);
const getDateJS=() => {
  let nowTime = now.getTime();
// let SundayTime ='';
  if (day === 0) {//如果是周日
    MondayTime = dayjs(nowTime - 6 * oneDayTime).format('YYYY-MM-DD');//显示周一
    // SundayTime = dayjs(nowTime).format('YYYY-MM-DD');//显示周日
  } else if (day === 1) { //如果是周一
    MondayTime = dayjs(nowTime).format('YYYY-MM-DD');//显示周一
    // SundayTime = dayjs(nowTime + 6 * oneDayTime).format('YYYY-MM-DD');//显示周日
  } else {
    MondayTime = dayjs(nowTime - (day - 1) * oneDayTime).format('YYYY-MM-DD');//显示周一
    // SundayTime = dayjs(nowTime + (7 - day) * oneDayTime).format('YYYY-MM-DD');//显示周日
  }
  for (let i = 0; i < 7; i++) {
    let date = new Date(MondayTime)
    date.setDate(date.getDate() + i);
    let month = date.getMonth() + 1; //月份从0开始所以需要+1
    let Day = date.getDate();
    weekJS.push(date.getFullYear() + '-' + month + '-' + Day)
  }
}
getDateJS()

let { proxy } = getCurrentInstance();

// let date=reactive(props.date)
// let week=props.week
// const getDate=() =>{
//   proxy.$axios.post('EmployeeController/GetDate',proxy.$qs.stringify({
//     week:0
//   })).then(response=> {
//     Object.keys(response.data).forEach((item) => {
//       date.push(response.data[item])
//     })
//     return date
//   })
// }
// getDate()
const lastWeek=()=>{
  Object.keys(weekJS).forEach((item) => {
    weekJS.pop()
  })
  let date=new Date(now)
  date.setDate(date.getDate() - 7);
  now=new Date(date)
  getDateJS()
  // proxy.$axios.post('EmployeeController/GetDate',proxy.$qs.stringify({
  //   week:week-7
  // })).then(response=> {
  //   week=week-7
  //   Object.keys(date).forEach((item) => {
  //     date.pop()
  //   })
  //   Object.keys(response.data).forEach((item) => {
  //     date.push(response.data[item])
  //   })
  //   return date
  // })
}
const thisWeek=()=>{
  Object.keys(weekJS).forEach((item) => {
    weekJS.pop()
  })
  let date=new Date()
  now=new Date(date)
  getDateJS()
  // proxy.$axios.post('EmployeeController/GetDate',proxy.$qs.stringify({
  //   week:0
  // })).then(response=> {
  //   week=0
  //   Object.keys(date).forEach((item) => {
  //     date.pop()
  //   })
  //   Object.keys(response.data).forEach((item) => {
  //     date.push(response.data[item])
  //   })
  //   return date
  // })
}
const nextWeek=()=>{
  Object.keys(weekJS).forEach((item) => {
    weekJS.pop()
  })
  let date=new Date(now)
  date.setDate(date.getDate() + 7);
  now=new Date(date)
  getDateJS()
  // proxy.$axios.post('EmployeeController/GetDate',proxy.$qs.stringify({
  //   week:week+7
  // })).then(response=> {
  //   week=week+7
  //   Object.keys(date).forEach((item) => {
  //     date.pop()
  //   })
  //   Object.keys(response.data).forEach((item) => {
  //     date.push(response.data[item])
  //   })
  //   return date
  // })
}

const props = defineProps({
      storeId:{
        type:String,
        default: '1'
      }
    }
//       date: {
//         type:Array,
//         default:()=>[]
//       },
//       week:  {
//         type:Number,
//         default:0
//       },
//     }
)

// arrayFormat:'brackets'后端无法接收整个数组 只能单个接收如 a[0],a[1],a[2]等
// arrayFormat:'brackets'后端则接收数组名后加上[]
// arrayFormat:'repeat'后端则直接输入接收数组名
let storeId=ref(props.storeId)
const GetScheduling=()=>{
  proxy.$axios.post('EmployeeController/GetScheduling',proxy.$qs.stringify({
    storeId:storeId.value,
    weekJS:weekJS
  },{arrayFormat:'brackets'})).then(response=> {

  })
}
const AutoScheduling=()=>{
  proxy.$axios.post('EmployeeController/AutoSchedulingTime',proxy.$qs.stringify({
    storeId:storeId.value,
    weekJS:weekJS
  },{arrayFormat:'brackets'})).then(response=> {
    GetScheduling()
  })
}
const UpdateScheduling=()=>{
  proxy.$axios.post('EmployeeController/UpdateScheduling',proxy.$qs.stringify({
    employeeCol:employee.employeeCol,
    weekJS:weekJS[6]
  })).then(response=> {
    GetScheduling()
  })
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.selectWeek{
  position: relative;
  left: 40%;
  top:20px;
  display: flex;
  flex-direction: row;
  gap: 50px;
  width: 500px;
  height: 40px;
}
table{
  position: relative;
  top: 50px;
  left: 25%;
  border: 3px cornflowerblue solid;
}
tr{
  width: 100%;
  height: 40px;
  border: 3px cornflowerblue solid;
}
td{
  width: 100px;
  height: 40px;
  line-height: 30px;
  border: 3px cornflowerblue solid;
}
.auto{
  position: relative;
  top: 61px;
}
</style>
