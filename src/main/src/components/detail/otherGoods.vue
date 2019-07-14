<template>
    <div class="others">
        <p class="othersTitle">卖家的其他闲置商品(共{{totalGoods}}件)</p>
        <div class="picCarousel">
            <span class="carouselBtn" @click="leftSlide=true"><</span>
            <div class="goodsContent">
                <div :class="['singleGoods',leftSlide?'leftSlide':'rightSlide']" v-for="goods in otherGoods">
                    <img :src="goods.goodsPicture">
                    <span class="goodsName">{{goods.goodsName}}</span>
                    <span class="goodsPrice">￥{{goods.goodsPrice}}元</span>
                </div>
            </div>
            <span class="carouselBtn" @click="leftSlide=false">></span>
        </div>
    </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
    data(){
        return {
            leftSlide:true
        }
    },
    computed: mapGetters({
        totalGoods: "getTotalGoods",
        otherGoods:"getOtherGoods"
    })
}
</script>

<style lang="less">
@import "../../assets/less/define.less";

.others{
    width: 1100px;
    margin: 10px auto 80px auto;
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
                margin: 0px 14px 0px 28px;
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
            @keyframes leftSlide{
                0%{
                    transform:translateX(-1025px);
                }
                100%{
                    transform:translateX(0px);
                }
            }
            .leftSlide{
                animation: leftSlide 1s ease-in-out 0s 1 forwards;
            }
            @keyframes rightSlide{
                0%{
                    transform:translateX(0px);
                }
                100%{
                    transform:translateX(-1025px);
                }
            }
            .rightSlide{
                animation: rightSlide 1s ease-in-out 0s 1 forwards;
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

