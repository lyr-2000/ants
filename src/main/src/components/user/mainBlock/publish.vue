<template>
    <div class="publish">
        <p class="title">发布物品</p>
        <div class="publishContent">
            <ul class="publichIndex">
                <li @click="pIndex=0" :class="{'chooseIndex':pIndex==0}">发布闲置</li>
                <li @click="pIndex=1" :class="{'chooseIndex':pIndex==1}">发布租赁</li>
                <li @click="pIndex=2" :class="{'chooseIndex':pIndex==2}">发布赠送</li>
                <li @click="pIndex=3" :class="{'chooseIndex':pIndex==3}">发布寻求</li>
            </ul>
            <PublishDetail v-if="pIndex==0" :pIndex="pIndex"></PublishDetail>
            <PublishDetail v-if="pIndex==1" :pIndex="pIndex"></PublishDetail>
            <PublishDetail v-if="pIndex==2" :pIndex="pIndex"></PublishDetail>
            <PublishDetail v-if="pIndex==3" :pIndex="pIndex"></PublishDetail>
        </div>
    </div>
</template>

<script>
import PublishDetail from './publishDetail.vue'

export default {
    data(){
        return{
            pIndex:0,
            goodsName:'',
            goodsPrice:'',
            goodsBargin:'',
            goodsWay:'',
            parentName:'选择大分类',
            childName:'选择小分类',
            goodsDescribe:''
        }
    },
    components:{
        PublishDetail
    }
}
</script>

<style lang="less" scoped>
@import '../../../assets/less/define.less';

.publish{
    height: 1000px;
    .publishContent{
        display: flex;
        font-size: 18px;
        color: @deepFontColor;
        .publichIndex{
            display: flex;
            flex-direction: column;
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
