<template>
    <div class="myGoods">
        <p class="title">{{title}}</p>
        <div class="myContent">
            <ul class="myIndex">
                <li @click="pIndex=0" :class="{'chooseIndex':pIndex==0}">我的闲置</li>
                <li @click="pIndex=1" :class="{'chooseIndex':pIndex==1}">我的租赁</li>
                <li @click="pIndex=2" :class="{'chooseIndex':pIndex==2}">我的赠送</li>
                <li @click="pIndex=3" :class="{'chooseIndex':pIndex==3}">我的寻求</li>
            </ul>
            <GoodsDetail v-if="pIndex==0" :pIndex="pIndex" :title="title"></GoodsDetail>
            <GoodsDetail v-if="pIndex==1" :pIndex="pIndex" :title="title"></GoodsDetail>
            <GoodsDetail v-if="pIndex==2" :pIndex="pIndex" :title="title"></GoodsDetail>
            <GoodsDetail v-if="pIndex==3" :pIndex="pIndex" :title="title"></GoodsDetail>
        </div>
    </div>
</template>

<script>
import GoodsDetail from './goodsDetail.vue'

export default {
    data(){
        return{
            pIndex:0,
            title:"我的物品"
        }
    },
    components:{
        GoodsDetail
    }
}
</script>

<style lang="less" scoped>
@import '../../../assets/less/define.less';

.myGoods{
    .myContent{
        display: flex;
        font-size: 18px;
        color: @deepFontColor;
        .myIndex{
            display: flex;
            flex-direction: column;
            width: 208px;
            height: 893px;
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
