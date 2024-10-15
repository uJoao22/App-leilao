export function formatMoney (cellValue, precision) {
  if (cellValue === null || cellValue === undefined) {
    return cellValue
  }

  return new Intl.NumberFormat('pt-BR',
    {
      style: 'currency',
      minimumFractionDigits: precision,
      currency: 'BRL'
    })
    .format(cellValue)
}
