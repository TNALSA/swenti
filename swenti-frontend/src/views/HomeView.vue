<template>
  <div class="homeview">
    <section class="py-5 text-center container">
      <div class="row py-lg-5">
        <div class="col-lg-6 col-md-8 mx-auto">
          <h1 class="fw-light">Welcome to Swenti</h1>
          <p class="lead text-body-secondary">Something short and leading about the collection below—its contents, the creator, etc. Make it short and sweet, but not too short so folks don’t simply skip over it entirely.</p>
<!--          <p>-->
<!--            <a href="#" class="btn btn-primary my-2">Main call to action</a>-->
<!--            <a href="#" class="btn btn-secondary my-2">Secondary action</a>-->
<!--          </p>-->
        </div>
      </div>
    </section>

    <div class="album py-5 bg-body-tertiary">
      <div class="container">
        <h4 style="font-weight: bold; color: #42b983">오늘의 헤드라인 뉴스</h4>
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
          <Card v-for="article in articles" :key="article" :article="article"/>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import Card from "@/components/Card.vue";
  import axios from "axios";
  import {useRouter} from "vue-router";
  import {onMounted, ref} from "vue";

  export default {
    name: 'HomeView',
    components: {Card},
    setup(){
      const articles = ref([]);
      const router = useRouter();

      onMounted(() => {
        axios.get("http://localhost:8080/lookup/v1").then(response => {

          console.log(response.data);
          articles.value = response.data;

          router.push("/")
        }).catch(error => {
          console.error("[Error]",error)
        });
      });

      return { articles };
    }
  }
</script>

<style>

</style>