<template>
  <el-container>
    <el-aside style="width: 200px;margin-top:20px;">
    <!-- <SideMenu @indexSelect="listByVariety" ref="sideMenu"></SideMenu> -->
    </el-aside>
    <el-main>
      <resource-page class="main-area" ref="resourceArea"></resource-page>
    </el-main>
  </el-container>
</template>

<script>
  import ResourcePage from './ResourcePage'
  export default {
    name: 'AppLibrary',
    components: {ResourcePage},
    methods: {
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
