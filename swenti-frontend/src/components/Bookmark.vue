<template>
  <bookmark>
    <div class="container">
      <div class="card mb-4">
        <div class="card-header">
          <h4 class="m-0">북마크 한 기사</h4>
        </div>
        <div class="card-body">
        </div>
      </div>
    </div>
  </bookmark>
</template>
<script>
export default {
  name: 'Bookmark'
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