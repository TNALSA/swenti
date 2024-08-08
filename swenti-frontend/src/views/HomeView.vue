<template>
  <div class="homeview">
    <section class="py-5 text-center container">
      <div class="row py-lg-5">
        <div class="col-lg-6 col-md-8 mx-auto">
          <h1 class="fw-light">Welcome to Swenti</h1>
          <p class="lead text-body-secondary">매일 IT 최신 뉴스를 받아보세요.</p>
        </div>
      </div>
    </section>

    <div class="album py-5 bg-body-tertiary">
      <div class="container">
        <h4 style="font-weight: bold; color: #007AFF">오늘의 헤드라인 뉴스</h4>

        <!-- 버튼을 감싸는 div 추가 -->
        <div class="button-group mb-4">
          <button @click="fetchArticles('네이버')" class="btn btn-primary">네이버</button>
          <button @click="fetchArticles('다음')" class="btn btn-secondary">다음</button>
        </div>

        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4 g-3">
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
      axios.get("http://localhost:8080/article/lookup/v2").then(response => {
        articles.value = response.data.articles;
        router.push("/")
      }).catch(error => {
        console.error("[Error]",error)
      });
    });

    const fetchArticles = (site) => {
      axios.post(`http://localhost:8080/article/lookup/v3/${site}`)
          .then(response => {
            articles.value = response.data.articles;
            router.push("/");
          })
          .catch(error => {
            console.error("[Error]", error);
          });
    };

    return { articles, fetchArticles };
  },
}
</script>

<style>
.button-group {
  margin: 20px 0; /* 버튼 그룹과 뉴스 사이 여백 */
}

.btn {
  margin: 0 10px; /* 버튼 사이 여백 */
  padding: 10px 20px; /* 버튼 패딩 */
  font-size: 16px; /* 버튼 글자 크기 */
  border-radius: 5px; /* 버튼 모서리 둥글게 */
}

.btn-primary {
  background-color: #007bff; /* 기본 버튼 색상 */
  color: white; /* 글자 색상 */
}

.btn-secondary {
  background-color: #6c757d; /* 보조 버튼 색상 */
  color: white; /* 글자 색상 */
}
</style>
