import myIndex from '../views/TimeTable.vue';
import myLogin from '../views/myLogin.vue';
import WhiteHtml from '../views/supplierAllBack.vue'
const routes = [
    { path: '/', meta:{title: '登录页面'}, component: myLogin },
    { path: '/index', meta:{requiresAuth: true,title: '主页面'}, component: myIndex },
    { path: '/white', meta:{title: '空白页面'}, component: WhiteHtml },
]

export default routes;