<template>
  <div class="LostAndFoundDetail">
    <div class="bg">
      <el-image style="width: 100%; height: 100%" :src="lostAndFoundBackgroundImage" fit="cover" />
    </div>
    <div class="main">
      <div class="content">
        <div class="header">
          <div class="lostOrfound">
            {{ lostAndFoundInfo.type==0?'找物品':'寻失主' }}
          </div>
          <div class="userinfo">
            <div class="avatar">
              <el-avatar :size="50" :src="publicUrl+sticker.avatar" />
            </div>
            <div class="username">
              {{ sticker.username }}
            </div>
          </div>

        </div>
        <div class="lostorfoundinfo">
          <div class="info-image">
            <el-image style="width: 100%; height: 100%" :src="publicUrl+lostAndFoundInfo.imageUrl" fit="cover" />
          </div>
          <div class="info-content">
            <div class="goodsname">
              {{ lostAndFoundInfo.goodsName }}
            </div>
            <div class="address">
              <p>丢失/拾取地址：</p>{{ lostAndFoundInfo.address }}
            </div>
            <div class="time">
              <p>丢失/拾取时间：</p>{{ lostAndFoundInfo.time }}
            </div>
            <div class="Contact">
              <p>联系人：</p>{{ lostAndFoundInfo.name }}
            </div>
            <div class="contactInformation">
              <p>联系方式：</p>{{ lostAndFoundInfo.contactInformation }}
            </div>
            <div class="description">
              <p>详细描述：</p>{{ lostAndFoundInfo.description }}
            </div>
          </div>
        </div>
        
      </div>
      <div class="comments">
        <div class="topic">
          评论
        </div>
        <div class="postcomments">
          <div class="commentsItem" v-for="commentsitem in comments">
            <div class="commentavatar">
              <el-avatar :size="50" :src="publicUrl+commentsitem.user.avatar" />

            </div>
            <div class="usercommentinfo">
              <div class="username-publishtime">
                <div class="username">
                  {{ commentsitem.user.username }}
                </div>
                <div class="publishTime">
                  {{ commentsitem.publishTime }}
                </div>
              </div>
              <div class="commentContent">
                {{ commentsitem.commentContent }}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>

import { useRoute } from "vue-router";
import {onMounted, ref} from 'vue' 
import { lostAndFoundBackgroundImage ,publicUrl} from "../../../api/util";
import http from "../../../api/http";
const route = useRoute()
const id = ref(1)
const lostAndFoundInfo = ref('')
const sticker = ref('')
const comments = ref([])
const getLostAndFoundCommentsById=()=>{
  http.get("/LostAndFound/getLostAndFoundCommentsById",{
    params:{
      id:id.value
    }
  })
  .then(res=>{
    comments.value = res.data.data
  })
  .catch(err=>{
    console.log(err)
  })
}
const getLostAndFoundInfoById=(id)=>{
  http.get("/LostAndFound/getLostAndFoundInfoById",{
    params:{
      id
    }
  })
  .then(res=>{
    console.log(res.data.data)
    lostAndFoundInfo.value = res.data.data
    sticker.value = res.data.data.user
  })
  .catch(err=>{
    console.log(err)
  })
}
onMounted(() => {
  id.value = route.params.id
  console.log("id:"+id.value,"params"+route.params.id)
  getLostAndFoundInfoById(route.params.id)
  getLostAndFoundCommentsById(route.params.id)
  // getLostAndFoundInfoById()

})
</script>

<style lang="scss" scoped>
.LostAndFoundDetail{
  width: 100%;

  .bg{
    width: 100%;
    height: 400px;
  }
  .main{
    width: 100%;
    height: 500px;
    padding: 20px 0;
    background: linear-gradient(rgb(34, 97, 149) 50%,rgb(147, 196, 230));
    display: flex;
    .content{
      width: 70%;
      height: 500px;
      margin: 0 0 0 100px;
      box-shadow: 0 5px 18px 1.8px rgba(34, 97, 149,0.8);
      background-color: white;
      border-radius: 10px;
      .header{
        height: 60px;
        border-bottom: 1px solid rgb(130, 209, 234);
        display: flex;
        justify-content: space-around;
        align-items: center;
        .lostOrfound{
          font-size: 18px;
          padding: 5px 10px;
          color: rgb(139, 170, 237);
          border: 1px solid rgb(154, 221, 250) ;
          border-radius: 5px;
          
        }
        .userinfo{
          display: flex;
          align-items: center;
          .avatar{

          }
          .username{
            margin-left: 10px;
          }
        }
      }
      .lostorfoundinfo{
        width: 100%;
        height: 440px;
        display: flex;
        .info-image{
          width: 50%;
        }
        .info-content{
          width: 50%;
          p{
            font-weight: bold;
            width: 25%;
            
          }
          .goodsname{
            height: 40px;
            line-height: 40px;
            padding-left: 5px;
            color: white;
            background-color: rgb(17, 130, 211);
          }
          .address{
            height: 50px;
            line-height: 50px;
            margin: 0 8px;
            padding: 10px 0;
            border-bottom: 1px solid rgb(17, 130, 211);
            display: flex;
          }
          .time{
            height: 50px;
            line-height: 50px;
            margin: 0 8px;
            padding: 10px 0;
            border-bottom: 1px solid rgb(17, 130, 211);
            display: flex;
          }
          .Contact{
            height: 50px;
            line-height: 50px;
            margin: 0 8px;
            padding: 10px 0;
            border-bottom: 1px solid rgb(17, 130, 211);
            display: flex;
          }
          .contactInformation{
            margin: 0 8px;
            height: 50px;
            line-height: 50px;
            padding: 10px 0;
            border-bottom: 1px solid rgb(17, 130, 211);
            display: flex;
          }
          .description{
            margin: 0 8px;
            height: 80px;
            line-height: 40px;
            padding: 10px 0;
            border-bottom: 1px solid rgb(17, 130, 211);
            display: flex;

          }
        }

      }

    }
  }
  .comments{
    width: 300px;
    height: 500px;
    margin-left: 30px;
    background-color: white;
    box-shadow: 0 5px 18px 1.8px rgba(34, 97, 149,0.8);
    border-radius: 10px;
    .topic{
      margin: 10px 0 10px 10px;

    }
    .topic::before{
      content: "";
      border-left: 4px solid rgb(71, 188, 228);
      padding-right: 5px;
      
    }
    .postcomments{
      .commentsItem{
        display: flex;
        .commentavatar{

        }
        .usercommentinfo{
          .username-publishtime{
            display: flex;
          }
        }
      }
    }
  }
}
</style>

