<template>
  <div class="article-container">
    <section class="article-header">
      <div class="article-title">
        <h1>{{ info.title }}</h1>
      </div>
      <div class="article-meta">
        <small>{{ info.writer }}</small>
        <small>{{ info.writed_date }}</small>
      </div>
    </section>

    <section class="article-content">
      <p>{{ info.details }}</p>
    </section>
  </div>
</template>

<script>
import axios from "axios";
import { useRouter } from "vue-router";

export default {
  name: 'ArticleView',
  props: {
    articleId: {
      type: [String, Number], // 타입을 String 또는 Number로 변경
      required: true
    }
  },
  data() {
    return {
      cur_articleId: this.articleId,
      info: {}
    };
  },
  mounted() {
    const cur_articleId = this.cur_articleId;
    const router = useRouter();
    console.log("요청하신 글 번호: ", cur_articleId);

    axios.get(`http://localhost:8080/lookup/details/${cur_articleId}`).then(response => {
      console.log("응답받은 데이터: ", response.data);
      this.info = response.data.article;
      router.push(`/article/${cur_articleId}`);
    }).catch(error => {
      console.error("[Error]", error);
    });
  }
}
</script>

<style scoped>
.article-container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  font-family: Arial, sans-serif;
}

.article-header {
  border-bottom: 1px solid #ddd;
  margin-bottom: 20px;
}

.article-title h1 {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 10px;
}

.article-meta small {
  display: block;
  color: #888;
  margin-bottom: 5px;
}

.article-content p {
  font-size: 16px;
  line-height: 1.6;
}

.article-content {
  margin-top: 20px;
}
</style>
