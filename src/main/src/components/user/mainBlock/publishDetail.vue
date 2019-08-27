<template>
    <div class="publishDetail">
        <li>
            <span class="goodsLabel">商品名字</span>
            <input type="text" v-model="publishData.goodsName" :placeholder="`九阳榨汁机/请输入${detailType}商品名字`">
        </li>
        <li v-show="pIndex!=2">
            <span class="goodsLabel">商品价格</span>
            <input type="text" v-model="publishData.goodsPrice" :placeholder="priceDescribe">
        </li>
        <li class="goodsBargin">
            <span class="goodsLabel">可否议价</span>
            <span class="label"  @click="publishData.goodsBargin=0">
                <img :src="publishData.goodsBargin==0?require('../../../assets/img/user/checkBtnBlue.png'):require('../../../assets/img/user/checkBtnBlack.png')">
                可以
            </span>
            <span @click="publishData.goodsBargin=1" class="label">
                <img :src="publishData.goodsBargin==1?require('../../../assets/img/user/checkBtnBlue.png'):require('../../../assets/img/user/checkBtnBlack.png')">
                不可以（这一行选项可以删掉）
            </span>
        </li>
        <li class="goodsWay">
            <span class="goodsLabel">取货方式</span>
            <span @click="publishData.goodsWay=0" class="label">
                <img :src="publishData.goodsWay==0?require('../../../assets/img/user/checkBtnBlue.png'):require('../../../assets/img/user/checkBtnBlack.png')">
                卖家送货上门
            </span>
            <span @click="publishData.goodsWay=1" class="label">
                <img :src="publishData.goodsWay==1?require('../../../assets/img/user/checkBtnBlue.png'):require('../../../assets/img/user/checkBtnBlack.png')">
                买家上门取货
            </span>
            <span @click="publishData.goodsWay=2" class="label">
                <img :src="publishData.goodsWay==2?require('../../../assets/img/user/checkBtnBlue.png'):require('../../../assets/img/user/checkBtnBlack.png')">
                有待商议
            </span>
        </li>
        <li class="goodsClassify">
            <span class="goodsLabel">商品分类</span>
            <select v-model="parentName">
                <option>选择大分类</option>
            </select>
            <select v-model="childName">
                <option>选择小分类</option>
            </select>
        </li>
        <li class="goodsDescribe">
            <span class="goodsLabel">商品简介</span>
            <textarea v-model="publishData.goodsDescribe" placeholder="请输入不超过XX字数的商品介绍"></textarea>
        </li>
        <li class="upload">
            <span class="goodsLabel">上传照片</span>
            <img src="../../../assets/img/user/upload.png">
        </li>
        <li class="upload">
            <span class="goodsLabel">上传视频</span>
            <img src="../../../assets/img/user/upload.png">
        </li>
        <li>
            <span class="goodsLabel"></span>
            <button class="publishBtn" @click="releaseGoods(publishType,publishData)">确认发布</button>
        </li>
    </div>
</template>

<script>
import {mapActions} from 'vuex'

export default {
    data(){
        return{
            publishData:{
                goodsName:'',
                goodsDescribe:'',
                goodsPrice:'',
                goodsBargin:'',
                goodsWay:'',
                goodsPicture:'',
                goodsVideo:'',
                goodsClass:''
            },
            parentName:'选择大分类',
            childName:'选择小分类',
            detailType:'',
            priceDescribe:'30/请输入合理的人民币价格',
            publishType:''
        }
    },
    props:["pIndex"],
    watch:{
        pIndex:function(newVal){
            if(newVal==0){
                this.detailType='';
                this.priceDescribe='30/请输入合理的人民币价格'
                this.publishType='Idle'
            }else if(newVal==1){
                this.detailType='租赁';
                this.priceDescribe='30/请输入合理的人民币价格'
                this.publishType='Lease'
            }else if(newVal==2){
                this.detailType='赠送';
                this.publishType='Give'
            }else if(newVal==3){
                this.detailType='寻求';
                this.priceDescribe='请输入大概的价格'
                this.publishType='Seek'
            }
        }
    },
    methods:{
        ...mapActions("user",["releaseGoods"])
    }
}
</script>

<style lang="less" scoped>
@import '../../../assets/less/define.less';
.publishDetail{
            display: flex;
            flex-direction: column;
            margin: 49px 0px 0px 50px;
            li{
                .goodsLabel{
                    display: inline-block;
                    width: 150px;
                }
                .label{
                    cursor: pointer;
                    img{
                        transform:translateY(4px);
                    }
                }
                input{
                    width: 400px;
                    height: 60px;
                    margin-bottom: 37px;
                    border:none;
                    text-indent: 20px;
                    font-size: 18px;
                    letter-spacing: 2px;
                    outline:none;
                    background-color: @borderColor;
                }
                img{
                    cursor: pointer;
                }
                textarea{
                    width: 400px;
                    height: 89px;
                    border:none;
                    padding-top: 11px;
                    font-size: 18px;
                    text-indent: 20px;
                    letter-spacing: 2px;
                    outline:none;
                    background-color: @borderColor;
                    resize: none;
                }
                .publishBtn{
                    border:none;
                    outline:none;
                    margin-top: 60px;
                    padding: 11px 60px;
                    font-size: 18px;
                    color: #fff;
                    background-color: @topicDeepBColor;
                    cursor: pointer;
                }
            }
            .goodsBargin{
                margin-bottom:48px;
                img{
                    margin-right: 15px;
                }
                .label{
                    margin-right: 48px;
                }
                
            }
            .goodsWay{
                *{
                    margin-right: 15px;
                }
                .goodsLabel{
                    margin-right: 0px;
                }
            }
            .goodsClassify{
                margin: 37px 0px 26px 0px;
                select{
                        width: 148px;
                        height: 40px;
                        padding: 0px 14px;
                        margin-right: 20px;
                        font-size: 18px;
                        color: @deepFontColor;
                        outline: none;
                        cursor: pointer;
                }
            }
            .goodsDescribe{
                display: flex;
                align-items: flex-start;
                margin-bottom: 5px;
            }
            .upload{
                display: flex;
                align-items: center;
                margin-top: 20px;
                img{
                    width: 70px;
                    height: 70px;
                }
            }
        }
</style>
