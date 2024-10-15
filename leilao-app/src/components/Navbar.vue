<template>
  <div>
    <v-list-item class="px-2">
      <v-list-item-title
        class="text-h6 color-grid"
        style="cursor: pointer; text-align: center;"
        @click="clickMenu({ path: '/' })"
      >
        Leilão
      </v-list-item-title>
    </v-list-item>

    <v-divider></v-divider>

    <v-list nav dense>
      <v-list-item
        v-for="(item, idx) in itens"
        :key="idx"
        link
        :style="item.path === $route.path ? 'backgroundColor: #0CB7F222;' : ''"
        @click="clickMenu(item)"
      >
        <v-list-item-icon class="me-2">
          <v-icon class="color-grid">{{ item.icon }}</v-icon>
        </v-list-item-icon>

        <v-list-item-title class="color-grid">
          {{ item.name }}
        </v-list-item-title>
      </v-list-item>
    </v-list>
  </div>
</template>

<script>
import { resolveRoutes } from '@/router/resolveRoutes'

export default {
  name: 'Navbar',

  data () {
    return {
      itens: []
    }
  },

  mounted () {
    this.itens = resolveRoutes()
  },

  methods: {
    clickMenu ({ path }) {
      if (path === this.$route.path) return
      this.$router.push({ path })
    }
  }
}
</script>

<style>
.color-grid {
  color: white !important;
  font-weight: bold !important;
}
</style>
