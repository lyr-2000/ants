<template>
    <div class="main">
        <PicShow
            :pics="detailGoods.goodsPicture"
        ></PicShow>
        <TextInfo
            :detailGoods="detailGoods"
        ></TextInfo>
    </div>
</template>

<script>
import PicShow from './picShow.vue'
import TextInfo from './textInfo.vue'

export default {
    components:{
        PicShow,
        TextInfo
    },
    props:["detailGoods"]
}
</script>

<style lang="less">
.main{
    display: flex;
    justify-content: space-between;
    margin: 20px auto;
    width: 1100px;
}
</style>

