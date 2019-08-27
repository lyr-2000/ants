<template>
    <div class="detail">
        <span class="back" @click="$emit('changeDetail')"><返回</span>
        <h1>关于蚂蚁置物首页上线的公告</h1>
        <p class="time">2019-09-12</p>
        <hr>
        <article>
            <span class="dot">·</span>
            <p>根据中国某某某某法律《某》的通知，从2019年09月起，欢迎使用高校专用大学校园二手交易平台蚂蚁置物，我们将统一当地高校的二手
闲置交易的系统。为此，对于某某某某某某某某某某某某某某某某某某某某某某某用户，我们将从2019年 12月起某某某某某某某某某某某
某某某某某某某某某某某某某某某某某某某某某某某：</p>
            <p></p>
            <p>　　一、请某某某某某某某某某某某某某某某某某按照某某某某某某某某某某的某某统一要求签订《某某某某某某某》，并于2019年9月31
日前将某某某。</p>
            <p></p>
            <p>　　二、部分某某某由于系统升级原因更改了某某某某某账号格式，请客户在签订 《某某某某某某某某某某》的同时与某某某某某确认某某
的账号，并于2019年 1月31日前以正式某某某某某某某某某某受到客户的《某某某某某某某某某某书》及新的某某某某某某某的帐号的，客
户将无法使用某某某某某某某某某某某某某某某某某某某某。</p>
            <p></p>
            <p>　　三、由于定期某某某某某后，系统将不再代为某某某某某，故某某某某某将统一采取某某某某某，客户签收的方式某某某某某某某某某某
某某某某某。为了确认某某某某某，请某某某某某某某某某某某某前往所在区某某某某某某某某某某某某某某某某某某某某某某某某某，同时
填报有关某某某某某</p>
            <span class="publisher">蚂蚁置物</span>
        </article>
        <router-link class="turnBtn" to="/feedBack">我要反馈</router-link>
    </div>
</template>

<script>
export default {

}
</script>

<style lang="less" scoped>
@import '../../assets/less/define.less';
.detail{
    position: relative;
    padding: 35px 35px 90px 35px;
    border: 10px solid @topicDeepBColor;
    .back{
        position: absolute;
        top: 35px;
        left: 35px;
        font-size: 20px;
        color:@deepFontColor;
        cursor: pointer;
    }
    h1,.time{
        text-align: center;
    }
    h1{
        margin: 0px;
        font-size: 26px;
    }
    .time{
        margin-top: 30px;
        margin-bottom: 20px;
        color: @deepFontColor;
    }
    hr{
        height: 3px;
        width: 1200px;
        background-color: @topicDeepBColor;
        color: @topicDeepBColor;
    }
    article{
        position: relative;
        width: 1200px;
        margin: 0px auto;
        padding-bottom: 90px;
        font-size: 18px;
        color: @deepFontColor;
        .dot{
            position: absolute;
            top: -60px;
            left: -30px;
            font-size: 100px;
            color: @topicDeepBColor;
        }
        >p:first-child{
            margin-top: 22px;
        }
        .publisher{
            float: right;
            margin-top: 40px;
            font-size: 18px;
            color: @topicDeepBColor;
        }
    }
    .turnBtn{
        position: absolute;
        left: 50%;
        padding: 13px 24px;
        border: 2px solid @topicDeepBColor;
        border-radius: 5px;
        font-size: 24px;
        text-align: center;
        color: @topicDeepBColor;
        transform: translateX(-50%);
    }
}
</style>
