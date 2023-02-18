<template>
  <el-dialog class="UpdateScheduling" title="换班员工信息如下:" :show-close="false" v-model="showDia" width="40%">
    【{{data.employeeName}}】可换班员工
    <select>
      <option>张三</option>
      <option>李四</option>
    </select>
    <template v-slot:footer>
      <div class="button">
        <el-button @click="confirmDia" class="btn btn-primary auto" type="primary">确定</el-button>
        <el-button @click="closeDia" class="btn btn-primary auto" plain>取消</el-button>
      </div>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import {ref, defineEmits, defineExpose, reactive} from 'vue'

const data = ref({
  employeeName:''
})
const emit = defineEmits([ 'confirmDia'])
let showDia = ref<boolean>(false)
const openDia= (employeeName): void => {
  data.value.employeeName=employeeName;
  showDia.value = true
}
const closeDia = (): void => {showDia.value = false
}
const confirmDia = (): void => {
  emit( 'confirmDia','弹窗内容事件处理完毕，信息传给父组件')
}
// vue3中规定，使用了<script setup>的组件是默认私有的:
//一个父组件无法访问到一个使用了<script setup>的子组件中的任何东西，除非子组件在其中通过defineExpose宏显式暴露
defineExpose({
  openDia,closeDia})

</script>

<style scoped>
div.button{
  width: 200px;
  height: 40px;
  margin-left:33%;
  margin-right:auto;
  display: flex;
  flex-direction: row;
  gap: 40px;
}
</style>
<style>
.UpdateScheduling{
  z-index: 10;
  position: absolute;
  left: 35%;
  top: 40%;
  width: 30%;
  height: 150px;
  background-color: deepskyblue;
  border: deepskyblue solid 1px;
}
</style>
