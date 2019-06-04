let vm = new Vue({
    el: '#app',
    data: {
        others: false,
        arrayBy: '综合',
        secIndex: 0,
        thiIndex: 0,
        synthesis: [
            { parentId: 1, parentName: "书籍", parentPicture: "book.png" },
            {
                parentId: 2,
                parentName: "文具",
                parentPicture: "stationery.png"
            },
            { parentId: 3, parentName: "日用", parentPicture: "daily.png" },
            { parentId: 4, parentName: "美妆", parentPicture: "cosmetics.png" },
            { parentId: 5, parentName: "食品", parentPicture: "food.png" },
            { parentId: 6, parentName: "电器", parentPicture: "electrical.png" },
            { parentId: 7, parentName: "其他", parentPicture: "others.png" }
        ],
        composite: [
            { subClassId: 0, subClassName: "英语四六级", parentClass: 0 },
            { subClassId: 0, subClassName: "英语四六级", parentClass: 0 },
            { subClassId: 0, subClassName: "证从", parentClass: 0 },
            { subClassId: 0, subClassName: "证从", parentClass: 0 },
            { subClassId: 0, subClassName: "证从", parentClass: 0 },
            { subClassId: 0, subClassName: "证从", parentClass: 0 },
            { subClassId: 0, subClassName: "证从", parentClass: 0 },
            { subClassId: 0, subClassName: "证从", parentClass: 0 },
        ],
        goodsExample: [{
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
        }, ]
    },
    methods: {
        changeChoose: function(type) {
            if (type == 'classify')
                this.others = false;
            else
                this.others = true;
        },
        changeArrayBy: function(type) {
            this.arrayBy = type;
        },
        // 显示三级导航
        childList: function(index) {
            this.secIndex = index;
            axios.post('/url', {})
                .then((res) => {
                    this.composite = res.composite
                })
                .catch((err) => {

                })

        },
        // 根据标签搜素相应的内容
        titleSearch: function(index) {
            this.thiIndex = index;
            axios.post('/url', {})
                .then((res) => {
                    this.goodsExample = res.goodsExample;
                })
        }
    },
    mounted() {
        axios.post('/ants/dataRendering/deputyPage', {

        }).then((res) => {
            this.synthesis = res.synthesis;
            this.composite = res.composite;
            this.allClassification = res.allClassification;
            this.goodsExample = res.goodsExample;
        })
    }
})