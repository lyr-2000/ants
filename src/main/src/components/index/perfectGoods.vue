<template>
    <div class="perfectGoods">
        <h2 class="perfectTitle">猜你喜欢</h2>

        <span class="leftHandle" @click="this.$emit('turnLeft','perfect')"><</span>
        <div class="goodsList">
            <div :class="['concreteContent',moveFlag.perfect?'moveL':'moveR']" v-for="content in guessLike">
                <a href="#">
                    <img :src="[content.goodsPicture]">
                </a>
                <p v-cloak>{{content.goodsName}}</p>
                <p v-cloak>￥{{content.goodsPrice}}元</p>
            </div>
        </div>
        <span class="rightHandle" @click="this.$emit('turnRight','perfect')">></span>

    </div>
</template>

<script>
export default {
    props:["gussLike","moveFlag"],
    methods:{
        
    }
}
</script>

<style lang="less" scoped>
    .perfectGoods{
        position: relative;
        h2{
            text-align: center;
            color: @perfectColor;
        }
    }
</style>
