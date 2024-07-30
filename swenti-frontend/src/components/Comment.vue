<template>
    <div class="comment-box" >
      {{ comment.details }}
      <div class="comment-date-writer">
        <small>{{comment.date}}</small>
        <small>{{comment.writer}}</small>
<!--        유저 확인 후 삭제 버튼 활성화 -->
        <small v-if="$store.state.account.id == comment.writer" @click="deleteComment(comment.commentid)" ><a>삭제</a></small>
      </div>
    </div>
</template>
<script>
  import axios from "axios";

  export default {
    name: 'Comment',
    props: {
      comment: {
        type: Object,
        required: true
      }
    },
    methods: {
     deleteComment(commentId) {
       axios.delete("http://localhost:8080/comment/delete",{
         params : {
           commentId : commentId
         }
       }).then(response => {
         console.log(response.data.comments);
         alert(response.data.comments);
         this.reRender();
       });
     },
      reRender(){
        window.location.reload();
      }
    }
  }
</script>
<style>
  .comment-box {
    border: 1px solid #42b983 ;
    border-radius: 10px / 10px ;
    height: 90px;
    padding: 15px;
  }
  .comment-date-writer {
    padding-top: 20px;
    padding-right: 20px;
    display: flex;
    justify-content: space-between;
    color: #888888;
  }
</style>
<script setup>
</script>