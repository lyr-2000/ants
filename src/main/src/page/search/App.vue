<template>
  <div id="app">
    <Header></Header>
    <ClassifyContainer :secIndex="secIndex" :thiIndex="thiIndex"
        :childList="childList" :synthesis="synthesis"
        @title-search="titleSearch" @show-childList="showChildList"></ClassifyContainer>
    <MainContent :secIndex="secIndex" :thiIndex="thiIndex"
        :childList="childList" :synthesis="synthesis" 
        :currentPage="currentPage" :page="page"
        @turn="turn" @title-search="titleSearch"
        @change-array-by="changeArrayBy" @show-childList="showChildList"></MainContent>
    <Footer></Footer>
  </div>
</template>

<script>
import Header from '../../components/construct/header.vue'
import Footer from '../../components/construct/footer.vue'
import ClassifyContainer from '../../components/search/classifyContainer.vue'
import MainContent from '../../components/search/mainContent.vue'

export default {
  name: 'app',
  components: {
    Header,
    Footer,
    ClassifyContainer,
    MainContent
  },
  data(){
    return{
        type: 1,
        secIndex: 0,
        thiIndex: 0,
        synthesis: [
            { parentId: 1, parentName: "书籍", parentPicture: "/book.png" },
            {
                parentId: 2,
                parentName: "文具",
                parentPicture: "/stationery.png"
            },
            { parentId: 3, parentName: "日用", parentPicture: "daily.png" },
            { parentId: 4, parentName: "美妆", parentPicture: "/cosmetics.png" },
            { parentId: 5, parentName: "食品", parentPicture: "/food.png" },
            { parentId: 6, parentName: "电器", parentPicture: "/electrical.png" },
            { parentId: 7, parentName: "其他", parentPicture: "/others.png" }
        ],
        childList: [
            { subClassId: 0, subClassName: "英语四六级", parentClass: 0 },
            { subClassId: 0, subClassName: "英语四六级", parentClass: 0 },
            { subClassId: 0, subClassName: "证从", parentClass: 0 },
            { subClassId: 0, subClassName: "证从", parentClass: 0 },
            { subClassId: 0, subClassName: "证从", parentClass: 0 },
            { subClassId: 0, subClassName: "证从", parentClass: 0 },
            { subClassId: 0, subClassName: "证从", parentClass: 0 },
            { subClassId: 0, subClassName: "证从", parentClass: 0 },
        ],
        goodsList: [{
            goodsId: 1,
            goodsName: "商品名",
            goodsPicture: "test1.png",
            goodsPrice: 0,
            goodsBargin: 0,
            uploadTime: '2019-06-03'
        }, {
            goodsId: 1,
            goodsName: "商品名",
            goodsPicture: "test1.png",
            goodsPrice: 0,
            goodsBargin: 0,
            uploadTime: '2019-06-03'
        }, {
            goodsId: 1,
            goodsName: "商品名",
            goodsPicture: "test1.png",
            goodsPrice: 0,
            goodsBargin: 0,
            uploadTime: '2019-06-03'
        }, {
            goodsId: 1,
            goodsName: "商品名",
            goodsPicture: "test1.png",
            goodsPrice: 0,
            goodsBargin: 0,
            uploadTime: '2019-06-03'
        }, {
            goodsId: 1,
            goodsName: "商品名",
            goodsPicture: "test1.png",
            goodsPrice: 0,
            goodsBargin: 0,
            uploadTime: '2019-06-03'
        }, {
            goodsId: 1,
            goodsName: "商品名",
            goodsPicture: "test1.png",
            goodsPrice: 0,
            goodsBargin: 0,
            uploadTime: '2019-06-03'
        }, {
            goodsId: 1,
            goodsName: "商品名",
            goodsPicture: "test1.png",
            goodsPrice: 0,
            goodsBargin: 0,
            uploadTime: '2019-06-03'
        }, {
            goodsId: 1,
            goodsName: "商品名",
            goodsPicture: "test1.png",
            goodsPrice: 0,
            goodsBargin: 0,
            uploadTime: '2019-06-03'
        }, {
            goodsId: 1,
            goodsName: "商品名",
            goodsPicture: "test1.png",
            goodsPrice: 0,
            goodsBargin: 0,
            uploadTime: '2019-06-03'
        }, {
            goodsId: 1,
            goodsName: "商品名",
            goodsPicture: "test1.png",
            goodsPrice: 0,
            goodsBargin: 0,
            uploadTime: '2019-06-03'
        }, {
            goodsId: 1,
            goodsName: "商品名",
            goodsPicture: "test1.png",
            goodsPrice: 0,
            goodsBargin: 0,
            uploadTime: '2019-06-03'
        }, {
            goodsId: 1,
            goodsName: "商品名",
            goodsPicture: "test1.png",
            goodsPrice: 0,
            goodsBargin: 0,
            uploadTime: '2019-06-03'
        }, {
            goodsId: 1,
            goodsName: "商品名",
            goodsPicture: "test1.png",
            goodsPrice: 0,
            goodsBargin: 0,
            uploadTime: '2019-06-03'
        }, {
            goodsId: 1,
            goodsName: "商品名",
            goodsPicture: "test1.png",
            goodsPrice: 0,
            goodsBargin: 0,
            uploadTime: '2019-06-03'
        }, {
            goodsId: 1,
            goodsName: "商品名",
            goodsPicture: "test1.png",
            goodsPrice: 0,
            goodsBargin: 0,
            uploadTime: '2019-06-03'
        }, {
            goodsId: 1,
            goodsName: "商品名",
            goodsPicture: "test1.png",
            goodsPrice: 0,
            goodsBargin: 0,
            uploadTime: '2019-06-03'
        }, ],
        currentPage: 3,
        page: 4
    }
  },
  methods:{
      changeArrayBy: function(type) {
        this.type = type;
        axios.post('/ants/class/chooseGoodsByType', {
                parentId: this.secIndex,
                childId: this.thiIndex,
                type: this.type
            })
            .then(res => {
                res = res.data;
                this.goodsList = res.goodsList;
                this.page = res.page;
                this.currentPage = 1;
            })
    },
    //跳转页数
    turn: function(currentPage) {
        console.log(currentPage);
        axios.post('/ants/class/pageJump', {
            parentId: this.secIndex,
            childId: this.thiIndex,
            type: this.type,
            currentPage: this.currentPage
        }).then(res => {
            res = res.data;
            this.goodsList = res.goodsList;
        })
    },
    // 根据标签搜素相应的内容
    titleSearch: function(index) {
        this.thiIndex = index;
        axios.post('/ants/class/goodsByChild', {
            subClassId: index,
            subClassName: this.childList[index].subClassName,
            parentClass: this.secIndex
        }).then(res => {
            res = res.data;
            this.goodsList = res.goodsList;
            this.page = res.page;
            this.currentPage = 1;
        })
    },
    // 显示三级导航
    showChildList: function(index) {
        this.secIndex = index;
        if (index != 0) {
            axios.post('/ants/class/goodsByParent', this.synthesis[index])
                .then((res) => {
                    res = res.data;
                    this.childList = res.childList;
                    this.goodsList = res.goodsList;
                })
                .catch((err) => {

                })
        }
    },
  },
  mounted() {
        //页面加载渲染
        axios.get('/ants/dataRendering/deputyPage', {}).then((res) => {
            res = res.data;
            this.synthesis = res.synthesis;
            this.childList = res.childList;
            this.allClassification = res.allClassification;
            this.childList = res.childList;
            this.page = res.page;
        })
    }
}
</script>

<style lang="less" scoped>
[v-cloak] {
    display: none;
}
</style>

