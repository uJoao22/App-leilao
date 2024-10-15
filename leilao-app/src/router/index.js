import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import { resolveRoutes } from './resolveRoutes'
import NotFound from '../components/NotFound.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '*',
      component: NotFound
    },
    ...resolveRoutes()
  ]
})
