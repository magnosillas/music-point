<template>
  <v-row no-gutters class="d-flex fill-height">
    <v-col cols="12" md="6" class="d-flex justify-center align-center">
      <v-card class="card elevation-5">
        <v-card-title class="text-center">
          <h1 class="display-2 font-weight-bold">Login</h1>
        </v-card-title>
        <v-card-text>
          <v-form class="form-signin" color="white">
            <v-text-field v-model="email" :rules="emailRules" label="Email" type="email" outlined required></v-text-field>
            <v-text-field v-model="password" :rules="passwordRules" label="Password" type="password" outlined></v-text-field>
            <v-row>
              <v-col cols="6">
                <v-btn class="login " color="#6F97FF"  block large @click="login">
                  <label class="block uppercase tracking-wide font-bold mb-2 text-gray-100">Login</label> 
                </v-btn>
              </v-col>
              <v-col cols="6">
                <NuxtLink to="/register">
                  <v-btn class="register" color="#3223FF" block large>
                    <NuxtLink to="/register">Register</NuxtLink>
                  </v-btn>
                </NuxtLink>
              </v-col>
            </v-row>
          </v-form>
        </v-card-text>
      </v-card>
    </v-col>
    <v-col cols="12" md="6" class="d-flex justify-center align-center">
      <img src="~/assets/logo.png" alt="logo music point" class="w-100 align-center" color="#FFFFFF">
    </v-col>
  </v-row>
</template>

<script>

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
    passwordRules: [
      v => !!v || 'Campo obrigatório',
      v => v.length >= 6 || 'Mínimo de 6 caracteres',
      v => v.length <= 50 || 'Máximo de 50 caracteres',
    ],
    
      email: '',
      password: '',
    
      
   
    
  }),
  methods: {
    login() {
      
      UsuarioService.login(this.email, this.password)
        .then(response => {
          console.log(response.status)
          if(response.status == 200){
            alert("email:" + this.email + " senha:" + this.password + " logado com sucesso!")
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