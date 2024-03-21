<template>
    <div class="login">
        <div class="loginForm">
            <div class="tabs">
                <div class="loginTab" :class="myType==1?'active':''" @click="handleTab(1)">
                    登录
                </div>
                <div class="registerTab" :class="myType==0?'active':'' " @click="handleTab(0)">
                    注册
                </div>
            </div>
            <div class="title">欢迎登录大家帮校园互助平台</div>
            <el-form :model="formLabelAlign">
                <el-form-item>
                    <el-input v-model="formLabelAlign.username" placeholder="请输入用户名" />
                </el-form-item>
                <el-form-item>
                    <el-input v-model="formLabelAlign.password" placeholder="请输入密码" show-password />
                </el-form-item>
                <el-form-item v-if="myType==0">
                    <el-input v-model="confirmPassword" placeholder="请确认密码" show-password />
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onLogin">{{myType==1?'登录':'注册'}}</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>
  
<script setup>
import { reactive, ref } from 'vue'
import { useRouter } from 'vue-router';
import http from "../../../api/http";
import { ElMessage } from 'element-plus'
import { defaultAvatar,defaultNickname } from '../../../api/util'
const myType = ref(1)//0注册，1登录
const confirmPassword = ref('')
const formLabelAlign = reactive({
    username: '',
    password: ''

})

const router = useRouter()
const handleTab=(type)=>{
    myType.value = type
    formLabelAlign.password=''
    confirmPassword.value=''
}
const onLogin = () => {
    if(myType.value == 1){
        http.post('/user/login', {
            username: formLabelAlign.username,
            password: formLabelAlign.password
        })
        .then(res=> {
            console.log(res)
            if (res.data.data.login == 'ok') {
                let userinfo = res.data.data.userinfo
                localStorage.setItem('isLogin',true)
                localStorage.setItem('userinfo', JSON.stringify(userinfo))
                ElMessage({
                    message: '登陆成功',
                    type: 'success',
                })
                router.push('/home')
            } else if (res.data.data.login == 'pwdErro') {
                ElMessage({
                    message: '密码错误，请检查您的密码',
                    type: 'error',
                })
            } else {
                ElMessage({
                    message: '没有此用户!请注册',
                    type: 'error',
                })
            }
        })
        .catch(function (err) {
            console.log(err);
        });
    }
    if(myType.value == 0){
        if(formLabelAlign.password == confirmPassword.value){
            http.post('/user/register',{
                username:formLabelAlign.username,
                password: formLabelAlign.password,
                avatar:defaultAvatar,
                nickname:defaultNickname,
                Permissions:0
            })
            .then(res=>{
                if(res.data.data.register == 'exist'){
                    ElMessage({
                        message: '账户已存在，请直接登陆！',
                        type: 'warning',
                    })
                }else{
                    ElMessage({
                        message: '注册成功',
                        type: 'success',
                    })
                    myType.value = 1
                    formLabelAlign.password=''
                    confirmPassword.value=''
                }
            })
        }else{
            ElMessage({
                message: '密码不一致',
                type: 'error',
            })
        }
    }
}

</script>
  
<style lang="scss" scoped>
.active{
    background-color: rgb(26, 26, 194);
}
.login {
    width: 100%;
    height: 100%;
    background-image: url('/image/bg.jpg');
    background-position: center;

    .loginForm {
        .tabs{
            display: flex;
            justify-content: center;
            color: white;
            .loginTab{
                margin-right:30px ;
                padding: 5px 20px;
                cursor: pointer;
            }
            .registerTab{
                margin-left:30px ;
                padding: 5px 20px;
                cursor: pointer;
            }
        }


        .title {
            margin: 15px 0;
            font-size: 16px;
            text-align: center;
            color: white;
        }

        box-shadow: 0 0 15px rgb(196, 191, 237);
        z-index: 100;
        width: 300px;
        padding: 10px;
        position: absolute;
        right: 200px;
        top: 30%;

        .el-form {
            margin: auto;
        }

        .el-form-item {
            width: 80%;
            margin: 15px auto;

            .el-button {
                width: 100%;
            }
        }
    }
}
</style>
  