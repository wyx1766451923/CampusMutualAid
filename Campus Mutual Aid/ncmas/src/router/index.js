import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect:'/home',
    },
    {
      path:'/login',
      component:()=>import('../views/Login/index.vue')
    },
    {
      path:'/home',
      redirect:'/home/index',
      component:()=>import('../views/Home/index.vue'),
      children:[
        {
          path:'index',
          component:()=>import('../views/Index/index.vue')
        },
        {
          path:'lostAndFound',
          component:()=>import('../views/LostAndFound/index.vue')

        },
        {
          path:'publishLostAndFoundInfo',
          component:()=>import('../views/LostAndFound/publishLostAndFoundInfo.vue')
        },
        {
          path:'resourceSharing',
          component:()=>import('../views/ResourceSharing/index.vue')
        },
        {
          path:'expressPickup',
          component:()=>import('../views/ExpressPickup/index.vue')
        },
        {
          path:'idleTransfer',
          component:()=>import('../views/IdleTransfer/index.vue')
        },
        {
          path:'CampusInformationDetails/:id',
          component:()=>import('../views/CampusInformationDetails/index.vue')
        },
        {
          path:'LostAndFoundDetail/:id',
          component:()=>import('../views/LostAndFoundDetail/index.vue')
        }
      ]
    }
    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (About.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import('../views/AboutView.vue')
    // }
  ]
})

export default router
