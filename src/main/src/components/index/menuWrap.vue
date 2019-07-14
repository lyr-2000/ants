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
@topicDeepBColor:#5d759d;
@topicShallowRColor:rgba(246,146,138,.5);
@borderColor:rgba(102,102,102,.5);
@fontColor:#666;
@fontHoverColor:#333;
.menuwrap{
        margin: 0px auto;
        width: 1030px;
        >div{
            display: inline-block;
            width: 150px;
            border: 1px solid @borderColor;
            text-align: center;
            cursor: pointer;
            >span{
                display: inline-block;
                padding: 5px 0px;
                width: 100px;
                text-align: center;
                &:hover{
                    color: @fontHoverColor;
                }
            }
        }
        .allClassify{
            position: relative;
            cursor: pointer;
            &:hover ul{
                display: inline-block;
            }
            >ul{
                position: absolute;
                left: 0px;
                top: 100%;
                width: 100%;
                text-align: center;
                background-color: rgba(255,255,255,.8);
                li{
                    width: 100%;
                    padding: 14px 0px;
                    img{
                        width: 12px;
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
                width: 1000px;
                padding: 10px 20px;
                background-color: #fff;
                border-top: 1px solid @topicDeepBColor;
                border-bottom: 1px solid @topicDeepBColor;
                >div{
                    float: left;
                    width: 28%;
                    height: 120px;
                    margin: 5px 20px;
                    text-align: left;
                    text-indent: 5px;
                    h4{
                        margin: 4px 0px;
                        border-bottom: 2px solid @topicDeepBColor;
                    }
                    >a{
                        display: inline-block;
                        width: 45%;
                        margin: 1px 0px;
                        font-size: 14px;
                        color: @fontColor;
                        &:hover{
                            color: @fontHoverColor;
                        }
                    }
                }
            }
        }
    }
</style>
