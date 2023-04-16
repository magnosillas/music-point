<template>
  <v-row no-gutters class="d-flex fill-height">
    <v-col cols="12" md="6" class="d-flex justify-center align-center">
      <v-card class="elevation-5" color="">
        <v-card-title class="text-center">
          <h1 class="display-2 font-weight-bold">Login</h1>
        </v-card-title>
        <v-card-text>
          <v-form class="form-signin" color="black">
            <v-text-field v-model="email" label="Email" type="email" outlined></v-text-field>
            <v-text-field v-model="password" label="Password" type="password" outlined></v-text-field>
            <v-row>
              <v-col cols="6">
                <v-btn class="register" color="#6F97FF" block large>Login</v-btn>
              </v-col>
              <v-col cols="6">
                <v-btn class="register" color="#3223FF" text-color="white" block large>Registrar-se</v-btn>
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
export default {
  // eslint-disable-next-line vue/component-definition-name-casing
  name: 'Login',
}
</script>
