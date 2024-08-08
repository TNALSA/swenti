<template>
    <div class="card-container">
      <div class="card-image">
        <img v-if="localArticle.images['image1']" :src="localArticle.images['image1']" alt="Article Image" height="100" width="150"/>
        <img v-else src="https://img.freepik.com/premium-vector/default-image-icon-vector-missing-picture-page-website-design-mobile-app-no-photo-available_87543-11093.jpg" height="225"/>
      </div>
      <div class="card-body">
        <div class="article-title" style="padding-bottom: 20px">
          <router-link  :to="{ name: 'Article', params: { articleId: bookmark.id}}" style="color: #007AFF; font-weight: bold">
            <a>{{ bookmark.title }}</a>
          </router-link>
        </div>
        <div class="d-flex justify-content-between align-items-center">
          <small>{{bookmark.media}}</small>
          <small class="text-body-secondary">{{ formattedDate }}</small>
        </div>
      </div>
    </div>
</template>
<script>
export default {
  name: 'BookmarkCard',
  props: {
    bookmark:{
      type: Object,
      required: true
    }
  },
  data() {
    return {
      localArticle: JSON.parse(JSON.stringify(this.bookmark)), // 깊은 복사
      formattedDate:''
    };
  },
  mounted() {
    if (typeof this.localArticle.images === 'string') {
      this.localArticle.images = JSON.parse(this.bookmark.images);
      this.formattedDate = this.formatDate(this.bookmark.writed_date)
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
<style>
.card-container {
  display: flex;
}
</style>