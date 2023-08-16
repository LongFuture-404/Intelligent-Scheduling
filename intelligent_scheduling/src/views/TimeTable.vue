<template>
    <pop_ups ref="dialog" @confirmDia="confirmDia"></pop_ups>
    <div class="table">
    <div class="selectWeek">
      <button type="button" class="btn btn-primary" @click="lastWeek">上一周</button>
      <button type="button" class="btn btn-primary" @click="thisWeek">本周</button>
      <button type="button" class="btn btn-primary" @click="nextWeek">下一周</button>
    </div>
  <el-button @click="addScheduling" class="addScheduling btn btn-primary" type="primary">添加排班</el-button>

      <ul class="theTime">
        <li class="weekTime">
          <div class="weekDay First">星期数/时间</div></li>
        <li v-for="count in 7">
          <div class="weekDay">{{weekJS[count-1]}}<br>{{week[count-1]}}</div>
        </li>
      </ul>

      <ul class="theTime">
        <li class="weekTime">
          <div class="weekTimeFirst">8:00~11:00<br>(周末)9:00~12:00</div></li>
        <li v-for="count in 5">
          <div class="employeeBox">
            <ul class="employee">
              <li v-for="item in Scheduling[count-1].dateScheduling" v-if="Scheduling[count-1]!=null">
                <p v-if="item.startTime<'11:00'">
                  {{item.employeeName}}
                  <i class="fa fa-caret-down" @click="detailedShow(item)"></i>
                </p>
                <span v-show="item.isShowDetailet&&item.startTime<'11:00'">
                  {{item.employeePosts}}
                  {{item.startTime}}
                  {{item.endTime}}
                  <i class="update" @click="UpdateScheduling(item)">改</i>
                </span>
              </li>
            </ul>
          </div>
        </li>
        <li v-for="count in 2">
          <div class="employeeBox">
            <ul class="employee">
              <li v-for="item in Scheduling[4+count].dateScheduling" v-if="Scheduling[4+count]!=null">
                <p v-if="item.startTime<'12:00'">
                  {{item.employeeName}}
                  <i class="fa fa-caret-down" @click="detailedShow(item)"></i>
                </p>
                <span v-show="item.isShowDetailet&&item.startTime<'12:00'">
                  {{item.employeePosts}}
                  {{item.startTime}}
                  {{item.endTime}}
                  <i class="update" @click="UpdateScheduling(item)">改</i>
                </span>
              </li>
            </ul>
          </div>
        </li>
      </ul>

      <ul class="theTime">
            <li class="weekTime">
              <div class="weekTimeFirst">11:00~13:00<br>(周末)12:00~14:00</div></li>
            <li v-for="count in 5">
              <div class="employeeBox">
                <ul class="employee">
                  <li v-for="item in Scheduling[count-1].dateScheduling" v-if="Scheduling[count-1]!=null">
                    <p v-if="item.startTime<'13:00'&&item.startTime>='11:00'">
                      {{item.employeeName}}
                      <i class="fa fa-caret-down" @click="detailedShow(item)"></i>
                    </p>
                    <span v-show="item.isShowDetailet&&item.startTime<'13:00'&&item.startTime>='11:00'">
                      {{item.employeePosts}}
                      {{item.startTime}}
                      {{item.endTime}}
                      <i class="update" @click="UpdateScheduling(item)">改</i>
                    </span>
                  </li>
                </ul>
              </div>
            </li>
            <li v-for="count in 2">
              <div class="employeeBox">
                <ul class="employee">
                  <li v-for="item in Scheduling[4+count].dateScheduling" v-if="Scheduling[4+count]!=null">
                    <p v-if="item.startTime<'14:00'&&item.startTime>='12:00'">
                      {{item.employeeName}}
                      <i class="fa fa-caret-down" @click="detailedShow(item)"></i>
                    </p>
                    <span v-show="item.isShowDetailet&&item.startTime<'14:00'&&item.startTime>='12:00'">
                      {{item.employeePosts}}
                      {{item.startTime}}
                      {{item.endTime}}
                      <i class="update" @click="UpdateScheduling(item)">改</i>
                    </span>
                  </li>
                </ul>
              </div>
            </li>
        </ul>

  <ul class="theTime">
    <li class="weekTime">
      <div class="weekTimeFirst">13:00~15:00<br>(周末)14:00~16:00</div></li>
    <li v-for="count in 5">
      <div class="employeeBox">
        <ul class="employee">
          <li v-for="item in Scheduling[count-1].dateScheduling" v-if="Scheduling[count-1]!=null">
            <p v-if="item.startTime<'15:00'&&item.startTime>='13:00'">
              {{item.employeeName}}
              <i class="fa fa-caret-down" @click="detailedShow(item)"></i>
            </p>
            <span v-show="item.isShowDetailet&&item.startTime<'15:00'&&item.startTime>='13:00'">
              {{item.employeePosts}}
              {{item.startTime}}
              {{item.endTime}}
              <i class="update" @click="UpdateScheduling(item)">改</i>
            </span>
          </li>
        </ul>
      </div>
    </li>
    <li v-for="count in 2">
      <div class="employeeBox">
        <ul class="employee">
          <li v-for="item in Scheduling[4+count].dateScheduling" v-if="Scheduling[4+count]!=null">
            <p v-if="item.startTime<'16:00'&&item.startTime>='14:00'">
              {{item.employeeName}}
              <i class="fa fa-caret-down" @click="detailedShow(item)"></i>
            </p>
            <span v-show="item.isShowDetailet&&item.startTime<'16:00'&&item.startTime>='14:00'">
              {{item.employeePosts}}
              {{item.startTime}}
              {{item.endTime}}
              <i class="update" @click="UpdateScheduling(item)">改</i>
            </span>
          </li>
        </ul>
      </div>
    </li>
  </ul>

  <ul class="theTime">
    <li class="weekTime">
      <div class="weekTimeFirst">15:00~18:00<br>(周末)16:00~19:00</div></li>
    <li v-for="count in 5">
      <div class="employeeBox">
        <ul class="employee">
          <li v-for="item in Scheduling[count-1].dateScheduling" v-if="Scheduling[count-1]!=null">
            <p v-if="item.startTime<'18:00'&&item.startTime>='15:00'">
              {{item.employeeName}}
              <i class="fa fa-caret-down" @click="detailedShow(item)"></i>
            </p>
            <span v-show="item.isShowDetailet&&item.startTime<'18:00'&&item.startTime>='15:00'">
              {{item.employeePosts}}
              {{item.startTime}}
              {{item.endTime}}
              <i class="update" @click="UpdateScheduling(item)">改</i>
            </span>
          </li>
        </ul>
      </div>
    </li>
    <li v-for="count in 2">
      <div class="employeeBox">
        <ul class="employee">
          <li v-for="item in Scheduling[4+count].dateScheduling" v-if="Scheduling[4+count]!=null">
            <p v-if="item.startTime<'19:00'&&item.startTime>='16:00'">
              {{item.employeeName}}
              <i class="fa fa-caret-down" @click="detailedShow(item)"></i>
            </p>
            <span v-show="item.isShowDetailet&&item.startTime<'19:00'&&item.startTime>='16:00'">
              {{item.employeePosts}}
              {{item.startTime}}
              {{item.endTime}}
              <i class="update" @click="UpdateScheduling(item)">改</i>
            </span>
          </li>
        </ul>
      </div>
    </li>
  </ul>

  <ul class="theTime">
    <li class="weekTime">
      <div class="weekTimeFirst">18:00~21:00<br>(周末)18:00~22:00</div></li>
    <li v-for="count in 5">
      <div class="employeeBox">
        <ul class="employee">
          <li v-for="item in Scheduling[count-1].dateScheduling" v-if="Scheduling[count-1]!=null">
            <p v-if="item.startTime<'21:00'&&item.startTime>='18:00'">
              {{item.employeeName}}
              <i class="fa fa-caret-down" @click="detailedShow(item)"></i>
            </p>
            <span v-show="item.isShowDetailet&&item.startTime<'21:00'&&item.startTime>='18:00'">
              {{item.employeePosts}}
              {{item.startTime}}
              {{item.endTime}}
              <i class="update" @click="UpdateScheduling(item)">改</i>
            </span>
          </li>
        </ul>
      </div>
    </li>
    <li v-for="count in 2">
      <div class="employeeBox">
        <ul class="employee">
          <li v-for="item in Scheduling[4+count].dateScheduling" v-if="Scheduling[4+count]!=null">
            <p v-if="item.startTime<'22:00'&&item.startTime>='19:00'">
              {{item.employeeName}}
              <i class="fa fa-caret-down" @click="detailedShow(item)"></i>
            </p>
            <span v-show="item.isShowDetailet&&item.startTime<'22:00'&&item.startTime>='19:00'">
              {{item.employeePosts}}
              {{item.startTime}}
              {{item.endTime}}
              <i class="update" @click="UpdateScheduling(item)">改</i>
            </span>
          </li>
        </ul>
      </div>
    </li>
  </ul>

  <ul class="theTime">
    <li class="weekTime">
      <div class="weekTimeFirst">21:00~23:00<br>(周末)22:00~24:00</div></li>
    <li v-for="count in 5">
      <div class="employeeBox">
        <ul class="employee">
          <li v-for="item in Scheduling[count-1].dateScheduling" v-if="Scheduling[count-1]!=null">
            <p v-if="item.startTime<'23:00'&&item.startTime>='21:00'">
              {{item.employeeName}}
              <i class="fa fa-caret-down" @click="detailedShow(item)"></i>
            </p>
            <span v-show="item.isShowDetailet&&item.startTime<'23:00'&&item.startTime>='21:00'">
              {{item.employeePosts}}
              {{item.startTime}}
              {{item.endTime}}
              <i class="update" @click="UpdateScheduling(item)">改</i>
            </span>
          </li>
        </ul>
      </div>
    </li>
    <li v-for="count in 2">
      <div class="employeeBox">
        <ul class="employee">
          <li v-for="item in Scheduling[4+count].dateScheduling" v-if="Scheduling[4+count]!=null">
            <p v-if="item.startTime<'24:00'&&item.startTime>='22:00'">
              {{item.employeeName}}
              <i class="fa fa-caret-down" @click="detailedShow(item)"></i>
            </p>
            <span v-show="item.isShowDetailet&&item.startTime<'24:00'&&item.startTime>='22:00'">
              {{item.employeePosts}}
              {{item.startTime}}
              {{item.endTime}}
              <i class="update" @click="UpdateScheduling(item)">改</i>
            </span>
          </li>
        </ul>
      </div>
    </li>
  </ul>
    </div>
