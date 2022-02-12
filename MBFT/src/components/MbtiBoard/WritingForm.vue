<template>
  <div class="wisdomWritingForm">
    <b-form v-on:submit="submitForm">
      <b-form-input
        v-model="writingSubject"
        placeholder="제목을 입력하시오"
      ></b-form-input>
      <br />
      <b-form-textarea
        id="textarea"
        v-model="writingContent"
        placeholder="내용을 입력하시오"
        rows="20"
      ></b-form-textarea>
      <b-button type="submit" variant="primary">Submit</b-button>
    </b-form>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import axios from "axios";

export default Vue.extend({
  data: function () {
    return {
      writingSubject: "",
      writingContent: "",
    };
  },
  methods: {
    submitForm: function () {
      var url = "/write/v1";
      var writing = {
        writingSubject: this.writingSubject,
        writingContent: this.writingContent,
        boardId: this.$route.params.id,
        writerId: "wisdom123", //추후 수정
      };
      console.log(writing);
      axios
        .post(url, writing)
        .then(function (response) {
          console.log(response.data);
          location.href = "/";
        })
        .catch(function (error) {
          console.log(error);
        });
    },
  },
});
</script>
