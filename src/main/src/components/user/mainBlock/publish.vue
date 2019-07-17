<template>
    <div class="publish">
        <p class="title">发布信息</p>
        <div class="publishContent">
            <ul class="publichIndex">
                <li @click="pIndex=0" :class="{'chooseIndex':pIndex==0}">发布闲置</li>
                <li @click="pIndex=1" :class="{'chooseIndex':pIndex==1}">发布寻求</li>
                <li @click="pIndex=2" :class="{'chooseIndex':pIndex==2}">发布租赁</li>
            </ul>
            <div class="publishDetail">
                <li>
                    <span class="goodsLabel">商品名字</span>
                    <input type="text" v-model="goodsName" placeholder="九阳榨汁机/请输入商品名字">
                </li>
                <li>
                    <span class="goodsLabel">商品价格</span>
                    <input type="text" v-model="goodsPrice" placeholder="30/请输入合理的人民币价格">
                </li>
                <li class="goodsBargin">
                    <span class="goodsLabel">可否议价</span>
                    <img @click="goodsBargin=0" :src="goodsBargin==0?require('../../../assets/img/user/checkBtnBlue.png'):require('../../../assets/img/user/checkBtnBlack.png')">
                    <span class="label">可以</span>
                    <img @click="goodsBargin=1" :src="goodsBargin==1?require('../../../assets/img/user/checkBtnBlue.png'):require('../../../assets/img/user/checkBtnBlack.png')">
                    <span class="label">不可以</span>
                </li>
                <li class="goodsWay">
                    <span class="goodsLabel">取货方式</span>
                    <img @click="goodsWay=0" :src="goodsWay==0?require('../../../assets/img/user/checkBtnBlue.png'):require('../../../assets/img/user/checkBtnBlack.png')">
                    <span class="label">卖家送货上门</span>
                    <img @click="goodsWay=1" :src="goodsWay==1?require('../../../assets/img/user/checkBtnBlue.png'):require('../../../assets/img/user/checkBtnBlack.png')">
                    <span class="label">买家上门取货</span>
                    <img @click="goodsWay=2" :src="goodsWay==2?require('../../../assets/img/user/checkBtnBlue.png'):require('../../../assets/img/user/checkBtnBlack.png')">
                    <span class="label">有待商议</span>
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
        </div>
    </div>
</template>

<script>
export default {
    data(){
        return{
            pIndex:0,
            goodsName:'',
            goodsPrice:'',
            goodsBargin:'',
            goodsWay:'',
            parentName:'选择大分类',
            childName:'选择小分类',
            goodsDescribe:''
        }
    }
}
</script>

<style lang="less">
@import '../../../assets/less/define.less';

.publish{
    height: 1000px;
    .title{
        padding: 43px 0px 40px 50px;
        margin: 0px;
        font-size:18px;
        color: @topicDeepBColor;
        box-shadow: 0px 4px 0px @borderColor;
    }
    .publishContent{
        display: flex;
        font-size: 18px;
        color: @deepFontColor;
        .publichIndex{
            display: flex;
            flex-direction: column;
            height: 893px;
            border-right: 4px solid @borderColor;
            li{
                padding: 20px 62px;
                border-bottom: 4px solid @borderColor;
            }
            .chooseIndex{
                color: @topicDeepBColor;
                background-color: @borderColor;
                box-shadow: 10px 0px 0px @topicDeepBColor inset;
            }
        }
        .publishDetail{
            display: flex;
            flex-direction: column;
            margin: 49px 0px 0px 50px;
            li{
                .goodsLabel{
                    display: inline-block;
                    width: 150px;
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
    }
}
</style>
