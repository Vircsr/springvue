<template>
  <div>
    <el-row style="height:840px">
      <!-- <search-bar></search-bar> -->
      <el-card style="width:280px; height:180px;margin-bottom:20px;margin-right:20px;float:left;" class="resource" body-style="padding:10px" shadow="hover"
        v-for="item in resources.slice((currentPage-1)*pagesize,currentPage*pagesize)"
        :key="item.id">
        <router-link :to="{name:'VideoPlayers', params:{id: item.id}}">
          <div v class="cover">
            <img :src="item.cover" alt="无法加载图片">
          </div>
          <div class="title">
            <span>{{item.title}}</span>
          </div>
          <!-- <div class="author" >
            <span>{{getAuthorName(item.author_id)}}</span>
          </div> -->
        </router-link>
      </el-card>
    </el-row>
    <el-row>
      <el-pagination
      :total="resources.length"
      :current-page="currentPage"
      :page-size="pagesize"
      @current-change="handleCurrentChange"
      ></el-pagination>
    </el-row>
  </div>
</template>

<script>
  export default {
    name: 'ResourcePage',
    data () {
      return {
        resources: [],
        currentPage: 1,
        pagesize: 12
      }
    },
    mounted: function () {
      this.loadResources()
    },
    methods: {
      loadResources () {
        var _this = this
        this.$axios.get('/videos').then(resp => {
          if (resp && resp.data.code === 200) {
            _this.resources = resp.data.result
          }
        })
      },
      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage
      }
    }
  }
</script>

<style scoped>
  .cover {
    width: 260px;
    height: 120px;
    margin-bottom: 5px;
    overflow: hidden;
    cursor: pointer;
  }

  img {
    width: 260px;
    height: 150px;
  }

  .title {
    width:260px;
    font-size:15px;
    text-align: left;
  }

  .author {
    width:250px;
    font-size: 13px;
    margin-bottom: 5px;
    text-align: left;
  }
</style>
