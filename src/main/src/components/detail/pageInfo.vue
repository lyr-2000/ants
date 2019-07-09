<template>
    <div class="pageInfo">
        <p>
            <span v-for="(word,index) in pageSource" :class="[index==pageSource.length-1?'currentPage':'']">
                {{word}}
                <strong v-if="index<pageSource.length-1">></strong>
            </span>
        </p>
    </div>
</template>

<script>
export default {
    props:["pageSource"]
}
</script>

<style lang="less">
@import "../../assets/less/define.less";

.pageInfo{
    width: 100%;
    border: 1px solid @toppicColor;
    &>p{
        width: 1200px;
        margin: 10px auto;
        text-indent: 120px;
        font-size: 18px;
        .currentPage{
            color: @toppicColor;
        }
    }
}
</style>
