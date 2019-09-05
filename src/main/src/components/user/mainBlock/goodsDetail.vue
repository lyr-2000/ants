<template>
    <div class="myGoodsDetail">
        <div class="topTitle">
            <span class="name">名称</span>
            <span class="price">价格</span>
            <span class="number">数目</span>
            <span class="time">{{timeType}}时间</span>
            <span class="state">{{stateType}}状态</span>
        </div>
        <div class="myGoodsContent">
            <div class="contentDetail" v-for="g in detailGoods">
                <img :src="g.goodsPicture">
                <span class="name">{{g.goodsName}}</span>
                <span class="price">￥{{g.goodsPrice}}</span>
                <span class="number">{{g.repertory}}</span>
                <span class="time">{{g.uploadTime}}</span>

                <span class="state" v-if="title==='我的物品'">{{g.goodsState}}</span>
                <a :class="title==='已交易的'||title==='收藏盒'?'state':''" href="#" v-if="title!=='正在交易'">查看详情</a>
                <span class="delete" v-if="title==='已交易的'||title==='收藏盒'">删除</span>
                <span class="confer" v-if="title==='正在交易'">
                    进入商议
                    <img :src="require('../../../assets/img/user/confer.png')">    
                </span>
            </div>
        </div>
    </div>
</template>

<script>
import {mapActions} from 'vuex'
import { setTimeout } from 'timers';

export default {
    data(){
        return{
            stateType:"",
            timeType:"",
            currentPage:0
        }
    },
    props:["title","detailGoods","pIndex"],
    methods:{
        ...mapActions("user",["getGoods"])
    },
    mounted(){
        let url;
        if(this.title==="我的物品"){
            this.stateType="交易";
            this.timeType="上传"
            url="/ants/student/myTradingSituation"
        }else if(this.title==="正在交易"||this.title==="收藏盒"){
            this.stateType="商议";
            this.timeType="商议"
            url="/ants/trade/myTradeGoods"
            if(this.title==="收藏盒"){
                url="/ants/tradeCase/tradingCase"
            }
        }else if(this.title==="已交易的"){
            this.stateType="";
            this.timeType="交易"
            url="/ants/sell/mySellGoods"
        }
        let type=0;
        if(this.pIndex==0||this.pIndex==1){
            type=this.pIndex+1
        }else if(this.pIndex==2){
            type=4
        }else if(this.pIndex==3){
            type=3
        }
        let data={
            url:url,
            type:type,
            cPage:this.currentPage,
            title:this.title
        }
        this.getGoods(data);
    }
}
</script>

<style lang="less" scoped>
@import '../../../assets/less/define.less';

.myGoodsDetail{
    width: 800px;
    margin: 4px 28px;
    .topTitle{
        padding-top: 12px;
        padding-bottom: 11px;
        margin-bottom: 10px;
        background-color: @topicDeepBColor;
        color: #fff;
        .name{
            margin-left: 120px;
        }
        .price{
            margin-left: 102px;
        }
        .number{
            margin-left: 70px;
        }
        .time{
            margin-left: 87px;
        }
        .state{
            margin-left: 86px;
        }
    }
    .myGoodsContent{
        .contentDetail{
            margin-top: 10px;
            display: flex;
            align-items: center;
            >img{
                @imgLength:100px;
                width:@imgLength;
                height: @imgLength;
            }
            span{
                display: inline-block;
            }
            .name{
                margin-left: 20px;
                width: 110px;
            }
            .price{
                width: 52px;
                margin-left: 30px;
            }
            .number{
                width: 40px;
                margin-left: 58px;
                text-align: center;
            }
            .time{
                width: 121px;
                margin-left: 72px;
            }
            .state{
                width: 80px;
                margin-left: 40px;
                text-align: center;
            }
            .delete,
            .confer{
                color: @topicDeepRColor;
                cursor: pointer;
            }
            .confer{
                margin-left: 54px;
                img{
                    transform: translateY(4px);
                }
            }
            a{
                width: 72px;
                font-size: 14px;
                color:@topicDeepBColor;
            }
        }
    }
}
</style>
