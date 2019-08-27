<template>
    <div id="app">
        <Header :identity="identity"></Header>
        <Main></Main>
        <Footer></Footer>
    </div>
</template>

<script>
import Header from '../components/construct/header.vue';
import Footer from '../components/construct/footer.vue';
import Main from '../components/user/mainContent.vue';
import store from '../store'

export default {
    data(){
        return{
            identity:'buyer',
        }
    },
    store,
    components:{
        Header,
        Footer,
        Main
    }
}
</script>

<style>

</style>
