<template>
    <div class="picShow">
        <div class="picTurn">
            <span v-for="(pic,index) in detailGoods.goodsPicture" :class="[index===picIndex?'choosePic':'']">
                <img  :src="pic"  @click="picIndex=index">
            </span>
            
        </div>
        <div class="bigPic">
            <img class="bigImg" :src="detailGoods.goodsPicture[picIndex]">
            <img class="blowUp" src="../../assets/img/detail/blowUp.png">
        </div>
    </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
    data(){
        return{
            picIndex:0
        }
    },
    computed: mapGetters({
        detailGoods: "getDetailGoods"
    })
}
</script>

<style lang="less">
@import "../../assets/less/define.less";

.picShow{
    display: flex;
    align-content: space-between;
    justify-content: space-evenly;
    height: 450px;
    width: 540px;
    .picTurn{
        width: 16%;
        &>span{
            display: inline-block;
            height: 86px;
            width: 86px;
            margin-bottom: 40%;
            >img{
                height: 100%;
                width: 100%;
                cursor:pointer;
            }
        }
        .choosePic{
            position: relative;
            border:2px solid @topicDeepRColor;
            &::after{
                @borderSize:10px;
                content: "";
                position: absolute;
                width: 0px;
                height: 0px;
                left:100%;
                top: 50%;
                border-left: @borderSize solid @topicDeepRColor;
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
        overflow: hidden;
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
