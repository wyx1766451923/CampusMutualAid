<template>
  <div class="cmpinfodetail">
    <div class="bg">
        <el-image style="width: 100%; height: 100%" :src="backgroundImage" fit="cover" />
    </div>
    <div class="essaty">
        <div class="title">
            {{  campusinfoDetail.title}}
        </div>
        <div class="releaseTime">
            日期：{{ campusinfoDetail.releaseTime }}
        </div>
        <div class="content" >
            {{ campusinfoDetail.content }}
        </div>
        <div class="image">
            <el-image style="width: 100%; height: 100%" :src="publicUrl+campusinfoDetail.imageurl" fit="cover" />
        </div>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';
import http from '../../../api/http';
import {backgroundImage,publicUrl} from '../../../api/util'
const route = useRoute()
const id = route.params.id
const campusinfoDetail = ref('')
console.log(route.params)
const getCampusinfo=()=>{
    http.get('/campusinfo/getCampusinfoById',{
        params: {
            id
        }
    })
    .then(res=>{
        console.log(res.data.data)
        campusinfoDetail.value = res.data.data
    })
    .catch(err=>{
        console.log(err)
    })
}

onMounted(()=>{
    getCampusinfo()
})
</script>

<style lang="scss" scoped>
.cmpinfodetail{
    background-color: white;

    .bg{
        width: 100%;
        height: 400px;
    }
    .essaty{
        // height: auto;
        background: rgb(243, 240, 240);
        margin: 10px 100px;
        border-radius: 20px;
        box-shadow: 0 5px 18px 1.8px rgba(243, 240, 240,1);
        .title{
            font-size: 24px;
            font-weight: bold;
            padding: 50px 0 40px 0;
            text-align: center;
        }
        .releaseTime{
            text-align: center;
            font-size: 16px;
            color: gray;
            padding: 0 0 40px 0;
        }
        .content{
            margin: 0 30px 0 30px;
            color: rgb(97, 97, 97);
        }
        .image{
            width: 500px;
            margin: 20px auto;
            padding-bottom: 50px;
        }
    }
}
</style>

