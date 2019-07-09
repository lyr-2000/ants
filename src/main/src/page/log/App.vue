<template>
  <div id="app">
    <TopTitle :productName="productName"></TopTitle>
    <Star></Star>
    <Sea></Sea>
    <Cloud></Cloud>
    <Inputcontainer :productName="productName"></Inputcontainer>
  </div>
</template>

<script>
import TopTitle from '../../components/log/topTitle.vue'
import Inputcontainer from '../../components/log/inputContainer.vue'
import Star from '../../components/log/star.vue'
import Sea from '../../components/log/sea.vue'
import Cloud from '../../components/log/cloud.vue'

export default {
  name: 'app',
  components: {
    Inputcontainer,
    TopTitle,
    Star,
    Sea,
    Cloud
  },
  data(){
    return{
      productName:'蚂蚁置物'
    }
  }
}
</script>

<style>
body{
    margin: 0px;
    padding: 0px;
    background: url('../../assets/img/log/blueBg.png');
    background-repeat: no-repeat;
    background-size: 100% 100%;
    background-attachment: fixed;
}

li{
    list-style: none;
}

input{
    outline: none;
}

button{
    outline: none;
    cursor: pointer;
}

[v-cloak] {
    display: none;
}

</style>
