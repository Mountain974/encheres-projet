import { useState, useEffect } from 'react'
import './App.css'

function App() {
  const [count, setCount] = useState(0)
  const [hello, setHello] = useState("")

  useEffect(() => {
	  fetch("./api/hello")
	  .then(response => response.text())
	  .then(data => setHello(data));
  }, [])


  return (
    <div className="App">

      <h1>{hello}</h1>

    </div>
  )
}

export default App