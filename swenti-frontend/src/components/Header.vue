<template>
  <header data-bs-theme="dark">
    <div class="collapse text-bg-dark" id="navbarHeader">
      <div class="container">
        <div class="row">
          <div class="col-sm-8 col-md-7 py-4">
            <h4>About</h4>
            <p class="text-body-secondary">Add some information about the album below, the author, or any other background context. Make it a few sentences long so folks can pick up some informative tidbits. Then, link them off to some social networking sites or contact information.</p>
          </div>
          <div class="col-sm-4 offset-md-1 py-4">
            <h4>Contact</h4>
            <ul class="list-unstyled">
              <li><a href="#" class="text-white">Follow on Twitter</a></li>
              <li><a href="#" class="text-white">Like on Facebook</a></li>
              <li><a href="#" class="text-white">Email me</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <div class="navbar navbar-dark bg-dark shadow-sm">
      <div class="container">
        <a href="#" class="navbar-brand d-flex align-items-center">
<!--          <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" id="earth"><path fill-rule="evenodd" d="M12.5 0A12.5 12.5 0 0 0 0 12.5 12.5 12.5 0 0 0 12.5 25 12.5 12.5 0 0 0 25 12.5 12.5 12.5 0 0 0 12.5 0zm0 4.5c4.412 0 8 3.588 8 8s-3.588 8-8 8-8-3.588-8-8 3.588-8 8-8zm0 1c-.231 0-.485.117-.773.43-.29.312-.583.81-.832 1.449-.234.597-.423 1.32-.565 2.121h4.34c-.142-.8-.331-1.524-.565-2.121-.249-.638-.543-1.137-.832-1.45-.288-.312-.542-.429-.773-.429zm-1.9.266A6.993 6.993 0 0 0 6.18 9.5h3.127c.152-.926.375-1.766.656-2.484.185-.474.397-.89.637-1.25zm3.8 0c.24.36.452.776.637 1.25.28.718.504 1.558.656 2.484h3.127a6.993 6.993 0 0 0-4.42-3.734zM5.793 10.5a7.017 7.017 0 0 0-.293 2c0 .696.105 1.366.293 2h3.394a19.076 19.076 0 0 1-.115-2c0-.696.048-1.357.116-2H5.793zm4.402 0c-.071.638-.123 1.3-.123 2s.052 1.36.123 2h4.61c.071-.64.123-1.3.123-2s-.052-1.362-.123-2h-4.61zm5.617 0c.068.643.116 1.304.116 2s-.048 1.357-.116 2h3.395a7.003 7.003 0 0 0 .293-2c0-.696-.105-1.366-.293-2h-3.395zm-9.63 5a6.992 6.992 0 0 0 4.416 3.732 6.566 6.566 0 0 1-.635-1.246c-.28-.718-.504-1.56-.656-2.486H6.182zm4.15 0c.141.8.33 1.527.563 2.123.249.639.543 1.136.832 1.45.288.312.542.427.773.427.231 0 .485-.115.773-.428.29-.313.583-.81.832-1.449.233-.596.422-1.323.563-2.123h-4.336zm5.361 0a12.462 12.462 0 0 1-.656 2.486 6.566 6.566 0 0 1-.635 1.246 6.992 6.992 0 0 0 4.416-3.732h-3.125z"></path></svg>-->
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