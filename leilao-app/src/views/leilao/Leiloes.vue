<template>
  <Table
    ref="Table"
    title="Leilões"
    :headers="headers"
    :list="list"
    :canEdit="false"
    :canAdd="false"
    :canDelete="false"
    @reload="fetch"
  />
</template>

<script>
import Table from '@/components/table/Table.vue'

export default {
  name: 'Leiloes',

  components: {
    Table
  },

  data () {
    return {
      headers: [
        { text: 'Vendedor', value: 'empresa.razaoSocial' },
        { text: 'Inicio previsto', value: 'leilao.inicioPrevisto', type: 'date' },
        { text: 'Total', value: 'leilao.valorTotal', type: 'money' }
      ],
      list: []
    }
  },

  created () {
    this.fetch()
  },

  methods: {
    async fetch () {
      this.list = await this.$http.get('compradores')
        .then(response => response)
        .catch(() => [])
    }
  }
}
</script>
