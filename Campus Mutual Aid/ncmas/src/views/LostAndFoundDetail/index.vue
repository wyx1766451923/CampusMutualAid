<template>
  <div class="">11111111</div>
</template>

<script setup>

import { useRoute } from "vue-router";
import {onMounted} from 'vue' 
const route = useRoute()
onMounted(() => {
    console.log(route.params)
})
</script>

<style lang="scss" scoped></style>

