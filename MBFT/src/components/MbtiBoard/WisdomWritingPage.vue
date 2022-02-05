<template>
  <div class="wisdomWritingPage">
    <wisdomHeader></wisdomHeader>
    <wisdomWritingForm></wisdomWritingForm>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import wisdomWritingForm from "./WisdomWritingForm.vue";
import wisdomHeader from "../Header/Header.vue";

@Component({
  components: {
    wisdomHeader,
    wisdomWritingForm,
  },
})
export default class WisdomWritingPage extends Vue {}
</script>
