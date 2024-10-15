function printMessages (toast, error) {
  let messages = []

  try {
    messages = error.data.response.body.messages.list || []
  } catch (e) {
    messages = []
  }

  if (messages.length > 0) {
    for (let i = 0; i < messages.length; i++) {
      toast.show({
        message: messages[i].value,
        type: messages[i].type
      })
    }
  }
}

export default (http, store) => {
  http.interceptors.request.use(
    (request) => {
      return request
    }, (error) => {
      console.error('Request error: ', error)
      return Promise.reject(error)
    }
  )

  http.interceptors.response.use(
    (response) => {
      printMessages(store.state.toast, response)
      return response.data.response.body.result
    },
    (error) => {
      printMessages(store.state.toast, error)

      return Promise.reject(error)
    }
  )
}
