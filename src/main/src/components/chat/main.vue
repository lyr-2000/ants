<template>
    <div class="main">
        <div class="userName">{{chooseUser.userName}}</div>
        <div class="chatContainer">
            <div :class="{'newsList':true,
                'newsLeft':!news.identify,
                'newsRight':news.identify}" 
                v-for="news in newsList">
                <img v-if="!news.identify" :src="news.identify?chooseUser.imgSrc:myIntro.portrait">
                <div class="news">{{news.content}}</div>
                <img v-if="news.identify" :src="news.identify?chooseUser.imgSrc:myIntro.portrait">
            </div>
        </div>
        <div class="chatSend">
            <div class="sendHandle">
                <img :src="emojiIcon" @mouseover="iconHoverIn('emoji')" @mouseleave="iconHoverOut('emoji')">
                <img :src="imgIcon" @mouseover="iconHoverIn('img')" @mouseleave="iconHoverOut('img')">
                <div class="sendBtn" @mouseover="iconHoverIn('send')" @mouseleave="iconHoverOut('send')" @click="sendMsg">
                    <span>发送</span>
                    <img :src="sendIcon">
                </div>
            </div>
            <textarea cols="30" rows="10" v-model="textMsg"></textarea>
        </div>
    </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex"

export default {
    data(){
        return{
            emojiIcon:require("../../assets/img/icon/emoji-before.png"),
            imgIcon:require("../../assets/img/icon/img-before.png"),
            sendIcon:require("../../assets/img/icon/send-before.png"),
            textMsg:""
        }
    },
    methods:{
        ...mapActions("chat",["onSend"]),
        iconHoverIn(type){
            if(type==='emoji'){
                this.emojiIcon=require("../../assets/img/icon/emoji-after.png");
            }else if(type==='img'){
                this.imgIcon=require("../../assets/img/icon/img-after.png");
            }else if(type==='send'){
                this.sendIcon=require("../../assets/img/icon/send-after.png");
            }
        },
        iconHoverOut(type){
            if(type==='emoji'){
                this.emojiIcon=require("../../assets/img/icon/emoji-before.png");
            }else if(type==='img'){
                this.imgIcon=require("../../assets/img/icon/img-before.png");
            }else if(type==='send'){
                this.sendIcon=require("../../assets/img/icon/send-before.png");
            }
        },
        sendMsg(){
            let data={
                type:1,
                msg:textMsg,
                id:myIntro.studentId,
                business:chooseUser.contactor
            }
            this.onSend(data);
        }
    },
    computed:{
        ...mapGetters("user",{
            myIntro:"getUser"
        }),
        ...mapGetters("chat",{
            chooseUser:"getChooseUser",
            newsList:"getNewsList",
        })
    }
}
</script>

<style lang="less" scoped>
@import '../../assets/less/define.less';
.main{
    width:780px;
    .userName{
        padding: 19px 60px;  
        border-bottom: 4px solid @chatShallowBColor;
        font-size: 30px;
        color: @deepFontColor;
    }
    .chatContainer{
        display: flex;
        flex-direction: column;
        height: 512px;
        border-bottom: 4px solid @chatShallowBColor;
        background-color: @chatBgColor;
        .newsList{
            display: flex;
            align-items: center;
            margin-top: 30px;
            img{
                margin: 0px 20px;
                cursor: pointer;
            }
            div{
                max-width: 400px;
                padding: 20px 6px 24px 10px;
                border-radius: 10px;
                font-size: 20px;
            }
        }
        .newsLeft{
            justify-content: flex-start;
            float: left;
            div{
                color:@deepFontColor;
                background-color: #fff;
            }
        }
        .newsRight{
            justify-content: flex-end;
            float: right;
            div{
                color: #fff;
                background-color: @chatDeepBColor;
            }
        }
    }
    .chatSend{
        .sendHandle{
            &>img:first-child{
                margin: 0px 10px 0px 20px;
            }
            .sendBtn{
                display: flex;
                align-items: center;
                float: right;
                margin-right: 35px;
                cursor: pointer;
                &:hover{
                    span{
                        color: @topicDeepBColor;
                    }
                }
                span{
                    margin-right: 9px;
                    font-size: 24px;
                    color: @deepFontColor;
                }
            }
        }
        textarea{
            margin: 12px 30px;
            width: 720px;
            height: 110px;
            border: none; 
            outline:none;
            font-size: 20px;
            color: @deepFontColor;
            resize: none;
        }
    }
}
</style>
