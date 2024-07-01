<template>
  <div>
    <h1> ArticleView 입니다. </h1>
    <p>{{ article }}</p>
  </div>
</template>

<script>
export default {
  name: 'ArticleView',
  props: {
    article: {
      type: Object,
      required: true
    }
  }
  }
</script>