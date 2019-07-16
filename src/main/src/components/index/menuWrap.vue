<template>
    <div class="menuwrap">
        <div class="allClassify">
            <span @click="$emit('show-detailed')">所有分类</span>
            <ul v-if="!showDetialedClassify">
                <li v-for="classify in parentClassification">
                    <img :src='[classify.parentPicture]'>
                    <span>{{classify.parentName}}</span>
                </li>
            </ul>
            <div class="detailedContent" v-if="showDetialedClassify">
                <div v-for="(classify,index) in parentClassification">
                    <h4>{{classify.parentName}}</h4>
                    <a href="" v-for="detailed in childClassification[index]">{{detailed}}</a>
                </div>
            </div>
        </div>
        <div class="otherClassify">
            <span>其他</span>
        </div>
    </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
    data(){
        return{}
    },
    computed: mapGetters({
        parentClassification: "getParentClassification",
        childClassification:"getChildClassification"
    }),
    props:["projectName","showDetialedClassify"],
    methods:{
    }
}
</script>

<style lang="less" scoped>
@import '../../assets/less/define.less';
@fontColor:#666;
@fontHoverColor:#333;
.menuwrap{
        margin: 0px auto;
        width: 1518px;
        height: 66px;
        box-shadow: 0px 0px 0px rgb(51,51,51,.8) inset;
        >div{
            display: inline-block;
            width: 260px;
            border: 1px solid @borderColor;
            text-align: center;
            cursor: pointer;
            >span{
                display: inline-block;
                padding: 19px 0px;
                width: 100px;
                font-size: 20px;
                text-align: center;
                &:hover{
                    color: @fontHoverColor;
                }
            }
        }
        .allClassify{
            position: relative;
            border-bottom: 2px solid #fff;
            cursor: pointer;
            >ul{
                position: absolute;
                left: 0px;
                top: 100%;
                display: flex;
                flex-direction: column;
                justify-content: space-around;
                width: 100%;
                height: 424px;
                background-color: rgba(255,255,255,.8);
                li{
                    display: flex;
                    width: 100%;
                    align-items: center;
                    justify-content: center;
                    img{
                        width: 20px;
                    }
                    span{
                        margin-left: 8px;
                        font-size: 20px;
                    }
                    &:hover{
                        color: @fontHoverColor;
                    }
                }
            }
            .detailedContent{
                position: absolute;
                left: 0%;
                top: 103%;
                width: 1060px;
                height: 410px;
                padding: 0px 200px 0px 140px;
                text-align: left;
                background-color: #fff;
                border-bottom: 1px solid @topicDeepBColor;
                >div{
                    float: left;
                    width: 28%;
                    margin: 10px 18px 20px 18px;
                    text-align: left;
                    text-indent: 5px;
                    h4{
                        margin: 10px 0px 15px 0px;
                        padding-bottom: 10px;
                        border-bottom: 2px solid @topicDeepBColor;
                        font-size: 20px;
                    }
                    >a{
                        display: inline-block;
                        width: 45%;
                        margin-top: 5px;
                        color: @shallowFontColor;
                        &:hover{
                            color: @topicDeepBColor;
                        }
                    }
                }
            }
        }
        .otherClassify{
            border-bottom: none;
        }
    }
</style>
