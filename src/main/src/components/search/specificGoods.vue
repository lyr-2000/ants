<template>
    <div class="goodsShow">
        <div class="specificGoods"  v-for="ex in goodsList">
            <img :src="[require('../../assets/img/search/'+ex.goodsPicture)]">
            <span v-cloak>{{ex.goodsName}}</span>
            <div>
                <span class="goodsPrice" v-cloak>￥{{ex.goodsPrice}}元</span>
                <span class="uploadTime" v-cloak>{{ex.uploadTime}}</span>
            </div>
            <div class="buttonContainer">
                <a>
                    <img 
                        :src="[require('../../assets/img/icon/'+shopSrc)]"
                        @mouseover="shopSrc='shop-rBg.png'"
                        @mouseleave="shopSrc='shop-wBg.png'">
                </a>
                <a href="detail.html/">
                    <img 
                        :src="[require('../../assets/img/icon/'+eyeSrc)]"
                        @mouseover="eyeSrc='eye-rBg.png'"
                        @mouseleave="eyeSrc='eye-wBg.png'">
                </a>
            </div>
        </div>
    </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
    data(){
        return{
            shopSrc:"shop-wBg.png",
            eyeSrc:"eye-wBg.png"
        }
    },
    computed: mapGetters({
        goodsList:"getGoodsList"
    })
}
</script>

<style lang="less" scoped>
@topicShallowRColor:rgba(246,146,138,.5);
.goodsShow{
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    align-content: space-around;
    justify-content: space-between;
    width: 100%;
    .specificGoods{
        display: flex;
        position: relative;
        flex-direction: column;
        width: 22%;
        height: 300px;
        margin-bottom: 20px;
        border: 2px solid rgba(102,102,102,.3);
        &:hover{
            border: 2px solid @topicShallowRColor;
            .buttonContainer{
                display: flex;
            }
        }
        &>img{
            width: 100%;
        }
        &>div{
            display: flex;
            justify-content: space-between;
            .goodsPrice{
                color: #f00;
            }
        }
        span{
            margin: 8px 0px;
            text-indent: 4px;
        }
        .buttonContainer{
            display: none;
            position: absolute;
            flex-direction: column;
            justify-content:space-evenly;
            align-items: center;
            top: 0px;
            left: 0px;
            width: 100%;
            height: 100%;
            background-color: rgba(102,102,102,.3);
            img{
                width: 100px;
                height: 100px;
                cursor: pointer;
            }
        }
    }
}
</style>

