<template>
    <div class="specialGoods">
        <div class="specialTitle">
            <div :class="{'show':showHot}" @click="changeShow('hot')">
                <span :class="{'hide':!showHot}">Hot</span>
                <span>最热闲置</span>
            </div>
            <div :class="{'show':!showHot,'newTitle':true}" @click="changeShow('new')">
                <span :class="{'hide':showHot}">New</span>
                <span>最新闲置</span>
            </div>
            <em :class="[showHot?'borderHot':'borderNew']"></em>
            <a class="more" href="#">更多></a>
        </div>
        <img class="leftHandle" @click="$emit('turn-left','special')" src="../../assets/img/index/left_icon.png">
        <div class="goodsList">
            <div :class="['concreteContent',moveFlag.hot?'moveL':'moveR']" v-if="showHot" v-for="content in hottest">
                <a href="#">
                    <img :src="[content.goodsPicture]">
                </a>
                <p v-cloak class="goodsName">{{content.goodsName}}</p>
                <p v-cloak class="specialPrice">￥<span>{{content.goodsPrice}}</span>元</p>
                <hr>
                <p v-cloak class="starNum">收藏人数：<span>{{content.starNum}}</span>人</p>
            </div>
            <div :class="['concreteContent',moveFlag.new?'moveL':'moveR']" v-if="!showHot" v-for="content in latest">
                <a href="#">
                    <img :src="[content.goodsPicture]">
                </a>
                <p v-cloak class="goodsName">{{content.goodsName}}</p>
                <p v-cloak class="specialPrice">￥<span>{{content.goodsPrice}}</span>元</p>
                <hr>
                <p v-cloak class="uploadTime">上传时间：<span>{{content.uploadTime}}</span></p>
            </div>
        </div>
        <img class="rightHandle" @click="$emit('turn-right','special')" src="../../assets/img/index/right_icon.png">
    </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
    data(){
        return{
            showHot: true,
        }
    },
    props:["moveFlag"],
    computed: mapGetters({
        guessLike: "getGuessLike",
        hottest:"getHottest",
        latest:"getLatest"
    }),
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
@import "../../assets/less/define.less";
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
    left: 10px;
}
.rightHandle{
    right: 10px;
}

.goodsList{
    @contentHeight:466px;
    position: relative;
    margin: 0px 87px;
    width: 1350px;
    height: @contentHeight+5px;
    overflow: hidden;
    white-space: nowrap;
    @blockWidth:296px;
    //每个具体块的布局
    .concreteContent{
        display: inline-block;
        width: @blockWidth;
        height: @contentHeight;
        margin-right:50px;
        border:2px solid @borderColor;
        text-align: center;
        img{
            width: @blockWidth;
            height: @blockWidth;
        }
        .goodsName{
            margin-top: 31px;
            margin-bottom: 0px;
            font-size: 20px;
        }
        .specialPrice{
            margin: 22px 0px 11px 0px;
        }
        .starNum,.uploadTime{
            margin-top: 8px;
        }
        .starNum,.specialPrice,.uploadTime{
            font-size: 18px;
            &>span{
                color: @topicDeepRColor;
            }
        }
        hr{
            margin: 0px auto;
            width: 80%;
            color: @borderColor;
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

@bottomLength:239px;

.specialGoods{
    position: relative;
    .specialTitle{
        position: relative;
        border-bottom:2px solid @borderColor;
        margin-bottom: 63px;
        div{
            display: inline-block;
            position: relative;
            padding: 5px 25px 5px 55px;
            border-bottom: 2px solid transparent;
            font-size: 24px;
            color: @topicDeepBColor;
            background-color: @borderColor;
            overflow: hidden;
            cursor: pointer;
            >span:first-child{
                display: inline-block;
                position: absolute;
                left: 0px;
                top: 0px;
                padding: 5px 8px;
                color: #fff;
                background-color: @topicDeepBColor;
            }
            >span:last-child{
                margin: 8px 34px 9px 22px;
            }
            .hide{
                animation: titleHide .5s linear 0s 1 forwards;
            }
        }
        .newTitle{
            margin-left: 5px;
        }
        em{
            position: absolute;
            display: inline-block;
            left: 0px;
            bottom: -2px;
            height: 0px;
            width: @bottomLength;
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
            padding:11px 15px 10px 29px;
            font-size: 20px;
            background-color: @topicDeepBColor;
            color: #fff;
            transform: translateY(-6px);
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
        width: @bottomLength;
    }
    50%{
        left: @bottomLength;
        width: 0px;
    }
    100%{
        left: 0px;
        width: @bottomLength;
    }
}

@keyframes borNew{
    0%{
        left: 0px;
        width: @bottomLength;
    }
    50%{
        left: @bottomLength;
        width: 0px;
    }
    100%{
        left: 245px;
        width: @bottomLength;
    }
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
