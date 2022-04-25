import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from "axios"
import ElmentUi from 'element-ui'

import './axios'
import "element-ui/lib/theme-chalk/index.css"

Vue.config.productionTip = false
Vue.prototype.$axios = axios
Vue.use(ElmentUi)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')