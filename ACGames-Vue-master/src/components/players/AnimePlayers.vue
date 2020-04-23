<template>
  <div class="video-container" style="width:1000px;height:600px;margin:auto;margin-top:20px;">
    <el-row :gutter="20" style="width:100%;height:100%;">
      <el-col :span="16">
        <el-card class="video-information" style="width:100%;height:120px;margin-bottom:10px;">
          <el-row :gutter="5" style="height:25px;overflow: hidden;">
            <el-col :span="15" class="information-title" style="height:25px;" align="left">{{videoInfo.comicName}}</el-col>
            <el-col :span="3" class="information-like" style="height:25px;">
              <el-button type="danger" style="height:25px;width:100%;" size="mini">{{videoInfo.like}}</el-button>
            </el-col>
            <el-col :span="6" class="information-time" style="height:25px;line-height:25px;font-size:12px;">{{videoInfo.updateTime}}</el-col>
          </el-row>
          <div align="left" class="information-introduction" style="width:100%;height:90px;overflow:auto;font-size:12px;" v-text='videoInfo.info'></div>
        </el-card>
        <div class="player-box" style="width:100%;overflow:hidden;">
          <video-player
            ref="videoPlayer"
            class="video-player vjs-custom-skin"
            :playsinline="true"
            :options="playerOptions"
            @play="onPlayerPlay($event)"
            @pause="onPlayerPause($event)"
          />
        </div>
      </el-col>
      <el-col :span="8" >
        <anime-list ref="animeList" style="width:100%;" @indexSelect="listAnimes"></anime-list>
      </el-col>
    </el-row>
  </div>
</template>

<script>
// import {formatDate} from '../../utils/index'
// import demoPlayer from './Player'
import AnimeList from './AnimeList'
export default {
  name: 'AnimePlayers',
  components: {AnimeList},
  data () {
    return {
      videoInfo: {},
      playerOptions: {},
      playerInfo: []
    }
  },
  methods: {
    onLive (onVideo) {
      this.playerOptions = {
        playbackRates: [0.7, 1.0, 1.5, 2.0], // 播放速度
        autoplay: false, // 如果true,浏览器准备好时开始回放。
        muted: false, // 默认情况下将会消除任何音频。
        loop: false, // 导致视频一结束就重新开始。
        preload: 'auto', // 建议浏览器在<video>加载元素后是否应该开始下载视频数据。auto浏览器选择最佳行为,立即开始加载视频（如果浏览器支持）
        language: 'zh-CN',
        aspectRatio: '16:9', // 将播放器置于流畅模式，并在计算播放器的动态大小时使用该值。值应该代表一个比例 - 用冒号分隔的两个数字（例如"16:9"或"4:3"）
        fluid: true, // 当true时，Video.js player将拥有流体大小。换句话说，它将按比例缩放以适应其容器。
        sources: [
          {
            type: 'video/mp4', // 这里的种类支持很多种：基本视频格式、直播、流媒体等，具体可以参看git网址项目
            src: onVideo // url地址
          }
        ],
        hls: true,
        poster: '', // 你的封面地址
        notSupportedMessage: '此视频暂无法播放，请稍后再试', // 允许覆盖Video.js无法播放媒体源时显示的默认信息。
        controlBar: {
          timeDivider: true,
          durationDisplay: true,
          remainingTimeDisplay: false,
          fullscreenToggle: true // 全屏按钮
        }
      }
    },
    listAnimes () {
      this.onLive(this.playerInfo[this.$refs.animeList.onRow].videoUrl)
    }
  },
  created: function () {
    var _this = this
    var animeListId = this.$route.params.id
    var url1 = '/comiclist/' + animeListId
    var url2 = '/comics/' + animeListId
    this.$axios.all([
      this.$axios.get(url1),
      this.$axios.get(url2)
    ]).then(this.$axios.spread((listInfo, comicsInfo) => {
      if (listInfo && listInfo.data.code === 200) {
        _this.videoInfo = listInfo.data.result
        // console.log(listInfo.data.result)
      }
      if (comicsInfo && comicsInfo.data.code === 200) {
        _this.playerInfo = comicsInfo.data.result
        _this.$refs.animeList.animes = comicsInfo.data.result
        _this.onLive(_this.playerInfo[0].videoUrl)
        // console.log(comicsInfo.data.result)
      }
    }))
  },
  // filters: {
  // },
  mounted () {
    // console.log('this')
    // console.log(this)
    // this.onLive(this.videoInfo.cover, this.videoInfo.content)
  },
  computed: {
    // player () {
    //   return this.$refs.videoPlayer.player
    // }
  }
}
</script>
