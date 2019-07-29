<template>
    <div id="app">
        <Header :identity="identity"></Header>
        <Main></Main>
        <Footer></Footer>
    </div>
</template>

<script>
import Header from '../../components/construct/header.vue';
import Footer from '../../components/construct/footer.vue';
import Main from '../../components/user/mainContent.vue';
import store from '../../store'

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

<style lang="less">
@import '../../assets/less/define.less';
.title{
    padding: 41px 0px 38px 50px;
    margin: 0px;
    font-size:22px;
    font-weight: bold;
    color: @topicDeepBColor;
    box-shadow: 0px 4px 0px @borderColor;
}
</style>
