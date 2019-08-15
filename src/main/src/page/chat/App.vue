<template>
    <div id="app">
        <Header :webPage="webPage" :identity="identity"></Header>
        <div class="mainContainer">
            <UserList></UserList>
            <Main></Main>
            <GoodsIntro></GoodsIntro>
        </div>
        <Footer></Footer>
    </div>
</template>

<script>
import Header from '../../components/construct/header.vue'
import Footer from '../../components/construct/footer.vue'
import store from '../../store'
import UserList from '../../components/chat/userList.vue'
import Main from '../../components/chat/main.vue'
import GoodsIntro from '../../components/chat/goodsIntro.vue'

export default {
    name:'app',
    store,
    components:{
        Header,
        Footer,
        UserList,
        Main,
        GoodsIntro
    },
    data(){
        return{
            webPage:"",
            identity:"buyer",
        }
    }
}
</script>

<style lang="less">
@import '../../assets/less/define.less';
.mainContainer{
    display: flex;
    width: 1400px;
    height: 800px;
    margin:40px auto 96px auto;
    overflow: hidden;
    box-shadow: @chatDeepBColor 0px 0px 20px;
}
</style>

