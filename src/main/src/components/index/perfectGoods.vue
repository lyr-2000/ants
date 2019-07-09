<template>
    <div class="perfectGoods">
        <h2 class="perfectTitle">猜你喜欢</h2>

        <span class="leftHandle" @click="$emit('turn-left','perfect')"><</span>
        <div class="goodsList">
            <div :class="['concreteContent',moveFlag.perfect?'moveL':'moveR']" v-for="content in guessLike">
                <a href="#">
                    <img :src="[content.goodsPicture]">
                </a>
                <p v-cloak>{{content.goodsName}}</p>
                <p v-cloak>￥{{content.goodsPrice}}元</p>
            </div>
        </div>
        <span class="rightHandle" @click="$emit('turn-right','perfect')">></span>

    </div>
</template>

<script>
export default {
    props:["guessLike","moveFlag"],
    methods:{
        
    }
}
</script>

<style lang="less" scoped>
@perfectColor:rgba(246,146,138,.5);
.perfectGoods{
    position: relative;
    h2{
        text-align: center;
        color: @perfectColor;
    }
}
.goodsList{
    @contentHeight:250px;
    position: relative;
    margin: 0px 60px;
    width: 980px;
    height: @contentHeight+5px;
    overflow: hidden;
    white-space: nowrap;
    //每个具体块的布局
    .concreteContent{
        display: inline-block;
        width: 17%;
        height: @contentHeight;
        margin: 0px 13px 0px 13px;
        border:2px solid rgba(102,102,102,.7);
        text-align: center;
        img{
            width: 100%;
            height: 80%;
        }
        p{
            margin: 3px 0px;
            transform: translateY(-6px);
        }
        &:hover{
            border: 2px solid @perfectColor;
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
        color: @topicDeepBColor;
    }
}
.leftHandle{
    left: 10px;
}
.rightHandle{
    right: 10px;
}

@keyframes contentMoveL{
    0%{
        transform: translateX(0px);
    }
    100%{
        transform:translateX(-980px)
    }
}

@keyframes contentMoveR{
    0%{
        transform: translateX(-980px);
    }
    100%{
        transform:translateX(0px)
    }
}
</style>
