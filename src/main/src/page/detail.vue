<template>
    <div id="app">
        <Header :webPage="webPage" :identity="identity"></Header>
        <PageInfo></PageInfo>
        <MainContent></MainContent>
        <hr>
        <OtherGoods></OtherGoods>
        <Footer></Footer>
    </div>
</template>

<script>
import Header from '../components/construct/header.vue'
import Footer from '../components/construct/footer.vue'
import PageInfo from '../components/detail/pageInfo.vue'
import MainContent from '../components/detail/mainContent.vue'
import OtherGoods from '../components/detail/otherGoods.vue'
import store from '../store'
import { mapActions } from "vuex";

export default {
    name:'app',
    store,
    components:{
        Header,
        Footer,
        PageInfo,
        MainContent,
        OtherGoods
    },
    data(){
        return{
            webPage:"",
            identity:"buyer",
        }
    },
    methods:{
        ...mapActions(["showinitDetailGoodsChildList"]),
    },
    mounted(){
        // 初始化信息
        this.initDetailGoods(5);
    }
}
</script>

<style lang="less" scoped>

hr{
    width: 1404px;
}

</style>

