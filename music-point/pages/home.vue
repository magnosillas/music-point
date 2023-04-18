<template>
  <v-app color="white">
  

    <!-- NAV-BAR -->
    <v-app-bar :clipped-left="clipped" fixed class="mb-60" color="#3214EE" app>
  <div style="display: flex; align-items: center; justify-content: center;">
    <img src="~/assets/logo-poo.png" alt="logo music point" class="w-100 align-center">
    <v-toolbar-title>Music Point</v-toolbar-title>
  </div>
  <!-- ESPAÇAMENTO PARA POSSÍVEIS CONTEÚDOS -->
  <v-spacer></v-spacer>
  <!-- icone profile -->
  <v-row class="d-flex justify-end">
    <v-avatar>
      <v-img :src="usuarioFoto" alt="User photo"/>

    </v-avatar>
  </v-row>
</v-app-bar>



    <!-- BLOCO POST  -->
    <v-main class="d-flex justify-center ">
      <v-card-text class="content width-800 position-fixed overflow-hidden  " >
        <v-row  >
          <v-col cols="16" class="align-self-center justify-content-center align-items-center " fixed>
            <v-autocomplete
              hide-no-data
              clearable
              label="Compartilhe sua opinião sobre um álbum ou música"
              prepend-inner-icon="mdi-magnify"
              outlined
              hide-details
              color="white"
              class="white--text"
              :items="albums"
              item-text="nome"
              item-value="id"
              id="search"
            >
            <template v-slot:item="{item}">
              <BotaoReview :album="item" @select-item="selecionarAlbum" @show-review-modal="showReviewModal" />

            </template>
            </v-autocomplete>
            
          </v-col>
        </v-row>
      </v-card-text>
      
      
      <div class="mt-5 ml-5 text-h5 indigo--text text--accent-4 font-weight-bold arial-font">Timeline</div>
   
          <!-- posts -->
      <v-card class="width-50 mt-5 posts " color="undefined">


     <v-row>
      <v-col cols="2">
        
          <v-img src="https://cdn.vuetifyjs.com/images/john.jpg" size="150" style="border-radius: 7px;" />
        </v-col>
        <v-col cols="auto">
          <v-card-title>nome do album</v-card-title>
    <v-card-subtitle>autor | tipo</v-card-subtitle>
  </v-col>
      </v-row>
      <v-row>
      <v-col cols="a">
    
    <v-card-title class="mt-0">Titulo</v-card-title>
    <v-card-text>Lorem ipsum dolor sit amet consectetur adipisicing elit. Corrupti in voluptas provident obcaecati incidunt enim aliquid ratione, magnam unde expedita voluptate! Libero aperiam animi excepturi eligendi iste, fuga doloremque dolore.</v-card-text>
    <v-card-actions>
      <v-btn icon>
        <v-icon>mdi-thumb-up-outline</v-icon>
      </v-btn>
      <v-btn icon>
        <v-icon>mdi-thumb-down-outline</v-icon>
      </v-btn>
      <v-spacer></v-spacer>
      <v-btn color="primary" text @click="$emit('edit')">Edit</v-btn>
      <v-btn color="primary" text @click="$emit('delete')">Delete</v-btn>
    </v-card-actions>
  </v-col>
</v-row>
  </v-card>


    </v-main>
    <div>
    

    <CriarReview v-if="showModal" :album="albumSelecionado" @hide-review-modal="hideReviewModal" />
  </div>
    <div class="overlay"></div>
  </v-app>

  

</template>

<script>
import BotaoReview from '@/components/BotaoReview.vue'


import CriarReview from "@/components/CriarReview.vue"
import AlbumService from "@/service/AlbumService"

export default {
  components: {
    CriarReview,
    BotaoReview
  },
  // eslint-disable-next-line vue/component-definition-name-casing
  name: 'Home',
  data: () => ({

      showModal: false,

      albums: [],
      search: null,

      albumSelecionado: null,

      usuarioFoto: "https://cdn.vuetifyjs.com/images/john.jpg"
      

    }),
    mounted(){
      this.getAlbums()

          // Verifica se o objeto "user" existe no localStorage
      if (localStorage.getItem('user')) {
        // Obtém o objeto "user" do localStorage e converte para um objeto JavaScript
        const user = JSON.parse(localStorage.getItem('user'));
        
        // Verifica se a propriedade "foto" existe no objeto "user"
        if (Object.hasOwnProperty.call(user, 'photoURL')) {
          // A propriedade "foto" existe, podemos acessá-la
          const fotoDoUsuario = user.photoURL;
          this.usuarioFoto = fotoDoUsuario;
          if (fotoDoUsuario !== null) {
            this.usuarioFoto = fotoDoUsuario;
          }


          console.log(fotoDoUsuario);
        } else {
          console.log('A propriedade "foto" não existe no objeto "user"');
        }
      } else {
        console.log('O objeto "user" não existe no localStorage');
        this.$router.push('/login')
      }

    },
    methods: {
      showReviewModal(album) {
      this.albumSelecionado = album;
      this.showModal = true;
    },
      hideReviewModal() {
      this.showModal = false;
    },
    selecionarAlbum(album) {
    this.albumSelecionado = album;
  },

      getAlbums(){
        AlbumService.listar()
        .then(response => {
          console.log(response.status)
          this.albums = response.data;
          console.log(this.albums);
        }).catch(e => {
          console.log(e.response.data.message)
          alert(e.response.data.message)
        })
      }
    }
    
  }

</script>

<style scoped>
v-app {
  background-color: white;
}

@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@800&display=swap');



.positin-fixed {
  position: fixed;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
}

.posts{
  color: white;
  background-color: #3214EE;
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

.text-overline {
  text-decoration: overline;
}

.content {
  background-color: #3214EE;
  
  border-radius: 7px;
}

.app {
  color: #3214EE;
}
</style>
