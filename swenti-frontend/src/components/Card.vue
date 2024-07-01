<template>
  <div class="col">
    <div class="card shadow-sm">
      <img :src="localArticle.images['image1']" alt="Article Image" height="225" width="100%"/>
      <div class="card-body">
        <div class="article-title">
<!--          <a class="card-text" style="color: #42b983; font-weight: bold">{{ article.title }}</a>-->
          <router-link :to= "{ name: 'Article', params: { article: article }}" style="color: #42b983; font-weight: bold">{{ article.title }}</router-link>
        </div>
        <div class="d-flex justify-content-between align-items-center">
          <small>{{ article.media }}</small>
          <small class="text-body-secondary">{{ article.writed_date }}</small>
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
        localArticle: JSON.parse(JSON.stringify(this.article)) // 깊은 복사
      };
    },
    mounted() {
      if (typeof this.localArticle.images === 'string') {
        this.localArticle.images = JSON.parse(this.article.images);
      }
    }
  }
</script>