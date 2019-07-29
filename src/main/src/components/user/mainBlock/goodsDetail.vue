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
            <div class="contentDetail" v-for="g in myGoods[pIndex]">
                <img :src="g.pic">
                <span class="name">{{g.goodsName}}</span>
                <span class="price">￥{{g.goodsPrice}}</span>
                <span class="number">{{g.repertory}}</span>
                <span class="time">{{g.uploadTime}}</span>

                <span class="state" v-if="title==='我的物品'">{{g.state}}</span>
                <a :class="title==='已交易的'?'state':''" href="#" v-if="title!=='正在交易'">查看详情</a>
                <span class="delete" v-if="title==='已交易的'">删除</span>
                <span class="confer" v-if="title==='正在交易'">
                    进入商议
                    <img :src="require('../../../assets/img/user/confer.png')">    
                </span>
            </div>
        </div>
    </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex"

export default {
    data(){
        return{
            stateType:"",
            timeType:""
        }
    },
    props:["pIndex","title"],
    computed:{
        ...mapGetters("user",{
            myGoods:"getMyGoods"
        }),
    },
    watch:{
        // "title":function(val){
        //     console.log('val: ', val);
        //     if(val==="正在交易"){
        //         this.stateType="商议";
        //     }else if(val==="已交易的"){
        //         this.stateType="";
        //     }
        // },
        "pIndex":function(val){
            if(this.title==="我的物品"){
                if(val===0){
                    this.stateType="闲置";
                }else if(val==1){
                    this.stateType="租赁";
                }else if(val==2){
                    this.stateType="赠送";
                }
            }
        }
        
    },
    mounted:function(){
        if(this.title==="我的物品"){
            this.stateType="闲置";
            this.timeType="上传"
        }else if(this.title==="正在交易"){
            this.stateType="商议";
            this.timeType="商议"
        }else if(this.title==="已交易的"){
            this.stateType="";
            this.timeType="交易"
        }
    }
}
</script>

<style lang="less">
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
