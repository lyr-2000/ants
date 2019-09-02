<template>
    <div class="myData">
        <p class="title">我的资料</p>
        <ul class="information">
            <li>
                <span class="infoLabel">头像</span>
                <div class="userImg">
                    <img :src="avatar==''?user.portrait:avatar">
                    <span>编辑</span>
                    <input type="file" @change="avatarUpload($event)">
                </div>
            </li>
            <li>
                <span class="infoLabel">昵称</span>
                <input type="text" v-model="user.userName">
            </li>
            <li>
                <span class="infoLabel">手机号码</span>
                <input type="text" v-model="user.mobilePhone">
            </li>
            <li>
                <span class="infoLabel">交易地址</span>
                <input type="text" v-model="user.address">
            </li>
            <li>
                <span class="infoLabel">微信号</span>
                <input type="text" v-model="user.userWechat">
            </li>
            <li>
                <span class="infoLabel">QQ号</span>
                <input type="text" v-model="user.userQQ">
            </li>
            <li>
                <span class="infoLabel"></span>
                <button class="saveBtn" @click="updateData()">确认保存</button>
            </li>
        </ul>
    </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex"

export default {
    data(){
        return{
            avatar:'',
            imgData:null
        }
    },
    computed:{
        ...mapGetters("user",{
            user:"getUser"
        })
    },
    methods:{
        ...mapActions("user",["saveStuMsg","uploadAvatar","formatFileSize"]),
        // 头像上传
        avatarUpload(e){
            let aFiles = e.target.files;
            let len = aFiles.length;
            let item = {
                name: aFiles[0].name,
                uploadPercentage: 1,
                // size: this.formatFileSize(aFiles[0].size, 0)
            }
            let reader=new FileReader();
            reader.readAsDataURL(aFiles[0]);
            reader.onload=e=>{
                this.avatar=e.currentTarget.result;
                console.log('this.result: ', e.currentTarget.result);
            }
            let param = new FormData();
            param.append("name","avatar");
            param.append("file",aFiles[0]);
            this.uploadAvatar(param);
            this.imgData=param;
        },
        // 提交个人资料
        updateData(){
            let data=user;
            if(this.imgData!==null){
                data.portrait=this.imgData;
            }
            saveStuMsg(data);
        }
    }
}
</script>

<style lang="less" scoped>
@import '../../../assets/less/define.less';

.myData{
    .title{
        padding: 41px 0px 38px 40px;
        border-left: 10px solid @topicDeepBColor;
    }
    .information{
        display: flex;
        flex-direction: column;
        margin:50px 0px 0px 89px;
        font-size: 18px;
        color: @deepFontColor;
        li{
            display: flex;
            flex-direction: row;
            align-items: center;
            margin-bottom: 26px;
            .infoLabel{
                display: inline-block;
                width: 150px;
            }
            input{
                width: 400px;
                height: 40px;
                border:none;
                outline: none;
                text-indent:20px;
                font-size: 18px;
                color: @deepFontColor;
                background-color: @borderColor;
            }
            .userImg{
                position: relative;
                @ImgLength:75px;
                width: @ImgLength;
                height:@ImgLength;
                img{
                    width: 100%;
                    height: 100%;
                }
                span{
                    display: none;
                    position: absolute;
                    left:0px;
                    bottom: 0px;
                    padding: 9px 22px 10px 21px;
                    font-size: 14px;
                    background-color: @borderColor;
                    cursor: pointer;
                }
                &:hover span{
                    display: inline;
                }
                input[type="file"]{
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 100%;
                    height: 100%;
                    border-radius: 50%;
                    opacity: 0;
                    cursor: pointer;
                }
            }
            .saveBtn{
                padding: 11px 60px;
                border: none;
                outline: none;
                font-size: 18px;
                color: #fff;
                background-color: @topicDeepBColor;
                cursor: pointer;
            }
        }
    }
}
</style>
