<template>
  <div class="article-container">
    <section class="article-header">
      <div class="article-title">
        <h1>{{ info.title }}</h1>
      </div>
      <div class="article-spec">
        <div class="article-meta">
          <small>{{ info.writer }}</small>
          <small>{{ formattedDate }}</small>
        </div>
        <div v-if="$store.state.account.id" class="article-bookmark" @click="bookMark">
          <i :class="['fas', 'fa-bookmark', { 'active': isBookmarked }]"></i>
        </div>
      </div>
    </section>
    <section class="article-content">
      <p>{{ info.details }}</p>
    </section>
    <section v-if="$store.state.account.id" class="comment-input">
      <textarea v-model="comment" placeholder="댓글을 입력 해 주세요."></textarea>
      <button @click="submitComment">입력</button>
    </section>
    <small v-else>로그인을 통해 댓글을 작성해보세요.</small>
  </div>
  <div class="article-container">
    <section>
      <div class="comment-area">
        <Comment v-for="comment in comments" :key="comment" :comment="comment"/>
      </div>
    </section>
  </div>
</template>

<script>
import axios from "axios";
import { useRouter } from "vue-router";
import store from "@/scripts/store";
import Comment from "@/components/Comment.vue";

export default {
  name: 'ArticleView',
  components: { Comment },
  props: {
    articleId: {
      type: [String, Number],
      required: true
    }
  },
  data() {
    return {
      cur_articleId: this.articleId,
      info: {},
      comments: [],
      formattedDate: '',
      comment: '',
      isBookmarked: false // 북마크 상태를 저장할 변수
    };
  },
  mounted() {
    const cur_articleId = this.cur_articleId;
    const router = useRouter();
    console.log("요청하신 글 번호: ", cur_articleId);
    axios.get(`http://localhost:8080/lookup/details/${cur_articleId}`).then(response => {
      this.info = response.data.article;
      this.comments = response.data.comments;
      this.formattedDate = this.formatDate(this.info.writed_date);

      // 북마크 설정 여부 조회
      if(store.state.account.id){
        axios.get(`http://localhost:8080/isBookmark/${cur_articleId}/${store.state.account.id}`).then(response => {
          this.isBookmarked = response.data;
        }).catch(error => {
          console.error("[Error]",error);
        })
      }

      router.push(`/article/${cur_articleId}`);
    }).catch(error => {
      console.error("[Error]", error);
    });
  },
  methods: {
    formatDate(dateString) {
      const date = new Date(dateString);
      const year = date.getFullYear();
      const month = date.getMonth() + 1;
      const day = date.getDate();
      const hours = date.getHours();
      const minutes = date.getMinutes();
      const seconds = date.getSeconds();

      return `${year}년 ${month}월 ${day}일 ${hours}시 ${minutes}분 ${seconds}초`;
    },
    submitComment() {
      if (this.comment.trim() === '') {
        alert('댓글을 입력해주세요.');
        return;
      }
      axios.post(`http://localhost:8080/comment/write`, {
        articleid: this.cur_articleId,
        writer: store.state.account.id,
        comment: this.comment
      }).then(response => {
        console.log("댓글이 성공적으로 등록되었습니다:", response.data);
        this.comment = '';
        this.reRender();
      }).catch(error => {
        console.error("[Error]", error);
      });
    },
    reRender() {
      window.location.reload();
    },
    bookMark() {
      if(!this.isBookmarked){
        // 북마크 설정
        axios.post('http://localhost:8080/setting/bookmark', {
          articleid: this.cur_articleId,
          userid: store.state.account.id
        }).catch(error => {
          console.error("[Error]", error);
        });
      }else{
        console.log("[isBookmarked]: "+this.isBookmarked);
        // 북마크 설정 해제
        axios.delete(`http://localhost:8080/clear/bookmark/${this.cur_articleId}/${store.state.account.id}`).then(response =>{
          console.log(response.data);
        }).catch(error => {
          console.error("[Error]",error)
        })
      }
      this.reRender();
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

.article-spec {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.article-bookmark {
  color: #888;
  margin-left: 10px;
  cursor: pointer; /* 포인터 커서 추가 */
}

.article-bookmark i {
  font-size: 20px; /* 아이콘 크기 */
}

.article-bookmark i.active {
  color: yellow; /* 북마크 활성화 시 색상 */
}

.comment-input {
  margin-top: 20px;
  display: flex;
}

.comment-input textarea {
  width: 100%;
  padding: 10px;
  font-size: 14px;
  border: 1px solid #ddd;
  border-radius: 4px;
  resize: none;
  margin-bottom: 10px;
}

.comment-input button {
  display: block;
  width: 20%;
  padding: 10px;
  background-color: #007AFF;
  color: white;
  border: none;
  border-radius: 4px;
  font-size: 16px;
  cursor: pointer;
  height: 63px;
}

.comment-input button:hover {
  background-color: dodgerblue;
}

.comment-area {
  display: grid;
  margin-bottom: 10px;
}
</style>
