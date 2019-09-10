import axios from 'axios'
const namespaced = true;
const state = {
    myInfo: ["个人资料", "我的物品", "发布物品", "收藏盒", "正在交易", "已交易的"],
    myGoods: {
        idleList: [{
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "计算机",
                goodsPrice: "20",
                repertory: "2",
                uploadTime: "2019-04-17",
                goodsState: "已交易"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "室内补湿仪",
                goodsPrice: "30",
                repertory: "1",
                uploadTime: "2019-08-17",
                goodsState: "未交易"
            }
        ],
        leaseList: [{
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "室内补湿仪",
                goodsPrice: "30",
                repertory: "1",
                uploadTime: "2019-08-17",
                goodsState: "出租中"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "移动小风扇",
                goodsPrice: "8",
                repertory: "6",
                uploadTime: "2018-11-22",
                goodsState: "空闲中"
            }
        ],
        giveList: [{
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "计算机",
                goodsPrice: "20",
                repertory: "2",
                uploadTime: "2019-04-17",
                goodsState: "已赠送"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "移动小风扇",
                goodsPrice: "8",
                repertory: "6",
                uploadTime: "2018-11-22",
                goodsState: "未赠送"
            }
        ],
        seekList: [{
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "计算机",
                goodsPrice: "20",
                repertory: "2",
                uploadTime: "2019-04-17",
                goodsState: "已找到"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "移动小风扇",
                goodsPrice: "8",
                repertory: "60",
                uploadTime: "2018-11-22",
                goodsState: "未找到"
            }
        ]
    },
    tradingGoods: {
        idleList: [{
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "计算机",
                goodsPrice: "20",
                repertory: "2",
                uploadTime: "2019-04-17",
                goodsState: "已交易"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "室内补湿仪",
                goodsPrice: "30",
                repertory: "1",
                uploadTime: "2019-08-17",
                goodsState: "未交易"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "移动小风扇",
                goodsPrice: "8",
                repertory: "6",
                uploadTime: "2018-11-22",
                goodsState: "正在交易"
            }
        ],
        leaseList: [{
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "计算机",
                goodsPrice: "20",
                repertory: "2",
                uploadTime: "2019-04-17",
                goodsState: "出租中"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "室内补湿仪",
                goodsPrice: "30",
                repertory: "1",
                uploadTime: "2019-08-17",
                goodsState: "出租中"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "移动小风扇",
                goodsPrice: "8",
                repertory: "6",
                uploadTime: "2018-11-22",
                goodsState: "空闲中"
            }
        ],
        giveList: [{
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "计算机",
                goodsPrice: "20",
                repertory: "2",
                uploadTime: "2019-04-17",
                goodsState: "已赠送"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "室内补湿仪",
                goodsPrice: "30",
                repertory: "1",
                uploadTime: "2019-08-17",
                goodsState: "已赠送"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "移动小风扇",
                goodsPrice: "8",
                repertory: "6",
                uploadTime: "2018-11-22",
                goodsState: "未赠送"
            }
        ],
        seekList: [{
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "计算机",
                goodsPrice: "20",
                repertory: "2",
                uploadTime: "2019-04-17",
                goodsState: "已找到"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "室内补湿仪",
                goodsPrice: "30",
                repertory: "1",
                uploadTime: "2019-08-17",
                goodsState: "已找到"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "移动小风扇",
                goodsPrice: "8",
                repertory: "60",
                uploadTime: "2018-11-22",
                goodsState: "未找到"
            }
        ]
    },
    haveTradeGoods: {
        idleList: [{
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "计算机",
                goodsPrice: "20",
                repertory: "2",
                uploadTime: "2019-04-17",
                goodsState: "已交易"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "室内补湿仪",
                goodsPrice: "30",
                repertory: "1",
                uploadTime: "2019-08-17",
                goodsState: "未交易"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "移动小风扇",
                goodsPrice: "8",
                repertory: "6",
                uploadTime: "2018-11-22",
                goodsState: "正在交易"
            }
        ],
        leaseList: [{
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "计算机",
                goodsPrice: "20",
                repertory: "2",
                uploadTime: "2019-04-17",
                goodsState: "出租中"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "室内补湿仪",
                goodsPrice: "30",
                repertory: "1",
                uploadTime: "2019-08-17",
                goodsState: "出租中"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "移动小风扇",
                goodsPrice: "8",
                repertory: "6",
                uploadTime: "2018-11-22",
                goodsState: "空闲中"
            }
        ],
        giveList: [{
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "计算机",
                goodsPrice: "20",
                repertory: "2",
                uploadTime: "2019-04-17",
                goodsState: "已赠送"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "室内补湿仪",
                goodsPrice: "30",
                repertory: "1",
                uploadTime: "2019-08-17",
                goodsState: "已赠送"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "移动小风扇",
                goodsPrice: "8",
                repertory: "6",
                uploadTime: "2018-11-22",
                goodsState: "未赠送"
            }
        ],
        seekList: [{
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "计算机",
                goodsPrice: "20",
                repertory: "2",
                uploadTime: "2019-04-17",
                goodsState: "已找到"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "室内补湿仪",
                goodsPrice: "30",
                repertory: "1",
                uploadTime: "2019-08-17",
                goodsState: "已找到"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "移动小风扇",
                goodsPrice: "8",
                repertory: "60",
                uploadTime: "2018-11-22",
                goodsState: "未找到"
            }
        ]
    },
    collectGoods: {
        buyList: [{
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "计算机",
                goodsPrice: "20",
                repertory: "2",
                uploadTime: "2019-04-17",
                goodsState: "已交易"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "室内补湿仪",
                goodsPrice: "30",
                repertory: "1",
                uploadTime: "2019-08-17",
                goodsState: "未交易"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "移动小风扇",
                goodsPrice: "8",
                repertory: "6",
                uploadTime: "2018-11-22",
                goodsState: "正在交易"
            }
        ],
        sellList: [{
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "计算机",
                goodsPrice: "20",
                repertory: "2",
                uploadTime: "2019-04-17",
                goodsState: "出租中"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "室内补湿仪",
                goodsPrice: "30",
                repertory: "1",
                uploadTime: "2019-08-17",
                goodsState: "出租中"
            },
            {
                goodsId: "",
                goodsPicture: require("../../assets/img/index/antsLogo.png"),
                goodsName: "移动小风扇",
                goodsPrice: "8",
                repertory: "6",
                uploadTime: "2018-11-22",
                goodsState: "空闲中"
            }
        ],
    },
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
    },
    getTradingGoods(state) {
        return state.tradingGoods
    },
    getHaveTradeGoods(state) {
        return state.tradingGoods
    },
    getCollectGoods(state) {
        return state.collectGoods
    }
}

