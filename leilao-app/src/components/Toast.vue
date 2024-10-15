<template>
  <v-snackbar
      v-model="showSnackbar"
      :color="color"
      :timeout="timer"
      bottom
      right
  >
    <v-icon left>
      {{icon}}
    </v-icon>
    {{message}}
  </v-snackbar>
</template>

<script>
export default {
  name: 'Toast',

  data () {
    return {
      showSnackbar: false,
      message: '',
      color: 'success',
      icon: 'mdi-check',
      timer: 3000
    }
  },

  methods: {
    show ({ message, type, timer, icon }) {
      const { color, icone } = this.resolveType(type)

      this.message = message || '...'
      this.color = color || 'success'
      this.timer = timer || 3000
      this.icon = icon || icone || 'mdi-check'
      this.showSnackbar = true
    },

    resolveType (type) {
      switch (type.toLowerCase()) {
        case 'success': return {
          icone: 'mdi-check',
          color: 'success'
        }

        case 'error': return {
          icone: 'mdi-alert',
          color: 'error'
        }

        case 'warning': return {
          icone: 'mdi-alert-circle',
          color: 'warning'
        }

        case 'info': return {
          icone: 'mdi-information',
          color: 'info'
        }

        default: return {
          icone: 'mdi-check',
          color: 'success'
        }
      }
    }
  }
}
</script>
