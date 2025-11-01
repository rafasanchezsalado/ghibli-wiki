<script>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
        <nav id="navbar" class="navbar">
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/films">Films</RouterLink>
        <RouterLink to="/locations">Locations</RouterLink>
        <RouterLink to="/people">People</RouterLink>
        <RouterLink to="/vehicles">Vehicles</RouterLink>
        <!-- <RouterLink to="/about">About</RouterLink> -->
      </nav>
</template>