import Vue from 'vue'
import HomeView from "@/views/HomeView.vue";

import VueRouter from 'vue-router'
import LoginView from "@/views/LoginView.vue";
import ArticleView from "@/views/ArticleView.vue";


Vue.use

const router = new VueRouter({
    mode: 'history',
    routes : [
        { path: '/', component: HomeView},
        { path: '/login', component: LoginView},
        { path: '/article', component: ArticleView}
    ]
})

export default router
