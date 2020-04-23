<template>
  <div>
    <el-menu
      :default-active="currentPath"
      router
      mode="horizontal"
      background-color="white"
      text-color="#222"
      active-text-color="red"
      style="min-width: 1300px">
      <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
        {{ item.navItem }}
      </el-menu-item>
      <span style="position: absolute;padding-top: 20px;right: 60%;font-size: 20px;font-weight: bold">ACGames</span>
      <el-input
        placeholder="快速搜索..."
        prefix-icon="el-icon-search"
        size="medium"
        style="width: 300px;position:absolute;margin-top: 12px;right: 18%"
        v-model="keywords"
        disabled>
      </el-input>
       <el-button type="text" style="position:absolute;margin-top: 12px;right:20px;" @click="logout">{{$store.state.usernames}}</el-button>
    </el-menu>
  </div>
</template>

<script>
  export default {
    name: 'NavMenu',
    data () {
      return {
        navList: [
          {name: '/index', navItem: '首页'},
          {name: '/library', navItem: '视频资源'},
          {name: '/personage', navItem: '个人中心'},
          {name: '/admin', navItem: '后台管理'}
        ],
        keywords: ''
      }
    },
    methods: {
      logout () {
        var _this = this
        this.$axios.get('/logout').then(resp => {
          if (resp && resp.data.code === 200) {
            _this.$store.commit('logout')
            _this.$router.replace('/login')
            console.log('logout')
          }
        }).catch(failResponse => {})
      }
    },
    computed: {
      hoverBackground () {
        return '#ffd04b'
      },
      currentPath () {
        var x = this.$route.path.indexOf('/', 1)
        if (x !== -1) {
          return this.$route.path.substring(0, x)
        } else {
          return this.$route.path
        }
      }
    }
  }
</script>

<style scoped>
  a{
    text-decoration: none;
  }

  span {
    pointer-events: none;
  }

</style>
