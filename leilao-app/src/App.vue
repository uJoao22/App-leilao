<template>
  <v-app id="app-leilao">
    <v-navigation-drawer
      v-if="!isNotFound"
      id="navbar"
      v-model="drawer"
      app
      permanent
      width="200"
    >
      <Navbar/>
    </v-navigation-drawer>

    <v-main class="main-content">
      <v-container fluid class="d-flex" :class="(isNotFound) ? 'remove-padding' : ''">
        <v-flex>
          <router-view></router-view>
          <Toast ref="Toast"/>
        </v-flex>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import { mapActions } from 'vuex'
import Navbar from '@/components/Navbar.vue'
import Toast from './components/Toast.vue'

export default {
  name: 'App',

  components: {
    Navbar,
    Toast
  },

  data () {
    return {
      drawer: true
    }
  },

  computed: {
    isNotFound () {
      return this.$route.matched[0].path === '*'
    }
  },

  mounted () {
    this.setToast(this.$refs.Toast)
  },

  methods: {
    ...mapActions(['setToast'])
  }
}
</script>

<style>
#app-leilao {
  background-color: #f1f1f1;
  display: flex;
}

#navbar {
  height: 100vh;
  width: 200px;
  background-color: #0CB7F2;
}

.main-content {
  flex-grow: 1;
}

.remove-padding {
  padding: 0 !important;
}

.v-container {
  display: flex;
  flex-direction: row;
  align-items: flex-start;
}

.v-flex {
  flex-grow: 1;
}

@media screen and (max-width: 576px) {
  #navbar {
    width: 120px !important;
  }

  .main-content {
    padding-left: 120px !important;
  }
}
</style>
