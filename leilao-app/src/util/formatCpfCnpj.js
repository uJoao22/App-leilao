export function formatCpfCnpj (cellValue) {
  let result = cellValue
  if (cellValue !== null && cellValue !== undefined) {
    result = `${cellValue}`

    if (cellValue.length === 11) {
      result = result.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/g, '$1.$2.$3-$4')
    } else if (cellValue.length <= 14) {
      result = result.replace(/^(\d{2})(\d{3})(\d{3})(\d{4})(\d{2})/, '$1.$2.$3/$4-$5')
    }
  }

  return result
}
