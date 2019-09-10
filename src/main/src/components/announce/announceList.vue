<template>
    <div class="list">
        <h1>公告信息</h1>
        <ul>
            <li class="announceList" v-for="msg in announcementList">
                <span class="announceTitle" @click="readDetail(msg.annId)">{{msg.annTitle}}</span>
                <span class="publishTime">{{msg.annTime}}</span>
            </li>
        </ul>
        <p class="pageTurn">
            <span :class="['leftHan',currentPage==1?'disabeldHan':'']" @click="pageTurn(currentPage-1)"><</span>
            <span v-for="num in allPage" :class="['turnHan',currentPage==num?'currentPage':'']" @click="pageTurn(num)">{{num}}</span>
            <span :class="['rightHan',currentPage==allPage?'disabeldHan':'']" @click="pageTurn(currentPage+1)">></span>
        </p>
    </div>
</template>

<script>
import {mapGetters,mapActions} from 'vuex'
export default {
    data(){
        return{
            currentPage:1
        }
    },
    computed:{
        ...mapGetters('announce',{
            announcementList:"getAnnouncementList",
            allPage:"getAllPage"
        })
    },
    methods:{
        ...mapActions("announce",["getAnnList"]),
        pageTurn(num){
            if(num<1||num>this.allPage){
                return;
            }
            this.currentPage=num;
            this.getAnnList(this.currentPage);
        },
        readDetail(id){
            this.$emit("changeDetail",id)
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
