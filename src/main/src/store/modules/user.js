import axios from 'axios'
const state = {

    myInfo: ["个人资料", "我的物品", "发布信息", "正在交易", "已交易的", "已赠送的", "租赁消息"],
    user: {
        pic: require("../../assets/img/index/antsLogo.png"),
        name: "广金吴彦祖",
        userMobile: '13782910291',
        goodsLocation: '南苑7#902',
        userWechat: '13782910291',
        userQQ: '579302718'
    }
}

const getters = {
    getMyInfo() {
        return state.myInfo
    },
    getUser() {
        return state.user
    }
}

const mutations = {

}

const actions = {

}

export default { state, getters, mutations, actions };