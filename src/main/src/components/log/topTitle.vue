<template>
    <div :class="['top']" v-cloak>
        <div class="topTitle" >
            <div @mousemove="isHover=true" @mouseleave="isHover=false" :class="[isHover?'hoverTitle':'']">
                <span  v-for="word in productName">{{word}}</span>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name:'topTitle',
    props:["productName"],
    data(){
        return{
            isHover:false
        }
    }
}
</script>

<style lang="less" scoped>
@wavColor:#fff;
@letterSpace:4px;
.top{
    position: relative;
    overflow: hidden;
    .topTitle {
        @fontSize:32px;
        float: left;
        margin: 40px 130px;
        width: (@letterSpace+@fontSize)*4;
        font-size: @fontSize;
        letter-spacing: @letterSpace;
        color: #fff;
        cursor: pointer;
        &>div{
            display: inline-block;
        }
        .hoverTitle{
            @animateTime:1s;
            @differTime:0.25s;
            >*{
                position: relative;
            }
            &>:nth-child(1){
                animation: wordMove @animateTime linear 0s 1 none;
            }
            &>:nth-child(2){
                animation: wordMove @animateTime linear @differTime 1 none;
            }
            &>:nth-child(3){
                animation: wordMove @animateTime linear @differTime*2 1 none;
            }
            &>:nth-child(4){
                animation: wordMove @animateTime linear @differTime*3 1 none;
            }
        }
    }
}

@keyframes wordMove{
    0%{
        bottom: 0px;
    }
    50%{
        bottom: 20px;
    }
    100%{
        bottom: 0px;
    }
}

</style>
