<template>
    <div class="topBanner">
        <MenuWrap @show-detailed="showDetailed" :showDetialedClassify="showDetialedClassify" :projectName="projectName"></MenuWrap>
        <ImgPlayBox></ImgPlayBox>
    </div>
</template>

<script>
import MenuWrap from './menuWrap.vue';
import ImgPlayBox from './imgPlayBox.vue';
import { mapGetters, mapActions } from "vuex";

export default {
    data(){
        return{
            showDetialedClassify: false,
        }
    },
    computed: mapGetters({
        parentClassification: "getParentClassification",
        childClassification:"getChildClassification"
    }),
    components:{
        MenuWrap,
        ImgPlayBox
    },
    props:["projectName"],
    methods:{
        ...mapActions(["concreteRequest"]),
        showDetailed: function() {
            // 当没有该数据时请求该数据
            if (this.childClassification == []){
                this.concreteRequest();
            }
            this.showDetialedClassify = !this.showDetialedClassify;
        }
    }
}
</script>

<style lang="less" scoped>

@topicShallowRColor:rgba(246,146,138,.5);
@borderColor:rgba(102,102,102,.5);
@fontColor:#666;
@fontHoverColor:#333;
.topBanner{
    position: relative;
    color: @fontColor;
}
</style>
