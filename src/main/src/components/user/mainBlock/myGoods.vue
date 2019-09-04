<template>
    <div class="myGoods">
        <p class="title">{{title}}</p>
        <div class="myContent">
            <ul class="myIndex">
                <li v-for="(val,key) in titleList" @click="pIndex=key" :class="{'chooseIndex':pIndex==key}">{{val}}</li>
            </ul>
            <GoodsDetail v-for="index in titleList.length" v-if="pIndex==index-1" :pIndex="pIndex" :detailGoods="myGoods | dataHandle(pIndex)" :title="title"></GoodsDetail>
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
            title:"我的物品",
            titleList:["我的闲置","我的租赁","我的赠送","我的寻求"]
        }
    },
    components:{
        GoodsDetail
    },
    computed:{
        ...mapGetters('user',{
            myGoods:"getMyGoods"
        })
    },
    filters:{
        dataHandle:(data,pIndex)=>{
            if(pIndex==0){
                return data.idleList
            }else if(pIndex==1){
                return data.leaseList
            }else if(pIndex==2){
                return data.giveList
            }else{
                return data.seekList
            }
        }
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
