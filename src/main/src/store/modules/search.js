import axios from 'axios';

const state = {
    type: 1,
    arraySort: true,
    secIndex: 0,
    thiIndex: 0,
    synthesis: [
        { parentId: 1, parentName: "书籍", parentPicture: "/book.png" },
        {
            parentId: 2,
            parentName: "文具",
            parentPicture: "/stationery.png"
        },
        { parentId: 3, parentName: "日用", parentPicture: "/daily.png" },
        { parentId: 4, parentName: "美妆", parentPicture: "/cosmetics.png" },
        { parentId: 5, parentName: "食品", parentPicture: "/food.png" },
        { parentId: 6, parentName: "电器", parentPicture: "/electrical.png" },
        { parentId: 7, parentName: "其他", parentPicture: "/others.png" }
    ],
    childList: [
        { subClassId: 0, subClassName: "英语四六级", parentClass: 0 },
        { subClassId: 0, subClassName: "英语四六级", parentClass: 0 },
        { subClassId: 0, subClassName: "证从", parentClass: 0 },
        { subClassId: 0, subClassName: "证从", parentClass: 0 },
        { subClassId: 0, subClassName: "证从", parentClass: 0 },
        { subClassId: 0, subClassName: "证从", parentClass: 0 },
        { subClassId: 0, subClassName: "证从", parentClass: 0 },
        { subClassId: 0, subClassName: "证从", parentClass: 0 },
    ],
    goodsExample: [{
        goodsId: 1,
        goodsName: "商品名",
        goodsPicture: "test1.png",
        goodsPrice: 0,
        goodsBargin: 0,
        uploadTime: '2019-06-03'
    }, {
        goodsId: 1,
        goodsName: "商品名",
        goodsPicture: "test1.png",
        goodsPrice: 0,
        goodsBargin: 0,
        uploadTime: '2019-06-03'
    }, {
        goodsId: 1,
        goodsName: "商品名",
        goodsPicture: "test1.png",
        goodsPrice: 0,
        goodsBargin: 0,
        uploadTime: '2019-06-03'
    }, {
        goodsId: 1,
        goodsName: "商品名",
        goodsPicture: "test1.png",
        goodsPrice: 0,
        goodsBargin: 0,
        uploadTime: '2019-06-03'
    }, {
        goodsId: 1,
        goodsName: "商品名",
        goodsPicture: "test1.png",
        goodsPrice: 0,
        goodsBargin: 0,
        uploadTime: '2019-06-03'
    }, {
        goodsId: 1,
        goodsName: "商品名",
        goodsPicture: "test1.png",
        goodsPrice: 0,
        goodsBargin: 0,
        uploadTime: '2019-06-03'
    }, {
        goodsId: 1,
        goodsName: "商品名",
        goodsPicture: "test1.png",
        goodsPrice: 0,
        goodsBargin: 0,
        uploadTime: '2019-06-03'
    }, {
        goodsId: 1,
        goodsName: "商品名",
        goodsPicture: "test1.png",
        goodsPrice: 0,
        goodsBargin: 0,
        uploadTime: '2019-06-03'
    }, {
        goodsId: 1,
        goodsName: "商品名",
        goodsPicture: "test1.png",
        goodsPrice: 0,
        goodsBargin: 0,
        uploadTime: '2019-06-03'
    }, {
        goodsId: 1,
        goodsName: "商品名",
        goodsPicture: "test1.png",
        goodsPrice: 0,
        goodsBargin: 0,
        uploadTime: '2019-06-03'
    }, {
        goodsId: 1,
        goodsName: "商品名",
        goodsPicture: "test1.png",
        goodsPrice: 0,
        goodsBargin: 0,
        uploadTime: '2019-06-03'
    }, {
        goodsId: 1,
        goodsName: "商品名",
        goodsPicture: "test1.png",
        goodsPrice: 0,
        goodsBargin: 0,
        uploadTime: '2019-06-03'
    }, {
        goodsId: 1,
        goodsName: "商品名",
        goodsPicture: "test1.png",
        goodsPrice: 0,
        goodsBargin: 0,
        uploadTime: '2019-06-03'
    }, {
        goodsId: 1,
        goodsName: "商品名",
        goodsPicture: "test1.png",
        goodsPrice: 0,
        goodsBargin: 0,
        uploadTime: '2019-06-03'
    }, {
        goodsId: 1,
        goodsName: "商品名",
        goodsPicture: "test1.png",
        goodsPrice: 0,
        goodsBargin: 0,
        uploadTime: '2019-06-03'
    }, {
        goodsId: 1,
        goodsName: "商品名",
        goodsPicture: "test1.png",
        goodsPrice: 0,
        goodsBargin: 0,
        uploadTime: '2019-06-03'
    }, ],
    currentPage: 3,
    page: 4
}

