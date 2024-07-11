<template>
    <div class="comment-box" >
      {{ comment.details }}
      <div class="comment-date-writer">
        <small>{{comment.date}}</small>
        <small>{{comment.writer}}</small>
      </div>
    </div>
</template>
<script>
  export default {
    name: 'Comment',
    props: {
      comment: {
        type: Object,
        required: true
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