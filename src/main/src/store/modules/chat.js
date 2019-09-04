const namespaced = true;
const state = {
    ws: "",
    url: "ws://127.0.0.1:8080/chat?",
    userList: [{
        contactor: 1,
        imgSrc: require("../../assets/img/index/antsLogo.png"),
        contactorName: 'abc',
        chatTime: '2019/8/10'
    }, {
        contactor: 2,
        imgSrc: require("../../assets/img/index/antsLogo.png"),
        contactorName: '111',
        chatTime: '2019/7/10'
    }, {
        contactor: 3,
        imgSrc: require("../../assets/img/index/antsLogo.png"),
        contactorName: '222',
        chatTime: '2019/6/20'
    }, {
        contactor: 4,
        imgSrc: require("../../assets/img/index/antsLogo.png"),
        contactorName: '333',
        chatTime: '2019/5/10'
    }],
    chooseUser: {
        contactor: 1,
        imgSrc: require("../../assets/img/index/antsLogo.png"),
        contactorName: 'abc',
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
    chooseChange(state, user) {
        state.chooseUser = user;
    }
}

const actions = {
    // 选择另一个用户
    chooseChange({ commit }, user) {
        commit("chooseChange", user)
    },
    // websocket连接
    socketInit(id, business) {
        let url = "";
        if (!business) {
            url = `${state.url}id=${id}&business=${business}`;
        } else {
            url = `${state.url}id=${id}`;
        }
        if ('WebSocket' in window) {
            state.ws = new WebSocket(url);
        } else if ('MozWebSocket' in window) {
            state.ws = new MozWebSocket(url);
        } else {
            alert('WebSocket is not supported by this browser.');
            return;
        }
    },
    // 连接后获取数据
    onMessage() {
        state.ws.onMessage = function(event) {

        }
    },
    // 连接后发送数据
    onSend(data, file) {
        state.wx.send(data)
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
                state.wx.send(blob)
                state.wx.send(fileFinish)
            }
        }
    },
}

export default { state, getters, mutations, actions, namespaced }