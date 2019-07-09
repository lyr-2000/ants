<template>
    <div class="goodsShow">
        <div class="specificGoods"  v-for="ex in goodsList">
            <img :src="[require('../../assets/img/search/'+ex.goodsPicture)]">
            <span v-cloak>{{ex.goodsName}}</span>
            <div>
                <span class="goodsPrice" v-cloak>￥{{ex.goodsPrice}}元</span>
                <span class="uploadTime" v-cloak>{{ex.uploadTime}}</span>
            </div>
            <div class="buttonContainer">

            </div>
        </div>
    </div>
</template>

<script>
export default {
    props:["goodsList"],
    mounted(){
        console.log(this.goodsList)
    }
}
</script>

<style lang="less" scoped>
@topInputColor:rgba(246,146,138,.5);
.goodsShow{
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    align-content: space-around;
    justify-content: space-between;
    width: 100%;
    .specificGoods{
        display: flex;
        flex-direction: column;
        width: 22%;
        height: 300px;
        margin-bottom: 20px;
        border: 2px solid rgba(102,102,102,.3);
        &:hover{
            border: 2px solid @topInputColor;
        }
        &>img{
            width: 100%;
        }
        &>div{
            display: flex;
            justify-content: space-between;
            .goodsPrice{
                color: #f00;
            }
        }
        span{
            margin: 8px 0px;
            text-indent: 4px;
        }
    }
}
</style>

