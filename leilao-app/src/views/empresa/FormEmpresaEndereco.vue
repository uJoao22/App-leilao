<template>
  <v-row class="m-0 p-0">
    <span class="text-h5 mb-3 col-12">
      Endereço
    </span>

    <!-- CEP -->
    <v-col cols="12" md="6">
      <v-text-field
        v-model="item.endereco.cep"
        :rules="rules.endereco.cep"
        label="CEP"
        :counter="9"
        :maxlength="9"
        @input="applyCepMask"
        @keypress="formOnlyNumbers"
      />
    </v-col>

    <!-- Município -->
    <v-col cols="12" md="6">
      <v-text-field
        v-model="item.endereco.municipio"
        :rules="rules.endereco.municipio"
        label="Município"
        :counter="64"
        :maxlength="64"
      />
    </v-col>

    <!-- Bairro -->
    <v-col cols="12" md="6">
      <v-text-field
        v-model="item.endereco.bairro"
        :rules="rules.endereco.bairro"
        label="Bairro"
        :counter="64"
        :maxlength="64"
      />
    </v-col>

    <!-- Logradouro -->
    <v-col cols="12" md="6">
      <v-text-field
        v-model="item.endereco.logradouro"
        :rules="rules.endereco.logradouro"
        label="Logradouro"
        :counter="64"
        :maxlength="64"
      />
    </v-col>

    <!-- Número -->
    <v-col cols="12" md="6">
      <v-text-field
        v-model="item.endereco.numero"
        :rules="rules.endereco.numero"
        label="Número"
        :counter="10"
        :maxlength="10"
      />
    </v-col>

    <!-- Complemento -->
    <v-col cols="12" md="6">
      <v-text-field
        v-model="item.endereco.complemento"
        :rules="rules.endereco.complemento"
        label="Complemento"
        :counter="64"
        :maxlength="64"
      />
    </v-col>
  </v-row>
</template>

<script>
import { formOnlyNumbers } from '@/util'

export default {
  name: 'FormEmpresaEndereco',

  data () {
    return {
      formOnlyNumbers
    }
  },

  props: {
    item: {
      type: Object,
      required: true
    },
    rules: {
      type: Object,
      required: true
    }
  },

  methods: {
    applyCepMask (value) {
      this.$emit('applyCepMask', value)
    }
  }
}
</script>
