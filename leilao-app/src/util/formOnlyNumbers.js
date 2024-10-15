export function formOnlyNumbers (event) {
  const charCode = event.charCode ? event.charCode : event.keyCode

  if (charCode < 48 || charCode > 57) {
    event.preventDefault()
  }
}
