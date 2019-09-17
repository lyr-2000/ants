const namespaced = true;
const state = {
    ws: "",
    url: "ws://127.0.0.1:8080/chat?",
    myId: '', // 用户自己的id
    userList: [{
        contactor: 171543114,
        contactorAvatar: require("../../assets/img/index/antsLogo.png"),
        contactorName: 'abc',
        latestTime: '2019/8/10'
    }, {
        contactor: 171543113,
        contactorAvatar: require("../../assets/img/index/antsLogo.png"),
        contactorName: '111',
        latestTime: '2019/7/10'
    }, {
        contactor: 171543115,
        contactorAvatar: require("../../assets/img/index/antsLogo.png"),
        contactorName: '222',
        latestTime: '2019/6/20'
    }, {
        contactor: 171543116,
        contactorAvatar: require("../../assets/img/index/antsLogo.png"),
        contactorName: '333',
        latestTime: '2019/5/10'
    }],
    chooseUser: {
        contactor: 171543114,
        contactorAvatar: require("../../assets/img/index/antsLogo.png"),
        contactorName: 'abc',
        latestTime: '2019/8/10'
    },
    // 聊天框中的信息
    // identify false为对方消息 true为自己的消息
    // type 1：文本信息   2：文件
    newsList: [{
        identify: false,
        content: '如果没记错的话应该是在体育中心总店买的吧,才用了几次',
        type: 1
    }, {
        identify: true,
        content: '请问怎么议价，能不能再便宜一点呢~',
        type: 1
    }, {
        identify: false,
        content: '不可以',
        type: 1
    }, {
        identify: false,
        content: '好吧，可以再少一点。',
        type: 1
    }, {
        identify: false,
        content: require("../../assets/img/index/antsLogo.png"),
        type: 2
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
    chooseChange(state, user) {
        state.chooseUser = user;
    },
    // 将信息推送到聊天记录框中
    pushMsg(state, data) {
        state.newsList.push(data);
    },
    // 修改联系人列表
    changeUserList(state, contactorlist) {
        // require图片
        contactorlist.forEach((contactor) => {
            contactor.contactorAvatar = require(contactor.contactorAvatar)
        })
        state.userList = contactorlist;
    },
    // 聊天记录覆盖
    changeList(state, newsList) {
        state.newsList = newsList
    }
}

const actions = {
    // 选择另一个用户
    chooseChange({ commit, state, dispatch }, user) {
        commit("chooseChange", user)
        console.log('data: ', data);
        let data = {
            type: 0,
            id: state.myId,
            business: state.chooseUser.contactor,
        }
        dispatch("onSend", { data, file: "" })
    },
    // websocket连接
    socketInit({ state, dispatch }, { id, business }) {
        let url = "";
        state.myId = id;
        if (!business) {
            url = `${state.url}id=${id}&business=${business}`;
        } else {
            url = `${state.url}id=${id}`;
        }
        if ('WebSocket' in window) {
            state.ws = new WebSocket(url);
            dispatch("onMessage")
        } else if ('MozWebSocket' in window) {
            state.ws = new MozWebSocket(url);
            dispatch("onMessage")
        } else {
            alert('WebSocket is not supported by this browser.');
            return;
        }
    },
    // 连接后获取数据
    onMessage({ state, commit }) {
        console.log('state: ', state);
        state.ws.onmessage = function(event) {
            console.log("event:", event);
            let data = JSON.parse(event.data);
            if (data.type == 0) {
                // 用户下线
                console.log("用户下线")
            } else if (data.type == 1) {
                console.log('接收信息 ', data);
                // 接收文本信息
                let identify = false;
                if (data.id == state.myId) {
                    identify = true;
                }
                commit("pushMsg", { content: data.msg, identify: identify, type: 1 })
            } else if (data.type == 2) {
                // 接收文件
                console.log('接收文件', data);
                let identify = false;
                if (data.id == state.myId) {
                    identify = true;
                }
                commit("pushMsg", { content: data.msg, identify: identify, type: 2 })
            } else if (data.type == 4) {
                // 接收历史消息
                console.log('历史消息', data);
                let newsList = [];
                data.from.forEach((info, index) => {
                    let identify = false;
                    if (info.id == state.myId) {
                        identify = true;
                    }
                    newsList[index] = { content: info.information, identify, type: 1 };
                })
                commit("changeList", newsList);
            } else if (data.type == 5) {
                console.log('data: ', data);
                commit('changeUserList', data.contactorlist)
            }
        }
    },
    // 连接后发送数据
    onSend({ state }, { data, file }) {
        // 发送文本信息
        if (data.type === 1 || data.type === 0) {
            console.log('信息或者获取聊天记录 ', data);
            data = JSON.stringify(data);
            state.ws.send(data)
        }
        // 发送文件
        if (data.type === 2) {
            let reader = new FileReader();
            reader.readAsArrayBuffer(file)
            reader.onload = function(e) {
                let blob = e.target.result
                let fileFinish = {
                    type: 3,
                    id: data.id,
                    business: data.business
                };
                // 提示后端文件发送完毕
                blob = JSON.stringify(blob);
                fileFinish = JSON.stringify(fileFinish);
                state.ws.send(blob)
                state.ws.send(fileFinish)
            }
        }
    },
}

export default { state, getters, mutations, actions, namespaced }