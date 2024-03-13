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
  }
  .index-main{
    background-color: red;
    width: 90%;
    margin: 0 auto;
    margin-top: 10px;
    height: 1000px;
    .title{
      width: 100%;
      height: 80px;
      background-color: rgb(64, 64, 155);
      text-align: center;
      color: white;
      line-height: 35px;
      font-size: 18px;
      padding-top: 5px;
    }
  }
}
</style>
