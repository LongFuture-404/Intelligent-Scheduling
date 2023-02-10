<template>
  <header>
    <LoginAndExit/>
  </header>
  <main>
    <router-view></router-view>
  </main>
</template>

<script setup lang="ts">
import LoginAndExit from "./components/LoginAndExit.vue";

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
