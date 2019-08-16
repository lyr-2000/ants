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

<style lang="less" scoped>
.main{
    display: flex;
    justify-content: space-between;
    margin: 60px auto 64px auto;
    width: 1404px;
}
</style>

