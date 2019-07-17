<template>
    <div class="pageTurn">
        <span class="turnPage" @click="turn(currentPage-1)"><</span>
        <div class="pageContainer">
            <span :class="{'currentPage':p==currentPage}" v-for="p in page" v-cloak @click="turn(p)">{{p}}</span>
        </div>
        <span class="turnPage" @click="turn(currentPage+1)">></span>
        <span v-cloak>共{{page}}页</span>
    </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
    computed: mapGetters({
        type:"getType",
        page:"getPage",
        currentPage:"getCurrentPage"
    }),
    methods:{
        ...mapActions(["turn"])
    }
}
</script>

<style lang="less" scoped>
@import "../../assets/less/define.less";

.pageTurn{
    @letterSpacing:9px;
    display: flex;
    justify-content: flex-end;
    width: 100%;
    margin-bottom: 283px;
    text-align: right;
    letter-spacing: @letterSpacing;
    font-size: 28px;
    color: @shallowFontColor;
    transform: translatex(@letterSpacing);
    .turnPage{
        cursor: pointer;
    }
    .pageContainer{
        display: flex;
        flex-direction: row;
        min-width:50px; 
        justify-content: space-evenly;
        span{
            display: inline-block;
            width: 15px;
            padding: 0px 10px;
            text-align: center;
            cursor: pointer;
        }
        .currentPage{
            background-color: @topicShallowRColor;
            color: #fff;
        }
    }
}
</style>

