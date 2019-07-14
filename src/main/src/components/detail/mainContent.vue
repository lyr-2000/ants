<template>
    <div class="main">
        <PicShow></PicShow>
        <TextInfo></TextInfo>
    </div>
</template>

<script>
import PicShow from './picShow.vue'
import TextInfo from './textInfo.vue'

export default {
    components:{
        PicShow,
        TextInfo
    }
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

