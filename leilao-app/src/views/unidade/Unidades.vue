<template>
  <div>
    <Table
      ref="Table"
      title="Unidades"
      :headers="headers"
      :list="list"
      @reload="fetch"
      @addItem="addItem"
      @editItem="editItem"
      @deleteItem=deleteItem
    />

    <FormUnidade
      ref="Form"
      @fetch="fetch"
    />
  </div>
</template>

<script>
import Table from '@/components/table/Table.vue'
import FormUnidade from './FormUnidade.vue'

export default {
  name: 'Unidades',

  components: {
    Table,
    FormUnidade
  },

  data () {
    return {
      headers: [
        { text: 'Cód.', align: 'start', value: 'id' },
        { text: 'Nome', value: 'nome' },
        { text: 'Criado em:', value: 'createdAt', type: 'date' },
        { text: 'Atualizado em:', value: 'updatedAt', type: 'date' }
      ],
      list: []
    }
  },

  created () {
    this.fetch()
  },

  methods: {
    async fetch () {
      this.list = await this.$http.get('unidades')
        .then(response => response)
        .catch(() => [])
    },

    addItem () {
      this.$refs.Form.addDialog()
    },

    editItem (item) {
      this.$refs.Form.editDialog(item)
    },

    deleteItem ({ item }) {
      this.$http.delete('unidades/' + item.id)
        .then(() => {
          this.fetch()
        })
    }
  }
}
</script>
