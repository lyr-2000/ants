<template>
    <div class="myGoods">
        <p class="title">我的物品</p>
    </div>
</template>

<script>
export default {

}
</script>

<style lang="less">
@import '../../../assets/less/define.less';

.myGoods{
    .title{
        padding: 43px 0px 40px 40px;
        margin: 0px;
        border-left: 10px solid @topicDeepBColor;
        font-size:18px;
        color: @topicDeepBColor;
        box-shadow: 0px 4px 0px @borderColor;
    }
}
</style>
