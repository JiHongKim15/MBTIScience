<template>
    <div>
        <h1> {{ mainBoard.title }} </h1>

        <div style = "text-align: right;">
            <h6> {{mainBoard.writer}} </h6>
            <h6> {{mainBoard.writeTime}}</h6>
        </div>

        <p> {{mainBoard.content}} </p>

        <button @click="mainBoardDelete">delete</button>
    </div>
</template>

<script lang = "ts">
import Vue from 'vue';
import AxiosService from '../../service/axios.service';

export default Vue.extend({
    data() {
        return {
            mainBoard: Object,
        };
    },
    methods: {
        async mainBoardDelete(){
             const response = await AxiosService.Instance.delete('/v1', {
                params: {
                    mainBoardNum: this.$route.params.mainBoardNum
                }
            });

            this.$router.go(-1);
        }
    },
    async mounted() {
        
        const response = await AxiosService.Instance.get('/v1/detail', {
            params: {
                mainBoardNum: this.$route.params.mainBoardNum
            }
        });
        
        this.mainBoard = response.data;
        
    }
    
});
</script>

<style>
@import "../../assets/css/main.css"
/*
@import "../../assets/js/main.js";
*/
</style>