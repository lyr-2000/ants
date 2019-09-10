<template>
    <div class="goodsIntro">
        <h2 class="goodsName">{{singleGoodsMessage.goodsName}}</h2>
        <hr>
        <img class="goodsImg" :src="singleGoodsMessage.goodsPicture[0]">
        <p>
            <span class="label">价格：</span>
            <span class="price">{{singleGoodsMessage.goodsPrice}}元</span>
            <span class="bargin" v-if="singleGoodsMessage.goodsBargin">/可议价</span>
            <span class="bargin" v-if="!singleGoodsMessage.goodsBargin">/不可议价</span>
        </p>
        <p>
            <span class="label">简介：</span>
            <span class="introduce">{{singleGoodsMessage.goodsDescrible}}</span>
        </p>
        <p>
            <span class="label">配送：</span>
            <span class="send">{{singleGoodsMessage.goodsWay}}</span>
        </p>
        <p class="btnContainer">
            <a class="detailBtn">查看详情</a>
            <a class="purchaseBtn">立即购买</a>
        </p>
        
    </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex"
export default {
    computed:{
        ...mapGetters({
            singleGoodsMessage:"getSingleGoodsMessage"
        })
    },
    methods:{
        ...mapActions(["initDetailGoods"])
    }
}
</script>

<style lang="less">
@import '../../assets/less/define.less';
.goodsIntro{
    width: 320px;
    background-color: @chatShallowBColor;
    .goodsName{
        margin: 28px 21px;
        color:@deepFontColor;
    }
    >hr{
        width: 60px;
        height: 4px;
        margin-left: 21px;
        background-color:@topicDeepBColor;
    }
    .goodsImg{
        width: 260px;
        height: 260px;
        margin: 20px 28px;
    }
    p{
        width: 260px;
        margin: 0px 28px 15px 28px;
        .label{
            font-size: 20px;
            color: @shallowFontColor;
        }
        .price{
            font-size: 30px;
            color: @topicDeepRColor;
        }
        .bargin{
            font-size: 18px;
            color: @topicDeepRColor;
        }
        .introduce , .send{
            font-size: 18px;
            line-height: 18px;
            color: @deepFontColor;
        }
        .detailBtn{
            background-color: @chatDeepBColor;
            &:hover{
                background-color: @topicDeepBColor;
            }
        }
        .purchaseBtn{
            background-color: @topicShallowRColor;
            &:hover{
                background-color: @topicDeepRColor;
            }
        }
    }
    .btnContainer{
        display: flex;
        justify-content: space-evenly;
        margin: 15px 0px;
        width: 100%;
        a{
            padding: 15px;
            border-radius: 10px;
            font-size: 22px;
            color: #fff;
            cursor: pointer;
        }
    }
}
</style>
