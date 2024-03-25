<template>
  <div class="personalCenter">
    <div class="main">
      <div class="briefInfo">
        <div class="avatar">
          <el-image style="width: 100%; height: 100%" :src="publicUrl+userinfo.avatar" fit="cover" />
        </div>
        <div class="userinfo">
          <div class="nickname">
            {{ userinfo.nickname }}
          </div>
          <div class="permissions">
            <el-tag :type="userinfo.permissions==0?'success':'primary'">{{ userinfo.permissions==0?'普通用户':'管理员' }}</el-tag>
            
          </div>
          <div class="username">
            UID:{{ userinfo.username }}
          </div>
        </div>
      </div>
      <div class="leftbarandRight">
        <div class="leftbar">
          <div class="topic">
            个人中心
          </div>
          <div class="tabs">
            <div class="mytab"  :class="tabValue==tabitem.value?'active':''" v-for="tabitem in tabs" :key="tabitem.value" @click="switchTab(tabitem.value)">
              {{ tabitem.label }}
            </div>

          </div>
        </div>
        <div class="rightContent">
          <div class="myposts" v-show="tabValue=='myposts'">
            <div class="postTopic">
              我的帖子
            </div>
            <div class="posts" ref="postsRef" @scroll="handleScroll">
              <div class="postitem" v-for="postitem in posts" :key="postitem.id" @click=gotoDetail(postitem.id)>
                <div class="time">
                  {{ postitem.time }}
                </div>
                <div class="goodsName">
                  {{ postitem.goodsName }}
                </div>
                <div class="description">
                  {{ postitem.description }}
                </div>
                <div class="imageUrl">
                  <el-image style="width: 100%; height: 100%" :src="publicUrl+postitem.imageUrl" fit="cover" />
                </div>
                <div class="type">
                  {{ postitem.type==0?'找物品':'寻失主' }}
                </div>
              </div>
              <div class="noMore" v-if="postCount<2">
                没有更多帖子了~~
              </div>
            </div>
          </div>
          <div class="myinfo" v-show="tabValue=='myinfo'">
            <div class="infoTopic">
              我的信息
            </div>
            <div class="infos">
              <div class="myavatar">
                <el-image style="width: 100%; height: 100%" :src="publicUrl+userinfo.avatar" fit="cover" />
              </div>
              <div class="infocontent">
                <el-form
                  label-position="left"
                  label-width="auto"
                  :model="myinfomodel"  
                >
                  <el-form-item label="账号">
                    <el-input v-model="myinfomodel.username" disabled/>
                  </el-form-item>
                  <el-form-item label="昵称" required>
                    <el-input v-model="myinfomodel.nickname" />
                  </el-form-item>
                  <el-form-item label="权限">
                    <el-select v-model="myinfomodel.permissions" placeholder="Select" >
                      <el-option
                        v-for="item in permisOption"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value"
                        disabled
                      />
                    </el-select>
                  </el-form-item>
                </el-form>
              </div>
            </div>
            <div class="handleUpdate">
              <el-button type="primary" @click="handleUpdate">
                保存修改
              </el-button>
            </div>
          </div>
          <div class="myavatarupdate" v-show="tabValue=='myavatar'">
            <div class="avatarTopic">
              我的头像
            </div>
            <div class="avatarcontent">
              <el-upload
                class="avatar-uploader"
                :action="uploadUrl+'/avatarimg'"
                :show-file-list="false"
                :limit="1"
                :on-success="handleAvatarSuccess"
                :before-upload="beforeAvatarUpload"
              >
                <img v-if="userinfo.avatar" :src="publicUrl+userinfo.avatar" class="avatarimg" />
                <el-icon v-else class="avatar-uploader-icon"><Plus /></el-icon>
              </el-upload>
              
            </div>
          </div>
          <div class="mysecurity" v-show="tabValue=='mysecurity'">
            <div class="securityTopic">
              账号安全
            </div>
            <div class="securitycontent">
              <el-form :model="mysecurityMoel">
                  <el-form-item label="修改密码" >
                      <el-input v-model="mysecurityMoel.password" placeholder="请输入密码" show-password/>
                  </el-form-item>
                  <el-form-item label="确认密码" >
                      <el-input v-model="mysecurityMoel.confirmPassword" placeholder="请确认密码" show-password />
                  </el-form-item>
                  <el-form-item s>
                      <el-button type="primary" @click="updetePassword" >保存修改</el-button>
                  </el-form-item>
              </el-form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>

