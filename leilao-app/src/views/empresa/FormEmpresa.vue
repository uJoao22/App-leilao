<template>
  <v-dialog
    v-model="dialog"
    max-width="60%"
  >
    <v-card>
      <v-card-title>
        <span class="text-h5 mb-3">
          {{ isEdit ? 'Edição de empresa' : 'Criação de empresa' }}
        </span>
      </v-card-title>

      <v-card-text>
        <v-form
          ref="Form"
          v-model="valid"
          lazy-validation
        >
          <v-row>
            <!-- Razão Social -->
            <v-col cols="12" md="6">
              <v-text-field
                v-model="item.razaoSocial"
                :rules="rules.razaoSocial"
                label="Razão Social"
                :counter="64"
                :maxlength="64"
                required
              />
            </v-col>

            <!-- CNPJ -->
            <v-col cols="12" md="6">
              <v-text-field
                v-model="item.cnpj"
                :rules="rules.cnpj"
                label="CNPJ"
                :counter="18"
                :maxlength="18"
                required
                @input="applyCnpjMask"
                @keypress="onlyNumbers"
              />
            </v-col>

            <!-- Telefone -->
            <v-col cols="12" md="6">
              <v-text-field
                v-model="item.telefone"
                :rules="rules.telefone"
                label="Telefone"
                :counter="15"
                :maxlength="15"
                @input="applyPhoneMask"
                @keypress="onlyNumbers"
              />
            </v-col>

            <!-- E-mail -->
            <v-col cols="12" md="6">
              <v-text-field
                v-model="item.email"
                :rules="rules.email"
                label="E-mail"
                :counter="254"
                :maxlength="254"
                required
              />
            </v-col>

            <!-- Site -->
            <v-col cols="12" md="6">
              <v-text-field
                v-model="item.site"
                :rules="rules.site"
                label="Site"
                :counter="254"
                :maxlength="254"
                required
              />
            </v-col>

            <!-- Usuário -->
            <v-col cols="12" md="6">
              <v-text-field
                v-model="item.usuario"
                :rules="rules.usuario"
                label="Usuário"
                :counter="20"
                :maxlength="20"
                required
              />
            </v-col>

            <!-- Senha -->
            <v-col cols="12" md="6">
              <v-text-field
                v-model="item.senha"
                :rules="rules.senha"
                label="Senha"
                :counter="128"
                :maxlength="128"
              />
            </v-col>

            <v-col cols="12">
              <v-divider/>
            </v-col>

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
                @keypress="onlyNumbers"
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
        razaoSocial: [
          v => !!v || 'Razão Social é obrigatória',
          v => (v && v.length <= 64) || 'Razão Social não pode ter mais de 64 caracteres'
        ],
        cnpj: [
          v => !!v || 'CNPJ é obrigatório',
          v => (v && v.length <= 18) || 'CNPJ não pode ter mais de 18 caracteres',
          v => /^(\d{2})\.(\d{3})\.(\d{3})\/(\d{4})-(\d{2})/.test(v) || 'CNPJ deve ser válido'
        ],
        telefone: [
          v => (!v || (v && v.length <= 15)) || 'Telefone não pode ter mais de 15 caracteres',
          v => /^(\(\d{2}\)\s?\d{4,5}-\d{4}|\d{4}-\d{4})$/.test(v) || 'Telefone deve ser válido'
        ],
        email: [
          v => !!v || 'E-mail é obrigatório',
          v => (v && v.length <= 254) || 'E-mail não pode ter mais de 254 caracteres',
          v => /.+@.+\..+/.test(v) || 'E-mail deve ser válido'
        ],
        site: [
          v => (!v || (v && v.length <= 254)) || 'Site não pode ter mais de 254 caracteres'
        ],
        usuario: [
          v => !!v || 'Usuário é obrigatório',
          v => (v && v.length <= 20) || 'Usuário não pode ter mais de 20 caracteres'
        ],
        senha: [
          v => (!v || (v && v.length <= 128)) || 'Senha não pode ter mais de 128 caracteres'
        ],
        endereco: {
          cep: [
            v => (!v || (v && v.length <= 9)) || 'CEP não pode ter mais de 9 caracteres',
            v => /^(\d{5})-(\d{3})/.test(v) || 'CEP deve ser válido'
          ],
          municipio: [
            v => (!v || (v && v.length <= 64)) || 'Município não pode ter mais de 64 caracteres'
          ],
          bairro: [
            v => (!v || (v && v.length <= 64)) || 'Bairro não pode ter mais de 64 caracteres'
          ],
          logradouro: [
            v => (!v || (v && v.length <= 64)) || 'Logradouro não pode ter mais de 64 caracteres'
          ],
          numero: [
            v => (!v || (v && v.length <= 10)) || 'Número não pode ter mais de 10 caracteres'
          ],
          complemento: [
            v => (!v || (v && v.length <= 64)) || 'Complemento não pode ter mais de 64 caracteres'
          ]
        }
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
        razaoSocial: '',
        cnpj: '',
        endereco: {
          id: null,
          logradouro: '',
          municipio: '',
          numero: '',
          complemento: '',
          bairro: '',
          cep: '',
          createdAt: new Date(),
          updatedAt: new Date()
        },
        telefone: '',
        email: '',
        site: '',
        usuario: '',
        senha: '',
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
      this.applyCnpjMask(this.item.cnpj)
      this.applyCepMask(this.item.endereco.cep)
      this.applyPhoneMask(this.item.telefone)

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
      this.$http.post('empresas', this.item)
        .then(() => {
          this.$emit('fetch')
        })
    },

    edit () {
      this.$http.put('empresas/' + this.item.id, this.item)
        .then(() => {
          this.$emit('fetch')
        })
    },

    applyPhoneMask (value) {
      const cleanValue = value.replace(/\D/g, '')
      let maskedValue = ''

      if (cleanValue.length <= 8) {
        maskedValue = cleanValue.replace(/(\d{4})(\d{0,4})/, '$1-$2')
      } else if (cleanValue.length <= 10) {
        maskedValue = cleanValue.replace(/(\d{2})(\d{4})(\d{0,4})/, '($1) $2-$3')
      } else if (cleanValue.length <= 11) {
        maskedValue = cleanValue.replace(/(\d{2})(\d{5})(\d{0,4})/, '($1) $2-$3')
      }

      this.item.telefone = maskedValue
    },

    applyCnpjMask (value) {
      const cleanValue = value.replace(/\D/g, '')
      let maskedValue = ''

      if (cleanValue.length <= 14) {
        maskedValue = cleanValue.replace(/^(\d{2})(\d{3})(\d{3})(\d{4})(\d{2})/, '$1.$2.$3/$4-$5')
      }

      this.item.cnpj = maskedValue
    },

    applyCepMask (value) {
      const cleanValue = value.replace(/\D/g, '')
      let maskedValue = ''

      if (cleanValue.length <= 8) {
        maskedValue = cleanValue.replace(/^(\d{5})(\d{3})/, '$1-$2')
      }

      this.item.endereco.cep = maskedValue
    },

    onlyNumbers (event) {
      const charCode = event.charCode ? event.charCode : event.keyCode

      if (charCode < 48 || charCode > 57) {
        event.preventDefault()
      }
    }
  }
}
</script>
