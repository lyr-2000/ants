<template>
    <div class="myGoodsDetail">
        <div class="topTitle">
            <span class="name">名称</span>
            <span class="price">价格</span>
            <span class="number">数目</span>
            <span class="time">时间</span>
            <span class="state">状态</span>
        </div>
        <div class="myGoodsContent">
            <div class="contentDetail" v-for="g in myGoods[pIndex]">
                <img :src="g.pic">
                <span class="name">{{g.goodsName}}</span>
                <span class="price">￥{{g.goodsPrice}}</span>
                <span class="number">{{g.repertory}}</span>
                <span class="time">{{g.uploadTime}}</span>
                <span class="state">{{g.state}}</span>
                <a href="#">查看详情</a>
            </div>
        </div>
    </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex"

export default {
    props:["pIndex"],
    computed:mapGetters("user",{
        myGoods:"getMyGoods"
    })
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
            margin-left: 111px;
        }
        .state{
            margin-left: 100px;
        }
    }
    .myGoodsContent{
        .contentDetail{
            margin-top: 10px;
            display: flex;
            align-items: center;
            img{
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
                margin-left: 42px;
                text-align: center;
            }
            a{
                font-size: 14px;
                color:@topicDeepBColor;
            }
        }
    }
}
</style>
