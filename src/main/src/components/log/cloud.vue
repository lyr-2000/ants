<template>
    <!-- 云层图 -->
        <div class="cloud">
            <img src="../../img/log/behindCloud.png">
            <img src="../../img/log/middleCloud.png">
            <img src="../../img/log/frontCloud.png">
        </div>
</template>

<script>
export default {

}
</script>

<style lang="less" scoped>
// 云图
.cloud{
    position: fixed;
    bottom: -10px;
    width: 120%;
    img{
        position: absolute;
        bottom: -20px;
        left: -30px;
        width: 100%;
        animation: mCloudMove 20s linear 0s infinite none;
        &:first-child{
            left: -40px;
            bottom: -30px;
            animation: bCloudMove 16s linear 0s infinite none;
        }
        &:last-child{
            left: -20px;
            bottom: -60px;
            animation: fCloudMove 24s linear 0s infinite none;
        }
    }
}

@keyframes fCloudMove{
    0%{
        left: -20px;
    }
    25%{
        left:-40px;
    }
    75%{
        left:0px;
    }
    100%{
        left:-20px
    }
}

@keyframes mCloudMove{
    0%{
        left: -30px;
    }
    25%{
        left:0px;
    }
    75%{
        left:-70px;
    }
    100%{
        left:-30px
    }
}

@keyframes bCloudMove{
    0%{
        left: -40px;
    }
    25%{
        left:-80px;
    }
    75%{
        left:0px;
    }
    100%{
        left:-40px
    }
}
</style>


