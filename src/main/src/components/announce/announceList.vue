<template>
    <div class="list">
        <h1>公告信息</h1>
        <ul>
            <li class="announceList" v-for="msg in announceList">
                <span class="announceTitle" @click="readDetail">{{msg.title}}</span>
                <span class="publishTime">{{msg.time}}</span>
            </li>
        </ul>
        <p class="pageTurn">
            <span :class="['leftHan',currentPage==1?'disabeldHan':'']" @click="pageTurn(currentPage-1)"><</span>
            <span v-for="num in pageNum" :class="['turnHan',currentPage==num?'currentPage':'']" @click="pageTurn(num)">{{num}}</span>
            <span :class="['rightHan',currentPage==pageNum?'disabeldHan':'']" @click="pageTurn(currentPage+1)">></span>
        </p>
    </div>
</template>

<script>
import {mapGetters} from 'vuex'
export default {
    data(){
        return{
            currentPage:1
        }
    },
    computed:{
        ...mapGetters('announce',{
            announceList:"getAnnounceList",
            pageNum:"getPageNum"
        })
    },
    methods:{
        pageTurn(num){
            if(num<1||num>this.pageNum){
                return;
            }
            this.currentPage=num;
        },
        readDetail(){
            this.$emit("changeDetail")
        }
    }
}
</script>

<style lang="less" scoped>
@import '../../assets/less/define.less';
.list{
    padding: 40px 100px 57px 50px;
    color: @deepFontColor;
    h1{
        padding-left: 20px;
        margin-top: 0px;
        margin-bottom: 46px;
        border-left: 5px solid @topicDeepRColor;
        font-size: 26px;
    }
    &>ul{
        display: inline-block;
        margin-left: 26px;
        li{
            width: 100%;
            margin-bottom: 30px;
            text-indent: 20px;
            list-style-type: disc;
            font-size: 30px;
            color: @topicDeepBColor;
            &>span{
                font-size: 18px;
                color: @deepFontColor;
            }
            .announceTitle{
                cursor: pointer;
            }
            .publishTime{
                float:right;
                color: @shallowFontColor;
            }
        }
    }
    .pageTurn{
        text-align: center;
        span{
            padding: 8px 12px;
            margin: 0px 6px;
            font-size: 24px;
            color: @topicDeepBColor;
            cursor: pointer;
        }
        .currentPage{
            color: #fff;
            background-color: @topicDeepRColor;
        }
        .disabeldHan{
            color: @deepFontColor;
        }
    }
}
</style>
