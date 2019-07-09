<template>
    <div class="mainLeft">
        <div class="arrayBy leftBlock">
            <span class="leftTitle">全部商品</span>
            <div>
                <span v-cloak :class="[type=='1'?'arrayChoose':'']" @click="$emit('change-array-by','1')">综合</span>
                <span v-cloak :class="[type=='2'?'arrayChoose':'']" @click="$emit('change-array-by','2')">按时间</span>
                <span v-cloak :class="[type=='3'?'arrayChoose':'']" @click="$emit('change-array-by','3')">按价格</span>
            </div>
        </div>
        <div class="searchInput">
            <input type="text">
            <img src="../../assets/img/index/search.png">
        </div>

        <div class="classifyNav leftBlock">
            <span class="leftTitle">全部分类</span>
            <ul>
                <li v-for="(classify,index) in synthesis" @click="$emit('show-child-list',index)">
                    <img :src="[require('../../assets/img/icon'+classify.parentPicture)]">
                    <span :class="[secIndex==index?'indexChoose':'']" v-cloak>{{classify.parentName}}</span>
                    <transition name="leftNav" enter-active-class="leftThiEnter" leave-active-class="leftThiLeave">
                        <ul v-if="index==secIndex&&index!==0">
                            <li v-for="(cla,i) in childList" :class="[i==thiIndex?'thiIndex':'']" v-cloak @click="$emit('title-search',i)">{{cla.subClassName}}</li>
                        </ul>
                    </transition>
                </li>
            </ul>
            
        </div>
    </div>
</template>

<script>
export default {
    data(){
        return{
            
        }
    },
    props:["synthesis","secIndex","thiIndex","type","childList"]
}
</script>

<style lang="less" scoped>
ul{
    margin: 0px;
    padding: 0px;
    list-style: none;
}

@toppicColor:#5d759d;
@topInputColor:rgba(246,146,138,.5);
.mainLeft{
    display: inline-block;
    width: 16%;
    margin-right: 20px;
    .leftBlock{
        border: 1px solid rgba(102,102,102,.5);
        margin-bottom: 20px;
        .leftTitle{
            display: inline-block;
            width: 100%;
            height: 28px;
            line-height: 28px;
            text-align: center;
            background-color: rgba(102,102,102,.5);
        }
    }
    .arrayBy{
        &>div{
            display: flex;
            flex-direction: row;
            justify-content: space-evenly;
            span{
                cursor: pointer;
            }
            .arrayChoose{
                color: @topInputColor;
            }
        }
    }
    .searchInput{
        display: flex;
        flex-direction: row;

        border: 2px solid @toppicColor;
        margin-bottom: 10px;
        input{
            width: 146px;
            border:none;
            padding:0px 5px;
            outline:none;
        }
        img{    
            width: 24px;
            height: 24px;
            padding: 3px;
            background-color: @toppicColor;
        }
    }
    .classifyNav{
        >ul{
            @textMove:10px;
            display: flex;
            flex-direction: column;
            text-indent: @textMove;
            >li{
                padding:5px 0px;
                cursor: pointer;
                >img{
                    transform: scale(0.6) translateX(@textMove) translateY(12px);
                }
                >ul{
                    display: flex;
                    flex-direction: column;
                    margin: 5px 10px;
                    border: 1px solid rgba(102,102,102,.5);
                    border-width: 1px 0px;
                    font-size: 12px;
                    color: rgba(102,102,102,.5);
                    overflow: hidden;
                    .thiIndex{
                        position: relative;
                        &::before{
                            content:">";
                            position: absolute;
                            top: 0px;
                            left: -10px;
                        }
                    }
                }
            }
        }
    }
}
.leftThiEnter{
    opacity: 0;
    height: 0px;
    animation:leftEnter .5s linear .5s 1;
}
.leftThiLeave{
    animation:leftEnter .5s reverse;
}
@keyframes leftLeave{
    0%{
        opacity: 1;
        height: 168px;
    }
    100%{
        opacity: 0;
        height: 0px;
    }
}

@keyframes leftEnter{
    0%{
        opacity: 0;
        height: 0px;
    }
    100%{
        opacity: 1;
        height: 168px;
    }
}
</style>

