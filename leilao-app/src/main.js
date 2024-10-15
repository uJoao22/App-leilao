import Vue from 'vue'
import App from './App'
import store from './store'
import router from './router'
import vuetify from '@/plugins/vuetify'
import { httpPlugin } from '@/plugins/http'

Vue.config.productionTip = false

Vue.use(httpPlugin, { store })

/* eslint-disable no-new */
new Vue({
  el: '#app',
  store,
  router,
  vuetify,
  components: { App },
  template: '<App/>'
})
