<template>
  <div id="app">
    <Header 
        :webPage="webPage" 
        :identity="identity"
    ></Header>
    <ClassifyContainer></ClassifyContainer>
    <MainContent></MainContent>
    <Footer></Footer>
  </div>
</template>

<script>
import Header from '../../components/construct/header.vue'
import Footer from '../../components/construct/footer.vue'
import ClassifyContainer from '../../components/search/classifyContainer.vue'
import MainContent from '../../components/search/mainContent.vue'
import store from '../../store'

export default {
  name: 'app',
  store,
  components: {
    Header,
    Footer,
    ClassifyContainer,
    MainContent
  },
  data(){
    return{
        webPage:'index',
        identity:'buyer',
    }
  }
}
</script>

<style lang="less">
[v-cloak] {
    display: none;
}
</style>