const mutations = {
    getUserMsg(state, res) {
        state.user = res.stuMessage;
    },
    saveStuMsg(state, res) {
        if (res.status === 'success') {
            alert('提交成功');
        } else {
            alert('提交失败');
        }
    },
    getGoods(state, { res, type, title }) {
        console.log('title: ', title);
        console.log('type: ', type);
        console.log('res: ', res);
        let goods = "";
        if (title === "收藏盒") {
            goods = "collectGoods";
            if (type == 1) {
                state[goods].buyList = res.buyList;
            } else if (type == 2) {
                state[goods].sellList = res.sellList;
            }
        } else {
            if (title === "我的物品") {
                goods = "myGoods";
            } else if (title == "正在交易") {
                goods = "tradingGoods";
            } else if (title == "已交易的") {
                goods = "haveTradeGoods";
            }
            if (type === 1) {
                state[goods].idleList = res.idleList;
                console.log('state[goods].idleList: ', state[goods].idleList);
            } else if (type === 2) {
                state[goods].leaseList = res.leaseList;
            } else if (type === 3) {
                state[goods].seekList = res.seekList;
            } else if (type === 4) {
                state[goods].giveList = res.giveList;
            }
        }

    },
    releaseGoods(res) {
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
        axios.get('/ants/student/getStuMessage')
            .then(res => {
                commit('getUserMsg', res.data)
            }).catch(err => {
                console.log(`can't request the data for ${err}`);
            })
    },
    // 提交个人信息修改
    saveStuMsg({ commit }, data) {
        console.log(data.user)
        axios({
                headers: {
                    'deviceCode': 'A95ZEF1-47B5-AC90BF3'
                },
                url: '/ants/student/saveStuMessage',
                data: data.user,
                method: 'post'
            })
            .then(res => {
                commit('saveStuMsg', res.data)
            }).catch(err => {
                console.log(`can't request the data for ${err}`);
                commit('saveStuMsg', err)
            })
        actions.uploadFile({ param: data.imgData, type: 'photo' });
    },
    // 获取物品
    getGoods({ commit }, data) {
        console.log('data: ', data);
        axios.post(data.url, `type=${data.type}&currentPage=${data.cPage+1}`)
            .then(res => {
                commit('getGoods', { res: res.data, type: data.type, title: data.title })
            }).catch(err => {
                console.log(`can't request the data for ${err}`)
            })
    },
    // 发布
    releaseGoods({ commit }, data) { // type:发布的类型
        if (data.params.img.length !== 0) {
            actions.uploadFile({ param: data.params.img, type: 'photo' });
        }
        if (data.params.video.length !== 0) {
            actions.uploadFile({ param: data.params.video, type: 'video' });
        }
        axios({
                headers: {
                    'deviceCode': 'A95ZEF1-47B5-AC90BF3'
                },
                url: `./ants/${data.type.toLowerCase()}/release${data.type}`,
                data: data.data,
                method: 'post'
            })
            .then(res => {
                commit('releaseGoods', res.data)
            }).catch(err => {
                console.log(`can't request the data for ${err}`);
            })
    },
    // 上传图片/视频
    uploadFile({ param, type }) {
        let config = {
            headers: {
                "Content-Type": "multipart/form-data"
            }
        }
        let url = "";
        if (type === "photo") {
            url = "/ants/upload/imgUpload"
        } else if (type === "video") {
            url = "/ants/upload/videoUpload"
        }
        axios({
                headers: {
                    'deviceCode': 'A95ZEF1-47B5-AC90BF3'
                },
                url: url,
                data: {
                    [type]: param
                },
                method: 'post',
                config: config
            })
            .then(res => {
                console.log(res);
            }).catch(err => {
                console.log(`can't upload avatar because of ${err}`)
            })
    }
}

export default { state, getters, mutations, actions, namespaced };