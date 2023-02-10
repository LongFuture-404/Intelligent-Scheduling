<template>
  <div class="input">
  <div class="input-group mb-3">
    <div class="input-group mb-3">
      <span class="input-group-text" id="basic-addon1">用户名</span>
      <input type="text" class="form-control" placeholder="用户名" v-model="data.UserId" aria-label="UserId" aria-describedby="basic-addon1">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text" id="basic-addon1">密码</span>
      <input type="password" class="form-control" placeholder="密码" v-model="data.PassWord" aria-label="PassWord" aria-describedby="basic-addon1">
    </div>
  </div>
    <div class="button-login">
      <button class="btn btn-primary" @click="login">登陆</button>
    </div>
  </div>
</template>

<script setup lang="ts">
import {useRoute, useRouter} from 'vue-router';
import store from "../store/index.ts";
import {getCurrentInstance, reactive} from "vue";
import router from "../router";
let { proxy } = getCurrentInstance();

const data = reactive({
  UserId: '',
  PassWord: ''
})
const login=()=>{
  if(data.UserId===''){
    alert("请输入用户名")
    return
  }
  if(data.PassWord===''){
    alert("请输入密码")
    return
  }
  proxy.$axios.post('EmployeeController/getUserByIdByPass',proxy.$qs.stringify({
    UserId:data.UserId,
    PassWord:data.PassWord
  })).then(response=>{
    let employee=response.data;
    if(Object.keys(employee).length===0){
      alert("密码错误请重新输入")
    }
    else if(employee.employeeId===null){
      alert("用户名错误请重新输入")
    }
    else{
      store.commit('addUser', {employeeId:employee.employeeId,employeeName:employee.employeeName})
      router.push({path: '/index'});
    }
  }).catch(error=>{
    console.error(error);
  })
}
</script>

<style scoped>
.input{
  position: relative;
  left: 40%;
  top: 200px;
  width: 300px;
  height: 300px;
}
</style>