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
import Main from '../components/requestTip/main.vue';

export default {
    data(){
        return{
            identity:'buyer',
        }
    },
    components:{
        Header,
        Footer,
        Main
    }
}
</script>

<style>

</style>
