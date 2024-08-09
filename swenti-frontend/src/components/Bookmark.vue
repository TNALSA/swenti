<template>
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
</template>
<script>

import {defineComponent, onMounted, ref} from "vue";
import BookmarkCard from "@/components/BookmarkCard.vue";
import axios from "axios";
import store from "@/scripts/store";

export default defineComponent({
  components: {BookmarkCard},
  setup(){
    const bookmarks = ref([]);
    // const router = useRouter();
    onMounted(() => {
      axios.get("http://localhost:8080/bookmark/lookup", { params: {userid : store.state.account.id}}).
      then(response => {
        console.log("북마크:" + JSON.stringify(response.data.bookmarks));
        bookmarks.value = response.data.bookmarks;
      }).catch(error => {
        console.error("[Error]",error)
      });
    });

    return { bookmarks };
  },

})
</script>
<style>

.bookmark a {
  font-weight: bold;
  border-radius: 5px;
  border: #007AFF;
}
</style>