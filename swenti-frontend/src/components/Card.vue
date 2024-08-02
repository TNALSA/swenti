<template>
  <div class="col">
    <div class="card shadow-sm">
      <img v-if="localArticle.images['image1']" :src="localArticle.images['image1']" alt="Article Image" height="225" width="100%"/>
      <img v-else src="https://img.freepik.com/premium-vector/default-image-icon-vector-missing-picture-page-website-design-mobile-app-no-photo-available_87543-11093.jpg" height="225"/>
      <div class="card-body">
        <div class="article-title">
          <router-link  :to="{ name: 'Article', params: { articleId: article.id}}" style="color: #007AFF; font-weight: bold">
            <a>{{ article.title }}</a>
          </router-link>
        </div>
        <div class="d-flex justify-content-between align-items-center">
          <small>{{ article.media }}</small>
          <small class="text-body-secondary">{{ formattedDate }}</small>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
  export default {
    name: 'Card',
    props: {
      article: {
        type: Object,
        required: true
      }
    },
    data() {
      return {
        localArticle: JSON.parse(JSON.stringify(this.article)), // 깊은 복사
        formattedDate: ''
      };
    },
    mounted() {
      if (typeof this.localArticle.images === 'string') {
        this.localArticle.images = JSON.parse(this.article.images);
        this.formattedDate = this.formatDate(this.article.writed_date)
      }
    },
    methods: {
      formatDate(dateString){
        const date = new Date(dateString);
        const year = date.getFullYear();
        const month = date.getMonth() + 1; // 월은 0부터 시작하므로 +1 필요
        const day = date.getDate();
        // const hours = date.getHours();
        // const minutes = date.getMinutes();
        // const seconds = date.getSeconds();

        return `${year}년 ${month}월 ${day}일`;
      }
    }

  }
</script>