import axios from 'axios'
const namespaced = true;
const state = {

    myInfo: ["个人资料", "我的物品", "发布物品", "收藏盒", "正在交易", "已交易的"],
    myGoods: [
        [{
                pic: require("../../assets/img/index/antsLogo.png"),
                goodsName: "计算机",
                goodsPrice: "20",
                repertory: "2",
                uploadTime: "2019-04-17",
                state: "已交易"
            },
            {
                pic: require("../../assets/img/index/antsLogo.png"),
                goodsName: "室内补湿仪",
                goodsPrice: "30",
                repertory: "1",
                uploadTime: "2019-08-17",
                state: "未交易"
            },
            {
                pic: require("../../assets/img/index/antsLogo.png"),
                goodsName: "移动小风扇",
                goodsPrice: "8",
                repertory: "6",
                uploadTime: "2018-11-22",
                state: "正在交易"
            }
        ],
        [{
                pic: require("../../assets/img/index/antsLogo.png"),
                goodsName: "计算机",
                goodsPrice: "20",
                repertory: "2",
                uploadTime: "2019-04-17",
                state: "出租中"
            },
            {
                pic: require("../../assets/img/index/antsLogo.png"),
                goodsName: "室内补湿仪",
                goodsPrice: "30",
                repertory: "1",
                uploadTime: "2019-08-17",
                state: "出租中"
            },
            {
                pic: require("../../assets/img/index/antsLogo.png"),
                goodsName: "移动小风扇",
                goodsPrice: "8",
                repertory: "6",
                uploadTime: "2018-11-22",
                state: "空闲中"
            }
        ],
        [{
                pic: require("../../assets/img/index/antsLogo.png"),
                goodsName: "计算机",
                goodsPrice: "20",
                repertory: "2",
                uploadTime: "2019-04-17",
                state: "已赠送"
            },
            {
                pic: require("../../assets/img/index/antsLogo.png"),
                goodsName: "室内补湿仪",
                goodsPrice: "30",
                repertory: "1",
                uploadTime: "2019-08-17",
                state: "已赠送"
            },
            {
                pic: require("../../assets/img/index/antsLogo.png"),
                goodsName: "移动小风扇",
                goodsPrice: "8",
                repertory: "6",
                uploadTime: "2018-11-22",
                state: "未赠送"
            }
        ],
        [{
                pic: require("../../assets/img/index/antsLogo.png"),
                goodsName: "计算机",
                goodsPrice: "20",
                repertory: "2",
                uploadTime: "2019-04-17",
                state: "已找到"
            },
            {
                pic: require("../../assets/img/index/antsLogo.png"),
                goodsName: "室内补湿仪",
                goodsPrice: "30",
                repertory: "1",
                uploadTime: "2019-08-17",
                state: "已找到"
            },
            {
                pic: require("../../assets/img/index/antsLogo.png"),
                goodsName: "移动小风扇",
                goodsPrice: "8",
                repertory: "6",
                uploadTime: "2018-11-22",
                state: "未找到"
            }
        ]
    ],
    user: {
        studentId: '1',
        portrait: require("../../assets/img/index/antsLogo.png"),
        userName: "广金吴彦祖",
        mobilePhone: '13782910291',
        address: '南苑7#902',
        userWechat: '13782910291',
        userQQ: '579302718'
    }
}

const getters = {
    getMyInfo(state) {
        return state.myInfo
    },
    getMyGoods(state) {
        return state.myGoods
    },
    getUser(state) {
        return state.user
    }
}

const mutations = {
    getUserMsg(state, res) {
        state.user = res;
    },
    releaseGoods(state, res) {
        if (res === 'success') {
            alert('发布成功')
        } else if (res === 'fail') {
            alert('发布失败')
        }
    }
}

const actions = {
    // 获取个人信息
    getUserMsg({ commit }) {
        axios.get('/ants/student/getStuMessag')
            .then(res => {
                commit('getUserMsg', res.data)
            }).catch(err => {
                console.log(`can't request the data for ${err}`);
            })
    },
    // 发布
    releaseGoods({ commit }, type, data) { // type:发布的类型
        axios.post(`./ants/${type.toLowerCase()}/release${type}`, data)
            .then(res => {
                commit('releaseGoods', res.data)
            }).catch(err => {
                console.log(`can't request the data for ${err}`);
            })
    }
}

export default { state, getters, mutations, actions, namespaced };