<template>
  <div id="app">
    <button><router-link to="/">hello</router-link></button>
    <button><router-link to="Demo">学生</router-link></button>
    <button><router-link to="Book">书籍</router-link></button>
    <router-view></router-view>
    <!--    使用组件-->
    <!--    <Demo></Demo>-->

  </div>
</template>

<script>
  // 引入组件
  // import Demo from "./components/book/Demo"
export default {
  name: 'App',
  //声明组件
  // components:{Demo}
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;
}
a {
  text-decoration: none;
}

.router-link-active {
  text-decoration: none;
}
</style>
