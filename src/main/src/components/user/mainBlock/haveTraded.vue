<template>
    <div class="haveTraded">
        <p class="title">{{title}}</p>
        <div class="haveTradedContent">
            <ul class="haveTradedIndex">
                <li @click="pIndex=0" :class="{'chooseIndex':pIndex==0}">闲置物品</li>
                <li @click="pIndex=1" :class="{'chooseIndex':pIndex==1}">租赁物品</li>
                <li @click="pIndex=2" :class="{'chooseIndex':pIndex==2}">赠送物品</li>
            </ul>
            <GoodsDetail v-if="pIndex==0" :pIndex="pIndex" :title="title"></GoodsDetail>
            <GoodsDetail v-if="pIndex==1" :pIndex="pIndex" :title="title"></GoodsDetail>
            <GoodsDetail v-if="pIndex==2" :pIndex="pIndex" :title="title"></GoodsDetail>
        </div>
    </div>
</template>

<script>
import GoodsDetail from './goodsDetail.vue'
export default {
    data(){
        return{
            pIndex:0,
            title:"已交易的"
        }
    },
    components:{
        GoodsDetail
    }
}
</script>

<style lang="less">
@import '../../../assets/less/define.less';

.haveTraded{
    height: 1000px;
    .haveTradedContent{
        display: flex;
        font-size: 18px;
        color: @deepFontColor;
        .haveTradedIndex{
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
