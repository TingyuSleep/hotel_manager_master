// 路由表
const constantRouterMap = [
    // ************* 前台路由 **************
    {
      path: '/',
      redirect: '/admin'
    },
    {
      path: '/index',
      name: 'index',
      redirect: '/index/portal',
      component: () => import('/@/views/index/index.vue'),
      children: [
        {
          path: 'login',
          name: 'login',
          component: () => import('/@/views/index/login.vue')
        },
        {
          path: 'register',
          name: 'register',
          component: () => import('/@/views/index/register.vue')
        },
        {
          path: 'portal',
          name: 'portal',
          component: () => import('/@/views/index/portal.vue')
        },
        {
          path: 'detail',
          name: 'detail',
          component: () => import('/@/views/index/detail.vue')
        },
        {
          path: 'confirm',
          name: 'confirm',
          component: () => import('/@/views/index/confirm.vue')
        },
        {
          path: 'pay',
          name: 'pay',
          component: () => import('/@/views/index/pay.vue')
        },
        {
          path: 'search',
          name: 'search',
          component: () => import('/@/views/index/search.vue')
        },
        {
          path: 'usercenter',
          name: 'usercenter',
          redirect: '/index/usercenter/addressView',
          component: () => import('/@/views/index/usercenter.vue'),
          children: [
            {
              path: 'addressView',
              name: 'addressView',
              component: () => import('/@/views/index/user/address-view.vue')
            },
            {
              path: 'wishThingView',
              name: 'wishThingView',
              component: () => import('/@/views/index/user/wish-thing-view.vue')
            },
            {
              path: 'collectThingView',
              name: 'collectThingView',
              component: () => import('/@/views/index/user/collect-thing-view.vue')
            },
            {
              path: 'orderView',
              name: 'orderView',
              component: () => import('/@/views/index/user/order-view.vue')
            },
            {
              path: 'orderView',
              name: 'orderView',
              component: () => import('/@/views/index/user/order-view.vue')
            },
            {
              path: 'userInfoEditView',
              name: 'userInfoEditView',
              component: () => import('/@/views/index/user/userinfo-edit-view.vue')
            },
            {
              path: 'followView',
              name: 'followView',
              component: () => import('/@/views/index/user/follow-view.vue')
            },
            {
              path: 'fansView',
              name: 'fansView',
              component: () => import('/@/views/index/user/fans-view.vue')
            },
            {
              path: 'scoreView',
              name: 'scoreView',
              component: () => import('/@/views/index/user/score-view.vue')
            },
            {
              path: 'commentView',
              name: 'commentView',
              component: () => import('/@/views/index/user/comment-view.vue')
            },
            {
              path: 'securityView',
              name: 'securityView',
              component: () => import('/@/views/index/user/security-view.vue')
            },
            {
              path: 'pushView',
              name: 'pushView',
              component: () => import('/@/views/index/user/push-view.vue')
            },
            {
              path: 'messageView',
              name: 'messageView',
              component: () => import('/@/views/index/user/message-view.vue')
            },
          ]
        }
      ]
    },
    {
      path: '/adminLogin',
      name: 'adminLogin',
      component: () => import('/@/views/admin/admin-login.vue'),
    },
  
  
  {
    path: '/admin',
    name: 'admin',
    redirect: '/admin/user',
    component: () => import('/@/views/admin/main.vue'),
    children: [
      { path: 'overview', name: 'overview', component: () => import('/@/views/admin/overview.vue') },
      { path: 'order', name: 'order', component: () => import('/@/views/admin/order.vue') },
      { path: 'thing', name: 'thing', component: () => import('/@/views/admin/thing.vue') },
      { path: 'guest', name: 'guest', component: () => import('/@/views/admin/guest.vue') },
      { path: 'user', name: 'user', component: () => import('/@/views/admin/user.vue') },
      { path: 'tag', name: 'tag', component: () => import('/@/views/admin/tag.vue') },
      { path: 'vip', name: 'vip', component: () => import('/@/views/admin/vip.vue') },
    ]
  },
];

export default constantRouterMap;
