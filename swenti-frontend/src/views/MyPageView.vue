<template>
  <div class="mypage">
    <section class="py-5 text-center container">
      <button @click="showInfo" >내 정보</button>
      <button @click="showBookmark">북마크</button>
    </section>
    <info v-if="currentView === 'info'"/>
    <bookmark v-if="currentView === 'bookmark'"/>
  </div>
</template>

<script>
import { ref } from 'vue';
// import Info from "@/components/Info.vue";

import Bookmark from "@/components/Bookmark.vue";
import Info from "@/components/Info.vue";

export default {
  name: 'MyPage',
  components: {Info, Bookmark},
  setup() {
    const currentView = ref('info');

    const showInfo = () => {
      currentView.value = 'info';
    };

    const showBookmark = () => {
      currentView.value = 'bookmark';
    };

    return { currentView, showInfo, showBookmark };
  },
  data() {
    return{
      prevContact: ''
    }
  },
}
</script>

<style>
.mypage {
  background-color: #f8f9fa; /* 배경색 */
  padding: 50px; /* 패딩 */
  display: flex;
}

.mypage section {
  width: 6%;
}

.mypage a {
  font-weight: bold;
  border-radius: 5px;
  border: #007AFF;
}

.card {
  border: 1px solid #dee2e6; /* 카드 테두리 색상 */
}

.card-header {
  background-color: #007bff; /* 카드 헤더 배경색 */
  color: white; /* 카드 헤더 글자색 */
}

.card label {
  font-weight: bold;
  font-size: large;
}

.card p {
  font-style: italic;
  color: #888888;
}

.btn-primary {
  background-color: #007bff; /* 버튼 색상 */
  border: none; /* 버튼 테두리 제거 */
}
</style>
