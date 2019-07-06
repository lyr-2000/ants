<template>
    <main>
        <Accounce></Accounce>
        <PerfectGoods :moveFlag="moveFlag" :gussLike="gussLike" 
                @turn-left="turnLeft" @turn-right="turnRight"></PerfectGoods>
        <div class="middleBanner"></div>
        <SpecialGoods :moveFlag="moveFlag" :gussLike="gussLike" 
               @turn-left="turnLeft" @turn-right="turnRight"></SpecialGoods>
    </main>
</template>

<script>
import Accounce from './announce.vue'
import PerfectGoods from './perfectGoods.vue'
import SpecialGoods from './specialGoods.vue'

export default {
    components:{
        Accounce,
        PerfectGoods,
        SpecialGoods
    },
    props:["moveFlag","gussLike"],
    methods:{
        turnLeft: function(type) {
            if (type === 'perfect') {
                this.moveFlag.perfect = false;
            } else if (type === 'special') {
                if (this.showHot) {
                    this.moveFlag.hot = false;
                } else {
                    this.moveFlag.new = false;
                }
            }
        },
        turnRight: function(type) {
            if (type === 'perfect') {
                this.moveFlag.perfect = true;
            } else if (type === 'special') {
                if (this.showHot) {
                    this.moveFlag.hot = true;
                } else {
                    this.moveFlag.new = true;
                }
            }
        },
    }
}
</script>

<style lang="less" scoped>
@toppicColor:#5d759d;
@perfectColor:rgba(246,146,138,.5);
main{
    margin: 20px auto;
    width: 1100px;
}

// 左右箭头
.leftHandle,.rightHandle{
    position: absolute;
    top: 50%;
    font-size: 40px;
    cursor: pointer;
    &:hover{
        color: @toppicColor;
    }
}
.leftHandle{
    left: 10px;
}
.rightHandle{
    right: 10px;
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
.middleBanner{
    width: 100%;
    height: 224px;
    margin: 40px 0px;
    background-image: url('../../img/index/banner.png');
    background-size: cover;
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

