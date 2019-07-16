<template>
    <div class="others">
        <p class="othersTitle">卖家的其他闲置商品(共{{totalGoods}}件)</p>
        <div class="picCarousel">
            <img :class="{'carouselBtn':true,'leftCarouselBtn':true,'leftSlide':leftSlide}" @click="leftSlide=true" src="../../assets/img/index/left_icon.png">
            <div class="goodsContent">
                <div :class="['singleGoods',leftSlide?'leftSlide':'rightSlide']" v-for="goods in otherGoods">
                    <img :src="goods.goodsPicture">
                    <span class="goodsName">{{goods.goodsName}}</span>
                    <span class="goodsPrice">￥{{goods.goodsPrice}}元</span>
                </div>
            </div>
            <img :class="{'carouselBtn':true,'rightCarouselBtn':true,'rightSlide':!leftSlide}" @click="leftSlide=false" src="../../assets/img/index/right_icon.png">
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
    width: 1404px;
    margin: 30px auto 0px auto;
    .othersTitle{
        margin-bottom: 30px;
        font-size: 24px;
        color: @topicDeepBColor;
    }
    .picCarousel{
        display: flex;
        position: relative;
        justify-content: space-between;
        .goodsContent{
            display: flex;
            justify-content: space-between;
            width: 1272px;
            margin-right: 30px;
            overflow: hidden;
            .singleGoods{
                @imgWidth:225px;
                display: flex;
                flex-direction: column;
                border: 1px solid @borderColor;
                margin-right: 35px;
                width: @imgWidth;
                height: 300px;
                text-align: center;
                img{
                    width: @imgWidth;
                    height: @imgWidth;
                }
                .goodsName{
                    margin: 10px 0px 15px 0px;
                    font-size: 15px;
                }
                .goodsPrice{
                    font-size: 13.5px;
                    font-weight: bold;
                    color: @topicDeepRColor;
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
            width: 26px;
            height: 62px;
            cursor: pointer;
            transform: translateY(122px);
            &:hover{
                filter: brightness(70%);
            }
        }
        .leftCarouselBtn{
            margin-right: 30px;
        }
    }
}
</style>

