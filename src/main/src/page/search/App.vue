<template>
  <div id="app">
    <Header></Header>
    <Footer></Footer>
  </div>
</template>

<script>
import Header from '../../components/construct/header.vue'
import Footer from '../../components/construct/footer.vue'

export default {
  name: 'app',
  components: {
    Header,
    Footer
  }
}
</script>

<style>
</style>
