<template>
  <v-app color="white">
    <!-- NAV-BAR -->
    <v-app-bar class="mb-60" color="#3214EE" app>
      <div style="display: flex; align-items: center; justify-content: center;">
        <img src="~/assets/logo-poo.png" alt="logo music point" class="w-100 align-center">
        <v-toolbar-title>Music Point</v-toolbar-title>
      </div>
      <!-- ESPAÇAMENTO PARA POSSÍVEIS CONTEÚDOS -->
      <v-spacer></v-spacer>
    </v-app-bar>
    <!-- BLOCO POST  -->
    <v-content>
      <v-card-text class="content width-1200 position-fixed overflow-hidden  mt-60" fluid>
        <v-row class="content position-fixed overflow-hidden  mt-60" fluid>
          <v-col cols="16" class="align-self-center justify-content-center align-items-center mx-auto">
            <v-text-field v-model="compartilhar" label="Compartilhe algo..." type="compartilhar" outlined></v-text-field>
          </v-col>
        </v-row>
      </v-card-text>
    </v-content>
    <div class="overlay"></div>
  </v-app>
</template>

<script>
export default {
  // eslint-disable-next-line vue/component-definition-name-casing
  name: 'Home',
}
</script>

<style>
v-app {
  background-color: white;
}

.positin-fixed {
  position: fixed;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
}

/* BLOCO COMPARTILHAR ALGO */
.max-width-1200 {
  width: 1200px;
  height: 40px;
  background-color: white;
  color: black;
  border-radius: 7px;
}

body {
  top: 0;
  left: 0;
  height: 100vh;
  width: 100%;
  background-color: white;
}

.content {
  background-color: #3214EE;
  height: 171px;
  border-radius: 7px;
}

.app {
  color: #3214EE;
}
</style>
