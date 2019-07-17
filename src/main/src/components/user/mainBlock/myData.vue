<template>
    <div class="myData">
        <p class="title">我的资料</p>
        <ul class="information">
            <li>
                <span class="infoLabel">头像</span>
                <div class="userImg">
                    <img :src="user.pic">
                    <span>编辑</span>
                </div>
            </li>
            <li>
                <span class="infoLabel">昵称</span>
                <input type="text" v-model="user.name">
            </li>
            <li>
                <span class="infoLabel">手机号码</span>
                <input type="text" v-model="user.userMobile">
            </li>
            <li>
                <span class="infoLabel">交易地址</span>
                <input type="text" v-model="user.goodsLocation">
            </li>
            <li>
                <span class="infoLabel">微信号</span>
                <input type="text" v-model="user.userWechat">
            </li>
            <li>
                <span class="infoLabel">QQ号</span>
                <input type="text" v-model="user.userQQ">
            </li>
            <li>
                <span class="infoLabel"></span>
                <button class="saveBtn">确认保存</button>
            </li>
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
    computed:mapGetters({
        user:"getUser"
    })
}
</script>

<style lang="less">
@import '../../../assets/less/define.less';

.myData{
    .title{
        padding: 43px 0px 40px 40px;
        margin: 0px;
        border-left: 10px solid @topicDeepBColor;
        font-size:18px;
        color: @topicDeepBColor;
        box-shadow: 0px 4px 0px @borderColor;
    }
    .information{
        display: flex;
        flex-direction: column;
        margin:50px 0px 0px 89px;
        font-size: 18px;
        color: @deepFontColor;
        li{
            display: flex;
            flex-direction: row;
            align-items: center;
            margin-bottom: 26px;
            .infoLabel{
                display: inline-block;
                width: 150px;
            }
            input{
                width: 400px;
                height: 40px;
                border:none;
                outline: none;
                text-indent:20px;
                font-size: 18px;
                color: @deepFontColor;
                background-color: @borderColor;
            }
            .userImg{
                position: relative;
                @ImgLength:75px;
                width: @ImgLength;
                height:@ImgLength;
                img{
                    width: 100%;
                    height: 100%;
                }
                span{
                    display: none;
                    position: absolute;
                    left:0px;
                    bottom: 0px;
                    padding: 9px 22px 10px 21px;
                    font-size: 14px;
                    background-color: @borderColor;
                    cursor: pointer;
                }
                &:hover span{
                    display: inline;
                }
            }
            .saveBtn{
                padding: 11px 60px;
                border: none;
                outline: none;
                font-size: 18px;
                color: #fff;
                background-color: @topicDeepBColor;
            }
        }
    }
}
</style>
