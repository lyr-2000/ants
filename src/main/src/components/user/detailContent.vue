<template>
    <div class="detailContent">
        <MyData v-if="showIndex==0"></MyData>
        <MyGoods v-if="showIndex==1"></MyGoods>
        <Publish v-if="showIndex==2"></Publish>
        <Collect v-if="showIndex==3"></Collect>
        <Trading v-if="showIndex==4"></Trading>
        <HaveTraded v-if="showIndex==5"></HaveTraded>
    </div>
</template>

<script>
import MyData from './mainBlock/myData.vue'
import MyGoods from './mainBlock/myGoods.vue'
import Publish from './mainBlock/publish.vue'
import Collect from './mainBlock/collect.vue'
import Trading from './mainBlock/trading.vue'
import HaveTraded from './mainBlock/haveTraded.vue'



export default {
    data(){
        return{

        }
    },
    components:{
        MyData,
        MyGoods,
        Publish,
        Collect,
        Trading,
        HaveTraded
    },
    props:["showIndex"]
}
</script>

<style lang="less">
.detailContent{
    width: 1060px;
    border-radius: 7px;
    background-color:#fff;
}
</style>
