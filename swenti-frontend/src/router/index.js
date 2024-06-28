import HomeView from "@/views/HomeView.vue";
import {createRouter, createWebHistory} from 'vue-router'
import LoginView from "@/views/LoginView.vue";
import ArticleView from "@/views/ArticleView.vue";


const routes = [
    {
        path: '/',
        name:'home',
        component: HomeView
    },
    {
    //     view 화면을 추가
        path: '/login',
        name: 'login',
        component: LoginView
    },
    {
        path:'/article',
        name: 'article',
        component: ArticleView
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

