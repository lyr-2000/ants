let vm = new Vue({
    el: "#app",
    data: {
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
        meteorMoveLength: 200,
        meteorShow: false, // 表示流星的显示
        dragStart: "",
    },
    methods: {
        dragDown: function(e) {
            this.dragStart = true;
            let start = e.targetTouches[0].clientX - this.$refs.slideHan.offsetLeft;
            this.dragStart = start;
        },
        dragMove: function(e) {
            this.location_x = e.targetTouches[0].clientX - this.$refs.slideHan.offsetLeft - start;
        },
        dragUp: function() {
            this.dragStart = false;
            this.dragUpRequest();
        },
        picCodeRequest: function() {
            axios.post('/ants/code/SlideCode', {
                imgName: this.sourceImgName
            }).then((res) => {
                this.sourceImgName = res.sourceImgName;
                this.bigImgName = res.bigImgName;
                this.smallImgName = res.smallImgName;
                this.location_y = res.location_y;
            }).catch((err) => {

            })
        },
        dragUpRequest: function() {
            axios.post('/ants/code/SlideCode', {
                _x: this.location_x
            }).then((res) => {
                if (res == 'success') {
                    this.loginRequest();
                } else {
                    alert('验证失败');
                }
            }).catch(err => {})
        },
        loginRequest: function() { // 发起登录请求
            let encodeData = this.submitForm1();
            axios.post('/url', {
                school: this.school,
                encodeData: encodeData,
                //图片的滑动x坐标
            }).then((res) => {

            }).catch((err) => {

            })
        },
        meteorBeforeEnter: function(el) {
            let clientX = Math.random() * 800 + 100;
            let clientY = Math.random() * 200;
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
            Velocity(el, { left: clientX, top: clientY, opacity: 1 }, { duration: 1000, complete: function() { Velocity(el, { left: clientX1, top: clientY2, opacity: 0 }, { duration: 400 }); } });
        },
        submitForm1: function() {
            try {
                let xh = this.sNo;
                let pwd = this.password;
                if (xh == "") {
                    alert("用户名不能为空！");
                    return false;
                }
                if (pwd == "") {
                    alert("密码不能为空！");
                    return false;
                }
                let account = encodeInp(xh);
                let passwd = encodeInp(pwd);
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
            console.log(1)
            that.meteorShow = !that.meteorShow;
            setTimeout(function() {
                that.meteorShow = false;
            }, 1000)
        }, 4000);
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