<template>
    <div class="picShow">
        <div class="picTurn">
            <span v-for="(pic,index) in pics" :class="[index===picIndex?'choosePic':'']">
                <img  :src="pic"  @click="picIndex=index">
            </span>
            
        </div>
        <div class="bigPic">
            <img class="bigImg" :src="pics[picIndex]">
            <img class="blowUp" src="../../assets/img/detail/blowUp.png">
        </div>
    </div>
</template>

<script>
export default {
    data(){
        return{
            picIndex:0
        }
    },
    props:["pics"]
}
</script>

<style lang="less">
@import "../../assets/less/define.less";

.picShow{
    display: flex;
    align-content: space-between;
    justify-content: space-evenly;
    height: 360px;
    width: 480px;
    .picTurn{
        width: 20%;
        &>span{
            display: inline-block;
            height: 60px;
            width: 60px;
            margin-bottom: 40%;
            >img{
                height: 100%;
                width: 100%;
                cursor:pointer;
            }
        }
        .choosePic{
            position: relative;
            border:2px solid @deepTopInputColor;
            &::after{
                @borderSize:10px;
                content: "";
                position: absolute;
                width: 0px;
                height: 0px;
                left:100%;
                top: 50%;
                border-left: @borderSize solid @deepTopInputColor;
                border-top: @borderSize solid transparent;
                border-right: @borderSize solid transparent;
                border-bottom: @borderSize solid transparent;
                transform: translateY(-50%);
            }
        }
    }
    .bigPic{
        position: relative;
        width: 75%;
        .bigImg{
            height: 100%;
        }
        .blowUp{
            position: absolute;
            bottom: 0px;
            right: 0px;
        }
    }
}
</style>
