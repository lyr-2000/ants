<template>
    <div class="announce">
        <img src="../../img/index/tongzhi.png">
        <p>
            <strong>公告</strong>
            <a :href="[`announce.html?id=${announcement.annId}`]" class="announceContent">{{announcement.annTitle}}</a>
            <span class="announceTime">{{announcement.annTime}}</span>
        </p>
        <a href="#" class="moreAnnounce">更多</a>
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
@toppicColor:#5d759d;
@fontColor:#666;
@fontHoverColor:#333;
.announce{
        position: relative;
        border-bottom: 1px solid rgba(121,121,121,.6);
        color: @fontColor;
        >img{
            float: left;
            width: 22px;
            height: 22px;
            margin-right: 10px;
        }
        .moreAnnounce{
            position:absolute;
            top: 0px;
            right: 0px;
            &:hover{
                color: @toppicColor;
            }
        }
        p{
            margin-bottom: 0px;
            .announceContent{
                display: inline-block;
                width: 500px;
                margin-left: 50px;
                font-size: 14px;
                overflow:hidden;
                white-space: nowrap;
                text-overflow:ellipsis;
                color: @fontColor;
                &:hover{
                    color: @fontHoverColor;
                }
            }
            .announceTime{
                margin-left: 20px;
                font-size: 14px;
            }
        }
    }

</style>

