<template>
    <div class="topBanner">
        <MenuWrap @show-detailed="showDetailed" :showDetialedClassify="showDetialedClassify" :projectName="projectName" :parentClassification="parentClassification" :childClassification="childClassification"></MenuWrap>
        <ImgPlayBox></ImgPlayBox>
    </div>
</template>

<script>
import MenuWrap from './menuWrap.vue'
import ImgPlayBox from './imgPlayBox.vue'

export default {
    data(){
        return{
            showDetialedClassify: false,
        }
    },
    components:{
        MenuWrap,
        ImgPlayBox
    },
    props:["projectName","parentClassification","childClassification"],
    methods:{
        showDetailed: function() {
            // 当没有该数据时请求该数据
            if (this.childClassification == []){
                this.$emit('concrete-request');
            }
            this.showDetialedClassify = !this.showDetialedClassify;
            console.log('this.showDetialedClassify: ', this.showDetialedClassify);

        }
    }
}
</script>

<style lang="less" scoped>

@topInputColor:rgba(246,146,138,.5);
@borderColor:rgba(102,102,102,.5);
@fontColor:#666;
@fontHoverColor:#333;
.topBanner{
    position: relative;
    color: @fontColor;
}
</style>
