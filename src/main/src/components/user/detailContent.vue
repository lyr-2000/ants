<template>
    <div class="detailContent">
        <MyData v-if="showIndex==0"></MyData>
        <MyGoods v-if="showIndex==1"></MyGoods>
        <Publish v-if="showIndex==2"></Publish>
        <Trading v-if="showIndex==3"></Trading>
        <HaveTraded v-if="showIndex==4"></HaveTraded>
    </div>
</template>

<script>
import MyData from './mainBlock/myData.vue'
import MyGoods from './mainBlock/myGoods.vue'
import Publish from './mainBlock/publish.vue'
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
