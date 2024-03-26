<template>
  <div class="resourcesharing">
    <div class="bg">
      <el-image style="width: 100%; height: 100%" :src="resourceSharingBackgroundImage" fit="cover" />
    </div>
    <div class="main">
      <div class="content">
        <div class="sharinginfoitem" v-for="item in resourceSharinginfo" :key="item.id">
          <div class="shareheader">
            <div class="avatar" style="width: 100px;height: 100px;">
              <el-image style="width: 100%; height: 100%" :src="publicUrl+item.user.avatar" fit="cover" />
            </div>
            <div class="nickname">
              {{ item.user.nickname }}
            </div>
          </div>
          <div class="img-Info">
            <div class="shareimg" style="width: 200px;height: 200px;">
              <el-image style="width: 100%; height: 100%" :src="publicUrl+item.imageUrl" fit="cover" />
            </div>
            <div class="shareinfo">

            </div>
          </div>
          <div class="description">
            {{ item.description }}
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue"
import http from "../../../api/http";
import { publicUrl, resourceSharingBackgroundImage } from "../../../api/util";
const resourceSharinginfo = ref([])
const page = ref(1)
const size = ref(2)
const getResourceSharingPage=(page = 0,size = 2,userid = 0)=>{
  http.post('/resourceSharing/getResourceSharingPage',{
    page,
    size,
    userid
  })
  .then(res=>{
    console.log(res.data.data)
    resourceSharinginfo.value = [...resourceSharinginfo.value,...res.data.data]
  })
  .catch(err=>{
    console.log(err)
  })
}
onMounted(()=>{
  getResourceSharingPage(undefined,undefined,undefined)
})
</script>

<style lang="scss" scoped>
.resourcesharing{
  background-color: rgb(210, 206, 206);
  .bg{
    width: 100%;
    height: 400px;
  }
  .main{
    width: 100%;
    height: 600px;
  }
}
</style>
