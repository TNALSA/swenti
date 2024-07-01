<template>
  <header data-bs-theme="dark">
    <div class="collapse text-bg-dark" id="navbarHeader">
      <div class="container">
        <div class="row">
          <div class="col-sm-8 col-md-7 py-4">
            <h4>About</h4>
            <p class="text-body-secondary">Swenti is provide Daily Headline News about IT information at Naver, Daum News Website</p>
          </div>
          <div class="col-sm-4 offset-md-1 py-4">
            <h4>Other</h4>
            <ul class="list-unstyled">
              <li><a href="#" class="text-white">Login</a></li>
<!--              <li><a class="text-white" type="button" aria-label="Toggle navigation">Language</a></li>-->
            </ul>
          </div>
        </div>
      </div>
    </div>
    <div class="navbar navbar-dark bg-dark shadow-sm">
      <div class="container">
        <a href="#" class="navbar-brand d-flex align-items-center">
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