<template>
  <div class="lostAndFound">
    <div class="bg">
      <el-image style="width: 100%; height: 100%" :src="lostAndFoundBackgroundImage" fit="cover" />
    </div>
    <div class="main">
      <div class="tab">
        <div class="found" :class="isSelected=='found'?'active':''" @click="handleSwitch('found')">找物品</div>
        <div class="lost" :class="isSelected=='lost'?'active':''" @click="handleSwitch('lost')">寻失主</div>
      </div>
      <div class="search-publish">
        <div class="search">
          <el-input
            v-model="goodsinput"
            style="width: 150px"
            placeholder="物品名字"
            clearable
          />
          <el-input
            v-model="dateinput"
            style="width: 150px"
            placeholder="日期"
            type="date"
            clearable
          />
          <el-button type="primary" @click="handleSearch">搜索</el-button>
        </div>
        <div class="publish">
          <el-button type="primary" @click="handlePublish">发帖</el-button>
        </div>
      </div>
      <div class="goodsinfo">
        <div class="infoitem" v-for="item in goodsinfos" :key="item.id" @click="handleToGoodsInfoDetail(item.id)">
          <div class="goodsimage">
            <el-image style="width: 100%; height: 100%" :src="publicUrl+item.imageUrl" fit="cover" />
          </div>
          <div class="info">
            <div class="goodsname">
              {{ item.goodsName }}
            </div>
            <div class="goodsaddress">
              {{ item.address }}
            </div>
            <div class="goodtime">
              {{ item.time}}
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { lostAndFoundBackgroundImage,publicUrl } from '../../../api/util';
let isSelected = ref('found')
const goodsinput = ref('')
const dateinput = ref('')
const router = useRouter()
const goodsinfos = [
  {
    id:1,
    goodsName:'vivo手机z50s哈哈版',
    address:'一操场外跑道健步处杠杠',
    time:'2023-3-17',
    imageUrl:'/img/lostandfound/lost1.png',
    description:'在操场跑道外部丢失，拾取到请联系我',
    name:'王大锤',
    ContactInformation:'QQ:1766451923',
    userid:1,
    type:0
  },
  {
    id:2,
    goodsName:'vivo手机',
    address:'一操场',
    time:'2023-3-17',
    imageUrl:'/img/lostandfound/lost1.png',
    description:'在操场跑道外部丢失，拾取到请联系我',
    name:'王大锤',
    ContactInformation:'QQ:1766451923',
    userid:1,
    type:0
  },
  {
    id:3,
    goodsName:'vivo手机',
    address:'一操场',
    time:'2023-3-17',
    imageUrl:'/img/lostandfound/lost1.png',
    description:'在操场跑道外部丢失，拾取到请联系我',
    name:'王大锤',
    ContactInformation:'QQ:1766451923',
    userid:1,
    type:0
  },
  {
    id:4,
    goodsName:'vivo手机',
    address:'一操场',
    time:'2023-3-17',
    imageUrl:'/img/lostandfound/lost1.png',
    description:'在操场跑道外部丢失，拾取到请联系我',
    name:'王大锤',
    ContactInformation:'QQ:1766451923',
    userid:1,
    type:0
  },
  {
    id:5,
    goodsName:'vivo手机',
    address:'一操场',
    time:'2023-3-17',
    imageUrl:'/img/lostandfound/lost1.png',
    description:'在操场跑道外部丢失，拾取到请联系我',
    name:'王大锤',
    ContactInformation:'QQ:1766451923',
    userid:1,
    type:0
  },
  {
    id:6,
    goodsName:'vivo手机',
    address:'一操场',
    time:'2023-3-17',
    imageUrl:'/img/lostandfound/lost1.png',
    description:'在操场跑道外部丢失，拾取到请联系我',
    name:'王大锤',
    ContactInformation:'QQ:1766451923',
    userid:1,
    type:0
  },
  {
    id:7,
    goodsName:'vivo手机',
    address:'一操场',
    time:'2023-3-17',
    imageUrl:'/img/lostandfound/lost1.png',
    description:'在操场跑道外部丢失，拾取到请联系我',
    name:'王大锤',
    ContactInformation:'QQ:1766451923',
    userid:1,
    type:0
  },
  {
    id:8,
    goodsName:'vivo手机',
    address:'一操场',
    time:'2023-3-17',
    imageUrl:'/img/lostandfound/lost1.png',
    description:'在操场跑道外部丢失，拾取到请联系我',
    name:'王大锤',
    ContactInformation:'QQ:1766451923',
    userid:1,
    type:0
  },
  {
    id:9,
    goodsName:'vivo手机',
    address:'一操场',
    time:'2023-3-17',
    imageUrl:'/img/lostandfound/lost1.png',
    description:'在操场跑道外部丢失，拾取到请联系我',
    name:'王大锤',
    ContactInformation:'QQ:1766451923',
    userid:1,
    type:0
  },
  {
    id:10,
    goodsName:'vivo手机',
    address:'一操场',
    time:'2023-3-17',
    imageUrl:'/img/lostandfound/lost1.png',
    description:'在操场跑道外部丢失，拾取到请联系我',
    name:'王大锤',
    ContactInformation:'QQ:1766451923',
    userid:1,
    type:0
  },
  {
    id:11,
    goodsName:'vivo手机',
    address:'一操场',
    time:'2023-3-17',
    imageUrl:'/img/lostandfound/lost1.png',
    description:'在操场跑道外部丢失，拾取到请联系我',
    name:'王大锤',
    ContactInformation:'QQ:1766451923',
    userid:1,
    type:0
  },
  {
    id:12,
    goodsName:'vivo手机',
    address:'一操场',
    time:'2023-3-17',
    imageUrl:'/img/lostandfound/lost1.png',
    description:'在操场跑道外部丢失，拾取到请联系我',
    name:'王大锤',
    ContactInformation:'QQ:1766451923',
    userid:1,
    type:0
  }
]
const handleSwitch=(selected)=>{
  isSelected.value = selected
}
const handleSearch=()=>{
  console.log(goodsinput.value,dateinput.value)
}
const handlePublish=()=>{
  console.log('publish')
}
let a = []
const handleToGoodsInfoDetail=(id)=>{
  console.log(id)
  router.push({
    path:`/home/lostAndFoundDetail/${id}`

  })
}
</script>

