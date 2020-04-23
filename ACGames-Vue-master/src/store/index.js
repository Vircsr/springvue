import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    usernames: window.localStorage.getItem('usernames') == null ? '' : JSON.parse(window.localStorage.getItem('usernames' || '[]')),
    adminMenus: []
  },
  mutations: {
    initAdminMenu (state, menus) {
      state.adminMenus = menus
    },
    login (state, data) {
      state.usernames = data
      window.localStorage.setItem('usernames', JSON.stringify(data))
    },
    logout (state) {
      // 注意不能用 null 清除，否则将无法判断 user 里具体的内容
      state.username = ''
      window.localStorage.removeItem('usernames')
      state.adminMenus = []
    }
  },
  actions: {
  }
})
