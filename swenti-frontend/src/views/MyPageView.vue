<template>
  <div class="mypage">
    <section class="py-5 text-center container">
      <div class="row py-lg-5">
        <div class="col-lg-6 col-md-8 mx-auto">
          <h1 class="fw-light">내 정보</h1>
          <p class="lead text-body-secondary">사용자 정보를 확인하고 수정하세요.</p>
        </div>
      </div>
    </section>

    <div class="container">
      <div class="card mb-4">
        <div class="card-header">
          <h4 class="m-0">사용자 정보</h4>
        </div>
        <div class="card-body">
          <form @submit.prevent="updateUserInfo">
            <div class="mb-3">
              <label for="username" class="form-label">이름</label>
              <input type="text" id="username" v-model="userInfo.username" class="form-control" required />
            </div>
            <div class="mb-3">
              <label for="email" class="form-label">생년월일</label>
              <input type="email" id="email" v-model="userInfo.email" class="form-control" required />
            </div>
            <div class="mb-3">
              <label for="bio" class="form-label">번호</label>
              <textarea id="bio" v-model="userInfo.bio" class="form-control" rows="3"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">정보 수정</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { ref, onMounted } from 'vue';
import axios from 'axios';

export default {
  name: 'MyPage',
  setup() {
    const userInfo = ref({
      username: '',
      email: '',
      bio: ''
    });

    onMounted(() => {
      // 사용자 정보를 가져오는 API 호출
      axios.get('http://localhost:8080/user/info')
          .then(response => {
            userInfo.value = response.data;
          })
          .catch(error => {
            console.error("[Error]", error);
          });
    });

    const updateUserInfo = () => {
      // 사용자 정보 수정 API 호출
      axios.put('http://localhost:8080/user/update', userInfo.value)
          .then(response => {
            console.log(response.data);
            alert('정보가 수정되었습니다.');
          })
          .catch(error => {
            console.error("[Error]", error);
          });
    };

    return { userInfo, updateUserInfo };
  },
}
</script>

<style>
.mypage {
  background-color: #f8f9fa; /* 배경색 */
  padding: 20px; /* 패딩 */
}

.card {
  border: 1px solid #dee2e6; /* 카드 테두리 색상 */
}

.card-header {
  background-color: #007bff; /* 카드 헤더 배경색 */
  color: white; /* 카드 헤더 글자색 */
}

.btn-primary {
  background-color: #007bff; /* 버튼 색상 */
  border: none; /* 버튼 테두리 제거 */
}
</style>
