<template>
    <div class="textInfo">
        <h1 class="goodsName">{{singleGoodsMessage.goodsName}}</h1>
        <div class="goodsPrice">
            <span class="goodsLabel">价格</span>
            <p>
                <span>{{singleGoodsMessage.goodsPrice}}元</span>
                <span class="goodsBargin">{{singleGoodsMessage.goodsBargin?'可议价':'不可议价'}}</span>
            </p>
        </div>
        <div class="goodsDescrible">
            <span class="goodsLabel">简介</span>
            <p>{{singleGoodsMessage.goodsDescrible}}</p>
        </div>
        <div class="goodsTransaction">
            <span class="goodsLabel">配送</span>
            <p>{{singleGoodsMessage.goodsWay}}</p>
        </div>
        <div class="goodsAmount">
            <span class="goodsLabel">数目</span>
            <p>
                <strong @click="buyNum>1?buyNum--:''" class="numHandle">-</strong>
                <input type="text" size="1" v-model="buyNum">
                <strong @click="buyNum<singleGoodsMessage.repertory?buyNum++:''" class="numHandle">+</strong>
                <span class="remanentNum">(库存{{singleGoodsMessage.repertory}}件)</span>
            </p>
        </div>
        <div class="goodsContact">
            <span class="goodsLabel">联系</span>
            <p>
                <router-link to="/chat">
                    <img src="../../assets/img/detail/chat.png" @click="enterChat">
                </router-link>
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
import { mapGetters, mapActions } from "vuex";

export default {
    data(){
        return{
            buyNum:1,
            tipContent:'啊哦~卖家隐藏了信息',
            tipShow:false
        }
    },
    computed: mapGetters({
        singleGoodsMessage: "getSingleGoodsMessage"
    }),
    methods:{
        // 进入聊天空间
        enterChat(){
            console.log('进入聊天空间');
        },
        // 获取联系方式
        getInfo(contact){
            this.tipShow=true;
            if(contact==='wechat'){
                if(this.singleGoodsMessage.wechatHidden){
                    this.tipContent=`微信号：${this.singleGoodsMessage.userWechat}`;
                }else{
                    this.tipContent='啊哦~卖家隐藏了信息';
                }
            }else if(contact==='qq'){
                if(this.singleGoodsMessage.qqHidden){
                    this.tipContent=`QQ号：${this.singleGoodsMessage.userQQ}`;
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
            }else if(newVal>this.singleGoodsMessage.repertory){
                this.buyNum=this.singleGoodsMessage.repertory;
            }
        }
    }
}
</script>

<style lang="less">
@import "../../assets/less/define.less";

@textMargin:16px;

.textInfo{
    width: 720px;
    color:@deepFontColor;
    .goodsName{
        margin-top: 0px;
        font-size: 30px;
    }
    &>div{
        display: flex;
        align-items: center;
        .goodsLabel{
            margin: 0px 50px 0px 40px;
            font-size: 20px;
            color:@shallowFontColor;
        }
    }
    .goodsPrice{
        background-color: @borderColor;
        p{
            display: flex;
            justify-content: space-between;
            width: 560px;
            &>span:first-child{
                font-size: 30px;
                color: @topicDeepRColor;
            }
            .goodsBargin{
                padding: 8px 20px;
                border-radius: 20px;
                font-size: 18px;
                color: #fff;
                background-color: @topicDeepRColor;
            }
        }
    }
    .goodsDescrible{
        align-items: flex-start;
        margin: @textMargin 0px;
        p{
            display: -webkit-box;
            width: 580px;
            height: 95px;
            margin: 0px;
            font-size: 20px;
            line-height: 24px;
            text-overflow: ellipsis;
            overflow: hidden;
            -webkit-line-clamp: 4;
            -webkit-box-orient: vertical;
        }
    }
    .goodsTransaction{
        margin-bottom: 28px;
        &>p{
            margin: 0px;
            font-size: 18px;
        }
    }
    .goodsAmount{
        display: flex;
        align-items: center;
        margin-bottom: 28px;
        p{
            margin: 0px;
        }
        .numHandle{
            @handleSize:16px;
            display: inline-block;
            width: @handleSize;
            height: @handleSize;
            border: 1px solid @shallowFontColor;
            text-align: center;
            font-weight: 100;
            font-size: 24px;
            line-height:13px;
            color: @deepFontColor;
            cursor: pointer;
            &:hover{
                border-color: @deepFontColor;
                color: @deepFontColor;
            }
        }
        input{
            position: relative;
            top: -3px;
            margin: 0px 8px;
            height: 18px;
            text-align: center;
        }
        .remanentNum{
            font-size: 18px;
            margin-left: 49px;
            color: @shallowFontColor;
        }
    }
    .goodsContact{
        margin-bottom: @textMargin;
        img{
            @iconSize:39px;
            width: @iconSize;
            height: @iconSize;
            margin-right: 15px;
            cursor: pointer;
        }
        p{
            margin: 0px;
        }
    }
    .handleButton{
        justify-content: space-between;
        button{
            width: 348px;
            border: 2px solid @topicDeepRColor;
            padding:13px;
            font-size: 30px;
            color: @topicDeepRColor;
            background-color: @topicShallowRColor;
            outline: none;
            cursor: pointer;
            &:hover{
                background-color:@topicDeepRColor;
                color: #fff;
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
