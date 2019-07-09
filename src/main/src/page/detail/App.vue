<template>
    <div id="app">
        <Header :webPage="webPage" :identity="identity"></Header>
        <PageInfo
            :pageSource="pageSource"
        ></PageInfo>
        <MainContent
            :detailGoods="detailGoods">
        </MainContent>
        <hr>
        <OtherGoods
            :totalGoods="totalGoods"
            :otherGoods="otherGoods"
        ></OtherGoods>
        <Footer></Footer>
    </div>
</template>

<script>
import Header from '../../components/construct/header.vue'
import Footer from '../../components/construct/footer.vue'
import PageInfo from '../../components/detail/pageInfo.vue'
import MainContent from '../../components/detail/mainContent.vue'
import OtherGoods from '../../components/detail/otherGoods.vue'
import axios from 'axios'

export default {
    name:'app',
    components:{
        Header,
        Footer,
        PageInfo,
        MainContent,
        OtherGoods
    },
    data(){
        return{
            webPage:"",
            identity:"buyer",
            pageSource:["分类页","商品详情"],
            detailGoods:{
                goodsName:'插电源室内喷雾补湿仪',
                goodsDescrible:'',
                goodsPrice:'32',
                goodsBargin:true, // 是否可议价
                goodsAmount:3, // 商品库存
                goodsLocation:'广金南苑13#905',
                isWechat:false,
                Wechat:'123-456-789',
                isQQ:true,
                QQ:'123456789',
                goodsPicture:[require('../../assets/img/detail/shop1.png'),require('../../assets/img/detail/shop1.png'),require('../../assets/img/detail/shop2.png'),require('../../assets/img/detail/shop3.png')]
            },
            totalGoods:8,
            otherGoods:[
                {goodsName:'插电源室内喷雾补湿仪',goodsPicture:require('../../assets/img/detail/shop1.png'),goodsPrice:12},
                {goodsName:'原木简约充电台灯',goodsPicture:require('../../assets/img/detail/shop2.png'),goodsPrice:32},
                {goodsName:'可调档充电随身小风扇',goodsPicture:require('../../assets/img/detail/shop3.png'),goodsPrice:54},
                {goodsName:'原木简约充电台灯',goodsPicture:require('../../assets/img/detail/shop2.png'),goodsPrice:32},
                {goodsName:'可调档充电随身小风扇',goodsPicture:require('../../assets/img/detail/shop3.png'),goodsPrice:54},
                {goodsName:'插电源室内喷雾补湿仪',goodsPicture:require('../../assets/img/detail/shop1.png'),goodsPrice:12},
                {goodsName:'原木简约充电台灯',goodsPicture:require('../../assets/img/detail/shop2.png'),goodsPrice:32},
                {goodsName:'可调档充电随身小风扇',goodsPicture:require('../../assets/img/detail/shop3.png'),goodsPrice:54},
            ]
        }
    },
    mounted(){

    }
}
</script>

<style lang="less">

hr{
    width: 1000px;
}

</style>

