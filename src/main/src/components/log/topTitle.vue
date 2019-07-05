<template>
    <div :class="['top']" v-cloak>
        <div :class="['topTitle']">
            {{productName}}
            <div class="wav"></div>
        </div>
    </div>
</template>

<script>
export default {
    name:'topTitle',
    props:["productName"]
}
</script>

<style lang="less" scoped>
@wavColor:#fff;
@letterSpace:4px;
.top{
    position: relative;
    overflow: hidden;
    .topTitle {
        @fontSize:32px;
        float: left;
        margin: 40px 130px;
        width: (@letterSpace+@fontSize)*4;
        font-size: @fontSize;
        letter-spacing: @letterSpace;
        color: #fff;
        cursor: pointer;
        overflow: hidden;
        &:hover .wav{
            animation:wavMove .5s linear 0s infinite none;
        }
    }
}
</style>
