<template>
    <!-- 轮播图 -->
    <div class="imgPlayBox">
        <div class="imgContainer">
            <img src="../../assets/img/index/playImg1.png">
        </div>
        <div class="playHandle">

        </div>
    </div>
</template>

<script>
export default {

}
</script>

<style lang="less" scoped>
.imgPlayBox{
    @imgHeight:420px;
    width: 100%;
    height: @imgHeight;
    .imgContainer{
        text-align: center;
        background-color: rgba(51,51,51,0.8);
        img{
            height: @imgHeight;
        }
    }
}
</style>

