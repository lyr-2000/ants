<template>
    <div id="app">
        <Header :isNotFound="true"></Header>
        <div class="main">
            <img src="../assets/img/ants/404.png">
            <p>404错误 这里什么都没有</p>
            <router-link to="/user">返回上级页面</router-link>
        </div>
    </div>
</template>

<script>
import Header from '../components/construct/header.vue'

export default {
    name:'app',
    components:{
        Header
    }
}
</script>

<style lang="less" scoped>
@import '../assets/less/define.less';
*{
    margin: 0px;
}
body{
    background-color:@chatShallowBColor;
}
.main{
    font-size: 30px;
    text-align: center;
    p{
        margin-bottom: 39px;
        color: @topicDeepBColor;
    }
    a{
        text-decoration: underline;
        color: @chatDeepBColor;
    }
}
</style>

