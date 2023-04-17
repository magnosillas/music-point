<template>
  <v-row no-gutters class="d-flex fill-height">
    <v-col cols="12" md="6" class="d-flex justify-center align-center">
      <v-card class="elevation-5" outlined color="transparent">
        <v-card-title class="text-center">
          <h1 class="card display-5 font-weight-bold">Registrar-se</h1>
        </v-card-title>
        <v-card-text>
          <v-form class="form-signin" color="black" @submit.prevent="submit">
            <v-text-field v-model="username" label="Usermame" type="username" outlined required></v-text-field>
            <v-text-field v-model="email" label="Email" type="email" outlined required></v-text-field>
            <v-text-field v-model="password" label="Password" type="password" outlined required></v-text-field>
            <v-row>
              <v-col cols="6">
                <v-btn class="register" type="submit" color="#3223FF" text-grey block large>Registrar-se</v-btn>
              </v-col>
            </v-row>
          </v-form>
        </v-card-text>
      </v-card>
    </v-col>
    <v-col cols="12" md="6" class="d-flex justify-center align-center">
      <img src="~/assets/logo.png" alt="logo music point" class="w-100 align-center">
    </v-col>
  </v-row>
</template>

<script>
import UsuarioService from "~/service/UsuarioService";
export default {
  // eslint-disable-next-line vue/component-definition-name-casing
  name: 'Register',
  data() {
    return {
      username: '',
      email: '',
      password: '',
    };
  },
  methods: {
    async submit() {
      try {
        await UsuarioService.criar({
          username: this.username,
          email: this.email,
          password: this.password
        });

        await this.$router.push('/login');
      } catch (error) {
        // console.error('Erro ao criar usuário', error);
        // Mostrar uma mensagem de erro para o usuário
      }
    }
  }
}


</script>

<style>
html,
body {
  height: 100%;
  background: rgb(64, 34, 250);
  background: linear-gradient(115deg, rgba(64, 34, 250, 1) 32%, rgba(82, 161, 255, 1) 100%);
}


.register {
  color: aliceblue;
}
</style>
