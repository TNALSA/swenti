<template>
  <header data-bs-theme="dark">
    <div class="collapse navbar-custom" id="navbarHeader">
      <div class="container">
        <div class="row">
          <div class="col-sm-8 col-md-7 py-4">
            <h4 style="color: white">About</h4>
            <p class="text-body-secondary">Swenti is provide Daily Headline News about IT information at Naver, Daum News Website</p>
          </div>
          <div class="col-sm-4 offset-md-1 py-4">
            <h4 style="color: white">Other</h4>
            <ul class="list-unstyled">
              <li>
                <a href="/login" class="text-white" v-if="!$store.state.account.id">Login</a>
                <p class="text-body-secondary" v-else>{{$store.state.account.id}}님 환영합니다.</p>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <div class="navbar navbar-custom shadow-sm">
      <div class="container">
        <a href="/" class="navbar-brand d-flex align-items-center">
          <svg xmlns="http://www.w3.org/2000/svg" id="Layer_1" data-name="Layer 1" viewBox="0 -3 30 30" width="50" height="35">
            <path d="M24,22H0V5.5c0-1.93,1.57-3.5,3.5-3.5H20.5c1.93,0,3.5,1.57,3.5,3.5V22ZM3,19H21V5.5c0-.276-.224-.5-.5-.5H3.5c-.276,0-.5,.224-.5,.5v13.5ZM19,7h-7v5h7V7Zm-9,2H5v3h5v-3Zm9,5H5v3h14v-3Z"/>
          </svg>
          <strong>Swenti</strong>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      </div>
    </div>

  </header>
</template>
<script>
  export default {
    name: 'Header'
  }
</script>

<style>
.navbar-custom {
  background-color: #42b983; /* 사용자 정의 배경색 */
}

.navbar-custom .navbar-brand,
.navbar-custom .navbar-toggler {
  color: #ffffff; /* 텍스트 색상 */
}

.navbar-custom .navbar-toggler-icon {
  background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 30 30'%3E%3Cpath stroke='rgba%28255, 255, 255, 1%29' stroke-width='2' d='M4 7h22M4 15h22M4 23h22'/%3E%3C/svg%3E"); /* 아이콘 색상 */
}
</style>