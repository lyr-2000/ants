<template>
    <div class="pageTurn">
        <span class="turnPage" @click="this.$emit('turn',currentPage-1)"><</span>
        <div class="pageContainer">
            <span :class="{'currentPage':p==currentPage}" v-for="p in page" v-cloak @click="turn(p)">{{p}}</span>
        </div>
        <span class="turnPage" @click="this.$emit('turn',currentPage+1)">></span>
        <span v-cloak>共{{page}}页</span>
    </div>
</template>

<script>
export default {
    props:["page","currentPage"],
    methods:{
        
    }
}
</script>

<style lang="less" scoped>
@topInputColor:rgba(246,146,138,.5);

.pageTurn{
    display: flex;
    flex-direction: row;
    justify-content: flex-end;
    width: 100%;
    *{
        padding: 0px 3px;
    }
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
            text-align: center;
            cursor: pointer;
        }
        .currentPage{
            background-color: @topInputColor;
            color: #fff;
        }
    }
}
</style>

