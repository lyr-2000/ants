<template>
    <div>
        <div class="classifyContainer">

            <div class="classifyTitle">
                <span :class="{'choosing':!others}" @click="changeChoose('classify')">分类</span>
                <span :class="{'choosing':others}" @click="changeChoose('others')">其他</span>
            </div>

            <div class="classifyIcon">
                <div v-for="(classify,index) in synthesis" @click="$emit('show-childList',index)">
                    <img :src="require('../../assets/img/icon'+classify.parentPicture)">
                    <span v-cloak :class="{'indexChoose':secIndex==index}">{{classify.parentName}}</span>
                </div>
            </div>
            
            <div :class="['concreteClassify',secIndex==0?'hideThi':'showThi']">
                <span v-for="(classify,index) in childList" :class="{'indexChoose':thiIndex==index}" @click="$emit('title-search',index)">{{classify.subClassName}}</span>
            </div>
            
        </div>
    </div>
</template>

<script>
export default {
    data(){
        return{
            others: false
        }
    },
    props:["secIndex","thiIndex","childList","synthesis"],
    methods:{
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
@topicDeepBColor:#5d759d;
@topicShallowRColor:rgba(246,146,138,.5);

.classifyContainer{
    width: 1200px;
    margin: 0px auto 10px auto;
    .classifyTitle{
        display: flex;
        flex-direction: row;
        text-align: center;
        cursor: pointer;
        span{
            display: inline-block;
            width: 50%;
            padding: 10px;
            border: 1px solid rgba(102,102,102,.5);
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
        border: 1px solid rgba(102,102,102,.5);
        >div{
            display: flex;
            flex-direction: column;
            padding: 10px 0px;
            cursor: pointer;
        }
    }
    .concreteClassify{
        display: flex;
        flex-direction: row;
        justify-content: space-evenly;
        border: 1px solid rgba(102,102,102,.5);
        span{
            padding: 10px 0px;
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
        height: 44px;
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
        height: 44px;
    }
}

</style>
