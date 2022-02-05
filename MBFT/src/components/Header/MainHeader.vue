<template>
  <div>
    <b-navbar type="dark" variant="dark">
      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item href="#">MBTIBoard</b-nav-item>

          <b-nav-item href="#">Profile</b-nav-item>

          <b-nav-item href="#">Sign Up</b-nav-item>
        </b-navbar-nav>

        <b-navbar-nav class="ml-auto">
          <b-nav-form>
            <b-form-input class="mr-sm-2" placeholder="Search"></b-form-input>
            <b-button class="my-2 my-sm-0" type="submit">Search</b-button>
          </b-nav-form>
        </b-navbar-nav>
        <!-- Navbar dropdowns -->
        <b-navbar-nav class="ml-auto">
          <b-nav-item-dropdown text="MBTI">
            <b-dropdown-item v-for="board in boards" :key="board.boardId"
              ><router-link :to="`/wisdom-board/${board.boardId}`">{{
                board.boardName
              }}</router-link></b-dropdown-item
            >
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script lang="ts">
import { Vue } from "vue-property-decorator";
import AxiosService from "../../service/axios.service";

export default Vue.extend({
  data() {
    return {
      boards: [],
    };
  },
  async mounted() {
    const response = await AxiosService.Instance.get("/mbtis/v1");
    this.boards = response.data;
  },
});
</script>
