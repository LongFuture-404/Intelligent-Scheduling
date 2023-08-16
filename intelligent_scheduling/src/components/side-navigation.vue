<template>
<div class="side-navigation">
    <ul>
        <li><router-link :to="{path:'/index'}">排班页面</router-link></li>
        <li><router-link :to="{path:'/storeManage'}">店铺管理</router-link></li>
        <li><router-link :to="{path:'/employeeManage'}">员工管理</router-link></li>
        <li><router-link :to="{path:'/schedulingRoleManage'}">排班管理</router-link></li>
        <li><router-link :to="{path:'/userManage'}">用户管理</router-link></li>
    </ul>
</div>
</template>

<script setup lang="ts">

</script>

<style scoped>
a{
    text-decoration: none;
}
.router-link-active {
    text-decoration: none;
}
.side-navigation{
    background-color: aqua;
    position: fixed;
    top: 40px;
    width: 6%;
    height: 100%;
}
ul{
    list-style-type: none;
    padding: 40px 5px 5px;
}
li{
    height: 60px;
}
</style>