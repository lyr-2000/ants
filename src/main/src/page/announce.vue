<template>
    <div id="app">
        <Header :identity="identity"></Header>
        <div class="mainContainer">
            <div class="main">
                <AnnounceList v-show="!isDetail" @changeDetail="changeDetail"></AnnounceList>
                <AnnounceDetail v-show="isDetail" @changeDetail="changeDetail"></AnnounceDetail>
            </div>
        </div>
    </div>
</template>

<script>
import Header from '../components/construct/header.vue'
import AnnounceList from '../components/announce/announceList.vue'
import AnnounceDetail from '../components/announce/announceDetail.vue'
import store from '../store'
import {mapActions} from 'vuex'
export default {
    name:'app',
    data(){
        return{
            identity:"buyer",
            isDetail:false
        }
    },
    store,
    components:{
        Header,
        AnnounceList,
        AnnounceDetail
    },
    methods:{
        ...mapActions("announce",["getAnnDetail"]),
        changeDetail(id){
            this.isDetail=!this.isDetail;
            if(this.isDetail){
                this.getAnnDetail(id)
            }
        }
    }
}
</script>

<style lang="less" scoped>
@import '../assets/less/define.less';
.mainContainer{
    padding-top: 40px;
    padding-bottom: 50px;
    background-color: @borderColor;
    .main{
        width: 1400px;
        margin:0px auto;
        box-shadow:0px 0px 10px @topicDeepBColor;
        background-color: #fff;
    }
}
</style>

