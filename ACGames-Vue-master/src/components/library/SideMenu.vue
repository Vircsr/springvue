<template>
  <el-menu
    class="varieties"
    default-active="0"
    @select="handleSelect">
    <el-menu-item index="0">
      <i class="el-icon-menu"></i>
      <span slot="title">全部</span>
    </el-menu-item>
    <el-menu-item index="1">
      <i class="el-icon-menu"></i>
      <span slot="title">番剧</span>
    </el-menu-item>
    <el-menu-item index="2">
      <i class="el-icon-menu"></i>
      <span slot="title">杂谈</span>
    </el-menu-item>
    <el-menu-item index="3">
      <i class="el-icon-menu"></i>
      <span slot="title">攻略</span>
    </el-menu-item>
    <el-menu-item index="4">
      <i class="el-icon-menu"></i>
      <span slot="title">实况</span>
    </el-menu-item>
    <el-menu-item index="5">
      <i class="el-icon-menu"></i>
      <span slot="title">推荐</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
    export default {
      name: 'SideMenu',
      data () {
        return {
          varid: ''
        }
      },
      methods: {
        handleSelect (key, keyPath) {
          this.varid = key
          this.$emit('indexSelect')
        }
      }
    }
</script>

<style scoped>
  .varieties {
    position: fixed;
    margin-left: 50%;
    left: -600px;
    top: 100px;
    width: 150px;
  }
</style>
