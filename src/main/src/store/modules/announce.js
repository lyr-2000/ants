import axios from 'axios'
const namespaced = true;
const state = {
    announcementList: [{
        annId: 23,
        annTitle: "关于蚂蚁置物首页上线的公告",
        annTime: "2019-09-21"
    }, {
        annId: 13,
        annTitle: "关于蚂蚁置物闲置物品什么什么上线的公告",
        annTime: "2019-09-12"
    }, {
        annId: 24,
        annTitle: "关于蚂蚁置物用户买家卖家的公告",
        annTime: "2019-09-08"
    }, {
        annId: 53,
        annTitle: "关于蚂蚁置物一些琐碎的小事虽然可以不说但是还是说一下吧的公告",
        annTime: "2019-09-04"
    }, {
        annId: 21,
        annTitle: "关于蚂蚁置物用户登录的协议麻烦你们看一下，不看的话错误损失要自己承担的哦的公告",
        annTime: "2019-09-01"
    }, {
        annId: 33,
        annTitle: "关于蚂蚁置物卖家怎么那么好免费送了那么多东西的公告",
        annTime: "2019-08-28"
    }, {
        annId: 41,
        annTitle: "关于蚂蚁置物免费送的东西可能存在风险要做好谨慎判断的公告",
        annTime: "2019-08-25"
    }, {
        annId: 23,
        annTitle: "关于蚂蚁置物价格太便宜的东西可能也存在风险要做好谨慎判断的公告",
        annTime: "2019-08-23"
    }, {
        annId: 26,
        annTitle: "关于蚂蚁置物卖家把东西卖那么贵简直没有天理啦的公告",
        annTime: "2019-08-22"
    }, {
        annId: 8,
        annTitle: "关于蚂蚁置物这真的是一个纯洁美丽的好网站的公告",
        annTime: "2019-08-21"
    }],
    annDetail: {
        annId: 20170525, //公告id
        annTitle: "测试1", //公告标题
        annContent: [
            "根据中国某某某某法律《某》的通知，从2019年09月起，欢迎使用高校专用大学校园二手交易平台蚂蚁置物，我们将统一当地高校的二手闲置交易的系统。为此，对于某某某某某某某某某某某某某某某某某某某某某某某用户，我们将从2019年 12月起某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某：:",
            "　　一、请某某某某某某某某某某某某某某某某某按照某某某某某某某某某某的某某统一要求签订《某某某某某某某》，并于2019年9月31日前将某某某",
            "　　二、部分某某某由于系统升级原因更改了某某某某某账号格式，请客户在签订 《某某某某某某某某某某》的同时与某某某某某确认某某的账号，并于2019年 1月31日前以正式某某某某某某某某某某受到客户的《某某某某某某某某某某书》及新的某某某某某某某的帐号的，客户将无法使用某某某某某某某某某某某某某某某某某某某某。",
            "　　三、由于定期某某某某某后，系统将不再代为某某某某某，故某某某某某将统一采取某某某某某，客户签收的方式某某某某某某某某某某某某某某某。为了确认某某某某某，请某某某某某某某某某某某某前往所在区某某某某某某某某某某某某某某某某某某某某某某某某某，同时填报有关某某某某某"
        ],
        annTime: "2019-05-02 16:14:54.0"
    },
    // 总页数
    allPage: 3
}

const getters = {
    getAnnouncementList(state) {
        return state.announcementList
    },
    getAnnDetail(state) {
        return state.annDetail
    },
    getAllPage(state) {
        return state.allPage
    }
}

const mutations = {
    getAnnList(state, res) {
        state.announcementList = res.announcementList;
        state.allPage = res.allPage;
    },
    getAnnDetail(state, res) {
        state.annDetail = res.annDetail
    }
}

const actions = {
    // 获取公告列表
    getAnnList({ commit }, cpage) {
        axios.get(`/ants/announcement/getAnnList?currentPage=${cpage}`)
            .then(res => {
                commit('getAnnList', res.data);
            })
            .catch(err => {
                console.log(`${err} happen when get AnnList`);
            })
    },
    // 获取公告详情
    getAnnDetail({ commit }, id) {
        axios.get(`/ants/announcement/getAnnDetail?annId=${id}`)
            .then(res => {
                commit('getAnnDetail', res.data);
            }).catch(err => {
                console.log(`${err} happen when get annDetail`)
            })
    }
}
export default { state, getters, mutations, actions, namespaced }