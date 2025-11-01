import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import FilmsView from '../views/FilmsView.vue'
import FilmDetailView from '../views/FilmDetailView.vue'
import LocationsView from '../views/LocationsView.vue'
import PeopleView from '../views/PeopleView.vue'
import SpeciesView from '../views/SpeciesView.vue'
import VehiclesView from '../views/VehiclesView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/films',
      name: 'films',
      component: FilmsView,
    },
    {
      path: '/films/:title',
      name: 'filmsDetail',
      component: FilmDetailView,
    },
    {
      path: '/locations',
      name: 'locations',
      component: LocationsView,
    },
    {
      path: '/people',
      name: 'people',
      component: PeopleView,
    },
    {
      path: '/species',
      name: 'species',
      component: SpeciesView,
    },
    {
      path: '/vehicles',
      name: 'vehicles',
      component: VehiclesView,
    },
    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (About.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import('../views/AboutView.vue'),
    // },
  ],
})

export default router
