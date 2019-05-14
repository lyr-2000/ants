let vm = new Vue({
    el: "#app",
    data: {
        productName: "蚂蚁置物",
        school: "",
        sNo: "",
        password: ""
    },
    methods: {
        login: function() { // 发起登录请求
            axios.post('url', {
                school: this.data.school,
                sNo: this.data.sNo,
                password: this.data.password
            }).then((res) => {

            }).catch((err) => {

            })
        }
    },
    components: {
        "infoInput": {
            template: `<div class="inputContainer">
                <slot name="input"></slot>
                <slot name="img"></slot>
            </div>`
        }
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