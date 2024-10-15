<template>
  <v-dialog
    v-model="dialog"
    max-width="60%"
  >
    <v-card>
      <v-card-title>
        <span class="text-h5 mb-3">
          {{ isEdit ? 'Edição de unidade' : 'Criação de unidade' }}
        </span>
      </v-card-title>

      <v-card-text>
        <v-form
          ref="Form"
          v-model="valid"
          lazy-validation
        >
          <v-row>
            <!-- Nome -->
            <v-col cols="12">
              <v-text-field
                v-model="item.nome"
                :rules="rules.nome"
                label="Nome"
                :counter="128"
                required
              />
            </v-col>

            <v-col cols="12" class="d-flex">
              <v-btn
                color="blue-grey lighten-4"
                small
                @click="close"
              >
                Cancelar
              </v-btn>

              <v-spacer></v-spacer>

              <v-btn
                color="primary"
                small
                @click="save"
              >
                Salvar
              </v-btn>
            </v-col>
          </v-row>
        </v-form>
      </v-card-text>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  name: 'FormItem',

  data () {
    return {
      dialog: false,
      valid: false,
      item: this.resetItem()
    }
  },

  computed: {
    isEdit () {
      return Boolean(this.item.id)
    },

    rules () {
      return {
        nome: [
          v => !!v || 'Nome é obrigatório',
          v => (v && v.length <= 128) || 'Nome não pode ter mais de 128 caracteres'
        ]
      }
    }
  },

  watch: {
    dialog (val) {
      val || this.close()
    }
  },

  methods: {
    resetItem () {
      return {
        id: null,
        nome: '',
        createdAt: new Date(),
        updatedAt: new Date()
      }
    },

    addDialog () {
      this.item = this.resetItem()
      this.initDialog()
    },

    editDialog (item) {
      this.item = Object.assign(this.resetItem(), item)
      this.initDialog()
    },

    initDialog () {
      this.dialog = true

      this.$nextTick(() => {
        this.$refs.Form.resetValidation()
      })
    },

    close () {
      this.dialog = false
      this.valid = false
    },

    save () {
      if (!this.$refs.Form.validate()) return

      if (this.isEdit) {
        this.edit()
      } else {
        this.create()
      }

      this.close()
    },

    create () {
      this.$http.post('unidades', this.item)
        .then(() => {
          this.$emit('fetch')
        })
    },

    edit () {
      this.$http.put('unidades/' + this.item.id, this.item)
        .then(() => {
          this.$emit('fetch')
        })
    }
  }
}
</script>
