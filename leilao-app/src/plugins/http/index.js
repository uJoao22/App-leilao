import axios from 'axios'
import interceptors from './interceptors'

export const http = axios.create({
  baseURL: 'http://localhost:8081'
})

export const httpPlugin = function install (Vue, { store }) {
  interceptors(http, store)

  Object.defineProperty(Vue.prototype, '$http', {
    get () {
      return http
    }
  })
}
