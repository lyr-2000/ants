import axios from 'axios'
const namespaced = true;
const state = {
    userList: [{
        id: 1,
        imgSrc: require("../../assets/img/index/antsLogo.png"),
        userName: 'abc',
        chatTime: '2019/8/10'
    }, {
        id: 2,
        imgSrc: require("../../assets/img/index/antsLogo.png"),
        userName: '111',
        chatTime: '2019/7/10'
    }, {
        id: 3,
        imgSrc: require("../../assets/img/index/antsLogo.png"),
        userName: '222',
        chatTime: '2019/6/20'
    }, {
        id: 4,
        imgSrc: require("../../assets/img/index/antsLogo.png"),
        userName: '333',
        chatTime: '2019/5/10'
    }],
    chooseUser: {
        id: 1,
        imgSrc: require("../../assets/img/index/antsLogo.png"),
        userName: 'abc',
        chatTime: '2019/8/10'
    },
    newsList: [{
        identify: false,
        content: '如果没记错的话应该是在体育中心总店买的吧,才用了几次'
    }, {
        identify: true,
        content: '请问怎么议价，能不能再便宜一点呢~'
    }, {
        identify: false,
        content: '不可以'
    }, {
        identify: false,
        content: '好吧，可以再少一点。'
    }, ]
}
const getters = {
    getUserList(state) {
        return state.userList
    },
    getChooseUser(state) {
        return state.chooseUser
    },
    getNewsList(state) {
        return state.newsList
    }
}
const mutations = {

}

const actions = {
    // 选择另一个用户
    chooseChange({ commit }, user) {
        state.chooseUser = user
    }
}

export default { state, getters, mutations, actions, namespaced };