<template>
  <v-card>
    <v-data-table
      :loading="loading"
      item-key="id"
      :headers="fullHeaders"
      :items="list"
      :search="search"
      sort-by="calories"
      class="elevation-1"
    >
      <template v-slot:top>
        <v-toolbar
          flat
        >
          <v-toolbar-title>{{ title }}</v-toolbar-title>

          <v-spacer></v-spacer>

          <v-text-field
            v-model="search"
            append-icon="mdi-magnify"
            label="Buscar..."
            single-line
            hide-details
          />

          <v-btn
            v-if="canAdd"
            class="ml-6"
            small
            color="primary"
            @click="$emit('addItem')"
          >
            Novo
          </v-btn>
        </v-toolbar>
      </template>

      <template v-slot:no-results>
        Nenhum registro atende aos critérios de pesquisa.
      </template>

      <template v-slot:body="{ items, headers }">
        <tbody>
          <tr v-for="(item, index) in items" :key="index">
            <td v-for="(h, idx) in headers" :key="idx">
              <span v-if="showActions && h.value === 'actions'">
                <v-btn
                  v-if="canEdit"
                  small
                  color="primary"
                  class="mr-2 btn-actions"
                  @click="$emit('editItem', item)"
                >
                  <v-icon small>
                    mdi-pencil
                  </v-icon>
                </v-btn>

                <v-btn
                  v-if="canDelete"
                  small
                  color="error"
                  class="btn-actions"
                  @click="deleteItem(item, index)"
                >
                  <v-icon small>
                    mdi-delete
                  </v-icon>
                </v-btn>
              </span>

              <span v-else-if="h.type === 'date'">
                {{ formatDate(getDataRow(item, h.value)) }}
              </span>

              <span v-else-if="h.type === 'cpfcnpj'">
                {{ formatCpfCnpj(getDataRow(item, h.value)) }}
              </span>

              <span v-else-if="h.type === 'money'">
                {{ formatMoney(getDataRow(item, h.value)) }}
              </span>

              <span v-else-if="h.type === 'phone'">
                {{ formatPhone(getDataRow(item, h.value)) }}
              </span>

              <span v-else>
                {{ getDataRow(item, h.value) }}
              </span>
            </td>
          </tr>
        </tbody>
      </template>

      <template v-slot:no-data>
        <span style="color: #616161">
          Nenhum registro encontrado.

          <span
            style="color: #42A5F5; text-decoration: underline; cursor: pointer;"
            @click="$emit('reload')"
          >
            Clique aqui para atualizar.
          </span>
        </span>
      </template>
    </v-data-table>

    <DeleteItem
      ref="DeleteItem"
      @deleteItem="(item , index) => $emit('deleteItem', { item, index })"
    />
  </v-card>
</template>

<script>
import { formatDate, formatCpfCnpj, formatMoney, formatPhone } from '@/util'
import DeleteItem from './DeleteItem.vue'

export default {
  name: 'Table',

  components: {
    DeleteItem
  },

  data: () => ({
    formatDate,
    formatCpfCnpj,
    formatMoney,
    formatPhone,
    dialog: false,
    search: ''
  }),

  props: {
    list: {
      type: Array,
      required: true
    },
    headers: {
      type: Array,
      required: true
    },
    title: {
      type: String,
      required: true
    },
    loading: {
      type: Boolean,
      default: false
    },
    canAdd: {
      type: Boolean,
      default: true
    },
    canEdit: {
      type: Boolean,
      default: true
    },
    canDelete: {
      type: Boolean,
      default: true
    }
  },

  computed: {
    showActions () {
      return this.canEdit || this.canDelete
    },

    fullHeaders () {
      const itens = [...this.headers]

      if (this.showActions) {
        itens.push({
          text: 'Ações',
          value: 'actions',
          sortable: false,
          width: 110,
          align: 'center'
        })
      }

      return itens
    }
  },

  methods: {
    deleteItem (item, index) {
      this.$refs.DeleteItem.openDialog(item, index)
    },

    getDataRow (row, prop) {
      const props = prop.split('.')
      let info = row

      props.forEach((p) => {
        if (info !== undefined && info !== null) {
          info = info[p]
        }
      })

      return info
    }
  }
}
</script>
