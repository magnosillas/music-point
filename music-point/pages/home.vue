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
      <v-img src="https://cdn.vuetifyjs.com/images/john.jpg" alt="John"></v-img>
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
              <v-btn text :to="`/review/${item.id}`">{{item.nome}}</v-btn>
            </template>
            </v-autocomplete>
            
          </v-col>
        </v-row>
      </v-card-text>
      
      
      <span class="text-h5 indigo--text text--accent-4 font-weight-bold arial-font">Postagens</span>
   
          <!-- posts -->
      <v-card class="width-50 mt-5 theme--flase">


     <v-row>
      <v-col cols="2">
        
          <v-img src="https://cdn.vuetifyjs.com/images/john.jpg" size="150" style="border-radius: 7px;" />
       
      </v-col>
      <v-col cols="15">
    <v-card-title>titulo</v-card-title>
    <v-card-subtitle>autor | data</v-card-subtitle>
    <v-card-subtitle>tipo(Album/Musica)</v-card-subtitle>
    <v-card-text>texto</v-card-text>
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
    <BotaoReview @show-review-modal="showReviewModal" />
    <CriarReview v-if="showModal" />
  </div>
    <div class="overlay"></div>
  </v-app>

  

</template>

<script>
import BotaoReview from '../components/BotaoReview.vue'


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


      user: {
        initials: 'JD',
        fullName: 'John Doe',
        email: 'john.doe@doe.com',
      },
    }),
    mounted(){
      this.getAlbums()
    },
    methods: {
      showReviewModal(){
        this.showModal = true
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
