<script setup lang="ts">
// import TheWelcome from '../components/TheWelcome.vue'
</script>

<template>
  <main>
    <video autoplay muted loop id="bg-video" width="1920" height="1080">
      <!-- <source src="@/assets/video.webm" type="video/webm"></source> -->
      <!-- <source src="@/assets/video.mp4" type="video/mp4"></source> -->
    </video>

    <img src="@/assets/studio_ghibli_logo_svg_black.png" alt="" width="960" height="540" />
  </main>
</template>

<style>
video {
  position: fixed;
  right: 0;
  bottom: 0;
  min-width: 100%;
  min-height: 100%;
  z-index: -2;
  object-fit: cover;
  filter: brightness(1);
  opacity: 0.5;
}

img {
  position: absolute;
  /* top: 2rem; */
  left: 50%;
  transform: translate(-50%, -50%);
  opacity: 1;
  z-index: -1;
  pointer-events: none;
  user-select: none;
  image-rendering: -webkit-optimize-contrast;
  image-orientation: from-image;
  object-fit: cover;
  vertical-align: middle;
  margin: 0;
  top: 50%;
  -ms-transform: translate(-50%);
}
</style>
