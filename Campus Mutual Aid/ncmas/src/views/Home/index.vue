<template>
    <div class="common-layout">
      <el-container>
          <HeaderNav/>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </div>
  </template>

<script setup>
import HeaderNav from '@/components/HeaderNav.vue';
</script>

<style lang="scss" scoped>
*{
  padding: 0;
  margin: 0;
}
.common-layout{
  height: 100%;
} 
.el-container{
  height: 100%;
}
</style>
