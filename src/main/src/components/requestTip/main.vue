<template>
    <div class="main">
        <div class="imgContainer">
            <img :src="requestImg">
        </div>
        <h1 class="msgTip">{{requestMsg}}</h1>
        <p>
            <a href="" v-if="requestMsg==='发布成功'">查看详情</a>
            <a href="" v-if="requestMsg==='发布失败'">重来一次</a>
            <a class="backBtn" href="">返回首页</a>
        </p>
    </div>
</template>

<script>
export default {
    data(){
        return{
            requestImg:require("../../assets/img/ants/success.png"),
            requestMsg:"",
        }
    },
    mounted(){
        if(window.location.search==="?type=success"){
            this.requestMsg='发布成功';
            this.requestImg=require("../../assets/img/ants/success.png");
        }else if(window.location.search==="?type=fail"){
            this.requestMsg='发布失败';
            this.requestImg=require("../../assets/img/ants/fail.png");
        }
    }
}
</script>

<style lang="less">
@import '../../assets/less/define.less';
*{
    margin: 0px;
}
.main{
    width: 1400px;
    height: 800px;
    margin:40px auto 96px auto;
    text-align: center;
    overflow: hidden;
    box-shadow: @chatDeepBColor 0px 0px 20px;
    .imgContainer{
        position: relative;
        margin-top: 100px;
        margin-bottom:40px;
        &::before{
            content: "";
            position: absolute;
            top: 50%;
            left: 50%;
            width: 443px;
            height: 443px;
            border:20px solid @chatShallowBColor;
            border-radius: 50%;
            transform:translateX(-50%) translateY(-50%);
            animation: bgAnimate 2s ease 0s infinite;
        }
    }
    .msgTip{
        margin-bottom: 50px;
        font-size:30px;
        color: @topicDeepBColor;
    }
    &>p{
        &>a{
            padding: 11px 20px;
            margin: 0px 25px;
            border:2px solid @topicDeepBColor;
            border-radius: 10px;
            font-size: 24px;
            background-color: @topicDeepBColor;
            color:#fff;
        }
        .backBtn{
            background-color: #fff;
            color: @topicDeepBColor;
        }
    }
}
@keyframes bgAnimate{
    0%{
        width: 380px;
        height: 380px;
        opacity: 1;
    }
    100%{
        width: 500px;
        height: 500px;
        opacity: .2;
    }
}
</style>
