<template>
  <v-row no-gutters class="d-flex fill-height">
    <v-col cols="12" md="6" class="d-flex justify-center align-center">
      <v-card class="card elevation-5">
        <v-card-title class="text-center">
          <h1 class="display-2 font-weight-bold">Login</h1>
        </v-card-title>
        <v-card-text>
          <v-form class="form-signin" color="white">
            <v-text-field v-model="email" label="Email" type="email" outlined></v-text-field>
            <v-text-field v-model="password" label="Password" type="password" outlined></v-text-field>
            <v-row>
              <v-col cols="6">
                <v-btn class="login" color="#6F97FF" block large>
                  <NuxtLink to="/login">Login</NuxtLink>
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
export default {
  // eslint-disable-next-line vue/component-definition-name-casing
  name: 'Login',
  data() {
    return {
      email: '',
      password: '',
    };
  },
}
</script>

<style scoped>
.card {
  background: white;
}

.form-signin {
  color: white;
  background-color: white;
}
</style>