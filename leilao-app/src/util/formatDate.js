export function formatDate (date) {
  const options = {
    year: 'numeric',
    month: 'numeric',
    day: 'numeric',
    hour: 'numeric',
    minute: 'numeric',
    timeZone: 'America/Sao_Paulo'
  }
  return new Date(date).toLocaleString('pt-BR', options)
}
