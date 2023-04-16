<template>
  <v-container class="fill-height d-flex align-center justify-center">
    <v-row>
      <v-col cols="12" sm="8" md="4">
        <v-card class="elevation-12">
          <v-card-title class="text-center">
            <h1 class="display-4 font-weight-bold">Login</h1>
          </v-card-title>
          <v-card-text>
            <v-form class="form-signin">
              <v-text-field v-model="email" label="Email" type="email" outlined></v-text-field>
              <v-text-field v-model="password" label="Password" type="password" outlined></v-text-field>
              <v-row>
                <v-col cols="6">
                  <v-btn class="register" color="black" block large>Registrar-se</v-btn>
                </v-col>
                <v-col cols="6">
                  <v-btn class="login" color="black" block large>Login</v-btn>
                </v-col>
              </v-row>
            </v-form>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
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
  background-color: #4022FA;
}

.v-card {
  max-width: 330px;
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
  color: black;
  background-color: black;
}

.register {
  background-color: #6F97FF;
}
</style>
