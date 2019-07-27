<template>
    <div class="myGoods">
        <p class="title">我的物品</p>
        <div class="myContent">
            <ul class="myIndex">
                <li @click="pIndex=0" :class="{'chooseIndex':pIndex==0}">我的闲置</li>
                <li @click="pIndex=1" :class="{'chooseIndex':pIndex==1}">我的寻求</li>
                <li @click="pIndex=2" :class="{'chooseIndex':pIndex==2}">我的租赁</li>
            </ul>
            <MyGoodsDetail v-if="pIndex==0" :pIndex="pIndex"></MyGoodsDetail>
            <MyGoodsDetail v-if="pIndex==1" :pIndex="pIndex"></MyGoodsDetail>
            <MyGoodsDetail v-if="pIndex==2" :pIndex="pIndex"></MyGoodsDetail>
        </div>
    </div>
</template>

<script>
import MyGoodsDetail from './myGoodsDetail.vue'

export default {
    data(){
        return{
            pIndex:0
        }
    },
    components:{
        MyGoodsDetail
    }
}
</script>

<style lang="less">
@import '../../../assets/less/define.less';

.myGoods{
    .title{
        padding: 41px 0px 38px 50px;
        margin: 0px;
        font-size:22px;
        font-weight: bold;
        color: @topicDeepBColor;
        box-shadow: 0px 4px 0px @borderColor;
    }
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
