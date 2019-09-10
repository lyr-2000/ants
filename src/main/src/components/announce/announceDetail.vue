<template>
    <div class="detail">
        <span class="back" @click="$emit('changeDetail')"><返回</span>
        <h1>{{annDetail.annTitle}}</h1>
        <p class="time">{{annDetail.annTime}}</p>
        <hr>
        <article>
            <span class="dot">·</span>
            <p v-for="content in annDetail.annContent">{{content}}</p>
            <span class="publisher">蚂蚁置物</span>
        </article>
        <router-link class="turnBtn" to="/feedBack">我要反馈</router-link>
    </div>
</template>

<script>
import {mapGetters} from 'vuex'

export default {
    computed:{
        ...mapGetters("announce",{
            annDetail:"getAnnDetail"
        })
    }
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
