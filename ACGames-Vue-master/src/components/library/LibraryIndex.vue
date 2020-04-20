<template>
  <el-container>
    <el-aside style="width: 200px;margin-top:20px;">
    <SideMenu @indexSelect="listByVariety" ref="sideMenu"></SideMenu>
    </el-aside>
    <el-main>
      <resource-page class="main-area" ref="resourceArea"></resource-page>
      <!-- <books class="books-area" ref="booksArea"></books> -->
    </el-main>
  </el-container>
</template>

<script>
  import SideMenu from './SideMenu'
  import ResourcePage from './ResourcePage'
  export default {
    name: 'AppLibrary',
    components: {SideMenu, ResourcePage},
    methods: {
      listByVariety () {
        var _this = this
        var varid = this.$refs.sideMenu.varid
        var url = 'varieties/' + varid + '/videos'
        this.$axios.get(url).then(resp => {
          if (resp && resp.data.code === 200) {
            _this.$refs.resourceArea.resources = resp.data.result
          }
        })
      }
    }
  }
</script>

<style scoped>
  .main-area {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
  }
</style>
