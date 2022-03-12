<template>
  <div class="writingPage">
    <writingForm></writingForm>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import writingForm from "./WritingForm.vue";

@Component({
  components: {
    writingForm,
  },
})
export default class writingPage extends Vue {}
</script>
