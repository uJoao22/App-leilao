export function formatCep (cellValue) {
  let result = cellValue.replace(/\D/g, '')

  if (result === null || result === undefined) {
    return result
  }

  if (result.length <= 8) {
    result = result.replace(/^(\d{5})(\d{3})/, '$1-$2')
  }

  return result
}
