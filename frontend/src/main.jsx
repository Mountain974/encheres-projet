import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import { QueryClient, QueryClientProvider } from '@tanstack/react-query'
import {AppRouter} from "./AppRouter.jsx";
import Hello from "./hello.jsx";

const queryClient = new QueryClient({
    defaultOptions :{
        queries:{
            retry: false,
            refetchOnWindowFocus: false,
        }
    }
})

ReactDOM.createRoot(document.getElementById('root')).render(

  <React.StrictMode>
      <QueryClientProvider client={queryClient}>
          <Hello />
      </QueryClientProvider>
  </React.StrictMode>,
)