import { onMounted, reactive, ref } from 'vue';
import { useRouter } from 'vue-router';
import http from '../../../api/http';
import { lostAndFoundBackgroundImage, publicUrl, uploadUrl } from '../../../api/util';
import { ElMessage, ElMessageBox } from 'element-plus'
const userinfo = ref('')
const tabValue = ref('myposts')
const page=ref(1)
const size=ref(2)
const posts = ref([])
const postsRef = ref('')
const postCount = ref(2)
const router = useRouter()
const switchTab=(value)=>{
  tabValue.value = value
}
const permisOption = [
  {
    label:'管理员',
    value:1
  },
  {
    label:'普通用户',
    value:0
  }
]
const myinfomodel = reactive({
  username: '',
  nickname: '',
  permissions: 0,
})
const mysecurityMoel = reactive({
  password:'',
  confirmPassword: '',
})
const tabs = [
  {
    label:'我的帖子',
    value:'myposts'
  },
  {
    label:'我的信息',
    value:'myinfo'
  },
  {
    label:'我的头像',
    value:'myavatar'
  },
  {
    label:'账号安全',
    value:'mysecurity'
  }
]
//节流函数
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
const updatePasswordById=()=>{
  http.post('/user/updatePasswordById',{
    id:userinfo.value.id,
    password:mysecurityMoel.password
  })
  .then(res=>{
    if(res.data.data.update=='equal'){
      ElMessage({
        message: '本次密码无法与上次相同，请修改',
        type: 'error',
      })
    }else{
      if(res.data.data.update=='ok'){
          localStorage.removeItem("isLogin")
          localStorage.removeItem("userinfo")
          router.push({
              path:'/login'
          })
      }else{
        ElMessage({
          message: '修改失败！请联系管理员',
          type: 'error',
        })
      }
    }
    
  })
  .catch(err=>{
    console.log(err)
  })
}
const updetePassword=()=>{

  console.log(mysecurityMoel)
  if(mysecurityMoel.password!=mysecurityMoel.confirmPassword || (mysecurityMoel.password == '' || mysecurityMoel.confirmPassword=='')){
    ElMessage({
      message: '两次密码不一致或为空',
      type: 'warning',
    })
  }else{
    if(mysecurityMoel.password.length<6 || mysecurityMoel.password.length>12){
      ElMessage({
        message: '密码长度应该为6-12',
        type: 'warning',
      })
    }else{
      updatePasswordById()
    }
  }
}
const deleteAvatar=(path,type)=>{
  http.post('/deleteimg',{
    path,
    type
  })
  .then(res=>{
    console.log(res)
  })
  .catch(err=>{
    console,log(err)
  })
}
const updateAvatarByid=(imageUrl,userid)=>{
  http.post('/user/updateAvatarByid',{
    avatar:imageUrl,
    id:userid
  })
  .then(res=>{
    if(res.data.data.update=='ok'){
      console.log('更新成功')
      userinfo.value.avatar = imageUrl
      localStorage.setItem('userinfo',JSON.stringify(userinfo.value))
      ElMessage({
        message: '修改成功！',
        type: 'success',
      })
      location.reload()
    }else{
      ElMessage({
        message: '修改失败！请联系管理员',
        type: 'error',
      })
    }
  })
  .catch(err=>{
    console.log(err)
  })
}
const handleAvatarSuccess=(response,uploadFile)=>{
  const newimageUrl = response.data
  const oldimageUrl = userinfo.value.avatar
  deleteAvatar(oldimageUrl,0)
  updateAvatarByid(newimageUrl,userinfo.value.id)


  console.log(oldimageUrl)
}
const getmyinfomodel = ()=>{
  myinfomodel.username = userinfo.value.username
  myinfomodel.permissions = userinfo.value.permissions
  myinfomodel.nickname = userinfo.value.nickname
}
const handleUpdate=()=>{
  console.log(myinfomodel)
  http.post('/user/updateUserInfoById',{
    id:userinfo.value.id,
    nickname:myinfomodel.nickname
  })
  .then(res=>{
    if(res.data.data.update=='ok'){
      console.log('更新成功')
      userinfo.value.nickname = myinfomodel.nickname
      localStorage.setItem('userinfo',JSON.stringify(userinfo.value))
      ElMessage({
        message: '修改成功！',
        type: 'success',
      })
      location.reload()
    }else{
      ElMessage({
        message: '修改失败！请联系管理员',
        type: 'error',
      })
    }
  })
  .catch(err=>{
    console.log(err)
  })
}
const gotoDetail = (postid)=>{
  router.push({
    path:`/home/lostAndFoundDetail/${postid}`
  })
}
const handleScroll=throttle(function(){
      const postsref = postsRef.value
      if (postsref.scrollTop + postsref.clientHeight >= postsref.scrollHeight-1) {
        page.value = page.value+1
        // loadMore()
        getLostAndFoundInfo((page.value-1)*size.value,undefined,null,undefined,undefined,userinfo.value.id )
        console.log('到底了');
      }
},500)
const getLostAndFoundInfo=(page=0,size=2,type=null,goodsinput='',dateinput='',userid)=>{
  http.post('/LostAndFound/getLostAndFoundPage',{
    page,
    size,
    type,
    goodsName:goodsinput,
    time:dateinput,
    userid:userinfo.value.id
  })
  .then(res=>{
    postCount.value = res.data.data.length
    posts.value = [...posts.value,...res.data.data]
    console.log(posts.value[0])
  })
  .catch(err=>{
    console.log(err)
  })
}

