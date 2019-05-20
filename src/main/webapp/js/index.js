let vm = new Vue({
    el: "#app",
    data: {
        projectName: '蚂蚁置物',
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
        }, ],
        newGoods: [{
            src: '',
            name: '',
            price: '',
            uploadTime: ''
        }, ]
    },
    methods: {
        turnLeft: function(type) {
            if (type === 'perfect') {

            } else if (type === 'special') {

            }
        },
        turnRight: function() {
            if (type === 'perfect') {

            } else if (type === 'special') {

            }
        }
    }
})