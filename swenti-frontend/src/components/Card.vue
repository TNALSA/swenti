<template>
  <div class="col">
    <div class="card shadow-sm">
      <img :src="localArticle.images['image1']" alt="Article Image" height="225" width="100%"/>
<!--      <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">-->
<!--        <title>Placeholder</title>-->
<!--&lt;!&ndash;        <rect width="100%" height="100%" fill="#55595c"/>&ndash;&gt;-->
<!--&lt;!&ndash;        <text x="50%" y="50%" fill="#eceeef" dy=".3em">{{localArticle.images["image1"]}}</text>&ndash;&gt;-->

<!--      </svg>-->
      <div class="card-body">
        <div class="article-title">
          <a class="card-text" style="color: #42b983; font-weight: bold" href="/article">{{ article.title }}</a>
<!--          <div>{{localArticle.images["image1"]}}</div>-->
        </div>
        <div class="d-flex justify-content-between align-items-center">
          {{ article.media }}
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
      console.log('Images:', this.article.images);
      if (typeof this.localArticle.images === 'string') {
        this.localArticle.images = JSON.parse(this.article.images);
      }
      console.log('Local Article:', this.localArticle);
      console.log('Images:', this.localArticle.images);
      if (this.localArticle.images) {
        const keys = Object.keys(this.localArticle.images);
        console.log('Keys in images:', keys);
        console.log('Image 1 exists:', keys.includes('image 1')); // 키 존재 여부 확인
        console.log('Image 1 value:', this.localArticle.images['image 1']); // 이미지 값 확인
      }
    }
  }
</script>