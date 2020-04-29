<template>
  <div>
    <div v-for="(item, index) in animes" :key="item.id">
      <router-link :to="{name:'AnimePlayers', params:{id: item.id}}">
      <el-row :gutter="5" class="anime" style="margin-bottom:3px;height:35px;">
        <el-col :span="4">
          <span style="height:35px;line-height:35px;">{{index + 1}}</span>
        </el-col>
        <el-col :span="20" align="left">
          <span style="height:35px;line-height:35px;">{{item.comicName}}</span>
        </el-col>
      </el-row>
      </router-link>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'ComicRank',
    data () {
      return {
        animes: []
      }
    },
    mounted: function () {
      this.loadAnimes()
    },
    methods: {
      loadAnimes () {
        var _this = this
        this.$axios.get('/comiclist/topten').then(resp => {
        if (resp && resp.data.code === 200) {
          _this.animes = resp.data.result
        }
      })
      }
    }
  }
</script>

<style scoped>
</style>
