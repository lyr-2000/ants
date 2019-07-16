<template>
    <div>
        <div class="classifyContainer">

            <div class="classifyTitle">
                <span :class="{'choosing':!others}" @click="changeChoose('classify')">分类</span>
                <span :class="{'choosing':others}" @click="changeChoose('others')">其他</span>
            </div>

            <div class="classifyIcon">
                <div v-for="(classify,index) in synthesis" @click="showChildList(index)">
                    <img :src="require('../../assets/img/icon'+classify.parentPicture)">
                    <span v-cloak :class="{'indexChoose':secIndex==index}">{{classify.parentName}}</span>
                </div>
            </div>
            
            <div :class="['concreteClassify',secIndex==0?'hideThi':'showThi']">
                <span v-for="(classify,index) in childList" :class="{'indexChoose':thiIndex==index}" @click="titleSearch(index)">{{classify.subClassName}}</span>
            </div>
            
        </div>
    </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
    data(){
        return{
            others: false
        }
    },computed: mapGetters({
        secIndex: "getSecIndex",
        thiIndex:"getThiIndex",
        childList:"getChildList",
        synthesis:"getSynthesis"
    }),
    methods:{
        ...mapActions(["showChildList","titleSearch"]),
        changeChoose(type) {
            if (type == 'classify')
                this.others = false;
            else
                this.others = true;
        }
    },
    mounted(){
        console.log(this.childList);
    }
}
</script>

<style lang="less">
@import "../../assets/less/define.less";

.classifyContainer{
    width: 1518px;
    margin: 0px auto 20px auto;
    font-size: 24px;
    .indexChoose{
        color: @topicDeepBColor;
    }
    .classifyTitle{
        display: flex;
        flex-direction: row;
        text-align: center;
        color: @deepFontColor;
        cursor: pointer;
        span{
            display: inline-block;
            width: 50%;
            padding:20px 0px;
            border: 1px solid @borderColor;
        }
        .choosing{
            background-color: @topicDeepBColor;
            color: #fff;
        }
    }
    .classifyIcon{
        display: flex;
        flex-direction: row;
        justify-content: space-evenly;
        border: 1px solid @borderColor;
        color:@deepFontColor;
        >div{
            display: flex;
            flex-direction: column;
            padding: 14px 0px 16px 0px;
            cursor: pointer;
            img{
                height: 47px;
            }
        }
    }
    .concreteClassify{
        display: flex;
        flex-direction: row;
        justify-content: space-evenly;
        border: 1px solid @borderColor;
        color: @deepFontColor;
        span{
            padding: 20px 0px;
            cursor: pointer;
        }
    }
    .hideThi{
        animation: hideThi .3s linear 0s 1 forwards;
    }
    .showThi{
        animation: showThi .3s linear 0s 1 forwards;
    }
}

@keyframes hideThi{
    0%{
        opacity: 1;
        height: 64px;
    }
    100%{
        opacity: 0;
        height: 0px;
    }
}

@keyframes showThi{
    0%{
        opacity: 0;
        height: 0px;
    }
    100%{
        opacity: 1;
        height: 64px;
    }
}

</style>
