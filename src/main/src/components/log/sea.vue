<template>
    <!-- 海浪图 -->
        <div class="sea">
            <img src="../../img/log/seaBehind.png">
            <!-- 鱼 -->
            <div class="fish">
                <img src="../../img/log/fish1.png">
                <img src="../../img/log/fish2.png">
            </div>
            <!-- 漂浮蚂蚁图 -->
            <div class="ants">
                <img src="../../img/log/ants.png">
            </div>
            <img src="../../img/log/seaFront.png">
        </div>
</template>

<script>
export default {

}
</script>

<style lang="less" scoped>
// 蚂蚁图
.ants{
    position: fixed;
    left: 65%;
    bottom: 18%;
    img{
        width: 240px;
        transform:skewX(0deg);
        animation:antsMove 5s linear 0s infinite none;
    }
}

@keyframes antsMove{
    0%{
        transform: translateX(0%) skewX(0deg);
    }
    25%{
        transform: translateX(3%) skewX(2deg);
    }
    75%{
        transform: translateX(-3%) skewX(-2deg);
    }
    100%{
        transform: translateX(0%) skewX(0deg);
    }
}

// 海浪图
.sea{
    position: fixed;
    bottom: 0px;
    width: 1920px;
    >img{
        position: absolute;
        width: 100%;
        &:first-child{
            left: -20px;
            bottom: -150px;
            animation:bSeaMove 5s linear 0s infinite none;
        }
        &:last-child{
            left: -20px;
            bottom: -200px;
            animation:fSeaMove 5s linear 0s infinite none;
        }
    }
}

@keyframes fSeaMove{
    0%{
        left: -20px;
    }
    25%{
        left:0px;
    }
    75%{
        left:-40px;
    }
    100%{
        left:-20px;
    }
}

@keyframes bSeaMove{
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
        left:-20px;
    }
}

// 鱼
.fish{
    img{
        position: relative;
        left: 60%;
        transform: translateY(30px);
        &:first-child{
            animation: fFishJump 6s ease-in-out 5s infinite none;
        }
        &:last-child{
            animation: bFishJump 5s ease-in-out 3s infinite none;
        }
    }
}

@keyframes fFishJump{
    0%{
        transform: translateX(0px) translateY(30px) rotate(90deg);
    }
    50%{
        transform: translateX(-500px) translateY(-300px) rotate(30deg);
    }
    100%{
        transform: translateX(-1000px) translateY(30px) rotate(-30deg);
    }
}

@keyframes bFishJump{
    0%{
        transform: translateX(0px) translateY(30px) rotate(0deg);
    }
    50%{
        transform: translateX(-600px) translateY(-300px) rotate(-45deg);
    }
    100%{
        transform: translateX(-1200px) translateY(30px) rotate(-90deg);
    }
}
</style>

