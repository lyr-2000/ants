<template>
    <div class="mainLeft">
        <div class="arrayBy leftBlock">
            <span class="leftTitle">全部商品</span>
            <div>
                <span v-cloak :class="[type=='1'?'arrayChoose':'']" @click="changeArrayBy('1')">综合</span>
                <span v-cloak :class="[type=='2'?'arrayChoose':'',arraySort&&type=='2'?'upSort':'',!arraySort&&type=='2'?'downSort':'']" @click="changeArrayBy('2')">按时间</span>
                <span v-cloak :class="[type=='3'?'arrayChoose':'',arraySort&&type=='3'?'upSort':'',!arraySort&&type=='3'?'downSort':'']" @click="changeArrayBy('3')">按价格</span>
            </div>
        </div>
        <div class="searchInput">
            <input type="text">
            <img src="../../assets/img/index/search.png">
        </div>

        <div class="classifyNav leftBlock">
            <span class="leftTitle">全部分类</span>
            <ul>
                <li v-for="(classify,index) in synthesis" @click="showChildList(index)">
                    <img :src="[require('../../assets/img/icon'+classify.parentPicture)]">
                    <span :class="[secIndex==index?'indexChoose':'']" v-cloak>{{classify.parentName}}</span>
                    <transition name="leftNav" enter-active-class="leftThiEnter" leave-active-class="leftThiLeave">
                        <ul v-if="index==secIndex&&index!==0">
                            <li v-for="(cla,i) in childList" :class="[i==thiIndex?'thiIndex':'']" v-cloak @click="titleSearch(i)">{{cla.subClassName}}</li>
                        </ul>
                    </transition>
                </li>
            </ul>
            
        </div>
    </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
    data(){
        return{
            
        }
    },
    computed: mapGetters({
        secIndex: "getSecIndex",
        thiIndex:"getThiIndex",
        childList:"getChildList",
        synthesis:"getSynthesis",
        type:"getType",
        arraySort:"getArraySort"
    }),
    methods:{
        ...mapActions(["changeArrayBy","titleSearch","showChildList"])
    }
}
</script>

<style lang="less" scoped>
@import "../../assets/less/define.less";

ul{
    margin: 0px;
    padding: 0px;
    list-style: none;
}
.mainLeft{
    display: inline-block;
    width: 214px;
    margin-right: 30px;
    .leftBlock{
        border: 1px solid @borderColor;
        margin-bottom: 20px;
        color: @deepFontColor;
        .leftTitle{
            display: inline-block;
            width: 100%;
            padding: 10px 0px 11px 0px;
            text-align: center;
            color: @deepFontColor;
            background-color: @borderColor;
        }
    }
    .arrayBy{
        &>div{
            display: flex;
            flex-direction: row;
            justify-content: space-evenly;
            margin: 20px 0px;
            span{
                cursor: pointer;
            }
            .arrayChoose{
                color: @topicDeepRColor;
            }
            .upSort::after{
                content:"↑";
            }
            .downSort::after{
                content:"↓";
            }
        }
    }
    .searchInput{
        display: flex;
        flex-direction: row;
        border: 2px solid @topicDeepBColor;
        margin-bottom: 20px;
        input{
            width: 158px;
            border:none;
            padding:0px 5px;
            outline:none;
        }
        img{    
            width: 18px;
            height: 18px;
            padding: 8px;
            background-color: @topicDeepBColor;
        }
    }
    .classifyNav{
        >ul{
            @textMove:10px;
            display: flex;
            flex-direction: column;
            text-indent: @textMove;
            padding-bottom: 20px;
            >li{
                padding:5px 20px;
                color: @shallowFontColor;
                cursor: pointer;
                >img{
                    @imgLength:24px;
                    width: @imgLength;
                    height: @imgLength;
                    transform:translateX(@textMove) translateY(12px);
                }
                >span{
                    display: inline-block;
                    margin: 20px 0px 0px 10px;
                    font-size: 18px;
                    transform: translatey(7px);
                }
                .indexChoose{
                    color: @topicDeepBColor;
                }
                >ul{
                    display: flex;
                    flex-direction: column;
                    margin: 20px 10px 0px 10px;
                    padding-bottom: 10px;
                    border: 1px solid @borderColor;
                    border-width: 1px 0px;
                    font-size: 12px;
                    overflow: hidden;
                    li{
                        margin: 10px 12px 0px 12px;
                        font-size: 18px;
                    }
                    .thiIndex{
                        position: relative;
                        &::before{
                            content:"";
                            position: absolute;
                            top: 4px;
                            left: 0px;
                            width: 0px;
                            border-top: 5px solid transparent;
                            border-right: 5px solid transparent;
                            border-bottom: 5px solid transparent;
                            border-left: 5px solid @topicDeepBColor;
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

