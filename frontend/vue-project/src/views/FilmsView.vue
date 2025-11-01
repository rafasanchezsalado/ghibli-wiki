<script setup lang="ts">
import { ref, onMounted } from 'vue';

const films = ref([]);
onMounted(async () => {
    const response = await fetch('http://localhost:8080/films');
    console.log(response);
    films.value = await response.json();
});
</script>

<template>
    <main>
        <h1>Films</h1>
        <div v-for="film in films">
            <RouterLink :to="`/films/${film.title.toLowerCase().replaceAll(' ', '+')}`">
                <span lang="en">{{ film.title }}</span>
                (
                <span lang="ja">{{ film.original_title }}</span>
                /
                <span lang="ja-Latn">{{ film.original_title_romanised }}</span></RouterLink>
                )
        </div>
    </main>
</template>original_title_romanised

<style></style>