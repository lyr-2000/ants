const namespaced = true;
const state = {
    announceList: [{
        title: "关于蚂蚁置物首页上线的公告",
        time: "2019-09-21"
    }, {
        title: "关于蚂蚁置物闲置物品什么什么上线的公告",
        time: "2019-09-12"
    }, {
        title: "关于蚂蚁置物用户买家卖家的公告",
        time: "2019-09-08"
    }, {
        title: "关于蚂蚁置物一些琐碎的小事虽然可以不说但是还是说一下吧的公告",
        time: "2019-09-04"
    }, {
        title: "关于蚂蚁置物用户登录的协议麻烦你们看一下，不看的话错误损失要自己承担的哦的公告",
        time: "2019-09-01"
    }, {
        title: "关于蚂蚁置物卖家怎么那么好免费送了那么多东西的公告",
        time: "2019-08-28"
    }, {
        title: "关于蚂蚁置物免费送的东西可能存在风险要做好谨慎判断的公告",
        time: "2019-08-25"
    }, {
        title: "关于蚂蚁置物价格太便宜的东西可能也存在风险要做好谨慎判断的公告",
        time: "2019-08-23"
    }, {
        title: "关于蚂蚁置物卖家把东西卖那么贵简直没有天理啦的公告",
        time: "2019-08-22"
    }, {
        title: "关于蚂蚁置物这真的是一个纯洁美丽的好网站的公告",
        time: "2019-08-21"
    }],
    // 总页数
    pageNum: 3
}

const getters = {
    getAnnounceList(state) {
        return state.announceList
    },
    getPageNum(state) {
        return state.pageNum
    }
}

const mutations = {

}

const actions = {

}
export default { state, getters, mutations, actions, namespaced }