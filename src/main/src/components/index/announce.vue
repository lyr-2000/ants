<template>
    <div class="announce">
        <img src="../../assets/img/index/tongzhi.png">
        <p>
            <strong>公告</strong>
            <router-link :to="`announce?id=${announcement.annId}`" class="announceContent">{{announcement.annTitle}}</router-link>
            <span class="announceTime">{{announcement.annTime}}</span>
        </p>
        <router-link to="announce" class="moreAnnounce">更多</router-link>
    </div>
</template>

<script>
export default {
    data(){
        return{
            announcement: {
                annTitle: '蚂蚁置物上线:一个专注于校园二手租赁，方便学生教师闲置物品出售购入平台',
                annTime: '2019-5-10',
                annId: '',
            }
        }
    }
}
</script>

<style lang="less" scoped>
@import "../../assets/less/define.less";
@topicDeepBColor:#5d759d;
@fontColor:#666;
@fontHoverColor:#333;
.announce{
        position: relative;
        border-bottom: 1px solid rgba(121,121,121,.6);
        color: @fontColor;
        >img{
            float: left;
            width: 24x;
            height: 24px;
            margin:0px 24px 0px 32px;
        }
        .moreAnnounce{
            position:absolute;
            top: 0px;
            right: 0px;
            &:hover{
                color: @topicDeepBColor;
            }
        }
        p{
            margin-top: 42px;
            margin-bottom: 0px;
            font-size: 18px;
            strong{
                position: relative;
                bottom: 3px;
                font-size: 20px;
            }
            .announceContent{
                display: inline-block;
                width: 647px;
                margin-left: 58px;
                overflow:hidden;
                white-space: nowrap;
                text-overflow:ellipsis;
                color: @fontColor;
                &:hover{
                    color: @fontHoverColor;
                }
            }
            .announceTime{
                position: relative;
                bottom: 3px;
                margin-left: 20px;
            }
        }
    }

</style>

