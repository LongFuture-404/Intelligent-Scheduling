<template>
<body>
  <div class="select">
<!--    js写法-->
<!--    <img alt="Vue logo" class="logo" :src=logo width="20" height="40" />-->
<!--    ts写法-->
    <img alt="Vue logo" class="logo" :src="require('../assets/logo.png')" width="40" height="40" />
    <ul>
      <li>
        <button v-if="store.state.user.employeeName===''" @click="login">登录</button>
        <button v-if="store.state.user.employeeName!==''" @click="login">{{store.state.user.employeeName}}</button>
      </li>
      <li>
        <button @click="exit">退出</button>
      </li>
    </ul>
  </div>
</body>
</template>

<script setup lang="ts">
import createPersistedState from "vuex-persistedstate";

declare function require(img: string): string;
import logo from '../assets/logo.png'
import {useRoute, useRouter} from 'vue-router';
import store from "../store/index.ts";
// import {ref} from "vue";
// let user=ref(props.user)
// const created=() =>{
//   if(store.state.user.employeeName===''){
//     user.value = '登录'
//   }else{
//     user.value = store.state.user.employeeName
//   }
//   return user
// }
// created()

const props = defineProps({
      msg: String,
      // user: String,
      logo: Image
    }
)

const router = useRouter()
const route = useRoute()

const login=() =>{
  if(store.state.user.employeeName==='') {
    router.push({path: '/'})
  }
  else{
    router.push({path: '/index'})
  }
}
const exit=()=>{
  sessionStorage.clear()
  store.state.user.employeeName=''
  router.replace({path: '/white'});
}
</script>

<style scoped>
body{
  max-width: 100%;
  min-height: 40px;
  background-color: cornflowerblue;
}
.logo {
  display: block;
  margin: 0 1rem 0 0;
  /*margin: 0 auto 2rem;*/
}
.select{
  width: 100%;
  height: 40px;
  color: aqua;
  display: flex;
  flex-direction: row;
  z-index: 5;
}
ul {
  position: relative;
  left: 60%;
  margin:0;padding:0;
  display: flex;
  flex-direction: row;
  gap: 30px;
}
li {
  list-style:none;
  line-height: 40px;
}
button{
  margin:0;padding:0;border:0;
  width: 80px;
  height: 40px;
  background-color: aqua;
  color: darkblue;
}
button.navigation{
  width: 57px;
}
</style>