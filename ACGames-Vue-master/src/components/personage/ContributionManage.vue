<template>
  <div>
    <el-table
    :data="tableData"
    height="500"
    border
    style="width: 100%">
    <el-table-column
      prop="title"
      label="标题"
      width="180">
    </el-table-column>
    <el-table-column
      prop="introduction"
      label="简介"
      width="300">
    </el-table-column>
    <el-table-column
      prop="hits"
      label="点击">
    </el-table-column>
    <el-table-column prop="createTime" label="创建时间">
    </el-table-column>
    <el-table-column prop="updateTime" label="最后更新时间">
    </el-table-column>
    <!-- <el-table-column
      label="操作"
      width="120">
      <template slot-scope="scope">
        <el-button type="text" size="small">删除</el-button>
      </template>
    </el-table-column> -->
  </el-table>
  </div>
</template>

<script>
  export default {
    name: 'ContributionManage',
    data () {
      return {
        tableData: []
      }
    }
  }
</script>

<style scoped>
</style>
