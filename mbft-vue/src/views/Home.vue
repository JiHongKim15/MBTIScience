<template>
  <div class="home">
    <div class="Header">
      <MainHeader></MainHeader>
    </div>

    <div class ="Footer">
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import MainHeader from "../components/Header/MainHeader.vue";

@Component({
  components: {
    MainHeader,
  },
})
export default class Main extends Vue {}
</script>
