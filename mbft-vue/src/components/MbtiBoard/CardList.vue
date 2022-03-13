<template>
    <div id = "graph">
        <div v-for = "(mainBoard, i) in mainBoardList" :key =i>
            <b-card
            border-variant="primary"
            tag="article"
            style="width: 98%; margin: 10px;"
            class="mb-2"
            @click="mainBoardDetail(mainBoard.mainBoardNum.toString())"
            >
                <b-card-title>
                    {{mainBoard.title}}
                </b-card-title>
                <b-card-text>
                    {{mainBoard.content}}
                    <br/>
                    {{mainBoard.writer}}
                </b-card-text>

            </b-card>
        </div>
    </div>
</template>

<script lang = "ts">
import Vue from 'vue';
import AxiosService from '../../service/axios.service';

export default Vue.extend({
    data() {
        return {
            mainBoardList: [],
        };
    },
    methods: {
        mainBoardDetail(mainBoardNum: string){
            
            this.$router.push({
                    path: this.$route.path + "/" + mainBoardNum,
            });
        }
    },
    async mounted() {
        const response = await AxiosService.Instance.get('/v1');
        this.mainBoardList = response.data;
    }
    
});
</script>