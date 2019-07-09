<template>
  <div id="app">
    <Header :webPage="webPage" :identity="identity"></Header>
    <TopBanner @concrete-request="concreteRequest" :projectName="projectName" 
        :parentClassification="parentClassification" :childClassification="childClassification"></TopBanner>
    <MainContent :guessLike="guessLike" 
        :hottest="hottest" :latest="latest"></MainContent>
    <Footer></Footer>
  </div>
</template>

<script>
import Header from '../../components/construct/header.vue'
import Footer from '../../components/construct/footer.vue'
import TopBanner from '../../components/index/topBanner.vue'
import MainContent from '../../components/index/mainContent.vue'

export default {
  name: 'app',
  components: {
    Header,
    Footer,
    TopBanner,
    MainContent
  },
  data(){
    return{
        webPage:'index',
        identity:'buyer',
        projectName: '蚂蚁置物',
        parentClassification: [{
            parentPicture:require( '../../img/icon/book.png'),
            parentName: '书籍'
        }, {
            parentPicture: require('../../img/icon/stationery.png'),
            parentName: '文具'
        }, {
            parentPicture: require('../../img/icon/daily.png'),
            parentName: '日用'
        }, {
            parentPicture: require('../../img/icon/cosmetics.png'),
            parentName: '美妆'
        }, {
            parentPicture: require('../../img/icon/food.png'),
            parentName: '食品'
        }, {
            parentPicture: require('../../img/icon/electrical.png'),
            parentName: '电器'
        }],
        childClassification: [
            ["英语四六级", "证从", "银从", "会计", "教师资格证", "计算机二级", "其他"],  
            ["本子", "笔", "便签", "文件夹", "计算器", "办公用品", "包装用品", "其他"],  
            ["收纳", "服饰", "鞋表", "箱包", "洗护用品", "非处方药物", "餐桌用品", "其他"],
            ["化妆水乳", "防晒隔离", "粉底定妆", "眼妆眉笔", "唇膏口红", "化妆工具", "美甲用具", "其他"],
            ["速食品", "饮料", "调味料", "五谷", "甜品", "膨化食物", "冲泡花茶", "其他"],
            ["U盘", "台灯", "数据线", "充电宝", "鼠标键盘", "洗衣机", "烘干机", "其他", ]
        ],
        guessLike: [{
            goodsPicture: require('../../img/icon/food.png'),
            goodsName: '商品名',
            goodsPrice: '价格'
        }, {
            goodsPicture: require('../../img/icon/food.png'),
            goodsName: '商品名',
            goodsPrice: '价格'
        }, {
            goodsPicture: require('../../img/icon/food.png'),
            goodsName: '商品名',
            goodsPrice: '价格'
        }, {
            goodsPicture: require('../../img/icon/food.png'),
            goodsName: '商品名',
            goodsPrice: '价格'
        }, {
            goodsPicture: require('../../img/icon/food.png'),
            goodsName: '商品名',
            goodsPrice: '价格'
        }, {
            goodsPicture: require('../../img/icon/food.png'),
            goodsName: '商品名',
            goodsPrice: '价格'
        }, {
            goodsPicture: require('../../img/icon/food.png'),
            goodsName: '商品名',
            goodsPrice: '价格'
        }],
        hottest: [{
            goodsPicture: '',
            goodsName: '',
            goodsPrice: '',
            starNum: ''
        }, {
            goodsPicture: '',
            goodsName: '',
            goodsPrice: '',
            starNum: ''
        }, {
            goodsPicture: '',
            goodsName: '',
            goodsPrice: '',
            starNum: ''
        }, {
            goodsPicture: '',
            goodsName: '',
            goodsPrice: '',
            starNum: ''
        }, {
            goodsPicture: '',
            goodsName: '',
            goodsPrice: '',
            starNum: ''
        }, {
            goodsPicture: '',
            goodsName: '',
            goodsPrice: '',
            starNum: ''
        }, ],
        latest: [{
            goodsPicture: '',
            goodsName: '',
            goodsPrice: '',
            uploadTime: ''
        }, {
            goodsPicture: '',
            goodsName: '',
            goodsPrice: '',
            uploadTime: ''
        }, {
            goodsPicture: '',
            goodsName: '',
            goodsPrice: '',
            uploadTime: ''
        }, {
            goodsPicture: '',
            goodsName: '',
            goodsPrice: '',
            uploadTime: ''
        }, {
            goodsPicture: '',
            goodsName: '',
            goodsPrice: '',
            uploadTime: ''
        }, {
            goodsPicture: '',
            goodsName: '',
            goodsPrice: '',
            uploadTime: ''
        }, ]
    
    }
  },
  methods:{
    //进入页面时发起请求
        initRequest() {
            let config = {
                headers: {
                    token: `http-test`
                }
            }
            axios.get('/ants/dataRendering/homePage', {})
                .then(res => {
                    res = res.data;
                    console.log(res);
                    this.parentClassification = res.parentClassification;
                    this.guessLike = res.guessLike;
                    this.hottest = res.hottest;
                    this.latest = res.latest;

                })
        },
        concreteRequest() {
            axios.get('/ants/class/allClassify', {})
                .then(res => {
                    res = res.data;
                    console.log(res);
                    this.childClassification = res.childClassification;
                })
        }
  }
}
</script>

<style>
body{
    margin: 0px;
}
ul{
    margin: 0px;
    padding: 0px;
}
li{
    float: left;
    list-style: none;
}

a{
    text-decoration: none;
    color: inherit;
}

</style>
