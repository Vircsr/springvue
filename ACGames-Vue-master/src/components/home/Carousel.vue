<template>
  <el-card class="card-carousel">
  <el-carousel  class="push" :interval="4000" arrow="always">
    <el-carousel-item v-for="item in items" :key="item.id">
      <a :href=item.link target="_blank">
        <img :src=item.img alt="" class="carousel_img">
      </a>
      <h3>{{item.title}}</h3>
    </el-carousel-item>
  </el-carousel>
  </el-card>
</template>

<style>
  .el-carousel__item h3 {
    color: black;
    font-size: 15px;
    /*line-height: 300px;*/
    bottom: 43px;
    float: left;
    position: relative;
  }

  .card-carousel {
    /* margin: 0 auto; */
    /* margin-left: 20px; */
    width: 100%;
    height: 320px;
  }

  .el-carousel__item:nth-child(2n) {
    background: black;
  }

  .el-carousel__item:nth-child(2n+1) {
    background: black;
  }

  .carousel_img {
    height: 100%;
    width: 100%;
    text-align: center;
  }
</style>

<script>
  export default {
    name: 'Carousel',
    data: function () {
      return {
        items: [{
          id: 1,
          title: 'BiliBili友情链接',
          img: 'http://img1.imgtn.bdimg.com/it/u=3548431432,1089795067&fm=26&gp=0.jpg',
          link: 'https://www.bilibili.com/'},
        {
          id: 2,
          title: 'AcFun友情链接',
          img: 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2644070286,2631167804&fm=26&gp=0.jpg',
          link: 'https://www.acfun.cn/'
        },
        {
          id: 3,
          title: 'cilicili友情链接',
          img: 'https://tva2.sinaimg.cn/large/9bd9b167gy1g4lhmyn191j21hc0xctu6.jpg',
          link: 'https://cilicili.cn/'
        }]
      }
    }
  }
</script>
