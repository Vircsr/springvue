<template>
<div>
  <!-- <el-dialog
    title="修改用户信息"
    :visible.sync="dialogFormVisible">
    <el-form v-model="selectedUser" style="text-align: left" ref="dataForm">
      <el-form-item label="用户名" label-width="120px" prop="username">
        <label>{{selectedUser.username}}</label>
      </el-form-item>
      <el-form-item label="真实姓名" label-width="120px" prop="name">
        <el-input v-model="selectedUser.name" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="手机号" label-width="120px" prop="phone">
        <el-input v-model="selectedUser.phone" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" label-width="120px" prop="email">
        <el-input v-model="selectedUser.email" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="密码" label-width="120px" prop="password">
        <el-button type="warning" @click="resetPassword(selectedUser.username)">重置密码</el-button>
      </el-form-item>
      <el-form-item label="角色分配" label-width="120px" prop="roles">
        <el-checkbox-group v-model="selectedRolesIds">
            <el-checkbox v-for="(role,i) in roles" :key="i" :label="role.id">{{role.nameZh}}</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取 消</el-button>
      <el-button type="primary" @click="onSubmit(selectedUser)">确 定</el-button>
    </div>
  </el-dialog> -->
  <el-card class="personage">
    <el-tabs :tab-position="tabPosition" style="height: 600px;margin-top:10px;">
      <el-tab-pane label="用户信息" style="width:80%;height:80%;margin-left:10%;margin-right:10%;margin-top:5%;">
        <el-form ref="userform" label-width="120px">
          <el-form-item label="用户ID：">
            <span style="float: left">{{userform.id}}</span>
          </el-form-item>
          <el-form-item label="用户名：">
            <span style="float: left">{{userform.username}}</span>
          </el-form-item>
          <el-form-item label="昵称：">
            <span style="float: left">{{userform.name}}</span>
          </el-form-item>
          <el-form-item label="联系方式：">
            <span style="float: left">{{userform.phone}}</span>
          </el-form-item>
          <el-form-item label="邮箱：">
            <span style="float: left">{{userform.email}}</span>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">修改</el-button>
          </el-form-item>
        </el-form>
      </el-tab-pane>
      <el-tab-pane label="投稿中心">
        <contribution-manage></contribution-manage>
      </el-tab-pane>
    </el-tabs>
  </el-card>
</div>
</template>

<script>
import ContributionManage from './ContributionManage'
  export default {
    name: 'PersonageIndex',
    components: {ContributionManage},
    data () {
      return {
        tabPosition: 'left',
        userform: [],
        videoform: [],
        dialogFormVisible: false
      }
    },
    // created: function () {
    //   this.loadUserInfo()
    // },
    mounted () {
      this.loadUserInfo()
      // console.log('mounted!')
    },
    methods: {
      onSubmit () {
        console.log('submit!')
      },
      loadUserInfo () {
        var _this = this
        var userid
        var url1 = '/user/' + this.$store.state.usernames
        this.$axios.get(url1).then(resp => {
          if (resp && resp.data.code === 200) {
            _this.userform = resp.data.result
            userid = resp.data.result.id
            console.log(userid)
            var url2 = '/videos/' + userid
            this.$axios.get(url2)
          }
        }).then(
          
        )
      },
      loadVideoInfo () {
        let userid = this.userform.id
        console.log(this.userform.id)
        console.log(userid)
        // console.log('loagvideo')
        let url2 = '/videos/' + userid
        this.$axios.get(url2).then(resp => {
          if (resp && resp.data.code === 200) {
            this.videoform = resp.data.result
            console.log(this.videoform)
            console.log('200')
          }
        })
      }
    }
  }
</script>

<style scoped>
.personage {
    width: 1200px;
    height:660px;
    margin-left: auto;
    margin-right: auto;
  }
</style>
