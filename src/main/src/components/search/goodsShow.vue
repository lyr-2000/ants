<template>
    <div class="goodsShow">
        <SpecificGoods></SpecificGoods>
        <PageTurn></PageTurn>
    </div>
</template>

<script>
import SpecificGoods from './specificGoods.vue';
import PageTurn from './pageTurn.vue';

export default {
    components:{
        SpecificGoods,
        PageTurn
    }
}
</script>

<style lang="less" scoped>
.goodsShow{
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    align-content: space-around;
    justify-content: space-between;
    width: 100%;
}
</style>

