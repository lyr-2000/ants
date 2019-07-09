<template>
    <div class="main">
        <MainLeft 
            :secIndex="secIndex"
            :thiIndex="thiIndex"
            :synthesis="synthesis"
            :type="type"
            :childList="childList"
            @title-search="titleSearch"
            @change-array-by="changeArrayBy"
            @show-child-list="showChildList"
        ></MainLeft>
        <GoodsShow 
            :page="page" 
            :currentPage="currentPage"
            :goodsList="goodsList"
            @turn="turn" 
            @title-search="titleSearch"
        ></GoodsShow>
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
    props:["type","secIndex","thiIndex","childList","synthesis","page","currentPage","goodsList"],
    methods:{
        turn(page){
            this.$emit("turn",page)
        },
        // 根据标签搜素相应的内容
        titleSearch(index) {
            this.$emit("title-search",index);
        },
        changeArrayBy(type){
            this.$emit('change-array-by',type);
        },
        showChildList(index){
            this.$emit('show-child-list',index);
        }
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

