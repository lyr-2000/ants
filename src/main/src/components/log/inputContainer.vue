<template>
    <!-- 登录框 -->
        <div class="inputBg" @mousemove.prevent="dragMove" @mouseup.prevent="dragUp">
            <div v-if="!showCode" :class="['infoInput']">
                <p>登录</p>

                <InfoInput>
                    <template #input>
                    <input type="text" placeholder="学校" v-model="school" @keyup.enter="picCodeRequest">
                </template>
                    <template #img>
                    <img src="../../assets/img/log/school.png">
                </template>
                </InfoInput>

                <InfoInput>
                    <template #input>
                    <input type="text" placeholder="学号/教工号" v-model="sNo" @keyup.enter="picCodeRequest">
                </template>
                    <template #img>
                    <img src="../../assets/img/log/sNo.png">
                </template>
                </InfoInput>

                <InfoInput>
                    <template #input>
                        <input type="password" placeholder="密码" v-model="password" @keyup.enter="picCodeRequest">
                    </template>
                    <template #img>
                        <img src="../../assets/img/log/password.png">
                    </template>
                </InfoInput>
                <p>
                    <input type="checkbox" name="rememberPassword">
                    <label for="rememberPassword">记住账号密码</label>
                    <button class="login" @click="picCodeRequest">登录</button>
                </p>
            </div>

            <div v-if="showCode" class="picContainer">
                <img v-if="!dragStart" :src="[sourceImgName]">
                <img v-show="dragStart" :src="[smallImgName]" ref="slideImg" class="slideImg" :style="`top:${location_y}`">
                <img :src="[bigImgName]" class="bigImg">
                <div class="codeTip" v-if="slideTip">
                    <p>拼图成功，用时{{slideTime}}s</p>
                </div>
            </div>
            <div v-if="showCode&&!slideSuccess" ref="slideCon" class="slideContainer">
                <img src="../../assets/img/index/slideBlock.png" ref="slideHan" class="slideHandle" @mousedown.prevent="dragDown">
                <div class="slideOver"></div>
                <p class="slidIcon">
                    <img src="../../assets/img/index/close.png" @click="closeCode">
                    <img src="../../assets/img/index/refresh.png" @click="picCodeRequest">
                </p>
            </div>

            <div v-if="showCode&&slideSuccess" class="slideSuccess">
                <p>
                    <i><img src="../../assets/img/index/tick.png"></i>
                    <span>三秒后自动转到首页</span>
                </p>
                <a href="index.html">立即前往</a>
            </div>

        </div>
</template>

<script>
import InfoInput from './infoInput.vue'
import axios from 'axios'

export default {
    data(){
        return{
            slideSuccess: false, // 跳转到首页提示
            startTime: 0, // 验证码开始滑动时间点
            slideTime: 0, // 验证码滑动时长
            slideTip: false, // 验证码结果提示
            showCode: false, // 是否显示验证码
            sourceImgName: "",
            bigImgName: "",
            smallImgName: "",
            location_y: "0px",
            location_x: "",
            dragStart: false,
            school: "",
            sNo: "",
            password: "",
            dragLeft: "",
        }
    },
    methods: {
        dragDown: function(e) {
            this.startTime = new Date();
            let start;
            this.$nextTick(()=>{
                start = e.clientX - this.$refs.slideHan.offsetLeft;
                this.dragStart = true;
                this.dragLeft = start;
            });
            return false;
        },
        dragMove: function(e) {
            if (this.dragStart) {
                let location_x = e.clientX - this.dragLeft;
                if (location_x < 0) {
                    location_x = 0;
                } else if (location_x > 310) {
                    location_x = 310;
                }
                this.location_x = location_x;
                this.$nextTick(()=>{
                    this.$refs.slideHan.style.left = this.location_x + 'px';
                    this.$refs.slideImg.style.left = this.location_x + 'px';
                })

            }
        },
        dragUp: function() {
            if (this.dragStart) {
                this.dragStart = false;
                this.slideTime = (new Date() - this.startTime) / 1000;
                this.dragUpRequest();
            }
        },
        picCodeRequest: function() {
            this.showCode = true;
            let that=this;
            axios.get("/slideCode/slide")
            .then((res) => {
                console.log(res);
                res=res.data
                this.bigImgName = `img/${res.bigImgName}`;
                this.sourceImgName = `img/${res.sourceImgName}`;
                this.smallImgName = `img/${res.smallImgName}`;
                that.location_y = res.location_y;
                that.$refs.slideImg.style.top = that.location_y + 'px';
            }).catch((err) => {
                console.error(`error ${err} happen when get picture code`);
            })
        },
        closeCode: function() {
            this.showCode = false;
        },
        dragUpRequest: function() {
            console.log(this.location_x)
            let that=this
            axios.get(`/slideCode/checkServlet?point=${that.location_x}`)
            .then((res) => {
                console.log('res: ', res);
                if (res.data.status == 1) {
                    that.slideTip = true;
                    that.loginRequest();
                } else {
                    alert(res.data.message);
                }
            }).catch(err => {})
        },
        loginRequest: function() { // 发起登录请求
            let encodeData = this.submitForm1();
            let that=this;
            if (!encodeData) {
                this.showCode = false;
                this.slideTip = false;
            } else {
                axios.post('/url', {
                    school: that.school,
                    encodeData: encodeData,
                    //图片的滑动x坐标
                }).then((res) => {
                    if (res == 'success') {
                        that.slideSuccess = true;
                        setTimeout(function() {
                            window.location.replace('index.html');
                        }, 3000);
                    } else {

                    }

                }).catch((err) => {

                })
            }
        },
        submitForm1: function() {
            try {
                let xh = this.sNo;
                let pwd = this.password;
                if (xh == "") {
                    console.log("用户名不能为空！");
                    return false;
                }
                if (pwd == "") {
                    console.log("密码不能为空！");
                    return false;
                }
                // let account = encodeInp(xh);
                // let passwd = encodeInp(pwd);
                let account = xh;
                let passwd = pwd;
                let encoded = account + "%%%" + passwd;
                return encoded;
            } catch (e) {
                alert(e.Message);
                return false;
            }
        }
    },
    components: {
        InfoInput
    },
}
</script>


