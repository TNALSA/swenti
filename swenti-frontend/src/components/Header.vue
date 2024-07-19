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
            <a v-if="$store.state.account.id" @click="logout" style="color: white">Logout</a>
          </div>
        </div>
      </div>
    </div>
    <div class="navbar navbar-custom shadow-sm">
      <div class="container">
        <a href="/" class="navbar-brand d-flex align-items-center">
<!--          <svg xmlns="http://www.w3.org/2000/svg" id="Layer_1" data-name="Layer 1" viewBox="0 -3 30 30" width="50" height="35">-->
<!--            <path d="M24,22H0V5.5c0-1.93,1.57-3.5,3.5-3.5H20.5c1.93,0,3.5,1.57,3.5,3.5V22ZM3,19H21V5.5c0-.276-.224-.5-.5-.5H3.5c-.276,0-.5,.224-.5,.5v13.5ZM19,7h-7v5h7V7Zm-9,2H5v3h5v-3Zm9,5H5v3h14v-3Z"/>-->
<!--          </svg>-->
          <svg xmlns="http://www.w3.org/2000/svg" id="Outline" viewBox="0 0 24 24" width="45" height="30" fill="white">
            <path d="M12,0A12,12,0,1,0,24,12,12.013,12.013,0,0,0,12,0Zm8.647,7H17.426a19.676,19.676,0,0,0-2.821-4.644A10.031,10.031,0,0,1,20.647,7ZM16.5,12a10.211,10.211,0,0,1-.476,3H7.976A10.211,10.211,0,0,1,7.5,12a10.211,10.211,0,0,1,.476-3h8.048A10.211,10.211,0,0,1,16.5,12ZM8.778,17h6.444A19.614,19.614,0,0,1,12,21.588,19.57,19.57,0,0,1,8.778,17Zm0-10A19.614,19.614,0,0,1,12,2.412,19.57,19.57,0,0,1,15.222,7ZM9.4,2.356A19.676,19.676,0,0,0,6.574,7H3.353A10.031,10.031,0,0,1,9.4,2.356ZM2.461,9H5.9a12.016,12.016,0,0,0-.4,3,12.016,12.016,0,0,0,.4,3H2.461a9.992,9.992,0,0,1,0-6Zm.892,8H6.574A19.676,19.676,0,0,0,9.4,21.644,10.031,10.031,0,0,1,3.353,17Zm11.252,4.644A19.676,19.676,0,0,0,17.426,17h3.221A10.031,10.031,0,0,1,14.605,21.644ZM21.539,15H18.1a12.016,12.016,0,0,0,.4-3,12.016,12.016,0,0,0-.4-3h3.437a9.992,9.992,0,0,1,0,6Z"/>
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
  import {useRouter} from "vue-router";
  import store from "@/scripts/store";

  export default {
    name: 'Header',
    setup(){
      const router = useRouter();
      const logout = () => {
        store.dispatch('logout');
        router.push("/");
      }
      return {logout}
    }
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