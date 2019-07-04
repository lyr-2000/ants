<template>
    <div class="topContainer">
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
            </div>
        </nav>
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
    </div>
</template>

<script>
export default {

}
</script>

<style>
body {
  margin: 0px;
  padding: 0px;
}
ul {
  margin: 0px;
  padding: 0px;
}
li {
  float: left;
  list-style: none;
}
a {
  text-decoration: none;
  color: inherit;
}
.topContainer {
  border-bottom: 1px solid rgba(102, 102, 102, 0.5);
}
.topContainer .nav {
  height: 36px;
  color: #fff;
  background-color: #5d759d;
}
.topContainer .nav .navContainer {
  margin: 0px auto;
  width: 1190px;
}
.topContainer .nav .navContainer ul li {
  padding: 8px 20px;
  cursor: pointer;
}
.topContainer .nav .navContainer .localIn {
  padding-bottom: 4px;
  color: #5d759d;
  background-color: rgba(255, 255, 255, 0.8);
}
.topContainer .nav .navContainer .leftNav {
  float: left;
  margin-left: 190px;
}
.topContainer .nav .navContainer .rightNav {
  float: right;
}
.topContainer .topHandle {
  margin: 16px auto;
  width: 1200px;
}
.topContainer .topHandle > div {
  display: inline-block;
}
.topContainer .topHandle .topLogo {
  margin-left: 88px;
}
.topContainer .topHandle .topLogo img {
  float: left;
  height: 34px;
}
.topContainer .topHandle .topLogo span {
  margin-left: 10px;
  font-size: 24px;
}
.topContainer .topHandle .searchGoods {
  margin: 0% 5% 0% 20%;
  padding: 4px;
  width: 280px;
  border: 2px solid #5d759d;
  border-radius: 5px;
}
.topContainer .topHandle .searchGoods input {
  margin: 3px;
  width: 232px;
  border: none;
  outline: none;
}
.topContainer .topHandle .searchGoods img {
  width: 20px;
  height: 20px;
  vertical-align: middle;
  cursor: pointer;
}
.topContainer .topHandle .searchGoods:hover {
  border-color: rgba(246, 146, 138, 0.5);
}
.topContainer .topHandle .searchGoods:focus-within {
  border-color: rgba(246, 146, 138, 0.5);
}
.topContainer .topHandle .mainHandle button {
  border: none;
  outline: none;
  border-radius: 5px;
  padding: 9px 18px;
  margin: 0 10px;
  font-size: 16px;
  color: #ffffff;
  background-color: rgba(246, 146, 138, 0.5);
  cursor: pointer;
}

</style>
