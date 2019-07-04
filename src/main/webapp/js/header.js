document.write(`<div class="topContainer">
<!-- 导航栏 -->
<nav class="nav">
    <div class="navContainer">
        <ul class="leftNav">
            <li class="localIn"><a href="index.html">首页</a></li>
            <li><a href="#">租赁</a></li>
            <li><a href="#">赠送</a></li>
        </ul>
        <ul class="rightNav">
            <li class="schoolChoose">广东金融学院</li>
            <li class="localIn">买家</li>
            <li>卖家</li>
            <li><a href="log.html">登录</a></li>
        </ul>
<!-- 顶部操作 -->
<div class="topHandle">
    <div class="topLogo">
        <img src="img/index/antsLogo.png" alt="蚂蚁置物">
        <span>蚂蚁置物</span>
    </div>
    <div class="searchGoods">
        <input type="text" v-model="searchWord">
        <img src="img/index/search.png" @click='search'>
    </div>

    <div class="mainHandle">
        <button>发布寻求</button>
        <button>正在寻求</button>
    </div>

</div>
</div>`)