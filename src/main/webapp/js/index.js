let vm = new Vue({
    el: "#app",
    data: {
        announceContent: '蚂蚁置物上线:一个专注于校园二手租赁，方便学生教师闲置物品出售购入平台',
        announceTime: '2019-5-10',
        projectName: '蚂蚁置物',
        searchWord: '',
        showDetialedClassify: false,
        moveFlag: {
            'perfect': false,
            'hot': false,
            'new': false
        },
        wholeClassify: [{
            src: 'img/index/shuji.png',
            name: '书籍'
        }, {
            src: 'img/index/wenju.png',
            name: '文具'
        }, {
            src: 'img/index/riyong.png',
            name: '日用'
        }, {
            src: 'img/index/huazhuang.png',
            name: '美妆'
        }, {
            src: 'img/index/lingshi.png',
            name: '食品'
        }, {
            src: 'img/index/dianqi.png',
            name: '电器'
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
            img: 'img/index/lingshi.png',
            name: '商品名',
            price: '价格'
        }, {
            img: 'img/index/lingshi.png',
            name: '商品名',
            price: '价格'
        }, {
            img: 'img/index/lingshi.png',
            name: '商品名',
            price: '价格'
        }, {
            img: 'img/index/lingshi.png',
            name: '商品名',
            price: '价格'
        }, {
            img: 'img/index/lingshi.png',
            name: '商品名',
            price: '价格'
        }, {
            img: 'img/index/lingshi.png',
            name: '商品名',
            price: '价格'
        }, {
            img: 'img/index/lingshi.png',
            name: '商品名',
            price: '价格'
        }],
        showHot: true,
        hotGoods: [{
            src: '',
            name: '',
            price: '',
            starNum: ''
        }, {
            src: '',
            name: '',
            price: '',
            starNum: ''
        }, {
            src: '',
            name: '',
            price: '',
            starNum: ''
        }, {
            src: '',
            name: '',
            price: '',
            starNum: ''
        }, {
            src: '',
            name: '',
            price: '',
            starNum: ''
        }, {
            src: '',
            name: '',
            price: '',
            starNum: ''
        }, ],
        newGoods: [{
            src: '',
            name: '',
            price: '',
            uploadTime: ''
        }, {
            src: '',
            name: '',
            price: '',
            uploadTime: ''
        }, {
            src: '',
            name: '',
            price: '',
            uploadTime: ''
        }, {
            src: '',
            name: '',
            price: '',
            uploadTime: ''
        }, {
            src: '',
            name: '',
            price: '',
            uploadTime: ''
        }, {
            src: '',
            name: '',
            price: '',
            uploadTime: ''
        }, ]
    },
    methods: {
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
            this.showDetialedClassify = !this.showDetialedClassify;
        }
    }
})