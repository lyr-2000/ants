<template>
    <div class="main">
        <MainLeft></MainLeft>
        <GoodsShow></GoodsShow>
    </div>
</template>

<script>
import MainLeft from './mainLeft.vue'
import GoodsShow from './goodsShow.vue'

export default {
    components:{
        MainLeft,
        GoodsShow
    }
}
</script>

<style lang="less" scoped>
@borderColor:rgba(102,102,102,.5);
@fontColor:#666;
@fontHoverColor:#333;
.main{
    display: flex;
    flex-direction: row;
    width: 1518px;
    margin: 0px auto 10px auto;
}
</style>

