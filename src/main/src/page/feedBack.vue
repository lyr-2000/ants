<template>
    <div class="feedBack">
        <Header :isNotFound="true" :identity="identity"></Header>
        <div class="mainContainer">
            <div class="main">
                <div class="topGreet">
                    <p>尊敬的用户：</p>
                    <img class="topImg" src="../assets/img/ants/climb.png">
                    <div class="flagTitle">
                        <h1>蚂蚁置物</h1>
                        <h1>反馈调查</h1>
                    </div>
                    <p>您好！为了给您提供更好的服务，我们希望收集您使用蚂蚁置物时的看法或建议。对您的配合和支持表示衷心感谢！</p>
                </div>
                <div class="mainContent">
                    <h2><span class="serialNum">1</span>反馈建议</h2>
                    <div class="detailContent">
                        <p>如果您在使用<span class="specialWord">蚂蚁置物</span>时，有什么好或不好的地方，请大声说出来！我们会关注您的反馈，不断优化产品，为您提供更好的服务！</p>
                        <div class="textContainer">
                            <textarea placeholder="请输入反馈建议" rows="4" v-model="fbContent"></textarea>
                        </div>
                    </div>
                    <h2><span class="serialNum">2</span>反馈调查</h2>
                    <div class="detailContent">
                        <p>您对<span class="specialWord">蚂蚁置物</span>的满意度如何？</p>
                        <p class="btnContainer">
                            <span class="radioBtn" v-for="btn in satisfactionArr" @click="fbSatisfaction=btn">
                                <img :src="fbSatisfaction==btn?require('../assets/img/user/checkBtnBlue.png'):require('../assets/img/user/checkBtnBlack.png')">
                                <span>{{btn}}</span>
                            </span>
                        </p>
                    </div>
                    <h2><span class="serialNum">3</span>信息填写</h2>
                    <div class="detailContent">
                        <p>我们会不定期邀请用户参与面对面的交流。如果您有意参与，请填写如下信息，方便我们与您联系，谢谢！（信息仅作为内部资料绝不外泄）</p>
                        <p class="queTitle">1.称呼</p>
                        <div class="textContainer">
                            <textarea placeholder="请输入您的称呼" rows="1" v-model="userName"></textarea>
                        </div>
                        <p class="queTitle">2.电话</p>
                        <div class="textContainer">
                            <textarea placeholder="请输入您的电话" rows="1" v-model="userMobile"></textarea>
                        </div>
                    </div>
                </div>
                <div class="submit">
                    <button @click="sumbitContent">提交</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import Header from '../components/construct/header.vue'
import axios from 'axios'

export default {
    data(){
        return{
            identity:"buyer",
            satisfactionArr:["非常满意","满意","一般","不满意","非常不满意"],
            fbSatisfaction:"非常满意",
            fbContent:"",
            userName:"",
            userMobile:""
        }
    },
    components:{
        Header
    },
    methods:{
        sumbitContent(){
            if(this.fbContent!==''&&this.fbContent!==''&&this.userName!==''&&this.userMobile!==''){
                let that=this;
                axios({
                    headers: {
                        'deviceCode': 'A95ZEF1-47B5-AC90BF3'
                    },
                    method:"post",
                    url:"/ants/feedback/insertFeedback",
                    data:{
                        fbSatisfaction:that.fbSatisfaction,
                        fbContent:that.fbContent,
                        userName:that.userName,
                        userMobile:that.userMobile
                    }
                }).then(res=>{
                    if(res.data.msg==='提交成功'){
                        alert("提交成功");
                        that.fbSatisfaction="";
                        that.fbContent="";
                        that.userName="";
                        that.userMobile="";
                    }
                }).catch(err=>{
                    alert(`提交失败`);
                    console.log(`the error happen for ${err}`)
                })
            }
        }
    }
}
</script>

<style lang="less" scoped>
@import '../assets/less/define.less';
*{
    margin: 0px;
    padding: 0px;
}
.mainContainer{
    padding-top: 144px;
    padding-bottom: 50px;
    background-color: @borderColor;
    .main{
        width: 1400px;
        margin:0px auto;
        box-shadow:0px 0px 15px rgba(93,117,157,.3);
        background-color: #fff;
        .topGreet{
            position: relative;
            padding: 14px 0px 16px 60px;
            color: #fff;
            background-color: @topicDeepBColor;
            .topImg{
                position: absolute;
                top: -126%;
                left: 50%;
                transform: translateX(-50%);
            }
            .flagTitle{
                position: absolute;
                top: -10px;
                right: 65px;
                width:200px;
                height: 170px;
                text-align: center;
                background-image: url("../assets/img/icon/polygon.png");
                h1:first-child{
                    display: inline-block;
                    margin: 20px 0px 5px 0px;
                }
                h1{
                    font-size: 30px;
                }
            }
            &>p{
                &:first-child{
                    margin-bottom: 8px;
                    font-size: 26px;
                }
                &:last-child{
                    font-size: 18px;
                }
            }
        }
        .mainContent{
            padding: 30px 60px;
            h2{
                font-size: 26px;
                color: @topicDeepBColor;
                .serialNum{
                    display: inline-block;
                    width: 30px;
                    height: 32px;
                    padding-left: 2px;
                    border-radius: 50%;
                    text-align: center;
                    line-height: 30px;
                    font-family: '黑体';
                    border:2px solid #fff;
                    color: #fff;
                    background-color: @topicDeepBColor;
                    transform: translateX(-75px);
                }
            }
            .detailContent{
                padding: 20px 40px;
                margin: 30px 0px 38px 0px;
                background-color: @borderColor;
                >p:first-child{
                    margin-bottom: 20px;
                    font-size: 18px;
                    color: @deepFontColor;
                }
                .specialWord{
                    font-weight: bold;
                    color:@topicDeepBColor;
                }
                .textContainer{
                    padding: 20px;
                    background-color: #fff;
                    textarea{
                        width:100%;
                        border:none;
                        outline:none;
                        font-size: 18px;
                        resize: none;
                    }
                }
                .btnContainer{
                    .radioBtn{
                        cursor: pointer;
                        img{
                            transform: translateY(3px);
                        }
                        span{
                            margin: 0px 50px 0px 10px;
                            font-size: 18px;
                            color: @deepFontColor;
                        }
                    }
                }
                .queTitle{
                    margin: 20px 0px 10px 0px;
                    font-weight: bolder;
                    font-family: '黑体';
                    color:@topicDeepBColor;
                }
            }
        }
        .submit{
            text-align: center;
            &>button{
                padding: 14px 50px;
                margin-bottom: 36px;
                border: 2px solid @topicDeepBColor;
                border-radius:5px;
                font-size: 24px;
                color: @topicDeepBColor;
                background-color:#fff;
                &:hover{
                    color: #fff;
                    background-color: @topicDeepBColor;
                }
            }
        }
    }
}
</style>
