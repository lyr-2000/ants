import Vue from 'vue';
import Vuex from 'vuex';
import index from './modules/index';
import search from './modules/search';
import detail from './modules/detail';

Vue.use(Vuex);
const store = new Vuex.Store({
    modules: {
        index,
        search,
        detail
    }
});

export default store;