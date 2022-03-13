<template>
  <div class="wisdomBoard">
    <wisdomHeader></wisdomHeader>
    this is {{ board.boardName }} page

    <div>
      <b-table :fields="fields" :items="writings"></b-table>
    </div>
  </div>
</template>

  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import wisdomHeader from "../Header/MainHeader.vue";
//import wisdomBoardIntro from "./WisdomBoardIntro.vue";
import AxiosService from "../../service/axios.service";
import axios from "axios";

export default Vue.extend({
  data() {
    return {
      board: {},
      writings: [],
    };
  },
  components: {
    wisdomHeader,
    //wisdomBoardIntro,
  },
  methods: {},
  async mounted() {
    const boardResponse = await AxiosService.Instance.get(
      `/mbtis/${this.$route.params.id}/v1`
    );
    this.board = boardResponse.data;

    const writingResponse = await AxiosService.Instance.get(
      `/writings/${this.$route.params.id}/v1`
    );
    this.writings = writingResponse.data;
    console.log(this.writings);
  },
});
</script>
