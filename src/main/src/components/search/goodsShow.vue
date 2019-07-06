<template>
    <div class="goodsShow">
        <SpecificGoods :goodsList="goodsList"></SpecificGoods>
        <PageTurn @turn="turn"></PageTurn>
    </div>
</template>

<script>
import SpecificGoods from './specificGoods.vue'
import PageTurn from './pageTurn.vue'

export default {
    components:{
        SpecificGoods,
        PageTurn
    },
    methods:{
        turn(page){
            this.$emit("turn",page)
        }
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

