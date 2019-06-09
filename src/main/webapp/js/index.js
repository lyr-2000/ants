let vm = new Vue({
    el: "#app",
    data: {
        announcement: {
            annTitle: '蚂蚁置物上线:一个专注于校园二手租赁，方便学生教师闲置物品出售购入平台',
            annTime: '2019-5-10',
            annId: '',
        },
        projectName: '蚂蚁置物',
        searchWord: '',
        showDetialedClassify: false,
        moveFlag: {
            'perfect': false,
            'hot': false,
            'new': false
        },
        wholeClassify: [{
            parentPicture: 'img/icon/book.png',
            parnentName: '书籍'
        }, {
            parentPicture: 'img/icon/stationery.png',
            parnentName: '文具'
        }, {
            parentPicture: 'img/icon/daily.png',
            parnentName: '日用'
        }, {
            parentPicture: 'img/icon/cosmetics.png',
            parnentName: '美妆'
        }, {
            parentPicture: 'img/icon/food.png',
            parnentName: '食品'
        }, {
            parentPicture: 'img/icon/electrical.png',
            parnentName: '电器'
        }],
        detailedClassify: [
            ["英语四六级", "证从", "银从", "会计", "教师资格证", "计算机二级", "其他"],  
            ["本子", "笔", "便签", "文件夹", "计算器", "办公用品", "包装用品", "其他"],  
            ["收纳", "服饰", "鞋表", "箱包", "洗护用品", "非处方药物", "餐桌用品", "其他"],
            ["化妆水乳", "防晒隔离", "粉底定妆", "眼妆眉笔", "唇膏口红", "化妆工具", "美甲用具", "其他"],
            ["速食品", "饮料", "调味料", "五谷", "甜品", "膨化食物", "冲泡花茶", "其他"],
            ["U盘", "台灯", "数据线", "充电宝", "鼠标键盘", "洗衣机", "烘干机", "其他", ]
        ],
        perfectGoods: [{
            goodsPicture: 'img/icon/food.png',
            goodsName: '商品名',
            goodsPrice: '价格'
        }, {
            goodsPicture: 'img/icon/food.png',
            goodsName: '商品名',
            goodsPrice: '价格'
        }, {
            goodsPicture: 'img/icon/food.png',
            goodsName: '商品名',
            goodsPrice: '价格'
        }, {
            goodsPicture: 'img/icon/food.png',
            goodsName: '商品名',
            goodsPrice: '价格'
        }, {
            goodsPicture: 'img/icon/food.png',
            goodsName: '商品名',
            goodsPrice: '价格'
        }, {
            goodsPicture: 'img/icon/food.png',
            goodsName: '商品名',
            goodsPrice: '价格'
        }, {
            goodsPicture: 'img/icon/food.png',
            goodsName: '商品名',
            goodsPrice: '价格'
        }],
        showHot: true,
        hotGoods: [{
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
        newGoods: [{
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
    },
    methods: {
        //进入页面时发起请求
        initRequest() {
            axios.post('/http://localhost:9090/ants/dataRendering/homePage', "")
                .then(res => {
                    console.log(res);
                    this.wholeClassify = res.parentClassification;
                    this.perfectGoods = res.guessLike;
                    this.hotGoods = res.hottest;
                    this.newGoods = res.latest;

                })
        },
        concreteRequest() {
            axios.post('http://localhost:9090/ants/class/allClassify', '')
                .then(res => {
                    console.log(res);
                    this.detailedClassify = res.childClassification;
                })
        },
        turnLeft: function(type) {
            if (type === 'perfect') {
                this.moveFlag.perfect = false;
            } else if (type === 'special') {
                if (this.showHot) {
                    this.moveFlag.hot = false;
                } else {
                    this.moveFlag.new = false;
                }
            }
        },
        turnRight: function(type) {
            if (type === 'perfect') {
                this.moveFlag.perfect = true;
            } else if (type === 'special') {
                if (this.showHot) {
                    this.moveFlag.hot = true;
                } else {
                    this.moveFlag.new = true;
                }
            }
        },
        changeShow: function(currentType) {
            if (currentType === 'hot') {
                this.showHot = true;
            } else {
                this.showHot = false;
            }
        },
        // 搜索
        search: function(val) {

        },
        showDetailed: function() {
            // 当没有该数据时请求该数据
            if (this.detailedClassify == [])
                this.concreteRequest();
            this.showDetialedClassify = !this.showDetialedClassify;
        }
    },
    created: function() {
        // this.initRequest();
    }
})