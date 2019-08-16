import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'

import Chat from './page/chat.vue'
import Detail from './page/detail.vue'
import Index from './page/index.vue'
import Log from './page/log.vue'
import RequestTip from './page/requestTip.vue'
import Search from './page/search.vue'
import User from './page/user.vue'
import NotFound from './page/404.vue'

Vue.use(VueRouter)
Vue.config.productionTip = false

const routes = [
    { path: '/', component: Index },
    { path: '/index', component: Index },
    { path: '/detail', component: Detail },
    { path: '/log', component: Log },
    { path: '/requestTip', component: RequestTip },
    { path: '/search', component: Search },
    { path: '/user', component: User },
    { path: '/chat', component: Chat },
    { path: '*', component: NotFound }
]

// 3. 创建 router 实例，然后传 `routes` 配置
// 你还可以传别的配置参数, 不过先这么简单着吧。
const router = new VueRouter({
    routes // (缩写) 相当于 routes: routes
})
new Vue({
    router,
    render: h => h(App),
}).$mount('#app')