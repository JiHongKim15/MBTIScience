import Vue from 'vue';
import VueRouter, { RouteConfig } from 'vue-router';
import Home from '../views/Home.vue';
import JiHong from '../components/JiHong/JiHong.vue';
import Detail from '../components/JiHong/Detail.vue';

Vue.use(VueRouter);

const routes: RouteConfig[] = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/jihong',
    name: 'JiHong',
    component: JiHong,
  },
  {
    path: '/jihong/:mainBoardNum',
    name: 'Detail',
    component: Detail,
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue'),
  },
  {
    path: '/wisdom-board',
    name: 'WisdomMain',
    component: () => import(/* webpackChunkName: "about" */ '../views/WisdomMain.vue'),
  },
  {
    path: '/wisdom-board/:id',
    name: 'WisdomBoard',
    component: () => import('../components/Wisdom/WisdomBoard.vue'),
  },
  {
    path: '/wisdom-board/:id/write',
    name: 'WisdomWritingPage',
    component: () => import('../components/Wisdom/WisdomWritingPage.vue'),
  }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
