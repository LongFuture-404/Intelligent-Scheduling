<template>
  <header>
    <LoginAndExit/>
  </header>
  <main>
    <side-navigation v-if="store.state.user.employeeId!=''"/>
    <router-view></router-view>
  </main>
</template>

<script setup lang="ts">
import LoginAndExit from "./components/LoginAndExit.vue";
import SideNavigation from "./components/side-navigation.vue";
import store from "./store";
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
