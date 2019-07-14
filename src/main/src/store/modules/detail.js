import axios from 'axios';

const state = {
    pageSource: ["分类页", "商品详情"],
    detailGoods: {
        goodsName: '插电源室内喷雾补湿仪',
        goodsDescrible: '这个补湿仪我才用了一个月，实体入的，真的是非常补湿，觉得超级好用，长得又好看又耐电，每次只加够水就可以保持空气补湿了，可是最近没钱只能忍痛割爱，走过路过千万不要错过，不要徘徊不要徘徊，徘徊就是白来',
        goodsPrice: '32',
        goodsBargin: true, // 是否可议价
        goodsAmount: 3, // 商品库存
        goodsLocation: '广金南苑13#905',
        transactionMode: '买家自取', // 买家取货方式
        isWechat: false,
        Wechat: '123-456-789',
        isQQ: true,
        QQ: '123456789',
        goodsPicture: [require('../../assets/img/detail/shop1.png'), require('../../assets/img/detail/shop1.png'), require('../../assets/img/detail/shop2.png'), require('../../assets/img/detail/shop3.png')]
    },
    totalGoods: 8,
    otherGoods: [
        { goodsName: '插电源室内喷雾补湿仪', goodsPicture: require('../../assets/img/detail/shop1.png'), goodsPrice: 12 },
        { goodsName: '原木简约充电台灯', goodsPicture: require('../../assets/img/detail/shop2.png'), goodsPrice: 32 },
        { goodsName: '可调档充电随身小风扇', goodsPicture: require('../../assets/img/detail/shop3.png'), goodsPrice: 54 },
        { goodsName: '原木简约充电台灯', goodsPicture: require('../../assets/img/detail/shop2.png'), goodsPrice: 32 },
        { goodsName: '可调档充电随身小风扇', goodsPicture: require('../../assets/img/detail/shop3.png'), goodsPrice: 54 },
        { goodsName: '插电源室内喷雾补湿仪', goodsPicture: require('../../assets/img/detail/shop1.png'), goodsPrice: 12 },
        { goodsName: '原木简约充电台灯', goodsPicture: require('../../assets/img/detail/shop2.png'), goodsPrice: 32 },
        { goodsName: '可调档充电随身小风扇', goodsPicture: require('../../assets/img/detail/shop3.png'), goodsPrice: 54 },
    ]
}

const getters = {
    getPageSource(state) {
        return state.pageSource;
    },
    getDetailGoods(state) {
        return state.detailGoods;
    },
    getTotalGoods(state) {
        return state.totalGoods;
    },
    getOtherGoods(state) {
        return state.otherGoods;
    },
}

const mutations = {

}

const actions = {

}
export default { state, getters, mutations, actions }