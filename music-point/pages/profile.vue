<template>
  <v-container>
    <!-- HEADER -->
    <v-app-bar :clipped-left="clipped" fixed class="navbar mb-auto" color="#3214EE" app>
      <div style="display: flex; align-items: center; justify-content: center;">
        <img src="~/assets/logo-poo.png" alt="logo music point" class="w-100 align-center">
        <v-toolbar-title class="titulo" color="white">Music Point</v-toolbar-title>
      </div>
      <!-- ESPAÇAMENTO PARA POSSÍVEIS CONTEÚDOS -->
      <v-spacer></v-spacer>
      <!-- LINK PARA HOME -->
      <NuxtLink class="font" to="/home">Home</NuxtLink>
    </v-app-bar>

    <!-- ESPAÇAMENTO -->
    <v-card class="mt-10">
      <v-row>
      </v-row>
    </v-card>

    <v-card-text class="content width-800 position-fixed overflow-hidden">
      <v-row>
        <v-col>
          <div style="display: flex; align-items: center;">
            <!-- icone profile -->
            <v-avatar class="avatar" size="150">
              <v-img :src="avatarURL"></v-img>
            </v-avatar>
            <div class="alterar-info">
              <h3 color="white">Perfil</h3>
              <p>Altere suas informações</p>
            </div>
            <v-spacer></v-spacer>
            <div class="font">
              <span color="white">SEGUINDO</span>
              <span display="block">0</span>
            </div>
            <div class="font">
              <span>SEGUIDORES</span>
              <span>0</span>
            </div>
          </div>

          <div class="biografia-texto">{{ biografiaSalva }}</div>

          <v-divider></v-divider>

          <v-card class="mt-10">
            <v-card-text>
              <v-form>
                <v-textarea v-model="biografriaTexto" clearable label="Biografia"></v-textarea>

                <v-file-input v-model="fotoNova" :rules="rulesAvatar" accept="image/png, image/jpeg, image/bmp"
                  placeholder="Escolha uma foto" prepend-icon="mdi-camera" label="Escolha uma foto"
                  @change="fotoSelecionada"></v-file-input>
                <v-btn @click="salvarAlteracoes">Salvar
                  Alterações</v-btn>
              </v-form>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-card-text>

    <v-divider></v-divider>
  </v-container>
</template>

<script>
// import UsuarioService from '@/service/UsuarioService.js'

export default {
  name: 'Profile',
  data: () => ({
    biografiaTexto: '',
    biografiaSalva: '',
    rulesAvatar: [
      value => {
        return !value || !value.length || value[0].size < 2000000 || 'A foto deve ser menor que 2mb'
      }
    ],
    foto: null,
    fotoNova: null
  }),
  computed: {
    avatarURL() {
      if (this.foto) {
        return URL.createObjectURL(this.foto)
      } else {
        return 'https://cdn.vuetifyjs.com/images/john.jpg'
      }
    }
  },

  methods: {
    salvarAlteracoes() {
      this.biografiaSalva = this.biografriaTexto
      if (this.fotoNova) {
        this.foto = this.fotoNova
        this.fotoNova = null
      }
    },
    // fotoSelecionada(e) {
    //   if (e.target && e.target.files) {
    //     this.foto = e.target.files[0]
    //   }
    // }
  },
}
</script>

<style scoped>
v-app {
  background-color: white;
}

@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@800&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Fredoka:wght@500&display=swap');

v-toolbar-title {
  font-family: 'Fredoka';
}

.titulo {
  font-family: 'Fredoka';
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
  width: 800;
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
  border-radius: 7px;
  margin-top: 50px;
}

.font {
  font-size: 18px;
  font-family: 'Montserrat';
  margin-top: 10px;
  margin: 5px;
  color: white;
  text-decoration: none;
}


.alterar-info {
  margin-left: 20px;
  color: white;
}

.alterar-info h3 {
  font-size: 40px;
  font-family: 'Montserrat';
}

.alterar-info p {
  font-size: 18px;
  font-family: 'Montserrat';
  margin-top: 10px;
}

.biografia-texto {
  font-size: 14px;
  font-family: 'Montserrat';
  margin: 5px;
  color: white;
}

.avatar {
  margin: 20px;
  font-size: 60px;
}
</style>