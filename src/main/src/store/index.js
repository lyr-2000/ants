import Vue from 'vue';
import Vuex from 'vuex';
import index from './modules/index';
import search from './modules/search';
import detail from './modules/detail';
import user from './modules/user';
import chat from './modules/chat'
import announce from './modules/announce'

Vue.use(Vuex);
const store = new Vuex.Store({
    modules: {
        index,
        search,
        detail,
        user,
        chat,
        announce
    }
});

export default store;