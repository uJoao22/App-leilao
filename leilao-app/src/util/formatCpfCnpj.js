export function formatCpfCnpj (cellValue, cpf = true, cnpj = true) {
  let result = cellValue.replace(/\D/g, '')

  if (result !== null && result !== undefined) {
    result = `${result}`

    if (cpf && result.length === 11) {
      return result.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/g, '$1.$2.$3-$4')
    }

    if (cnpj && result.length <= 14) {
      return result.replace(/^(\d{2})(\d{3})(\d{3})(\d{4})(\d{2})/, '$1.$2.$3/$4-$5')
    }
  }

  return result
}
