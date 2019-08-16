<template>
  <div id="app">
    <Header :webPage="webPage" :identity="identity"></Header>
    <TopBanner :projectName="projectName" ></TopBanner>
    <MainContent></MainContent>
    <Footer></Footer>
  </div>
</template>

<script>
import Header from '../components/construct/header.vue'
import Footer from '../components/construct/footer.vue'
import TopBanner from '../components/index/topBanner.vue'
import MainContent from '../components/index/mainContent.vue'
import store from '../store'

export default {
  name: 'app',
  store,
  components: {
    Header,
    Footer,
    TopBanner,
    MainContent
  },
  data(){
    return{
        webPage:'index',
        identity:'buyer',
        projectName: '蚂蚁置物',
    }
  }
}
</script>

<style scoped>
body{
    margin: 0px;
}
ul{
    margin: 0px;
    padding: 0px;
}
li{
    float: left;
    list-style: none;
}

a{
    text-decoration: none;
    color: inherit;
}

</style>
