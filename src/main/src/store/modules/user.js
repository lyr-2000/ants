import axios from 'axios'
const namespaced = true;
const state = {

    myInfo: ["个人资料", "我的物品", "发布信息", "正在交易", "已交易的", "已赠送的", ""],
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
                state: "已找到"
            },
            {
                pic: require("../../assets/img/index/antsLogo.png"),
                goodsName: "室内补湿仪",
                goodsPrice: "30",
                repertory: "1",
                uploadTime: "2019-08-17",
                state: "未找到"
            },
            {
                pic: require("../../assets/img/index/antsLogo.png"),
                goodsName: "移动小风扇",
                goodsPrice: "8",
                repertory: "6",
                uploadTime: "2018-11-22",
                state: "已找到"
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
        ]
    ],
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

}

const actions = {

}

export default { state, getters, mutations, actions, namespaced };