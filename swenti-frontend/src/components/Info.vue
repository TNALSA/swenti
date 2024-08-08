<template>
  <info>
    <div class="container">
      <div class="card mb-4">
        <div class="card-header">
          <h4 class="m-0">사용자 정보</h4>
        </div>
        <div class="card-body">
          <form @submit.prevent="updateUserInfo">
            <div class="mb-3">
              <label for="username" class="form-label">이름</label>
              <p>{{ userInfo.username }}</p>
            </div>
            <div class="mb-3">
              <label for="birth" class="form-label">생년월일</label>
              <p>{{ userInfo.birth }}</p>
            </div>
            <div class="mb-3">
              <label for="contact" class="form-label">연락처</label>
              <input id="contact" type="tel" placeholder="{{ userInfo.contact }}" v-model="userInfo.contact" class="form-control"
                     pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" title="000-0000-0000의 형태로 입력해주세요."/>
            </div>
            <button type="submit" class="btn btn-primary">정보 수정</button>
          </form>
        </div>
      </div>
    </div>
  </info>
</template>
<script>
import {onMounted, ref} from "vue";
import axios from "axios";
import store from "@/scripts/store";

export default {
  name: 'Info',
  setup() {
    const userInfo = ref({
      username: '',
      birth: '',
      contact: ''
    });

    const prevContact = ref('');

    onMounted(() => {
      // 사용자 정보를 가져오는 API 호출
      axios.get('http://localhost:8080/info',{ params: {userid : store.state.account.id}})
          .then(response => {
            userInfo.value.username = response.data.user.name;
            const date = new Date(response.data.user.birth);
            // userInfo.value.birth = response.data.user.birth;
            userInfo.value.birth = `${date.getFullYear()}년 ${date.getMonth()+1}월 ${date.getDate()}일`
            userInfo.value.contact = response.data.user.phone;

            prevContact.value = response.data.user.phone;
          })
          .catch(error => {
            console.error("[Error]", error);
          });
    });

    const updateUserInfo = () => {
      if(userInfo.value.contact === prevContact.value){
        alert('변경된 정보가 없습니다.')
        return;
      }
      // 사용자 정보 수정 API 호출
      axios.put('http://localhost:8080/info/update',
          {
            userid: store.state.account.id,
            contact: userInfo.value.contact
          })
          .then(response => {
            console.log(response.data);
            alert('정보가 수정 되었습니다.');
            window.location.reload();
          })
          .catch(error => {
            console.error("[Error]", error);
          });
    };
    return { userInfo, updateUserInfo };
  }
}
</script>

<style>
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