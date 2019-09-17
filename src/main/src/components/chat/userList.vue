<template>
    <div class="userList">
        <div class="myInfo">
            <img :src="myIntro.portrait">
            <span class="userName">{{myIntro.userName}}</span>
        </div>
        <div class="otherInfo">
            <div v-for="user in userList" 
                :class="{'detailInfo':true,'chooseInfo':chooseUser.contactor===user.contactor}"
                @click="chooseChange(user)">
                <img :src="user.contactorAvatar">
                <span class="userName">{{user.contactorName}}</span>
                <span class="chatTime">{{user.latestTime | timeChange}}</span>
            </div>
        </div>
    </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex"

export default {
    data(){
        return{
            
        }
    },
    methods:{
        ...mapActions('chat',{
            chooseChange:"chooseChange"
        }),
        // 获取聊天信息
        getNewsList(){
            console.log(111)
            let data={
                type:0,
                id:this.myIntro.studentId,
                business:this.chooseUser.contactor,
            }
            console.log('data: ', data);
            this.onSend({data,file:""})
            
        }
    },
    computed:{
        ...mapGetters("user",{
            myIntro:"getUser"
        }),
        ...mapGetters("chat",{
            userList:"getUserList",
            chooseUser:"getChooseUser"
        })
    },
    filters:{
        timeChange(data){
            let dateArr=data.split('/');
            let year=dateArr[0];
            let month=dateArr[1];
            let day=dateArr[2];
            return `${month}-${day}`
        }
    },
    mounted(){
        this.chooseChange(this.userList[0]);
    }
}
</script>

<style lang="less">
@import '../../assets/less/define.less';

.userList{
    width: 300px;
    height: 100%;
    @imgLength:60px;
    background-color: @chatHalfBcolor;
    .myInfo{
        display: flex;
        align-items: center;
        background-color: @topicDeepBColor;
        img{
            width: @imgLength;
            height: @imgLength;
            margin: 10px 15px 10px 20px;
        }
    }
    .otherInfo{
        .detailInfo{
            display: flex;
            align-items: center;
            cursor: pointer;
            img{
                width: @imgLength;
                height: @imgLength;
                margin: 10px 20px;
            }
            .userName{
                display: inline-block;
                width: 120px;
            }
            .chatTime{
                color: @deepFontColor;
            }
        }
        .chooseInfo{
            border-left: 4px solid @topicDeepBColor;
            background-color: @chatDeepBColor;
            img{
                margin-left: 16px;
            }
        }
    }
    .userName{
        font-size: 20px;
        color: #fff;
    }
}
</style>
