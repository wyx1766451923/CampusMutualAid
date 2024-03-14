<template>
  <div class="index">
      <div class="swiper">
          <swiper
              :modules="modules"
              :slides-per-view="1"
              :space-between="50"
              :pagination="{ clickable: true }"
              :autoplay="true"
              @swiper="onSwiper"
              @slideChange="onSlideChange"
          >
              <swiper-slide>
                <el-image style="width: 100%; height: 100%" src="/image/swiper/swiper1.png" fit="cover" />
              </swiper-slide>
              <swiper-slide>
                <el-image style="width: 100%; height: 100%" src="/image/swiper/swiper2.png" fit="cover" />
              </swiper-slide>
              <swiper-slide>
                <el-image style="width: 100%; height: 100%" src="/image/swiper/swiper3.png" fit="cover" />
              </swiper-slide>
          </swiper>
      </div>
      <div class="index-main">
        <div class="title">
           校园资讯
           <p>Campus Information</p>
        </div>
        <div class="content">
          <div class="top-info">
            <div class="top-info-item" v-for="topInfoItem in topinfo" :key="topInfoItem.id">
              <div class="info-image">
                <el-image style="width: 100%; height: 100%" :src="topInfoItem.imageurl" fit="cover" />
              </div>
              <div class="title-info">
                <div class="info-title">
                  {{ topInfoItem.title }}
                </div>
                <div class="info-content">
                  {{ topInfoItem.content }}
                </div>
                <div class="info-time">
                  <div class="cal-icon">
                    <el-icon size="18px"><Calendar /></el-icon>
                  </div>
                  {{ topInfoItem.releaseTime }}
                </div>
              </div>
            </div>
          </div>
          <div class="bottom-info">

          </div>
        </div>

      </div>
    </div>
</template>

<script setup>
  // Import Swiper Vue.js components
  import { Pagination, Scrollbar, A11y,Autoplay} from 'swiper/modules'
  import { Swiper, SwiperSlide } from 'swiper/vue'

  // Import Swiper styles
  import 'swiper/css'
  import 'swiper/css/navigation';
  import 'swiper/css/pagination';
  import 'swiper/css/scrollbar';
  const topinfo = [
    {
      id:1,
      title:'测试标题1',
      imageurl:'/image/swiper/swiper1.png',
      content:'测试内容测试内容测试内容，测试内容测试内容测试内容测试内容，测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容，测试内容测试内容测试内容测试内容测试内容，测试内容测试内容测试内容测试内容测试内容，测试内容测试内容测试内容测试内容。',
      releaseTime:"2024-3-14"
    },
    {
      id:2,
      title:'测试标题1',
      imageurl:'/image/swiper/swiper1.png',
      content:'测试内容测试内容测试内容，测试内容测试内容测试内容测试内容，测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容，测试内容测试内容测试内容测试内容测试内容，测试内容测试内容测试内容测试内容测试内容，测试内容测试内容测试内容测试内容。',
      releaseTime:"2024-3-14"
    }
  ]
  const bootominfo = [

    {
      id:3,
      title:'测试标题1',
      imageurl:'/image/swiper/swiper1.png',
      content:'测试内容测试内容测试内容，测试内容测试内容测试内容测试内容，测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容，测试内容测试内容测试内容测试内容测试内容，测试内容测试内容测试内容测试内容测试内容，测试内容测试内容测试内容测试内容。',
      releaseTime:"2024-3-14"
    },
    {
      id:4,
      title:'测试标题1',
      imageurl:'/image/swiper/swiper1.png',
      content:'测试内容测试内容测试内容，测试内容测试内容测试内容测试内容，测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容，测试内容测试内容测试内容测试内容测试内容，测试内容测试内容测试内容测试内容测试内容，测试内容测试内容测试内容测试内容。',
      releaseTime:"2024-3-14"
    },
    {
      id:5,
      title:'测试标题1',
      imageurl:'/image/swiper/swiper1.png',
      content:'测试内容测试内容测试内容，测试内容测试内容测试内容测试内容，测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容，测试内容测试内容测试内容测试内容测试内容，测试内容测试内容测试内容测试内容测试内容，测试内容测试内容测试内容测试内容。',
      releaseTime:"2024-3-14"
    }
  ]
  const onSwiper = (swiper) => {
    console.log(swiper)
  }
  const onSlideChange = () => {
    console.log('slide change')
  }
  const modules=[Pagination, Scrollbar, A11y,Autoplay]
</script>

<style lang="scss" scoped>
.index{
  height:100% ;
  .swiper{
      width: 100%;
      height: 100%;
      margin: 0px 1px;
  }
  .index-main{
    width: 100%;
    margin: 0px 2px;
    background-image: linear-gradient(rgb(66, 66, 211),white);
    height: auto;
    .title{
      width: 100%;
      height: 80px;
      text-align: center;
      color: white;
      line-height: 35px;
      font-size: 18px;
      padding-top: 5px;
      
    }
    .content{
      width: 100%;
      height: 600px;
      .top-info{
        display: flex;
        margin: 10px 5px;
        justify-content: space-between;
        .top-info-item{
          cursor: pointer;
          transition: all 0.5s;
          display: flex;
          width: 48.5%;
          height: 330px;
          background-color: rgb(242, 241, 218);
          box-shadow: 0 5px 18px 1.8px rgba(0,0,0,0.1);

          .info-image{
            width: 55%;
            height: 100%;
            flex-shrink: 0;
          }
          .title-info{
            width: 45%;
            margin-top: 70px;
            padding: 010px;
            position: relative;
            .info-title{
              font-size: 16px;
              word-break: break-all;
              overflow: hidden;
              -webkit-line-clamp: 2;
              -webkit-box-orient: vertical;
              padding: 0 0px 40px 0px;
            }
            .info-content{
              font-size: 16px;
              color: gray;
              width: 100%;
              word-break: break-word;
              text-overflow: ellipsis;
              display: -webkit-box;
              -webkit-box-orient: vertical;
              -webkit-line-clamp: 3;
              overflow: hidden;

            }
            .info-time{
              position: absolute;
              bottom: 8px;
              right: 10px;
              display: flex;
              color: gray;
              .cal-icon{
                padding-top: 2px;
                margin-right: 2px;
              }
            }
          }
          
        }
        .top-info-item:hover{
          transition: all 0.5s;
          transform:translateY(-12px);
          background-color: rgb(125, 184, 224);
          .info-title{
            color: white;
          }
          .info-content{
            color: white;
          }
          .info-time{
            color: white;
          }
        }
      }
    }
  }
}
</style>
