// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
//qs
import QS from 'qs'
// 将qs放到原型链中
Vue.prototype.$qs = QS
//ElementUI
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI)
//axios
import axios from 'axios';
import VueAxios from 'vue-axios'
Vue.use(VueAxios,axios)
Vue.prototype.$axios = axios

Vue.config.productionTip = false






/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
