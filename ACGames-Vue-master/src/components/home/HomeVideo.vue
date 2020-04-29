<template>
  <el-card class="box-card">
    <div slot="header">
      <span style="font-weight: bold;font-size: 20px">视频推荐</span>
    </div>
    <div class="recommend-box">
      <el-card style="width:280px; height:200px;margin-bottom:20px;margin-right:20px;float:left;" class="resource" body-style="padding:10px" shadow="hover"
        v-for="item in videos"
        :key="item.id">
        <router-link :to="{name:'VideoPlayers', params:{id: item.video.id}}">
          <div v class="cover">
            <img :src="item.video.cover" alt="无法加载图片">
          </div>
          <div class="title">
            <span>{{item.video.title}}</span>
          </div>
        </router-link>
      </el-card>
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
  },
  methods: {
    loadRecommends () {
      var _this = this
      var url = '/videos/' + this.$store.state.user.id + '/recommend'
      this.$axios.get(url).then(resp => {
        if (resp && resp.data.code === 200) {
          _this.videos = resp.data.result
          console.log(resp.data.result)
        }
      })
    }
  },
  mounted: function () {
    this.loadRecommends()
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
