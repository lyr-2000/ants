let vm = new Vue({
    el: "#app",
    data: {
        projectName: '蚂蚁置物',
        wholeClassify: [{
            src: 'img/shuji.png',
            name: '书籍'
        }, {
            src: 'img/wenju.png',
            name: '文具'
        }, {
            src: 'img/riyong.png',
            name: '日用'
        }, {
            src: 'img/huazhuang.png',
            name: '美妆'
        }, {
            src: 'img/lingshi.png',
            name: '食品'
        }, {
            src: 'img/dianqi.png',
            name: '电器'
        }],
        perfectGoods: [{
            img: 'img/lingshi.png',
            name: '商品名',
            price: '价格'
        }, {
            img: 'img/lingshi.png',
            name: '商品名',
            price: '价格'
        }, {
            img: 'img/lingshi.png',
            name: '商品名',
            price: '价格'
        }, {
            img: 'img/lingshi.png',
            name: '商品名',
            price: '价格'
        }]
    },
    methods: {
        turnLeft: function() {

        },
        turnRight: function() {

        }
    }
})