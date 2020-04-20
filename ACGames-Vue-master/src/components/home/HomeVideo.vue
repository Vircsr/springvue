<template>
  <el-card class="box-card">
    <div slot="header">
      <span style="font-weight: bold;font-size: 20px">游戏视频</span>
    </div>
    <div style="height:450px;width:100%;margin:0 auto;">
      <el-row :gutter="10" type="flex" class="video-home" justify="space-between">
        <el-col :span="12">
          <div class="video-card"></div>
        </el-col>
        <el-col :span="12">
          <div class="video-card"></div>
        </el-col>
        <el-col :span="12">
          <div class="video-card"></div>
        </el-col>
      </el-row>
      <br />
      <el-row :gutter="10" type="flex" class="video-home" justify="space-between">
        <el-col :span="12">
          <div class="video-card"></div>
        </el-col>
        <el-col :span="12">
          <div class="video-card"></div>
        </el-col>
        <el-col :span="12">
          <div class="video-card"></div>
        </el-col>
      </el-row>
    </div>
  </el-card>
</template>

<script>
export default {
  name: 'HomeVideo',
  data () {
    return {
      videos: []
    }
  }
}
</script>

<style scoped>
.box-card {
  margin-top: 20px;
  width: 988px;
  height: 520px;
  text-align: left;
}
.cover {
  width: 280px;
  height: 150px;
  margin-bottom: 7px;
  overflow: hidden;
  cursor: pointer;
}
.video-card {
  background-color: #000000;
  width: 280px;
  height: 200px;
}
el-image {
  width: 280px;
  height: 150px;
}
</style>
