<template>
    <div class="publishDetail">
        <li>
            <span class="goodsLabel">商品名字</span>
            <input type="text" v-model="goodsName" :placeholder="`九阳榨汁机/请输入${detailType}商品名字`">
        </li>
        <li v-show="pIndex!=2">
            <span class="goodsLabel">商品价格</span>
            <input type="text" v-model="goodsPrice" :placeholder="priceDescribe">
        </li>
        <li class="goodsBargin">
            <span class="goodsLabel">可否议价</span>
            <span class="label"  @click="goodsBargin=0">
                <img :src="goodsBargin==0?require('../../../assets/img/user/checkBtnBlue.png'):require('../../../assets/img/user/checkBtnBlack.png')">
                可以
            </span>
            <span @click="goodsBargin=1" class="label">
                <img :src="goodsBargin==1?require('../../../assets/img/user/checkBtnBlue.png'):require('../../../assets/img/user/checkBtnBlack.png')">
                不可以（这一行选项可以删掉）
            </span>
        </li>
        <li class="goodsWay">
            <span class="goodsLabel">取货方式</span>
            <span @click="goodsWay=0" class="label">
                <img :src="goodsWay==0?require('../../../assets/img/user/checkBtnBlue.png'):require('../../../assets/img/user/checkBtnBlack.png')">
                卖家送货上门
            </span>
            <span @click="goodsWay=1" class="label">
                <img :src="goodsWay==1?require('../../../assets/img/user/checkBtnBlue.png'):require('../../../assets/img/user/checkBtnBlack.png')">
                买家上门取货
            </span>
            <span @click="goodsWay=2" class="label">
                <img :src="goodsWay==2?require('../../../assets/img/user/checkBtnBlue.png'):require('../../../assets/img/user/checkBtnBlack.png')">
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
            <textarea v-model="goodsDescribe" placeholder="请输入不超过XX字数的商品介绍"></textarea>
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
            <button class="publishBtn">确认发布</button>
        </li>
    </div>
</template>

<script>
export default {
    data(){
        return{
            goodsName:'',
            goodsPrice:'',
            goodsBargin:'',
            goodsWay:'',
            parentName:'选择大分类',
            childName:'选择小分类',
            goodsDescribe:'',
            detailType:'',
            priceDescribe:'30/请输入合理的人民币价格'
        }
    },
    props:["pIndex"],
    watch:{
        pIndex:function(newVal){
            if(newVal==0){
                this.detailType='';
                this.priceDescribe='30/请输入合理的人民币价格'
            }else if(newVal==1){
                this.detailType='租赁';
                this.priceDescribe='30/请输入合理的人民币价格'
            }else if(newVal==2){
                this.detailType='赠送';
            }else if(newVal==3){
                this.detailType='寻求';
                this.priceDescribe='请输入大概的价格'
            }
        }
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
