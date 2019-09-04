<template>
    <div class="colect">
        <p class="title">{{title}}</p>
        <div class="colectContent">
            <ul class="colectIndex">
                <li v-for="(val,key) in titleList" @click="pIndex=key" :class="{'chooseIndex':pIndex==key}">{{val}}</li>
            </ul>
            <GoodsDetail v-for="index in titleList.length" v-if="pIndex==index-1" :pIndex="pIndex" :detailGoods="collectGoods | dataHandle(pIndex)" :title="title"></GoodsDetail>
        </div>
    </div>
</template>

<script>
import GoodsDetail from './goodsDetail.vue'
import {mapGetters} from 'vuex'
export default {
    data(){
        return{
            pIndex:0,
            title:"收藏盒",
            titleList:["我想买的","我想卖的"]
        }
    },
    components:{
        GoodsDetail
    },
    computed:{
        ...mapGetters('user',{
            collectGoods:"getCollectGoods"
        })
    },
    filters:{
        dataHandle:(data,pIndex)=>{
            if(pIndex==0){
                return data.buyList
            }else if(pIndex==1){
                return data.sellList
            }
        }
    }
}
</script>
<style lang="less" scoped>
@import '../../../assets/less/define.less';

.colect{
    height: 1000px;
    .colectContent{
        display: flex;
        font-size: 18px;
        color: @deepFontColor;
        .colectIndex{
            display: flex;
            flex-direction: column;
            height: 893px;
            width: 208px;
            border-right: 4px solid @borderColor;
            li{
                padding: 20px 62px;
                border-bottom: 4px solid @borderColor;
                cursor: pointer;
            }
            .chooseIndex{
                color: @topicDeepBColor;
                background-color: @borderColor;
                box-shadow: 10px 0px 0px @topicDeepBColor inset;
            }
        }
    }
}
</style>
