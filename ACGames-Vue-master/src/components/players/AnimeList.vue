<template>
  <div class="menu-container">
    <el-table
    :data="animes"
    style="width:100%;"
    height="500"
    highlight-current-row
    @row-click="handleRowChange">
      <el-table-column
      label="章节列表"
      prop="sectionName"
      border
      width="310"></el-table-column>
    </el-table>
    <!-- <el-menu
      model="vertical"
      @select="handleSelect"
      style="overflow:auto;">
      <el-menu-item v-for="item in animes" :key="item.id" :index="item.sectionId.toString()">
        <span slot="title">{{item.sectionName}}</span>
      </el-menu-item>
    </el-menu> -->
  </div>
</template>

<script>
  export default {
    data () {
      return {
        onRow: '',
        animes: []
      }
    },
    methods: {
      handleRowChange (row) {
        this.onRow = row.sectionId - 1
        this.$emit('indexSelect')
        console.log('click')
        console.log(row)
      }
    }
  }
</script>

<style scoped>
</style>
