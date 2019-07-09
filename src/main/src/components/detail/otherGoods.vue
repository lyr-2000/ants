<template>
    <div class="others">
        <p class="othersTitle">卖家的其他闲置商品(共{{totalGoods}}件)</p>
        <div class="picCarousel">
            <span class="carouselBtn"><</span>
            <div class="goodsContent">
                <div class="singleGoods" v-for="goods in otherGoods">
                    <img :src="goods.goodsPicture">
                    <span class="goodsName">{{goods.goodsName}}</span>
                    <span class="goodsPrice">￥{{goods.goodsPrice}}元</span>
                </div>
            </div>
            <span class="carouselBtn">></span>
        </div>
    </div>
</template>

<script>
export default {
    props:["totalGoods","otherGoods"]
}
</script>

<style lang="less">
@import "../../assets/less/define.less";

.others{
    width: 1000px;
    margin: 10px auto;
    .othersTitle{
        color: @topicDeepBColor;
    }
    .picCarousel{
        display: flex;
        justify-content: space-between;
        .goodsContent{
            display: flex;
            justify-content: space-between;
            overflow: hidden;
            .singleGoods{
                display: flex;
                flex-direction: column;
                border: 1px solid rgba(204,204,204);
                margin-right: 30px;
                height: 220px;
                text-align: center;
                img{
                    width: 160px;
                    height: 160px;
                }
                .goodsPrice{
                    color: @deepTopInputColor;
                }
            }
        }
        .carouselBtn{
            display: inline-block;
            font-size: 40px;
            transform: translateY(40%);
            cursor: pointer;
        }
    }
}
</style>

