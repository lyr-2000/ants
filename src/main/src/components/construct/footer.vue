<template>
    <footer>
        <div class="footIcon">
            <img src="../../assets/img/index/foot_icon1.png">
            <img src="../../assets/img/index/foot_icon2.png">
            <img src="../../assets/img/index/foot_icon3.png">
        </div>
        <p>蚂蚁置物校园二手交易平台联系方式：12312312345</p>
    </footer>
</template>

<script>
export default {

}
</script>
<style lang="less" scoped>
@import '../../assets/less/define.less';
// 页脚
footer{
    padding: 20px 0px;
    text-align: center;
    vertical-align: middle;
    background-color: @footerColor;
    img{
        margin: 10px 50px;
    }
    p{
        margin-bottom: 0px;
        color: #fff;
    }
}
</style>