<div class="MainButton">
  <button type="button" class="btn btn-primary auto" @click="AutoScheduling">自动生成</button>
  <button type="button" class="btn btn-primary auto" @click="GetScheduling">查看本周排班安排</button>
</div>
</template>

<script setup lang="ts">
import {getCurrentInstance, reactive, ref} from "vue";
import store from "../store";
import dayjs from "dayjs";
import Pop_ups from "../components/pop_ups.vue";

let now = new Date();
let day = now.getDay();
let oneDayTime = 24 * 60 * 60 * 1000;
let MondayTime = '';
let weekJS = reactive([]);
let Scheduling=reactive([])
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
    let weekDay=dayjs(date.getFullYear() + '-' + month + '-' + Day).format("YYYY-MM-DD")
    weekJS.push(weekDay)
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
  GetScheduling()
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
  GetScheduling()
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
  GetScheduling()
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
let dialog = ref<InstanceType<typeof Pop_ups>| null>(null)

const confirmDia = (val:string): void => {
  console.log(val)
  GetScheduling()
  dialog.value?.closeDia()
}
const addScheduling = () => {
  dialog.value?.openAddDia(weekJS,store.state.storeId,data.schedulingCol)
}
const data=reactive({
  schedulingCol:'',
})
const props = defineProps({
      week:{
        type:Array,
        default:["星期一","星期二","星期三","星期四","星期五","星期六","星期日"]
      },
    },
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

const GetScheduling=()=>{
  proxy.$axios.post('EmployeeController/GetScheduling',proxy.$qs.stringify({
    storeId:store.state.storeId,
    weekJS:weekJS
  },{arrayFormat:'brackets'})).then(response=> {
    Object.keys(Scheduling).forEach((item) => {
      Scheduling.pop()
    })
    let result = response.data;
    let dataInfo = {};
    result.forEach((item, index) => {
      let { date } = item;
      let weekDay=dayjs(new Date(date)).format("YYYY-MM-DD")
      if (!dataInfo[weekDay]) {
        dataInfo[weekDay] = {
          date,
          dateScheduling: []
        }
      }
      item.isShowDetailet=false;
      dataInfo[weekDay].dateScheduling.push(item);
    });
    let list = Object.values(dataInfo);
    for(let scheduling of list){
      Scheduling.push(scheduling);
    }
    // console.log(Scheduling)
  })
}
GetScheduling()

const AutoScheduling=()=>{
  proxy.$axios.post('EmployeeController/AutoSchedulingTime',proxy.$qs.stringify({
    storeId:store.state.storeId,
    weekJS:weekJS
  },{arrayFormat:'brackets'})).then(response=> {
    alert(" 智能排班完成 ")
    GetScheduling()
  })
}
const UpdateScheduling=(employeeScheduling)=>{
  data.schedulingCol=employeeScheduling.schedulingCol
  dialog.value?.openUpdateDia(employeeScheduling,weekJS,store.state.storeId,data.schedulingCol)
}
const detailedShow=(employeeScheduling)=>{
  // console.log(employeeScheduling)
  employeeScheduling.isShowDetailet = !employeeScheduling.isShowDetailet;
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.table{
    width: 96%;
    position: absolute;
    left:4%;
    top:40px;
}
.MainButton{
  width: 400px;
  height: 50px;
  position: absolute;
  top: 110%;
  left: 43%;
  display: flex;
  flex-direction: row;
  gap: 50px;
}
.selectWeek{
  position: relative;
  left: 40%;
  top:10px;
  display: flex;
  flex-direction: row;
  gap: 50px;
  width: 350px;
  height: 40px;
}
.addScheduling{
  width: 100px;
  position: absolute;
  left: 80%;
  top: 10px;
}
div.weekDay{
    padding: 0;
  height: 80px;
    width: 170px;
}
div.weekDay.First{
  width: 150px;
}
div.weekTimeFirst{
  padding: 0;
  width: 150px;
}
ul.employee{
  padding: 0;
  float: left;
}
p{
  margin: 0;
  font-size: 13px;
  width: 52px;
  height: 20px;
  line-height: 25px;
}
span{
  font-size: 8px;
}
ul.theTime{
  width: 95%;
  display:block;
  position: relative;
  top: 15px;
}
li{
  display:inline-block;
  float:left;
  list-style:none;
}
ul div{
  width: 170px;
  height: 100px;
  line-height: 32px;
  border: 2px cornflowerblue solid;
}
ul div.employeeBox{
    width: 170px;
  box-sizing: border-box;
  padding: 0;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
}
</style>