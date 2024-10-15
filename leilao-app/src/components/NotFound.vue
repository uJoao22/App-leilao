<template>
  <div class="not-found">
    <div class="not-found-container">
      <h1 class="not-found-title">404</h1>
      <p class="not-found-message">Oops! Nada foi encontrado aqui.</p>
      <button class="not-found-button" @click="goHome">Voltar para Home</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'NotFound',

  methods: {
    goHome () {
      this.$router.push('/')
    }
  }
}
</script>

<style scoped>
.not-found {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #0CB7F2;
  color: white;
  text-align: center;
}

.not-found-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.not-found-title {
  font-size: 10rem;
  font-weight: bold;
  margin: 0;
}

.not-found-message {
  font-size: 1.5rem;
  margin: 20px 0;
}

.not-found-button {
  background-color: white;
  color: #0CB7F2;
  border: none;
  padding: 10px 20px;
  font-size: 1rem;
  font-weight: bold;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.not-found-button:hover {
  background-color: #ffffff88;
}
</style>
