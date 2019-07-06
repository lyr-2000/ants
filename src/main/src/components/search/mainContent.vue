<template>
    <div>
        <MainLeft @title-search="titleSearch"></MainLeft>
        <GoodsShow :page="page" :currentPage="currentPage"
                @turn="turn" @title-search="titleSearch"></GoodsShow>
    </div>
</template>

<script>
import MainLeft from './mainLeft.vue'
import GoodsShow from './goodsShow.vue'

export default {
    components:{
        MainLeft,
        GoodsShow
    },
    props:["secIndex","thiIndex","childList","synthesis","page","currentPage"],
    methods:{
        turn(page){
            this.$emit("turn",page)
        },
        // 根据标签搜素相应的内容
        titleSearch: function(index) {
            this.$emit("title-search",index);
        },
    }
}
</script>

<style lang="less" scoped>
@topInputColor:rgba(246,146,138,.5);
@borderColor:rgba(102,102,102,.5);
@fontColor:#666;
@fontHoverColor:#333;
.main{
    display: flex;
    flex-direction: row;
    width: 1200px;
    margin: 0px auto 10px auto;
}
</style>

