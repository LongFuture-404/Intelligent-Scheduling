<template>
    <div class="storeMain">
        店铺名称:<el-input v-model="data.storesName"></el-input>
        店铺地址:<el-input v-model="data.storesAddress"></el-input>
        店铺面积:<el-input v-model="data.storesSize"></el-input>
        <el-button class="update" type="primary" plain @click="update">确认</el-button>
    </div>
</template>

<script setup lang="ts">
import {getCurrentInstance, reactive} from "vue";
import store from "../store";
import {ElMessage} from "element-plus";

let { proxy } = getCurrentInstance();
const data=reactive({
    storesName: '',
    storesAddress: '',
    storesSize: ''
})
const init=()=>{
    proxy.$axios.post('StoreController/storeSelect',proxy.$qs.stringify({
        storesId:store.state.storeId
    })).then(response=>{
        data.storesName=response.data.storesName,
        data.storesAddress=response.data.storesAddress,
        data.storesSize=response.data.storesSize
    })
}
init()

const update=()=>{
    proxy.$axios.post('StoreController/updateStore',proxy.$qs.stringify({
        storesId:store.state.storeId,
        storesName:data.storesName,
        storesAddress:data.storesAddress,
        storesSize:data.storesSize
    })).then(response=>{
            ElMessage({
                customClass:'focus-message',
                message:'修改成功',
                type:'success'});
    })
}
</script>

<style lang="scss">
.storeMain{
    width: 60%;
    position: absolute;
    padding: 40px 0;
    left:30%;
    top:20%;
    background-color: aqua;
}
.storeMain .el-input{
    position: relative;
    left: 22%;
    width:55%;
    display: flex;
    flex-direction: column;
    gap: 300px;
}
.storeMain .update{
    position: relative;
    top: 20px;
}
</style>