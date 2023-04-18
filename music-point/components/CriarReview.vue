<template>
  <div class="register-modal">
    <v-card class="register-form">
      <v-card-title class="register-form__title">Faça um Review</v-card-title>
      <v-row align="center">
      <v-col cols="2">
        
        <v-img :src="this.album.foto" size="200" style="border-radius: 7px;" />
     
    </v-col>
    <v-col cols="15">
  <v-card-title>{{ this.album.nome }}</v-card-title>
  <v-card-subtitle>{{this.album.artista.nome}} | Album</v-card-subtitle>
</v-col>
</v-row>
<div class="post-form">
      <v-card-text>
        <v-text-field
          v-model="review.titulo"
          :rules="tituloRules"
          label="Título da postagem"
          outlined
          shaped
          class="mb-3"
          hide-details
        ></v-text-field>
      </v-card-text>
      <v-card-text>
        <v-textarea
          v-model="review.texto"
          label="Dê sua opinião"
          auto-grow
          :rules="textoRules"
          outlined
          rows="3"
          row-height="25"
          shaped
          hide-details
        ></v-textarea>
      </v-card-text>
    </div>
      <v-card-text>
        <v-row align="center">
          <v-col cols="3">
            <v-label for="register-form__rating" class="register-form__label">Classificação:</v-label>
          </v-col>
          <v-col cols="14">
            <v-rating
              v-model="review.nota"
              :rules="notaRules"
              background-color="#eee"
              color="#3214EE"
              hover-color="#3214EE"
              :clearable="false"
            ></v-rating>
          </v-col>
        </v-row>
      </v-card-text>
      <v-card-actions>
        <v-btn color="red" text @click="cancelRegistration">Cancelar</v-btn>
        <v-btn color="#3214EE" text @click="submitRegistration">Registrar</v-btn>
      </v-card-actions>
    </v-card>
    <v-alert
      :value="alertVisible"
      type="error"
      transition="scale-transition"
      dismissible
      @input="alertVisible = false"
    >
      {{ alertMessage }}
    </v-alert>
  </div>
  
</template>

<script>
import { reactive } from 'vue';
import ReviewService from '@/service/ReviewService.js';

export default {
  name: 'CriarReview',
  
  props: {
    showModal: {
    type: Boolean,
    required: true
  },
  album: {
    type: Object
  },
  
  },
  data() {
    return {
      tituloRules: [
      v => !!v || 'Campo obrigatório',
      v => v.length <= 50 || 'Máximo de 50 caracteres',
    ],
    textoRules: [
      v => !!v || 'Campo obrigatório',
      v => v.length >= 3 || 'Mínimo de 3 caracteres',
    ],
    notaRules: [
      v => !!v || 'Campo obrigatório',
    
    ],
      
      usuarioCopy: null,

      review: reactive({
        
        titulo: "",
        texto: "",
        nota: null,
        album: this.album,
        autor: null,
      }),
      alertVisible: false,
      alertMessage: '',

    };
  },
  mounted() {
    if (localStorage.getItem('user')) {
        // Obtém o objeto "user" do localStorage e converte para um objeto JavaScript
        const user = JSON.parse(localStorage.getItem('user'));
        // Define o valor da propriedade "user" com o objeto JavaScript
        if (user.id !== null ){
          
          this.review.autor = user;
        }
        
    } else {
        // Redireciona para a página de login
        this.$router.push('/login');
    }
  },
  methods: {
    cancelRegistration() {
      // Aqui você pode adicionar a lógica para cancelar o registro
      this.$emit("hide-review-modal");
    },
    submitRegistration() {
      // Aqui você pode adicionar a lógica para enviar o registro para o servidor
      this.criarReview();
      
    },

    criarReview(){
      ReviewService.criar(this.review)
      .then(response => {
        console.log(response.status)
          if(response.status === 201){
            this.alertMessage = 'Review criado com sucesso!';
            this.alertVisible = true;
            console.log(response.data);
            this.$emit("hide-review-modal");
            this.$emit("atualizar-reviews");
          }
      })
      .catch(e => {
          console.log(e.response.data.message)
          this.alertMessage = e.response.data.message;
          this.alertVisible = true;
        });
    },
    }

  };
</script>

<style scoped>
.register-modal {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  z-index: 9999;
  display: flex;
  justify-content: center;
  align-items: center;
}

.register-form {
  max-width: 600px;
  margin: 0 auto;
  background-color: white;
  border-radius: 7px;
}

.register-form__title {
  font-size: 24px;
  margin-bottom: 20px;
  color: #3214EE;
}

.register-form__label {
  display: block;
  font-weight: bold;
  margin-bottom: 5px;
  color: #3214EE;
}

.register-form__buttons {
  display: flex;
  justify-content: space-between;
  margin-top: 20px;
}

.v-btn {
  text-transform: none;
}

.v-input__control {
  border-radius: 7px;
}

.v-rating__icon {
  font-size: 24px;
}

.v-rating__selections {
  margin-left: 10px;
}
.post-form {
  max-width: 600px;
  margin: 0 auto;
}
.v-rating__fill {
  color: #3214EE;
}
</style>