const getUserinfo=()=>{
  userinfo.value =  JSON.parse(localStorage.getItem('userinfo'))
  getmyinfomodel()
}
onMounted(()=>{
  getUserinfo()
  getLostAndFoundInfo(undefined,undefined,null,undefined,undefined,userinfo.value.id)
  

})
</script>

<style lang="scss" scoped>
.active{
  background-color: rgb(116, 166, 236);
  color: white;
}
.personalCenter{
  width: 100%;
  height: 100vh;
  background-color: rgb(224, 222, 222);
  padding-top: 100px;
  .main{
    width: 70%;
    height: 600px;
    margin: 0 auto;

    .briefInfo{
      width: 100%;
      height: 100px;
      background-color: white;
      margin: 10px 0;
      box-shadow: 0 5px 18px 2px rgb(208, 207, 207);
      padding-top: 5px;
      display: flex;
 
      .avatar{
        height: 95px;
        width: 95px;
        margin: 0 10px 0 5px;
        border-radius: 5px;
        overflow: hidden;
      }
      .userinfo{
        margin-left: 10px;
        .nickname{
          font-weight: bold;
          margin-bottom: 12px;
        }
        .permissions{
          margin-bottom: 15px;
        }
        .username{
          font-size: 12px;
          color: gray;
        }
      }
    }
    .leftbarandRight{
      height: 500px;
      background-color: rgb(224, 222, 222);
      display: flex;
      justify-content: space-between;
      .leftbar{
        height: 100%;
        width: 20%;
        background-color: white;
        box-shadow: 0 5px 18px 2px rgb(208, 207, 207);
        text-align: center;
        .topic{
          margin: 10px 0 0 0;
          padding-top: 10px;
          padding-bottom: 20px;
          font-size: 18px;
          color: gray;
          border-bottom: 1px solid rgb(203, 203, 203);

          }
          .tabs{
            .mytab{
              height: 50px;
              line-height: 50px;
              cursor:pointer;
            }
        }
      }
      .rightContent{
        height: 100%;
        width: 79%;
        background-color: white;
        box-shadow: 0 5px 18px 2px rgb(208, 207, 207);
        .myposts{
          position: relative;
          .postTopic{
            padding: 10px 0 15px 20px;
            border-bottom:1px solid rgb(217, 216, 216) ;

          }
          .posts::-webkit-scrollbar{
            display: none;
          }
          .posts{
            height: 450px;
            overflow: auto;
            .postitem{
              margin: 10px 20px 20px 20px;
              padding-bottom: 20px;
              border-bottom: 1px solid rgb(193, 190, 190);
              cursor: pointer;
              .time{
                font-size: 16px;
                color: gray;
              }
              .goodsName{
                margin: 10px 0;
                font-weight: bold;
              }
              .description{
                margin: 0 0 10px 0;
                font-size: 14px;
                color: gray;
              }
              .imageUrl{
                width: 150px;
                height: 150px;
                border-radius: 10px;
                overflow: hidden;
              }
              .type{
                text-align: center;
                width: 50px;
                margin: 10px;
                font-size: 14px;
                color: rgb(74, 73, 73);
                background-color: rgb(179, 177, 177);
                padding: 5px 8px;
                border-radius: 18px;
              }
            }
            .noMore{
              text-align: center;
              margin: 5px 0;
              font-size: 14px;
              color: gray;
              padding-bottom: 10px;
            }
          }
          
        }
        .myinfo{

          .infoTopic{
            padding: 10px 0 15px 20px;
            border-bottom:1px solid rgb(217, 216, 216) ;
          }
          .infos{
            margin: 10px 20px;
            .myavatar{
              width: 180px;
              height: 180px;
              margin: 0 auto;
              border-radius: 50%;
              overflow: hidden;
            }
            .infocontent{
              margin-top: 20px;
              display: flex;
              justify-content: center;
              .el-form{
                width: 300px;
              }
            }
          }
          .handleUpdate{
            margin-top: 20px;
            text-align: center;
          }

        }
        .myavatarupdate{
          .avatarTopic{
            padding: 10px 0 15px 20px;
            border-bottom:1px solid rgb(217, 216, 216) ;
          }
          .avatarcontent{
            width: 180px;
            height: 180px;
            margin: 0 auto;
            margin-top: 100px;
            border-radius: 50%;
            overflow: hidden;
            .avatar-uploader{
              width: 100%;
              height: 100%;
              .el-upload{
                width: 100%;
                height: 100%;
                .avatarimg{
                  width: 100%;
                  height: 100%;
                }
              }
            }
          }


        }
        .mysecurity{
          .securityTopic{
            padding: 10px 0 15px 20px;
            border-bottom:1px solid rgb(217, 216, 216) ;
          }
          .securitycontent{
            width: 200px;
            margin: 0 auto;
            margin-top: 150px;
          }
        }
      }
    }
  }
}
</style>
