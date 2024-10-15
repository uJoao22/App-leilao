export function formatPhone (cellValue) {
  if (cellValue !== null && cellValue !== undefined) {
    if (cellValue.length === 11) {
      return cellValue.replace(/(\d{2})(\d{5})(\d{4})/g, '($1) $2-$3')
    }

    if (cellValue.length === 10) {
      return cellValue.replace(/(\d{2})(\d{4})(\d{4})/g, '($1) $2-$3')
    }

    return cellValue.replace(/(\d{4})(\d{4})/g, '$1-$2')
  }

  return cellValue
}
