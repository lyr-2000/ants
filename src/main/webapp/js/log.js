let vm = new Vue({
    el: "#app",
    data: {
        productName: "蚂蚁置物",
        school: "",
        sNo: "",
        password: "",
        meteorMoveLength: 100,
        meteorShow: false, // 表示流星的显示
    },
    methods: {
        login: function() { // 发起登录请求
            axios.post('url', {
                school: this.school,
                sNo: this.sNo,
                password: this.password
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
        meteorEnter: function(el, done) {
            let clientX = parseInt(el.style.left) - this.meteorMoveLength + 'px';
            let clientY = parseInt(el.style.top) + this.meteorMoveLength + 'px';
            Velocity(el, { left: clientX, top: clientY, opacity: 1 }, { duration: 1000 });
        },
        meteorLeave: function(el, done) {
            let clientX = parseInt(el.style.left) - this.meteorMoveLength + 'px';
            let clientY = parseInt(el.style.top) + this.meteorMoveLength + 'px';
            Velocity(el, { left: clientX, top: clientY, opacity: 0 }, { duration: 1000 });
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
    starDOM.setAttribute('src', 'img/singleStar.png');
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