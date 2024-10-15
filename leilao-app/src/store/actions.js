import * as TYPES from './types'

export default {
  setToast ({ commit }, obj) {
    commit(TYPES.MAIN_TOAST, obj)
  }
}
