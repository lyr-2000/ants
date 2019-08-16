<template>
    <div class="main">
        <div class="mainContent">
            <InfoNav :showIndex="showIndex" @turn-info="turnInfo"></InfoNav>
            <DetailContent :showIndex="showIndex"></DetailContent>
        </div>
    </div>
</template>

<script>
import InfoNav from './infoNav.vue'
import DetailContent from './detailContent.vue'

export default {
    data(){
        return{
            showIndex:0
        }
    },
    components:{
        InfoNav,
        DetailContent
    },
    methods:{
        turnInfo(index){
            this.showIndex=index;
        }
    }
}
</script>

<style lang="less" scoped>
@import "../../assets/less/define.less";
.main{
    width: 100%;
    height: 1207px;
    background-color: @borderColor;
    .mainContent{
        display:flex;
        margin: 0px auto;
        padding-top: 68px;
        width: 1520px;
    }
}
</style>
