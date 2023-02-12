<template>
    <div class="selectWeek">
      <button type="button" class="btn btn-primary" @click="lastWeek">上一周</button>
      <button type="button" class="btn btn-primary" @click="thisWeek">本周</button>
      <button type="button" class="btn btn-primary" @click="nextWeek">下一周</button>
    </div>
      <div hidden="hidden">{{storeId}}</div>

      <ul class="theTime">
        <li class="weekTime">
          <div>星期数/时间</div></li>
        <li v-for="count in 7">
          <div class="weekDay">{{weekJS[count-1]}}<br>{{week[count-1]}}</div>
        </li>
      </ul>

      <ul class="theTime">
        <li class="weekTime">
          <div>8:00~11:00<br>(周末)9:00~12:00</div></li>
        <li v-for="count in 5">
          <div>
            <ul class="employee">
              <li v-for="item in Scheduling[count].dateScheduling" v-if="Scheduling[count]!=null">
                <p v-if="item.startTime<'11:00'">
                  {{item.employeeName}}
                </p>
              </li>
            </ul>
          </div>
        </li>
        <li v-for="count in 2">
          <div>
            <ul class="employee">
              <li v-for="item in Scheduling[4+count].dateScheduling" v-if="Scheduling[4+count]!=null">
                <p v-if="item.startTime<'12:00'">
                  {{item.employeeName}}
                </p>
              </li>
            </ul>
          </div>
        </li>
      </ul>

      <ul class="theTime">
            <li class="weekTime">
              <div>11:00~13:00<br>(周末)12:00~14:00</div></li>
            <li v-for="count in 5">
              <div>
                <ul class="employee">
                  <li v-for="item in Scheduling[count].dateScheduling" v-if="Scheduling[count]!=null">
                    <p v-if="item.startTime<'13:00'&&item.startTime>='11:00'">
                      {{item.employeeName}}
                    </p>
                  </li>
                </ul>
              </div>
            </li>
            <li v-for="count in 2">
              <div>
                <ul class="employee">
                  <li v-for="item in Scheduling[4+count].dateScheduling" v-if="Scheduling[4+count]!=null">
                    <p v-if="item.startTime<'14:00'&&item.startTime>='12:00'">
                      {{item.employeeName}}
                    </p>
                  </li>
                </ul>
              </div>
            </li>
        </ul>

  <ul class="theTime">
    <li class="weekTime">
      <div>13:00~15:00<br>(周末)14:00~16:00</div></li>
    <li v-for="count in 5">
      <div>
        <ul class="employee">
          <li v-for="item in Scheduling[count].dateScheduling" v-if="Scheduling[count]!=null">
            <p v-if="item.startTime<'15:00'&&item.startTime>='13:00'">
              {{item.employeeName}}
            </p>
          </li>
        </ul>
      </div>
    </li>
    <li v-for="count in 2">
      <div>
        <ul class="employee">
          <li v-for="item in Scheduling[4+count].dateScheduling" v-if="Scheduling[4+count]!=null">
            <p v-if="item.startTime<'16:00'&&item.startTime>='14:00'">
              {{item.employeeName}}
            </p>
          </li>
        </ul>
      </div>
    </li>
  </ul>

  <ul class="theTime">
    <li class="weekTime">
      <div>15:00~18:00<br>(周末)16:00~19:00</div></li>
    <li v-for="count in 5">
      <div>
        <ul class="employee">
          <li v-for="item in Scheduling[count].dateScheduling" v-if="Scheduling[count]!=null">
            <p v-if="item.startTime<'18:00'&&item.startTime>='15:00'">
              {{item.employeeName}}
            </p>
          </li>
        </ul>
      </div>
    </li>
    <li v-for="count in 2">
      <div>
        <ul class="employee">
          <li v-for="item in Scheduling[4+count].dateScheduling" v-if="Scheduling[4+count]!=null">
            <p v-if="item.startTime<'19:00'&&item.startTime>='16:00'">
              {{item.employeeName}}
            </p>
          </li>
        </ul>
      </div>
    </li>
  </ul>

  <ul class="theTime">
    <li class="weekTime">
      <div>18:00~21:00<br>(周末)18:00~22:00</div></li>
    <li v-for="count in 5">
      <div>
        <ul class="employee">
          <li v-for="item in Scheduling[count].dateScheduling" v-if="Scheduling[count]!=null">
            <p v-if="item.startTime<'21:00'&&item.startTime>='18:00'">
              {{item.employeeName}}
            </p>
          </li>
        </ul>
      </div>
    </li>
    <li v-for="count in 2">
      <div>
        <ul class="employee">
          <li v-for="item in Scheduling[4+count].dateScheduling" v-if="Scheduling[4+count]!=null">
            <p v-if="item.startTime<'22:00'&&item.startTime>='19:00'">
              {{item.employeeName}}
            </p>
          </li>
        </ul>
      </div>
    </li>
  </ul>

  <ul class="theTime">
    <li class="weekTime">
      <div>21:00~23:00<br>(周末)22:00~24:00</div></li>
    <li v-for="count in 5">
      <div>
        <ul class="employee">
          <li v-for="item in Scheduling[count].dateScheduling" v-if="Scheduling[count]!=null">
            <p v-if="item.startTime<'23:00'&&item.startTime>='21:00'">
              {{item.employeeName}}
            </p>
          </li>
        </ul>
      </div>
    </li>
    <li v-for="count in 2">
      <div>
        <ul class="employee">
          <li v-for="item in Scheduling[4+count].dateScheduling" v-if="Scheduling[4+count]!=null">
            <p v-if="item.startTime<'24:00'&&item.startTime>='22:00'">
              {{item.employeeName}}
            </p>
          </li>
        </ul>
      </div>
    </li>
  </ul>
<div class="MainButton">
  <button type="button" class="btn btn-primary auto" @click="AutoScheduling">自动生成</button>
  <button type="button" class="btn btn-primary auto" @click="GetScheduling">查看本周排班安排</button>
</div>

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
      },
      week:{
        type:Array,
        default:["星期一","星期二","星期三","星期四","星期五","星期六","星期日"]
      }
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

let storeId=ref(props.storeId)
const GetScheduling=()=>{
  proxy.$axios.post('EmployeeController/GetScheduling',proxy.$qs.stringify({
    storeId:storeId.value,
    weekJS:weekJS
  },{arrayFormat:'brackets'})).then(response=> {
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
      dataInfo[weekDay].dateScheduling.push(item);
    });
    for (let weekCount=0;weekCount<5;weekCount++) {
      dataInfo[weekJS[weekCount]].dateScheduling.forEach((item,index)=>{
        let {startTime}=item;
        if(dataInfo[weekJS[weekCount]].dateScheduling[startTime]){

        }
      })
    }
    let list = Object.values(dataInfo);
    for(let scheduling of list){
      scheduling.isShowDetailet = false;
    }
    Scheduling = list;
    return Scheduling
  })
}
GetScheduling()

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
.MainButton{
  width: 400px;
  height: 50px;
  position: relative;
  top: -20px;
  left: 40%;
  display: flex;
  flex-direction: row;
  gap: 50px;
}
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
.auto{
  position: relative;
  top: 61px;
}
ul.employee{
  padding: 0;
  float: left;
}
p{
  font-size: 14px;
  width: 50px;
  height: 14px;
}
ul.theTime{
  width: 100%;
  display:block;
  position: relative;
  top: 30px;
  height: 60px;
}
li{
  display:inline-block;
  float:left;
  list-style:none;
}
ul div{
  width: 180px;
  height: 76px;
  line-height: 38px;
  border: 2px cornflowerblue solid;
}
</style>
