<template>
  <div>
    <Table
      ref="Table"
      title="Empresas"
      :headers="headers"
      :list="list"
      @reload="fetch"
      @addItem="addItem"
      @editItem="editItem"
      @deleteItem=deleteItem
    />

    <FormEmpresa
      ref="Form"
      @fetch="fetch"
    />
  </div>
</template>

<script>
import Table from '@/components/table/Table.vue'
import FormEmpresa from './FormEmpresa.vue'

export default {
  name: 'Empresas',

  components: {
    Table,
    FormEmpresa
  },

  data () {
    return {
      headers: [
        {
          text: 'CNPJ',
          align: 'start',
          sortable: false,
          value: 'cnpj',
          type: 'cpfcnpj'
        },
        { text: 'Razão social', value: 'razaoSocial' },
        { text: 'Telefone', value: 'telefone', type: 'phone' },
        { text: 'E-mail', value: 'email' }
      ],
      list: []
    }
  },

  created () {
    this.fetch()
  },

  methods: {
    async fetch () {
      this.list = await this.$http.get('empresas')
        .then(response => response || [])
        .catch(() => [])
    },

    addItem () {
      this.$refs.Form.addDialog()
    },

    editItem (item) {
      this.$refs.Form.editDialog(item)
    },

    deleteItem ({ item }) {
      this.$http.delete('empresas/' + item.id)
        .then(() => {
          this.fetch()
        })
    }
  }
}
</script>
