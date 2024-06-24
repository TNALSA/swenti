const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  // npm run build 타겟 Directory
  outputDir: '../swenti-backend/src/main/resources/static',

  // npm run serve 개발 진행 시에 포트가 다르기 때문에  프록시 설정
  devServer: {
    proxy: "http://localhost:8080"
  }
})
