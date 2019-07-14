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
import { mapGetters, mapActions } from "vuex";
export default {
    computed: mapGetters({
        pageSource: "getPageSource"
    })
}
</script>

<style lang="less">
@import "../../assets/less/define.less";

.pageInfo{
    width: 100%;
    border: 1px solid @topicDeepBColor;
    &>p{
        width: 1100px;
        margin: 10px auto;
        font-size: 18px;
        .currentPage{
            color: @topicDeepBColor;
        }
    }
}
</style>