const getters = {
    getType: function(state) {
        return state.type;
    },
    getArraySort: function(state) {
        return state.arraySort;
    },
    getSecIndex: function(state) {
        return state.secIndex;
    },
    getThiIndex: function(state) {
        return state.thiIndex;
    },
    getSynthesis: function(state) {
        return state.synthesis;
    },
    getChildList: function(state) {
        return state.childList;
    },
    getGoodsList: function(state) {
        return state.goodsExample;
    },
    getCurrentPage: function(state) {
        return state.currentPage;
    },
    getPage: function(state) {
        return state.page;
    },
}

const mutations = {
    changeArrayBy(state, res) {
        state.goodsExample = res.goodsExample;
        state.page = res.page;
        state.currentPage = 1;
    },
    turn(state, res) {
        state.goodsExample = res.goodsExample;
    },
    titleSearch(state, res) {
        state.goodsExample = res.goodsExample;
        state.page = res.page;
        state.currentPage = 1;
    },
    showChildList(state, res) {
        state.childList = res.childList;
        state.goodsExample = res.goodsExample;
    },
    init(state, res) {
        state.synthesis = res.synthesis;
        state.childList = res.childList;
        state.goodsExample = res.goodsExample;
        state.page = res.page;
    }
}

const actions = {
    changeArrayBy({ commit }, type) {
        if (state.type == type) {
            if (type !== '1') {
                state.arraySort = !state.arraySort;
            }
        } else {
            state.type = type;
            state.arraySort = true;
        }
        axios.post('/ants/class/chooseGoodsByType', {
                parentId: state.secIndex,
                childId: state.thiIndex,
                type: state.type
            })
            .then(res => {
                commit("changeArrayBy", res.data)
            }).catch(err => {
                console.log(`can't request the data for ${err}`);
            })
    },
    //跳转页数
    turn({ commit }, currentPage) {
        if (currentPage > state.page || currentPage < 1) {
            return;
        } else {
            state.currentPage = currentPage;
            axios.post('/ants/class/pageJump', {
                parentId: state.secIndex,
                childId: state.thiIndex,
                type: state.type,
                currentPage: state.currentPage
            }).then(res => {
                commit("turn", res.data);
            }).catch(err => {
                console.log(`can't request the data for ${err}`);
            })
        }
    },
    // 根据标签搜索相应的内容
    titleSearch({ commit }, index) {
        state.thiIndex = index;
        axios.post('/ants/class/goodsByChild', {
            subClassId: index,
            subClassName: state.childList[index].subClassName,
            parentClass: state.secIndex
        }).then(res => {
            commit("titleSearch", res.data);
        }).catch(err => {
            console.log(`can't request the data for ${err}`);
        })
    },
    // 显示三级导航
    showChildList({ commit }, index) {
        console.log('index: ', index);
        state.secIndex = index;
        if (index != 0) {
            axios.post('/ants/class/goodsByParent', state.synthesis[index])
                .then((res) => {
                    commit('showChildList', res.data)
                })
                .catch((err) => {
                    console.log(`the error called ${err} when request childList`)
                })
        }
    },
    // 初始化页面数据
    initData({ commit }) {
        console.log('init')
        axios.get('/ants/dataRendering/deputyPage')
            .then((res) => {
                commit('init', res.data);
            }).catch(err => {
                console.log(`can't request the data for ${err}`);
            })
    }
}

export default { state, getters, mutations, actions }