<style lang="scss" scoped>
.active{
  border: none !important;
  font-size: 20px;
  background-color: rgb(63, 156, 209);
  color: white;
  transition: all 0.3s;
}
.lostAndFound{
  .bg{
    width: 100%;
    height: 400px;
  }
  .main{
    margin: 10px 100px;

    .tab{
      display: flex;
      justify-content: center;
      margin: 20px 0;
      font-size: 18px;
      cursor:pointer;
      transition: all 0.3s;
      .found{
        padding: 5px 10px 5px 10px;
        border: 1px solid black;
      }
      .lost{
        padding: 5px 10px 5px 10px;
        border: 1px solid black;
      }
    }
    .search-publish{
      box-shadow: 0 5px 18px 1.8px rgb(216, 226, 240);
      display: flex;
      justify-content: space-between;
      padding: 10px;
      border-radius: 10px;
      .search{
        padding-left: 20px;

      }
      .publish{
        padding-right: 20px;

      }
    }
    .goodsinfo{
      width: 100%;
      margin: 20px 0;
      border-radius: 20px;
      box-shadow: 0 5px 18px 1.8px rgb(201, 199, 199);
      display: flex;
      justify-content: space-between;
      flex-wrap: wrap;
      .infoitem{
        transition: all 0.5s;
        cursor: pointer;
        width: 23%;
        display: flex;
        margin: 20px 10px;
        border-radius: 10px;
        background-color: rgb(223, 230, 231);
        box-shadow: 0 5px 18px 1.8px rgb(216, 226, 240);
        .goodsimage{
          width: 200px;
          border-radius: 10px;
          overflow: hidden;
        }
        .info{
          width: 80px;
          padding: 10px;
          font-size: 14px;
          position: relative;
          .goodsname{
            width: 80px;
            text-align: center;
            overflow: hidden;
            text-overflow: ellipsis;
            text-wrap: nowrap;
          }
          .goodsaddress{
            text-align: center;
            width: 80px;
            margin-top: 20px;
            word-break: break-all;
            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-box-orient: vertical;
            -webkit-line-clamp: 2;
            overflow: hidden;

          }
          .goodtime{
            position: absolute;
            bottom: 5px;
            right: 5px;

          }
        }
      }
      .infoitem:hover{
        
        transform: scale(1.1);
        transition: all 0.5s;
        overflow: hidden;
        color: white;
        .info{
          background-color: rgb(92, 201, 234);
        }
      }
    }
  }
}
</style>
