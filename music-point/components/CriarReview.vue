<template>
    <div class="register-modal">
        <div class="register-form">
    <h2 class="register-form__title">Formulário de Registro</h2>
    <div class="register-form__section">
      <label class="register-form__label" for="register-form__text">Texto:</label>
      <textarea class="register-form__text" id="register-form__text" v-model="text"></textarea>
    </div>
    <div class="register-form__section">
      <label class="register-form__label" for="register-form__rating">Classificação:</label>
      <div class="register-form__rating justify-space-evenly">
        <button class="register-form__rating-button " v-for="n in 5" :key="n" :class="{ active: rating === n }" @click="setRating(n)">{{ n }}</button>
      </div>
    </div>
    <div class="register-form__buttons">
      <button class="register-form__button register-form__button--cancel" @click="cancelRegistration">Cancelar</button>
      <button class="register-form__button register-form__button--submit" @click="submitRegistration">Registrar</button>
    </div>
  </div>
    </div>
  </template>
  
  <script>
    export default {
    data() {
        return {
        title: 'Registro',
        text: '',
        rating: null
        }
    },
    methods: {
        setRating(rating) {
        this.rating = rating;
        },
        cancelRegistration() {
        // Aqui você pode adicionar a lógica para cancelar o registro
            this.$emit('hide-review-modal');
        },
        submitRegistration() {
        // Aqui você pode adicionar a lógica para enviar o registro para o servidor
        
        }
    }
    }
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
     background-color: rgb(81, 170, 243);
     padding: 15px;
    border-radius: 7px;
}

.register-form__title {
  font-size: 24px;
  margin-bottom: 20px;
}

.register-form__section {
  margin-bottom: 20px;
}

.register-form__label {
  display: block;
  font-weight: bold;
  margin-bottom: 5px;
}

.register-form__text {
  width: 100%;
  height: 100px;
  padding: 10px;
  border-radius: 5px;
  border: 1px solid #ccc;
}

.register-form__rating {
  display: flex;
  align-items: center;
}

.register-form__rating-button {
  background-color: #fff;
  color: #000;
  border: none;
  margin-right: 5px;
  padding: 15px 15px;
  font-size: 16px;
  border-radius: 10px;
  cursor: pointer;
}

.register-form__rating-button.active {
  background-color: #3214EE;
  color: #fff;
}

.register-form__buttons {
  display: flex;
  justify-content: space-between;
}

.register-form__button {
  background-color: #3214EE;
  color: #fff;
  border: none;
  padding: 10px 15px;
  font-size: 16px;
  border-radius: 5px;
  cursor: pointer;
}

.register-form__button--cancel {
  background-color: #ccc;
}
  </style>
  