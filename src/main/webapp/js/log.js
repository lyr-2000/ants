let vm = new Vue({
    el: "#app",
    data: {
        slideSuccess: false, // 跳转到首页提示
        startTime: 0, // 验证码开始滑动时间点
        slideTime: 0, // 验证码滑动时长
        slideTip: false, // 验证码结果提示
        showCode: false, // 是否显示验证码
        imgSource: "",
        sourceImgName: "",
        bigImgName: "",
        smallImgName: "",
        location_y: "",
        location_x: "",
        dragStart: false,
        productName: "蚂蚁置物",
        school: "",
        sNo: "",
        password: "",
        meteorMoveLength: 100,
        meteorShow: false, // 表示流星的显示
        dragLeft: "",
    },
    methods: {
        dragDown: function(e) {

            this.startTime = new Date();
            this.dragStart = true;
            let start = e.clientX - this.$refs.slideHan.offsetLeft;

            this.dragLeft = start;
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

                this.$refs.slideHan.style.left = this.location_x + 'px';
                this.$refs.slideImg.style.left = this.location_x + 'px';

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
            axios.post('/ants/code/showCode', {
                imgName: this.sourceImgName
            }).then((res) => {
                this.sourceImgName = res.sourceImgName;
                this.bigImgName = res.bigImgName;
                this.smallImgName = res.smallImgName;
                this.location_y = res.location_y;
                this.$refs.slideImg.style.top = this.location_y + 'px';
            }).catch((err) => {

            })
        },
        closeCode: function() {
            this.showCode = false;
        },
        dragUpRequest: function() {
            axios.post('/ants/code/SlideCode', {
                _x: this.location_x
            }).then((res) => {
                console.log(res);
                if (res == 'success') {
                    this.slideTip = true;
                    this.loginRequest();
                } else {
                    alert('验证失败');
                }
            }).catch(err => {})
        },
        loginRequest: function() { // 发起登录请求
            let encodeData = this.submitForm1();
            if (!encodeData) {
                this.showCode = false;
                this.slideTip = false;
            } else {
                axios.post('/url', {
                    school: this.school,
                    encodeData: encodeData,
                    //图片的滑动x坐标
                }).then((res) => {
                    if (res == 'success') {
                        this.slideSuccess = true;
                        setTimeout(function() {
                            window.location.replace('index.html');
                        }, 3000);
                    } else {

                    }

                }).catch((err) => {

                })
            }
        },
        meteorBeforeEnter: function(el) {
            let clientX = Math.random() * 1000 + 100;
            let clientY = Math.random() * 100;
            el.style.left = clientX + 'px';
            el.style.top = clientY + 'px';
            el.style.opacity = 0;
        },
        meteorBeforeLeave: function(el, done) {
            el.style.opacity = 0;
        },
        meteorLeave: function(el, done) {
            let clientX = parseInt(el.style.left) - this.meteorMoveLength + 'px';
            let clientY = parseInt(el.style.top) + this.meteorMoveLength + 'px';
            let clientX1 = parseInt(clientX) - this.meteorMoveLength + 'px';
            let clientY2 = parseInt(clientY) + this.meteorMoveLength + 'px';
            Velocity(el, { left: clientX, top: clientY, opacity: 1 }, { duration: 500, complete: function() { Velocity(el, { left: clientX1, top: clientY2, opacity: 0 }, { duration: 400 }); } });
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
        "infoInput": {
            template: `<div class="inputContainer">
                <slot name="input"></slot>
                <slot name="img"></slot>
            </div>`
        }
    },
    mounted() {
        let that = this;
        setInterval(function() {
            that.meteorShow = !that.meteorShow;
            setTimeout(function() {
                that.meteorShow = false;
            }, 1000)
        }, 3000);
    }
})


function createStar() {
    let container = document.getElementsByClassName("starImg")[0];
    let starDOM = document.createElement('img');
    starDOM.setAttribute('src', 'img/log/singleStar.png');
    let type = Math.floor(Math.random() * 3 + 1);
    starDOM.setAttribute('class', 'shine' + type);
    let clientX = Math.random() * window.innerWidth;
    starDOM.style.left = `${clientX}px`;
    let clientY = Math.random() * 200;
    starDOM.style.top = `${clientY}px`;
    let scale = 1 - Math.random() * 2;
    starDOM.style.transform = `scale(${scale})`;
    container.appendChild(starDOM);
    setInterval(() => {
        clientX = Math.random() * window.innerWidth;
        starDOM.style.left = `${clientX}px`;
        clientY = Math.random() * 200;
        starDOM.style.top = `${clientY}px`;
        scale = 1 - Math.random() * 2;
        starDOM.style.transform = `scale(${scale})`;
    }, (type + 3) * 1000)

}

for (let i = 0; i < 40; i++) {
    createStar();
}