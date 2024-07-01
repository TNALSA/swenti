import {createApp} from 'vue'
import App from './App.vue'
import {createRouter, createWebHistory} from 'vue-router'
import HomeView from "@/views/HomeView.vue";
import LoginView from "@/views/LoginView.vue";
import ArticleView from "@/views/ArticleView.vue";

const routes = [
    {path: '/', component: HomeView},
    {path: '/login', component: LoginView},
    {
        path: '/article',
        name: 'Article',
        component: ArticleView,
        props: true
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

createApp(App).use(router).mount('#app')