<style lang="less" scoped>
@inputFontColor:#9fbdd2;
@inputChangeColor:#246c9b;
.inputBg{
    position: fixed;
    left: 50%;
    top: 40%;
    width: 440px;
    height: 400px;
    border-radius: 10px;
    background-color: rgb(255,255,255);
    transform: translateX(-50%) translateY(-50%);
    .infoInput{
        position: absolute;
        left: 50%;
        top: 50%;
        width: 300px;
        height: 340px;
        color: @inputFontColor;
        transform: translateX(-50%) translateY(-50%);
        >p{
            &:first-child{
                font-size: 24px;
                color: @inputChangeColor;
            }
            &:last-child{
                margin-top: 40px;
            }
        }
        .inputContainer{
            position: relative;
            margin: 5px;
            border-bottom: 2px solid @inputFontColor;
            input{
                padding: 30px 10px 5px 10px;
                border:none;
                font-size: 16px;
                letter-spacing: 3px;
                color: @inputChangeColor;
                &::-webkit-input-placeholder{
                    color: @inputFontColor;
                }
            }
            //输入框右侧图片
            img{
                position: absolute;
                right: 10px;
                bottom: 5px;
            }
            &:hover{
                border-color: @inputChangeColor;
            }
            &:focus-within{
                border-color: @inputChangeColor;
            }
        }
        .login{
            border: none;
        }
        button{
            float: right;
            width: 120px;
            height: 35px;
            border-radius: 5px;
            color: rgb(255,255,255);
            background-color: @inputFontColor;
            &:hover{
                background-color: @inputChangeColor;
            }
        }
    }
    .picContainer{
        position: relative;
        width: 400px;
        height: 220px;
        margin: 13px auto;
        border-radius: 10px;
        background-color: #f00;
        .codeTip{
            position: absolute;
            bottom: 0px;
            width: 100%;
            border-radius: 10px;
            text-align: center;
            margin: 0px;
            color: #fff;
            background-color: @inputFontColor;
            p{
                margin: 4px 0px;
            }
        }
        .slideImg{
            position: absolute;
            left: 0px;
            width: 90px;
            height: 90px;
            background-color: black;
        }
        .bigImg{
            width: 100%;
            height: 100%;
        }
    }
    .slideContainer{
        position: relative;
        margin: 0 auto;
        width: 90%;
        height: 100px;
        background-image: url('../../assets/img/index/codeBg.png');
        background-size: 100%;
        background-repeat: no-repeat;
        background-position: center;
        >img{
            position: absolute;
            left: 0px;
            top: 50%;
            width: 90px;
            height: 90px;
            transform: translateY(-50%);
            cursor: pointer;
        }
        .slideOver{
            height: 100px;
        }
        .slidIcon{
            margin: 0px;
            text-align: center;
            >img{
                margin: 0px 10px;
                cursor: pointer;
            }
        }
    }
    .slideSuccess{
        text-align: center;
        >p{
            @imgLength:40px;
            @imgBorder:2px;
            i{
                position: relative;
                display: inline-block;
                width: @imgLength;
                height: @imgLength;
                border:@imgBorder solid @inputFontColor;
                border-radius: 50%;
                line-height: 40px;
                font-size: 24px;
                color: @inputChangeColor;
                &::before{
                    content: "";
                    position: absolute;
                    top: -@imgBorder;
                    left: -@imgBorder;
                    width: inherit;
                    height: inherit;
                    border: @imgBorder solid @inputChangeColor;
                    border-radius: 50%;
                    animation: circleLoading 3s linear 0s 1 none;
                }            
                @keyframes circleLoading{
                    0%{
                        clip: rect(0px 0px @imgLength+2*@imgBorder 0px);
                        transform: rotate(100deg);
                    }
                    100%{
                        clip:rect(0px @imgLength+2*@imgBorder @imgLength+2*@imgBorder 0px);
                        transform: rotate(250deg);
                    }
                }
            }
            letter-spacing: 4px;
            font-size: 20px;
            color: @inputFontColor;
        }
        >a{
            display: inline-block;
            padding: 10px 70px;
            border-radius: 10px;
            font-size: 20px;
            text-decoration: none;
            background-color: @inputFontColor;
            color: #fff;
            &:hover{
                background-color: @inputChangeColor;
            }
        }
    }
}

</style>
