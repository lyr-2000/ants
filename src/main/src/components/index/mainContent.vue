<template>
    <main>
        <Accounce></Accounce>
        <PerfectGoods :moveFlag="moveFlag" @turn-left="turnLeft" 
            @turn-right="turnRight"></PerfectGoods>
        <div class="middleBanner"></div>
        <SpecialGoods :moveFlag="moveFlag" @turn-left="turnLeft" 
            @turn-right="turnRight"></SpecialGoods>
    </main>
</template>

<script>
import Accounce from './announce.vue';
import PerfectGoods from './perfectGoods.vue';
import SpecialGoods from './specialGoods.vue';
import { mapGetters, mapActions } from "vuex";

export default {
    components:{
        Accounce,
        PerfectGoods,
        SpecialGoods
    },
    data(){
        return{  
            moveFlag: {
                'perfect': false,
                'hot': false,
                'new': false
            },
        }
    },
    computed: mapGetters({
        guessLike: "getGuessLike",
        hottest:"getHottest",
        latest:"getLatest"
    }),
    methods:{
        turnLeft: function(type) {
            if (type === 'perfect') {
                this.moveFlag.perfect = false;
            } else if (type === 'special') {
                if (this.showHot) {
                    this.moveFlag.hot = false;
                } else {
                    this.moveFlag.new = false;
                }
            }
        },
        turnRight: function(type) {
            if (type === 'perfect') {
                this.moveFlag.perfect = true;
            } else if (type === 'special') {
                if (this.showHot) {
                    this.moveFlag.hot = true;
                } else {
                    this.moveFlag.new = true;
                }
            }
        },
    }
}
</script>

<style lang="less" scoped>
@import "../../assets/less/define.less";
main{
    margin: 20px auto 283px auto;
    width: 1518px;
}

// 左右箭头
.leftHandle,.rightHandle{
    position: absolute;
    top: 50%;
    font-size: 40px;
    cursor: pointer;
    &:hover{
        color: @topicDeepBColor;
    }
}
.leftHandle{
    left: 10px;
}
.rightHandle{
    right: 10px;
}


.middleBanner{
    width: 100%;
    height: 310px;
    margin: 54px 0px 61px 0px;
    background-image: url('../../assets/img/index/banner.png');
    background-size: cover;
}
@keyframes contentMoveL{
    0%{
        transform: translateX(0px);
    }
    100%{
        transform:translateX(-980px)
    }
}

@keyframes contentMoveR{
    0%{
        transform: translateX(-980px);
    }
    100%{
        transform:translateX(0px)
    }
}
</style>

