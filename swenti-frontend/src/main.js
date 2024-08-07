import {createApp} from 'vue'
import App from './App.vue'
import {createRouter, createWebHistory} from 'vue-router'
// import HomeView from "@/views/HomeView.vue";
import LoginView from "@/views/LoginView.vue";
import ArticleView from "@/views/ArticleView.vue";
import HomeView from "@/views/HomeView.vue";
import MyPageView from "@/views/MyPageView.vue"
import BookmarkView from "@/views/BookmarkView.vue"
import store from "@/scripts/store";


const routes = [
    {
        path: '/',
        component: HomeView
    },
    {
        path: '/login', component: LoginView
    },
    {
        path: '/article/:articleId',
        name: 'Article',
        component: ArticleView,
        props: true
    },
    {
        path: '/mypage',
        component: MyPageView
    },
    {
        path: '/bookmark',
        component: BookmarkView
    }

]

const router = createRouter({
    history: createWebHistory(),
    routes
})

createApp(App).use(router).use(store).mount('#app')


