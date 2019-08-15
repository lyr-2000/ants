<template>
    <div class="infoNav">
        <div class="topInfo">
            <img src="../../assets/img/index/antsLogo.png">
            <span class="myName">{{user.userName}}</span>
        </div>
        <ul class="infoChoose">
            <li v-for="(info,index) of myInfo" @click="$emit('turn-info',index)" :class="{'chooseInfo':showIndex==index}">{{info}}</li>
        </ul>
    </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex"

export default {
    data(){
        return{
            
        }
    },
    props:["showIndex"],
    computed: mapGetters("user",{
        myInfo: "getMyInfo",
        user:"getUser"
    })
}
</script>

<style lang="less">
@import "../../assets/less/define.less";
.infoNav{
    width: 400px;
    height: 698px;
    margin-right: 60px;
    border-radius:7px;
    font-size: 20px;
    color: @deepFontColor;
    background-color: #fff;
    .topInfo{
        @imgWidth:138px;
        display: flex;
        flex-direction: column;
        align-items: center;
        img{
            width: @imgWidth;
            height: @imgWidth;
            margin-top: 50px;
        }
        .myName{
            margin:20px 0px 30px 0px;
        }
    }
    ul{
        display: flex;
        flex-direction: column;
        li{
            width: 100%;
            height: 60px;
            border: 1px solid @borderColor;
            text-align: center;
            line-height: 60px;
            cursor: pointer;
        }
        .chooseInfo{
            @borderWidth:8px;
            border-left: @borderWidth solid @topicDeepBColor;
            text-indent: -15px;
            background-color: @borderColor;
        }
    }
}
</style>
