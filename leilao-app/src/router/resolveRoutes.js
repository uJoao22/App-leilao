export function resolveRoutes () {
  const files = require.context('../views', true, /\.\/\w+\/routes\.js$/)

  const routers = files.keys().flatMap((key) => {
    const z = require(`../views${key.replace(/(\.|routes.js)/g, '')}routes.js`)
    return z.default
  })

  return routers
}
