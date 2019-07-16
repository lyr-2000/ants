<template>
    <div class="perfectGoods">
        <h2 class="perfectTitle">猜你喜欢</h2>

        <img class="leftHandle" @click="$emit('turn-left','perfect')" src="../../assets/img/index/left_icon.png">
        <div class="goodsList">
            <div :class="['concreteContent',moveFlag.perfect?'moveL':'moveR']" v-for="content in guessLike">
                <a href="#">
                    <img :src="[content.goodsPicture]">
                </a>
                <p v-cloak class="goodsName">{{content.goodsName}}</p>
                <p v-cloak class="goodsPrice">￥{{content.goodsPrice}}元</p>
            </div>
        </div>
        <img class="rightHandle" @click="$emit('turn-right','perfect')" src="../../assets/img/index/right_icon.png">

    </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";


export default {
    props:["moveFlag"],
    computed: mapGetters({
        guessLike: "getGuessLike"
    }),
    methods:{
        
    }
}
</script>

<style lang="less" scoped>
@import "../../assets/less/define.less";
.perfectGoods{
    position: relative;
    h2{
        text-align: center;
        margin: 47px 0px 50px 0px;
        font-size: 36px;
        color: @topicDeepRColor;
    }
}
.goodsList{
    @contentHeight:400px;
    position: relative;
    margin: 0px 87px;
    width: 1350px;
    height: @contentHeight+5px;
    overflow: hidden;
    white-space: nowrap;
    //每个具体块的布局
    @blockWidth:296px;
    .concreteContent{
        display: inline-block;
        width: @blockWidth;
        height: @contentHeight;
        margin-right:50px;
        border:2px solid @shallowFontColor;
        text-align: center;
        img{
            width: @blockWidth;
            height: @blockWidth;
        }
        p{
            margin: 0px;
            transform: translateY(-6px);
        }
        .goodsName{
            margin: 11px 0px 20px 0px;
            font-size: 20px;
        }
        .goodsPrice{
            margin-bottom: 34px;
            font-size: 18px;
            color: @topicDeepRColor;
        }
        &:hover{
            border: 2px solid @topicDeepRColor;
        }
    }
    .moveL{
        animation: contentMoveL .5s ease-in-out 0s 1 forwards;
    }
    .moveR{
        animation: contentMoveR .5s ease-in-out 0s 1 forwards;
    }
}
@topicDeepBColor:#5d759d;
// 左右箭头
.leftHandle,.rightHandle{
    position: absolute;
    top: 50%;
    font-size: 40px;
    cursor: pointer;
    &:hover{
        filter: brightness(70%);
    }
}
.leftHandle{
    left: 32px;
}
.rightHandle{
    right: 32px;
}

@keyframes contentMoveL{
    0%{
        transform: translateX(0px);
    }
    100%{
        transform:translateX(-1050px)
    }
}

@keyframes contentMoveR{
    0%{
        transform: translateX(-1050px);
    }
    100%{
        transform:translateX(0px)
    }
}
</style>
