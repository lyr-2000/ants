<template>
    <div class="topContainer">
        <!-- 导航栏 -->
        <nav class="nav">
            <div class="navContainer">
                <ul class="leftNav">
                    <li :class="{localIn:webPage=='index'}"><a href="index.html">首页</a></li>
                    <li :class="{localIn:webPage=='rent'}"><a href="#">租赁</a></li>
                    <li :class="{localIn:webPage=='sent'}"><a href="#">赠送</a></li>
                </ul>
                <ul class="rightNav">
                    <li class="schoolChoose">>广东金融学院</li>
                    <li :class="{localIn:identity=='buyer'}">买家</li>
                    <li :class="{localIn:identity=='seller'}">卖家</li>
                    <li><a href="log.html">登录</a></li>
                </ul>
            </div>
        </nav>
        <!-- 顶部操作 -->
        <div class="topHandle">
            <div class="topLogo">
                <img src="../../assets/img/index/antsLogo.png" alt="蚂蚁置物">
                <span>蚂蚁置物</span>
            </div>
            <div class="searchGoods">
                <input type="text" v-model="searchWord">
                <img src="../../assets/img/index/search.png" @click='search'>
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
    data(){
        return{
            searchWord:""
        }
    },
    props:["webPage","identity"],
    methods:{
        search(val){
          
        }
    }
}
</script>

<style lang="less">
@import url('../../assets/less/define.less');

body{
    margin: 0px;
    padding: 0px;
}

ul{
    margin: 0px;
    padding: 0px;
}

li{
    float: left;
    list-style: none;
}

a{
    text-decoration: none;
    color: inherit;
}

//顶部容器
.topContainer{
    @windowWidth:1518px;
    border-bottom: 1px solid @borderColor;
    .nav{
        height: 47px;
        color: #fff;
        background-color: @topicDeepBColor;
        .navContainer{
            margin: 0px auto;
            width: @windowWidth+72;
            font-size: 20px;
            ul{
                li{
                    padding: 9px 30px 12px 30px;
                    cursor: pointer;
                }
            }
            .localIn{
                padding-bottom: 9px;
                color: @topicDeepBColor;
                background-color: rgba(255,255,255,.8);
            }
            .leftNav{
                float: left;
                margin-left: 202px;
            }
            .rightNav{
                float: right;
            }
        }
    }

    // 表单去表格样式
    .inputNoBorder(){
        border:none;
        outline:none;
    }

    .topHandle{
        margin: 24px auto;
        width: @windowWidth;
        >div{
            display: inline-block;
        }
        .topLogo{
            img{
                float: left;
                height: 50px;
            }
            span{
                margin-left: 11px;
                font-size: 36px;
            }
        }
        .searchGoods{
            margin:0px 80px 0px 347px;
            padding: 4px;
            width: 390px;
            border: 2px solid @topicDeepBColor;
            border-radius: 5px;
            transform: translatey(-4px);
            input{
                margin: 4px 0px;
                width: 346px;
                height: 31px;
                .inputNoBorder;
            }
            img{
                width: 24px;
                height: 24px;
                vertical-align: middle;
                cursor: pointer;
            }
            &:hover{
                border-color: @topicDeepRColor;
            }
            &:focus-within{
                border-color: @topicDeepRColor;
            }
        }
        .mainHandle{
            button{
                .inputNoBorder;
                border-radius: 5px;
                padding: 9px 18px;
                margin-right: 50px;
                font-size: 24px;
                color: rgb(255,255,255);
                background-color: @topicShallowRColor;
                cursor: pointer;
                &:hover{
                    background-color: @topicDeepRColor;
                }
            }
        }
    }
}

</style>
