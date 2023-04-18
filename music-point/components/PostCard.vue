<template>
  <v-card class="width-500">
    <v-row>
      <v-col cols="2">
        <v-avatar size="150">
          <v-img :src="review.autor.photoURL" />
        </v-avatar>
      </v-col>
      <v-col cols="15">
        <v-card-title>{{ review.titulo }}</v-card-title>
        <v-card-subtitle>{{ review.autor.username }} | {{ review.dataCriacao }}</v-card-subtitle>
        <v-card-subtitle>{{ review.conteudoTipo }}</v-card-subtitle>
        <v-card-text>{{ review.texto }}</v-card-text>
        <v-card-actions>
          <v-btn icon @click="$emit('like')">
              <v-icon>mdi-thumb-up-outline</v-icon>
              <span v-text="review.likes"></span>
          </v-btn>
          <v-btn icon @click="$emit('unlike')">
            <v-icon>mdi-thumb-down-outline</v-icon>
            <span v-text="review.unlikes"></span>
          </v-btn>
          <v-spacer></v-spacer>
          <v-btn color="primary" text @click="$emit('edit')">Edit</v-btn>
          <v-btn color="primary" text @click="$emit('delete')">Delete</v-btn>
        </v-card-actions>
      </v-col>
    </v-row>
  </v-card>
</template>

<script>
export default {
  props: {
    review: {
      type: Object,
      required: true
    }
  }
}
</script>
