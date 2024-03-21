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
            <div class="nickname">
              {{ sticker.nickname }}
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
        <div class="topic-opr">
          <div class="topic">
            评论
          </div>
          <div class="op">
            <el-button type="primary" @click="handleComment()">评论</el-button>
          </div>
        </div>
        <div class="postcomments" ref="commentsRef" @scroll="handleScroll">
          <div class="commentsItem" v-for="commentsitem in comments">
            <div class="commentavatar">
              <el-avatar :size="40" :src="publicUrl+commentsitem.user.avatar" />

            </div>
            <div class="usercommentinfo">
              <div class="nickname-publishtime">
                <div class="nickname">
                  {{ commentsitem.user.nickname }}
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
          <div class="noMore" v-if="commentCount<7">
            没有更多评论了~~
          </div>
        </div>

      </div>
    </div>
      <div class="publishComment" v-show="pubComShow">
        <div class="commentTextArea">
          <el-input
            v-model="mycomment"
            style="width: 240px;"
            :rows="3"
            resize="none"
            type="textarea"
            maxlength="40"
            show-word-limit
            placeholder="请输入评论"
          />
        </div>
        <div class="ibutton">
          <div class="cancelButton">
            <el-button type="info" @click="handleCancel">取消</el-button>
          </div>
          <div class="publishButton">
            <el-button type="success" @click="handlePublish">发表</el-button>
          </div>
        </div>
      </div>
  </div>

</template>

<script setup>

import { useRoute } from "vue-router";
import {onMounted, ref} from 'vue' 
import { lostAndFoundBackgroundImage ,publicUrl} from "../../../api/util";
import { ElMessage, ElMessageBox } from 'element-plus'
import http from "../../../api/http";
import router from "@/router";
const route = useRoute()
const id = ref(1)
const lostAndFoundInfo = ref('')
const sticker = ref('')
const comments = ref([])
const commentsRef = ref(null)
const commentCount = ref(0)
const loading = ref(false)
let page = ref(1)
let size = ref(7)
const isLogin = ref(false)
const pubComShow = ref(false)
const mycomment = ref('')

function throttle(fn,delay = 1000) {//节流
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
const handleComment=()=>{
  if(isLogin.value){
    pubComShow.value = true
  }else{
    console.log(isLogin.value)
    ElMessageBox.alert('未登录，是否跳转登录？', '登录', {

      confirmButtonText: 'OK',
      callback: (action) => {

        if(action=='cancel'){
          console.log('取消登录')
        }else{
          router.push({
            path:'/login'
          })
        }


      },
    })
  }
  
}
const handlePublish=()=>{
  console.log(mycomment.value)
  mycomment.value=''
  pubComShow.value = false
}
const handleCancel=()=>{
  mycomment.value=''
  pubComShow.value = false
}
const handleScroll=throttle(function(){
  const comment = commentsRef.value
      if (comment.scrollTop + comment.clientHeight >= comment.scrollHeight-1) {
        loading.value = true
        page.value = page.value+1
        // loadMore()
        getLostAndFoundCommentsById((page.value-1)*size.value,undefined,id.value )
        console.log('到底了');
      }
},500)
const getLostAndFoundCommentsById=(page=0,size=7,id)=>{
  http.post("/LostAndFound/getLostAndFoundCommentsById",{
    page,
    size,
    id
  })
  .then(res=>{

    comments.value = [...comments.value,...res.data.data]
    commentCount.value = res.data.data.length
    loading.value = false
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
  isLogin.value = localStorage.getItem('isLogin')
  console.log(isLogin.value)
  getLostAndFoundInfoById(route.params.id)
  getLostAndFoundCommentsById(undefined,undefined,route.params.id)
  // getLostAndFoundInfoById()

})
</script>

<style lang="scss" scoped>
.LostAndFoundDetail{
  width: 100%;
  position: relative;
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
          // .avatar{

          // }
          .nickname{
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
    .topic-opr{
      display: flex;
      justify-content: space-between;
      .op{
        margin: 5px 10px 0 0;
      }
    }
    .topic{
      margin: 10px 0 10px 10px;

    }
    .topic::before{
      content: "";
      border-left: 4px solid rgb(71, 188, 228);
      padding-right: 5px;
      
    }
    .postcomments::-webkit-scrollbar{
      display: none;
    }
    .postcomments{
      height: 450px;
      overflow: auto;
      .commentsItem{
        display: flex;
        padding: 10px 8px;
        .commentavatar{
          padding-right: 10px;
        }
        .usercommentinfo{
          .nickname-publishtime{
            display: flex;
            .nickname{
              font-size: 16px;
              font-weight:bold;

            }
            .publishTime{
              padding-left: 20px;
              font-size: 12px;
              line-height: 20px;
              color: gray;
            }
          }
          .commentContent{
            font-size: 14px;
            background-color: rgb(215, 213, 213);
            border-radius: 5px;
            padding: 3px 5px;
            margin: 5px 0 0 2px;
            color: rgb(112, 111, 111);
          }

        }
        
      }
    }
    .noMore{
      text-align: center;
      margin: 5px 0;
      font-size: 14px;
      color: gray;
    }
  }

  .publishComment{
    position: absolute;
    right: 38px;
    bottom: 20rem;
    width: 280px;
    height: 150px;
    background-color: rgba(240, 249, 249,1);
    box-shadow: 0 5px 18px 1.8px rgba(240, 249, 249,0.5);
    border-radius: 20px;
    .commentTextArea{
      margin: 0 0 10px 20px;
      padding-top: 20px;
    }
    .ibutton{
      display: flex;
      justify-content: space-between;
      .cancelButton{
        padding-left: 20px;
      }
      .publishButton{
        padding-right: 20px;
      }
    }

  }
}
</style>

