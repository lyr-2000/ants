<template>
    <div class="specialGoods">
        <div class="specialTitle">
            <!-- <div :class="[showHot?'show':'']" @click="changeShow('hot')"> -->
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
        <span class="leftHandle" @click="this.$emit('turnLeft','special')"><</span>
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
        <span class="rightHandle" @click="this.$emit('turnRight','special')">></span>
    </div>
</template>

<script>
export default {
    data(){
        return{
            showHot: true,
        }
    },
    props:["latest","hottest"]
}
</script>

<style lang="less" scoped>
@toppicColor:#5d759d;
@perfectColor:rgba(246,146,138,.5);
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
            color: @toppicColor;
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
                background-color: @toppicColor;
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
            border-bottom: 2px solid @toppicColor;
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
            background-color: @toppicColor;
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

</style>
