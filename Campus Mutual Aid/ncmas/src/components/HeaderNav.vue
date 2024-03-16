<template>
 <div class="header-nav">
    <div class="nav-name">
        大家帮校园互助平台
    </div>
    <div class="nav-tabs">
        <el-menu
            :default-active="router.currentRoute.value.fullPath"
            class="el-menu-demo"
            mode="horizontal"
            :ellipsis="false"
            router
        >
            <el-menu-item index="/home/index">首页</el-menu-item>
            <el-menu-item index="/home/lostAndFound">失物招领</el-menu-item>
            <el-menu-item index="/home/resourceSharing">资源共享</el-menu-item>
            <el-menu-item index="/home/expressPickup">快递代取</el-menu-item>
            <el-menu-item index="/home/idleTransfer">闲置转让</el-menu-item>
        </el-menu>
    </div>
    <div class="nav-user">
        <el-dropdown @command="handleCommand">
            <span class="el-dropdown-link">
                <el-avatar :icon="UserFilled" />
            </span>
            <template #dropdown>
                <el-dropdown-menu>
                    <el-dropdown-item command="personalCenter">个人中心</el-dropdown-item>
                    <el-dropdown-item command="logout">退出登录</el-dropdown-item>
                </el-dropdown-menu>
            </template>
        </el-dropdown>
        <div class="username">
            红树
        </div>
    </div>
 </div>
</template>

<script setup>
import { ref } from 'vue'

import { useRouter } from 'vue-router';
import { UserFilled } from '@element-plus/icons-vue'
const router = useRouter()
const handleCommand=(command)=>{
    if(command=="personalCenter"){
        console.log("turn to person")
    }
    if(command=="logout"){
        console.log("logout")
    }
}


</script>

<style lang="scss" scoped>
.el-menu--horizontal>.el-menu-item.is-active {
    color:rgb(39, 15, 219) !important;
    background-color: rgba(0,0,0,0);
}
.el-menu-item:hover{
    color: black !important;
}
.header-nav{
    width: 100%;
    height: 100px;
    position: fixed;
    top: 0;
    left: 0;
    background-color: rgba(0,0,0,0.1);
    margin: 2px 0px;
    z-index: 100;
    display: flex;
    .nav-name{
        width: 33%;
        text-align: center;
        margin: auto 0;
        font-size: 24px;
        color: white;
    }
    .nav-tabs{
        width: 32%;
        height: 100%;
        .el-menu{
            height: 100%;
            background-color: rgba(0,0,0,0);
            border-bottom: 0;
            .el-menu-item{
                font-size: 16px;
                color: white;
            }

        }
    }
    .nav-user{
        margin: auto 50px;
        cursor: pointer;
        display: flex;
        .username{
            width: 100%;
            font-size: 14px;
            text-align: center;
            margin: auto 0;
            padding-left: 3px;
        }
    }
}

</style>
