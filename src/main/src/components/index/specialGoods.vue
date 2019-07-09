<template>
    <div class="specialGoods">
        <div class="specialTitle">
            <div :class="{'show':showHot}" @click="changeShow('hot')">
                <span :class="{'hide':!showHot}">Hot</span>
                <span>最热闲置</span>
            </div>
            <div :class="{'show':!showHot}" @click="changeShow('new')">
                <span :class="{'hide':showHot}">New</span>
                <span>最新闲置</span>
            </div>
            <em :class="[showHot?'borderHot':'borderNew']"></em>
            <a class="more" href="#">更多></a>
        </div>
        <span class="leftHandle" @click="$emit('turn-left','special')"><</span>
        <div class="goodsList">
            <div :class="['concreteContent',moveFlag.hot?'moveL':'moveR']" v-if="showHot" v-for="content in hottest">
                <a href="#">
                    <img :src="[content.goodsPicture]">
                </a>
                <p v-cloak>{{content.goodsName}}</p>
                <p v-cloak class="specialPrice">{{content.goodsPrice}}</p>
                <p v-cloak>收藏人数：{{content.starNum}}人</p>
            </div>
            <div :class="['concreteContent',moveFlag.new?'moveL':'moveR']" v-if="!showHot" v-for="content in latest">
                <a href="#">
                    <img :src="[content.goodsPicture]">
                </a>
                <p v-cloak>{{content.goodsName}}</p>
                <p v-cloak class="specialPrice">￥{{content.goodsPrice}}元</p>
                <p v-cloak>上传时间：{{content.uploadTime}}</p>
            </div>
        </div>
        <span class="rightHandle" @click="$emit('turn-right','special')">></span>
    </div>
</template>

<script>
export default {
    data(){
        return{
            showHot: true,
        }
    },
    props:["latest","hottest","moveFlag","guessLike"],
    methods:{
        changeShow: function(currentType) {
            if (currentType === 'hot') {
                this.showHot = true;
            } else {
                this.showHot = false;
            }
        }
    }
}
</script>

<style lang="less" scoped>
@topicDeepBColor:#5d759d;
@perfectColor:rgba(246,146,138,.5);
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
.specialGoods{
    position: relative;
    .specialTitle{
        position: relative;
        border-bottom:2px solid rgba(204,204,204,.5);
        margin-bottom: 4px;
        div{
            display: inline-block;
            position: relative;
            padding: 5px 40px;
            border-bottom: 2px solid transparent;
            color: @topicDeepBColor;
            background-color: rgba(204,204,204,.5);
            overflow: hidden;
            cursor: pointer;
            >span:first-child{
                display: inline-block;
                position: absolute;
                left: 0px;
                top: 0px;
                padding: 8px 6px;
                font-size: 12px;
                color: #fff;
                background-color: @topicDeepBColor;
            }
            .hide{
                animation: titleHide .5s linear 0s 1 forwards;
            }
        }
        em{
            position: absolute;
            display: inline-block;
            left: 0px;
            bottom: 0px;
            height: 0px;
            width: 144px;
            border-bottom: 2px solid @topicDeepBColor;
        }
            .borderHot{
                animation: borHot .5s ease-in 0s 1 forwards;
            }
            .borderNew{
                animation: borNew .5s ease-in 0s 1 forwards;
            }
        .more{
            float: right;
            padding: 4px 6px;
            background-color: @topicDeepBColor;
            color: #fff;
        }
        .show{
            >span:first-child{
                animation: titleShow .5s linear 0s 1 forwards;
            }
        }
    }
}
@topLength:32px;
@keyframes titleHide{
    0%{
        top: 0px;
        opacity: 1;
    }
    100%{
        top: @topLength;
        opacity: 0;
    }
}

@keyframes titleShow{
    0%{
        top: @topLength;
        opacity: 0;
    }
    100%{
        top:0px;
        opacity: 1;
    }
}


@keyframes borHot{
    0%{
        left: 148px;
        width: 144px;
    }
    50%{
        left: 144px;
        width: 0px;
    }
    100%{
        left: 0px;
        width: 144px;
    }
}

@keyframes borNew{
    0%{
        left: 0px;
        width: 144px;
    }
    50%{
        left: 144px;
        width: 0px;
    }
    100%{
        left: 148px;
        width: 144px;
    }
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
