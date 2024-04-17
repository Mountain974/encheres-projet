import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  server:{
      proxy: {
          "/api": "http://localhost:8080",
          "/perform-login": "http://localhost:8080",
          "/perform-logout": "http://localhost:8080",
      }
  },
  plugins: [react()],
  build:{
  	  outDir: "../src/main/resources/static",
      emptyOutDir: true,
    }
})
