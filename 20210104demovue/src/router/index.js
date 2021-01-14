import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Demo from '@/components/student/Demo'
import Book from '@/components/book/Book'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    }, {
      path: '/Demo',
      name: 'Demo',
      component: Demo
    }, {
      path: '/Book',
      name: 'Book',
      component: Book
    }

  ]
})
