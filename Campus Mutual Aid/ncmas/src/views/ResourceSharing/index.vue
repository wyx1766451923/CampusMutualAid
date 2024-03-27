<template>
  <div class="resourcesharing">
    <div class="bg">
      <el-image style="width: 100%; height: 100%" :src="resourceSharingBackgroundImage" fit="cover" />
    </div>
    <div class="main">
      <div class="content" ref="sharingRef" @scroll="handleScroll">
        <div class="sharinginfoitem" v-for="item in resourceSharinginfo" :key="item.id">
          <div class="shareheader">
            <div class="avatar" >
              <el-image style="width: 100%; height: 100%" :src="publicUrl+item.user.avatar" fit="cover" />
            </div>
            <div class="nickname">
              {{ item.user.nickname }}
            </div>
          </div>
          <div class="img-Info">
            <div class="shareimg" >
              <el-image style="width: 100%; height: 100%" :src="publicUrl+item.imageUrl" fit="cover" />
            </div>
            <div class="shareinfo">
              <div class="resourcename">
                {{ item.resourcename }}
              </div>
              <div class="resourcetype">
                <p>资源类型:</p>{{ item.resourcetype }}
              </div>
              <div class="access">
                <p>获取方式:</p>{{ item.access }}
              </div>
              <div class="contactinformation">
                <p>联系方式:</p>{{ item.contactinformation }}
              </div>
            </div>
          </div>
          <div class="description">
            <div class="desctopic">详情</div>
            <div class="descinfo">
              {{ item.description }}
            </div>
          </div>
        </div>
        <div class="nomore" v-if="sharingCount<2">
          没有更多内容了~~
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
const sharingRef = ref('')
const sharingCount = ref(0)
function throttle(fn,delay = 1000) {
  let timer = null
  return function (...args){
    if(timer == null){
      timer = setTimeout(()=>{
        fn.call(this,...args)
        timer = null
      },delay)
    }
  }
}
const getResourceSharingPage=(page = 0,size = 2,userid = 0)=>{
  http.post('/resourceSharing/getResourceSharingPage',{
    page,
    size,
    userid
  })
  .then(res=>{
    // console.log(res.data.data)
    sharingCount.value = res.data.data.length
    resourceSharinginfo.value = [...resourceSharinginfo.value,...res.data.data]
  })
  .catch(err=>{
    console.log(err)
  })
}
const handleScroll=throttle(function(){
      const sharingref = sharingRef.value
      if (sharingref.scrollTop + sharingref.clientHeight >= sharingref.scrollHeight-1) {
        page.value = page.value+1
        // loadMore()
        getResourceSharingPage((page.value-1)*size.value,undefined,undefined)
        console.log('到底了');
      }
},500)
onMounted(()=>{
  getResourceSharingPage(undefined,undefined,undefined)
})
</script>

<style lang="scss" scoped>
.resourcesharing{
  background-color: rgb(241, 235, 235);
  width: 100%;
  height: auto;
  .bg{
    width: 100%;
    height: 400px;
  }
  .main{
    width: 100%;
    height: auto;
    .content::-webkit-scrollbar{
      display: none;
    }
    .content{
      width: 50%;
      margin: 0 auto;
      height: 100vh;
      overflow: auto;
      .sharinginfoitem{
        width: 100%;
        margin: 20px 0;
        .shareheader{
          width: 100%;
          background-color: rgb(69, 179, 238);
          height: 60px;
          display: flex;
          justify-content: center;
          
          .avatar{
            width: 50px;
            height: 50px;
            margin-top: 5px;
            border-radius: 50%;
            overflow: hidden;
            box-shadow: 0 5px 18px 1.8px rgb(241, 235, 235)
          }
          .nickname{
            line-height: 55px;
            margin-left:10px ;
            font-weight: bold;
          }
        }
        .img-Info{
          margin-top: 10px;
          display: flex;
          justify-content: space-between;
          .shareimg{
            width: 400px;
            height: 400px;
            box-shadow: 0 5px 18px 1.8px rgb(249, 246, 246);

          }
          .shareinfo{
            width: 320px;
            background-color: rgb(243, 245, 246);
            box-shadow: 0 5px 18px 1.8px rgb(221, 219, 219);
            padding: 20px 15px;
            p{
              width: 100px;
            }
            .resourcename{
              text-align: center;
              font-weight: bold;
              margin-bottom: 20px;

            }
            .resourcetype{
              display: flex;
              height: 50px;
              line-height: 50px;
              border-bottom: 1px solid rgb(167, 167, 241);
            }
            .access{
              display: flex;
              height: 50px;
              line-height: 50px;
              border-bottom: 1px solid rgb(167, 167, 241);
            }
            .contactinformation{
              display: flex;
              height: 50px;
              line-height: 50px;
              border-bottom: 1px solid rgb(167, 167, 241);
            }
          }

        }
        .description{
          width: 100%;
          height: 60px;
          margin-top: 10px;
          background-color: rgb(243, 245, 246);
          padding-bottom: 10px;
          .desctopic{
            width: 100%;
            padding: 5px 0;
            text-align: center;
            background-color: rgb(124, 211, 240);
          }
          .descinfo{
            margin: 10px;
          }
          
        }
      }
      .nomore{
        text-align: center;
        height: 50px;
        line-height: 30px;
        color: gray;
      }
    }
    
  }
}
</style>
