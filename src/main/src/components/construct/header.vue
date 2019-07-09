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
                    <li class="schoolChoose">广东金融学院</li>
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


@topicDeepBColor:#5d759d;
@topicShallowRColor:rgba(246,146,138,.5);
@borderColor:rgba(102,102,102,.5);
@fontColor:#666;
@fontHoverColor:#333;

//顶部容器
.topContainer{
    border-bottom: 1px solid @borderColor;
    .nav{
        height: 36px;
        color: #fff;
        background-color: @topicDeepBColor;
        .navContainer{
            margin: 0px auto;
            width: 1190px;
            ul{
                li{
                    padding: 8px 20px;
                    cursor: pointer;
                }
            }
            .localIn{
                padding-bottom: 4px;
                color: @topicDeepBColor;
                background-color: rgba(255,255,255,.8);
            }
            .leftNav{
                float: left;
                margin-left: 190px;
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
        margin: 16px auto;
        width: 1200px;
        >div{
            display: inline-block;
        }
        .topLogo{
            margin-left: 88px;
            img{
                float: left;
                height: 34px;
            }
            span{
                margin-left: 10px;
                font-size: 24px;
            }
        }
        .searchGoods{
            margin:0% 5% 0% 20%;
            padding: 4px;
            width: 280px;
            border: 2px solid @topicDeepBColor;
            border-radius: 5px;
            input{
                margin: 3px;
                width: 232px;
                .inputNoBorder;
            }
            img{
                width: 20px;
                height: 20px;
                vertical-align: middle;
                cursor: pointer;
            }
            &:hover{
                border-color: @topicShallowRColor;
            }
            &:focus-within{
                border-color: @topicShallowRColor;
            }
        }
        .mainHandle{
            // float: right;
            button{
                .inputNoBorder;
                border-radius: 5px;
                padding: 9px 18px;
                margin: 0 10px;
                font-size: 16px;
                color: rgb(255,255,255);
                background-color: @topicShallowRColor;
                cursor: pointer;
            }
        }
    }
}

</style>
