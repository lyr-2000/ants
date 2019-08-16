<template>
    <div class="colect">
        <p class="title">{{title}}</p>
        <div class="colectContent">
            <ul class="colectIndex">
                <li @click="pIndex=0" :class="{'chooseIndex':pIndex==0}">我想买的</li>
                <li @click="pIndex=1" :class="{'chooseIndex':pIndex==1}">我想卖的</li>
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
            title:"收藏盒"
        }
    },
    components:{
        GoodsDetail
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
