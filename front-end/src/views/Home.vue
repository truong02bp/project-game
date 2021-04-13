<template>
  <div class="home">
    <Header/>
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js + TypeScript App"/>
  </div>
</template>

<script lang="ts">
import Vue from 'vue';
import HelloWorld from '@/components/HelloWorld.vue'; // @ is an alias to /src
import Header from '@/views/Header.vue'; // @ is an alias to /src
export default Vue.extend({
  name: 'Home',
  components: {
    HelloWorld,Header,
  },
});
</script>
