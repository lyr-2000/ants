<template>
    <!-- 星星图 -->
    <div class="starImg" ref="container">

        <img  src="../../assets/img/log/singleStar.png" class="hide" ref="singleStar">
        <transition name="meteor" @before-enter="meteorBeforeEnter" @before-leave="meteorBeforeLeave" @leave="meteorLeave">
            <img class="meteor" src="../../assets/img/log/meteor.png" v-if="meteorShow">
        </transition>
    </div>
</template>

<script>
export default {
    name:'star',
    data(){
        return{
            meteorMoveLength: 100,
            meteorShow: false, // 表示流星的显示
        }
    },
    methods:{
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
        createStar() {
            let starDOM =this.$refs.singleStar.cloneNode(false);
            let type = Math.floor(Math.random() * 3 + 1);
            starDOM.setAttribute('class', 'shine' + type);
            let clientX = Math.random() * window.innerWidth;
            starDOM.style.left = `${clientX}px`;
            let clientY = Math.random() * 200;
            starDOM.style.top = `${clientY}px`;
            let scale = 1 - Math.random() * 2;
            starDOM.style.transform = `scale(${scale})`;
            this.$refs.container.appendChild(starDOM);
            setInterval(() => {
                clientX = Math.random() * window.innerWidth;
                starDOM.style.left = `${clientX}px`;
                clientY = Math.random() * 200;
                starDOM.style.top = `${clientY}px`;
                scale = 1 - Math.random() * 2;
                starDOM.style.transform = `scale(${scale})`;
            }, (type + 3) * 1000)
        }
    },
    mounted(){
        setInterval(function() {
            this.meteorShow = !this.meteorShow;
            setTimeout(function() {
                this.meteorShow = false;
            }, 1000)
        }, 3000);
        let container=this.$refs.container
        let singleStar=this.$refs.singleStar
         for (let i = 0; i < 40; i++) {
            this.createStar();
        }
    }
}


</script>

<style lang="less" scoped>
.starImg{
    width: 0px;
    height: 0px;
    img{
        position: fixed;
    }
    .hide{
        display: none;
    }
    .shine1{
        animation:starShine 4s linear 0s infinite none;
    }
    .shine2{
        animation:starShine 5s linear 0s infinite none;
    }
    .shine3{
        animation:starShine 6s linear 0s infinite none;
    }
}

@keyframes starShine{
    0%{
        opacity: 0;
    }
    50%{
        opacity: 1;
    }
    100%{
        opacity: 0;
    }
}
</style>

