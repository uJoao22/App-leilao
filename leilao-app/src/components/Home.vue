<template>
  <div class="home">
    <h4 class="text-h4 mb-10">
      Seja bem-vindo ao Leilão! O que está procurando?
    </h4>

    <div class="home-grid-itens">
      <div
        v-for="(r, idx) in itens"
        :key="idx"
        class="home-grid"
        @click="clickMenu(r)"
      >
        <div class="d-flex flex-column">
          <v-icon x-large class="color-grid">
            {{ r.icon }}
          </v-icon>

          <span class="color-grid">
            {{ r.name }}
          </span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { resolveRoutes } from '@/router/resolveRoutes'

export default {
  name: 'Home',

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
.home {
  display: flex;
  align-items: center;
  justify-content: end;
  flex-direction: column;
  height: 50vh;
  padding: 0px 20px;
}

.home-grid-itens {
  display: flex;
  align-items: end;
  justify-content: center;
  flex-wrap: wrap;
  gap: 1rem;
}

.home-grid {
  display: flex;
  justify-content: center;
  align-items: center;
  border: 1px solid rgb(182, 182, 182);
  width: 10rem;
  height: 10rem;
  cursor: pointer;
  border-radius: 1rem;
  background-color: #0CB7F2;
}

.color-grid {
  color: white !important;
  font-weight: bold !important;
}

@media screen and (max-width: 790px) {
  .home {
    height: 60vh;
  }
}

@media screen and (max-width: 614px) {
  .home {
    height: 80vh;
  }
}
</style>
