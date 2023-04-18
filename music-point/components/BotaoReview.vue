<template>
    <button @click="showModal">Postar</button>
  </template>
  
  <script>
  export default {
    methods: {
      showModal() {
        // aqui você pode emitir um evento que será capturado pelo componente pai
        this.$emit('show-review-modal');
      }
    }
  }
  </script>
  