import myIndex from '../views/TimeTable.vue';
import myLogin from '../views/myLogin.vue';
import WhiteHtml from '../views/supplierAllBack.vue'
import storeManage from "../views/storeManage.vue";
import employeeManage from "../views/employeeManage.vue"
import schedulingRoleManage from "../views/schedulingRoleManage.vue"
import userManage from "../views/userManage.vue"
import employeeInsert from "../views/employeeInsert.vue"
import employeeUpdate from "../views/employeeUpdate.vue"

const routes = [
    { path: '/', meta:{title: '登录页面'}, component: myLogin },
    { path: '/index', meta:{requiresAuth: true,title: '主页面'}, component: myIndex },
    { path: '/white', meta:{title: '空白页面'}, component: WhiteHtml },
    { path: '/storeManage', meta:{requiresAuth: true,title: '店铺管理页面'}, component: storeManage },
    { path: '/employeeManage', meta:{requiresAuth: true,title: '员工管理页面'}, component: employeeManage },
    { path: '/schedulingRoleManage', meta:{requiresAuth: true,title: '排班规则管理页面'}, component: schedulingRoleManage },
    { path: '/userManage', meta:{requiresAuth: true,title: '用户管理页面'}, component: userManage },
    { path: '/employeeInsert', meta:{requiresAuth: true,title: '用户添加页面'}, component: employeeInsert },
    { path: '/employeeUpdate', meta:{requiresAuth: true,title: '用户修改页面'}, component: employeeUpdate }
]

export default routes;