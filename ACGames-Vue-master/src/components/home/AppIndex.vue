<template>
  <div style="margin-top: 40px">
    <side-menu id="side-menu"></side-menu>
    <div class="home">
      <el-card id="header-div" style="width:988px;height:500px;">
        <el-row :gutter="20" >
          <el-col :span="15">
            <div style="height:140px;">
            </div>
            <carousel></carousel>
          </el-col>
          <el-col :span="9" style="height:460px;">
            <el-card style="width:100%;height:100%;" body-style="padding:5px;">
              <div slot="header" class="clearfix">
                <span style="font-size:20px;">番剧排行榜</span>
                <el-button type="text" style="float: right; padding: 3px 0">更多</el-button>
              </div>
              <comic-rank class="comic-rank" ref="comicRank"></comic-rank>
            </el-card>
          </el-col>
        </el-row>
      </el-card>
      <home-video id="home-video"></home-video>
    </div>
  </div>
</template>

<script>
  import Carousel from './Carousel'
  import SideMenu from './SideMenu'
  import HomeVideo from './HomeVideo'
  import ComicRank from './ComicRank'
  export default {
    name: 'AppIndex',
    components: {Carousel, SideMenu, HomeVideo, ComicRank}
  }
</script>

<style scoped>
  .home {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
    margin-top: -20px;
  }

  #header-div {
    padding-bottom: 20px;
    padding-left: 5px;
    background-color: white;
  }

  #side-menu {
    position: fixed;
    margin-left: 50%;
    left: -680px;
    top: 100px;
  }
  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }
</style>
