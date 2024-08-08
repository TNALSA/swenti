<template>
  <div class="bookmark">
    <section class="py-5 text-center container">
      <a href="/mypage" type="button">내 정보</a>
      <a href="/bookmark" type="button">북마크</a>
    </section>
    <div class="container">
      <div class="card mb-4">
        <div class="card-header">
          <h4 class="m-0">북마크 한 기사</h4>
        </div>
        <div class="card-body">
          <bookmark-card v-for="bookmark in bookmarks" :key="bookmark" :bookmark="bookmark"/>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import {onMounted, ref} from "vue";
// import {useRouter} from "vue-router";
import axios from "axios";
import store from "@/scripts/store";
import BookmarkCard from "@/components/BookmarkCard.vue";

export default {
  name:'BookmarkView',
  components: {BookmarkCard},
  setup(){
    const bookmarks = ref([]);
    // const router = useRouter();
    onMounted(() => {
      axios.get("http://localhost:8080/lookup/bookmark", { params: {userid : store.state.account.id}}).
      then(response => {
        console.log("북마크:" + JSON.stringify(response.data.bookmarks));
        bookmarks.value = response.data.bookmarks;
      }).catch(error => {
        console.error("[Error]",error)
      });
    });

    return { bookmarks };
  },

}
</script>
<style>
.bookmark {
  background-color: #f8f9fa; /* 배경색 */
  padding: 50px; /* 패딩 */
  display: flex;
}
.bookmark section {
  width: 6%;
}

.bookmark a {
  font-weight: bold;
  border-radius: 5px;
  border: #007AFF;
}
</style>