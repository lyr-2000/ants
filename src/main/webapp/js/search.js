let vm = new Vue({
    el: '#app',
    data: {
        others: false,
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

    }
})