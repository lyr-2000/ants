<template>
    <div class="textInfo">
        <h1 class="goodsName">{{detailGoods.goodsName}}</h1>
        <div class="goodsPrice">
            <span class="goodsLabel">价格</span>
            <p>
                <span>{{detailGoods.goodsPrice}}元</span>
                <span class="goodsBargin">{{detailGoods.goodsBargin?'可议价':'不可议价'}}</span>
            </p>
        </div>
        <div class="goodsDescrible">
            <span class="goodsLabel">简介</span>
            <p>{{detailGoods.goodsDescrible}}</p>
        </div>
        <div class="goodsTransaction">
            <span class="goodsLabel">配送</span>
            <p>{{detailGoods.transactionMode}}</p>
        </div>
        <div class="goodsAmount">
            <span class="goodsLabel">数目</span>
            <p>
                <strong @click="buyNum>1?buyNum--:''" class="numHandle">-</strong>
                <input type="text" size="1" v-model="buyNum">
                <strong @click="buyNum<detailGoods.goodsAmount?buyNum++:''" class="numHandle">+</strong>
                <span class="remanentNum">(库存{{detailGoods.goodsAmount}}件)</span>
            </p>
        </div>
        <div class="goodsContact">
            <span class="goodsLabel">联系</span>
            <p>
                <img src="../../assets/img/detail/chat.png" @click="enterChat">
                <img src="../../assets/img/detail/wechat.png" @click="getInfo('wechat')">
                <img src="../../assets/img/detail/QQ.png" @click="getInfo('qq')">
            </p>
        </div>
        <div class="handleButton">
            <button class="addToCart">加入购物车</button>
            <button class="immediatePurchase">立即购买</button>
        </div>
        <div class="tipContainer" v-if="tipShow">
            <div class="tipFixed">
                <p>{{tipContent}}</p>
                <img src="../../assets/img/detail/close.png" @click="tipShow=false">
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data(){
        return{
            buyNum:1,
            tipContent:'啊哦~卖家隐藏了信息',
            tipShow:false
        }
    },
    props:["detailGoods"],
    methods:{
        // 进入聊天空间
        enterChat(){
            console.log('进入聊天空间');
        },
        // 获取联系方式
        getInfo(contact){
            this.tipShow=true;
            if(contact==='wechat'){
                if(this.detailGoods.isWechat){
                    this.tipContent=`微信号：${this.detailGoods.Wechat}`;
                }else{
                    this.tipContent='啊哦~卖家隐藏了信息';
                }
            }else if(contact==='qq'){
                if(this.detailGoods.isQQ){
                    this.tipContent=`QQ号：${this.detailGoods.QQ}`;
                }else{
                    this.tipContent='啊哦~卖家隐藏了信息';
                }
            }
        }
    },
    watch:{
        buyNum:function(newVal){
            if(newVal<0){
                this.buyNum=1;
            }else if(newVal>this.detailGoods.goodsAmount){
                this.buyNum=this.detailGoods.goodsAmount;
            }
        }
    }
}
</script>

<style lang="less">
@import "../../assets/less/define.less";

.textInfo{
    width: 600px;
    .goodsName{
        margin-top: 0px;
    }
    &>div{
        display: flex;
        align-items: center;
        .goodsLabel{
            margin: 0px 20px;
            color: rgb(151,151,151);
        }
    }
    .goodsPrice{
        background-color: rgba(204,204,204,.3);
        p{
            display: flex;
            justify-content: space-between;
            width: 80%;
            &>span:first-child{
                font-size: 24px;
                color: @topicDeepRColor;
            }
            .goodsBargin{
                padding: 0px 20px;
                border-radius: 20px;
                line-height: 32px;
                color: #fff;
                background-color: @topicDeepRColor;
            }
        }
    }
    .goodsDescrible{
        align-items: flex-start;
        margin-top: 16px;
        p{
            display: -webkit-box;
            width: 465px;
            height: 95px;
            margin: 0px;
            font-size: 18px;
            text-overflow: ellipsis;
            overflow: hidden;
            -webkit-line-clamp: 4;
            -webkit-box-orient: vertical;
        }
    }
    .goodsTransaction{
        &>p{
            font-size: 18px;
        }
    }
    .goodsAmount{
        display: flex;
        align-items: center;
        .numHandle{
            @handleSize:16px;
            @handleColor:#666;
            display: inline-block;
            width: @handleSize;
            height: @handleSize;
            border: 1px solid @handleColor;
            text-align: center;
            line-height: @handleSize;
            color: @handleColor;
            cursor: pointer;
            &:hover{
                @hoverColor:#000;
                border-color: @hoverColor;
                color: @hoverColor;
            }
        }
        input{
            margin: 0px 5px;
            text-align: center;
        }
        .remanentNum{
            margin-left: 20px;
            color: rgb(151,151,151);
        }
    }
    .goodsContact{
        img{
            @iconSize:30px;
            width: @iconSize;
            height: @iconSize;
            margin-right: 15px;
            cursor: pointer;
        }
    }
    .handleButton{
        justify-content: space-between;
        button{
            width: 48%;
            border: 2px solid @topicDeepRColor;
            padding:6px;
            font-size: 20px;
            background-color:@topicDeepRColor;
            color: #fff;
            outline: none;
            cursor: pointer;
            &:hover{
                color: @topicDeepRColor;
                background-color: @topicShallowRColor;
            }
        }
    }
}

.tipContainer{
    position: fixed;
    top: 0px;
    left: 0px;
    width: 100%;
    height: 100%;
    background-color: rgba(151,151,151,.5);
    .tipFixed{
        position: absolute;
        top: 45%;
        left: 50%;
        width: 600px;
        height: 300px;
        transform: translateX(-50%) translateY(-50%) scale(0.7);
        background: url('../../assets/img/detail/tipTop.png');
        p{
            position: absolute;
            left: 50%;
            top: 50%;
            font-size: 25px;
            transform: translateX(-50%);
        }
        img{
            position: absolute;
            left: 50%;
            top: 85%;
            transform: translateX(-50%) scale(1.2);
            cursor: pointer;
        }
    }
}
</style>
