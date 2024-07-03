<template>
  <div class="article-container">
    <section class="article-header">
      <div class="article-title">
        <h1>{{ info.title }}</h1>
      </div>
      <div class="article-meta">
        <small>{{ info.writer }}</small>
        <small>{{ formattedDate }}</small>
      </div>
    </section>
    <section class="article-content">
<!--      <img v-if="image['image1']" :src="image['image1']" alt="Article Image" height="225" width="100%"/>-->
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
      info: {}, // 객체 형태로 초기화
      formattedDate: '', // String 형태로 초기화
    };
  },
  mounted() {
    const cur_articleId = this.cur_articleId;
    const router = useRouter();
    console.log("요청하신 글 번호: ", cur_articleId);

    axios.get(`http://localhost:8080/lookup/details/${cur_articleId}`).then(response => {
      console.log("응답받은 데이터: ", response.data);
      this.info = response.data.article;
      this.formattedDate = this.formatDate(this.info.writed_date);
      router.push(`/article/${cur_articleId}`);
    }).catch(error => {
      console.error("[Error]", error);
    });
  },
  methods: {
    formatDate(dateString) {
      const date = new Date(dateString);
      const year = date.getFullYear();
      const month = date.getMonth() + 1; // 월은 0부터 시작하므로 +1 필요
      const day = date.getDate();
      const hours = date.getHours();
      const minutes = date.getMinutes();
      const seconds = date.getSeconds();

      return `${year}년 ${month}월 ${day}일 ${hours}시 ${minutes}분 ${seconds}초`;
    }
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
