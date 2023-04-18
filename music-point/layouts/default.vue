<template>
  <v-container>
    <Nuxt />
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      email: '',
      password: '',
    };
  },
};
</script>

<style>
html,
body {
  height: 100%;
  /* background: rgb(64, 34, 250);
  background: linear-gradient(115deg, rgba(64, 34, 250, 1) 32%, rgba(82, 161, 255, 1) 100%); */
  margin: 0;
  padding: 0;
  border: 0;
  box-sizing: border-box;
}

.v-card {
  width: 100vw;
  padding: 15px;
  color: black;
}

.v-text-field {
  margin-bottom: 10px;
  color: black;
}

.v-text-field:last-of-type {
  margin-bottom: 0;
}

.v-btn {
  margin-top: 20px;
  color: whitesmoke;
  background-color: white;
}
</style>