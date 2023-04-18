<template>
  <v-row no-gutters class="d-flex fill-height" @submit.prevent="submit">
    <v-col cols="12" md="6" class="d-flex justify-center align-center">
      <v-card class="elevation-5" color="">
        <v-card-title class="text-center">
          <h1 class="display-5 font-weight-bold">Registrar-se</h1>
        </v-card-title>
        <v-card-text>
          <v-form class="form-signin" color="black">
            <v-text-field v-model="usuario.email" :rules="emailRules" label="Email" type="email" outlined required></v-text-field>
            <v-text-field v-model="usuario.username" :rules="usernameRules" label="Username" type="text" outlined required></v-text-field>
            <v-text-field v-model="usuario.password" :rules="passwordRules" label="Password" type="password" outlined required></v-text-field>
            <v-row>
              <v-col cols="6">
                <v-btn class="register" color="#3223FF" text-color="white" block large @click="criar">Registrar-se</v-btn>
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
import { reactive } from 'vue'

import UsuarioService from '@/service/UsuarioService.js'

export default {
  // eslint-disable-next-line vue/component-definition-name-casing
  name: 'Login',
  data: () => ({
    valid: false,
    emailRules: [
      v => !!v || 'Campo obrigatório',
      v => /.+@.+\..+/.test(v) || 'E-mail inválido',
      v => v.length <= 50 || 'Máximo de 50 caracteres',
    ],
    usernameRules: [
      v => !!v || 'Campo obrigatório',
      v => v.length >= 3 || 'Mínimo de 3 caracteres',
      v => v.length <= 50 || 'Máximo de 50 caracteres',
    ],
    passwordRules: [
      v => !!v || 'Campo obrigatório',
      v => v.length >= 6 || 'Mínimo de 6 caracteres',
      v => v.length <= 50 || 'Máximo de 50 caracteres',
    ],
    
      usuario: reactive({
        email: '',
        username: '',
        password: ''
      })
    
      
   
    
  }),
  methods: {
    criar() {
      
      UsuarioService.criar(this.usuario)
        .then(response => {
          console.log(response.status)
          if(response.status === 201){
            const user = response.data
            localStorage.setItem('user', JSON.stringify(user))
          this.$router.push('/home')
          }
        })
        .catch(e => {
          console.log(e.response.data.message)
          alert(e.response.data.message)
        })
    },
  },
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
