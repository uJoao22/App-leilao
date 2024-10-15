export function formatPhone (cellValue) {
  let result = cellValue.replace(/\D/g, '')

  if (result !== null && result !== undefined) {
    if (result.length === 11) {
      return result.replace(/(\d{2})(\d{5})(\d{4})/g, '($1) $2-$3')
    }

    if (result.length === 10) {
      return result.replace(/(\d{2})(\d{4})(\d{4})/g, '($1) $2-$3')
    }

    return result.replace(/(\d{4})(\d{4})/g, '$1-$2')
  }

  return result
}
