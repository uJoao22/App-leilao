<template>
  <v-dialog v-model="dialogDelete" max-width="450px">
    <v-card>
      <v-card-title class="">Tem certeza que deseja remover o item?</v-card-title>

      <v-card-actions class="mt-2 pb-4">
        <v-btn
          color="blue-grey lighten-4"
          small
          @click="closeDelete"
        >
          Cancelar
        </v-btn>

        <v-spacer></v-spacer>

        <v-btn
          color="error"
          small
          @click="deleteItemConfirm"
        >
          Remover
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  name: 'DeleteItem',

  data () {
    return {
      dialogDelete: false,
      index: -1,
      itemRemove: null,
      item: null
    }
  },

  methods: {
    openDialog (item, index) {
      this.item = item
      this.index = index
      this.dialogDelete = true
    },

    deleteItemConfirm () {
      this.$emit('deleteItem', this.item, this.index)
      this.closeDelete()
    },

    closeDelete () {
      this.index = -1
      this.item = null
      this.dialogDelete = false
    }
  }
}
</script>

<style>
.btn-actions {
  padding: 0px 6px !important;
  min-width: 30px !important;
}
</style>
