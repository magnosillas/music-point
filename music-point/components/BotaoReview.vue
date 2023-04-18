<template>
    <v-btn text @click="showModal">{{ this.album.nome }}</v-btn>
  </template>
  
  <script>
  export default {
    props: {
    album: Object
  },
    methods: {
      showModal() {
        // aqui você pode emitir um evento que será capturado pelo componente pai
        this.$emit('show-review-modal', this.album);
      }
    }
  }
  </script>
  